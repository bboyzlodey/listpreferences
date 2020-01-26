package denis.app.listofpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mResultEditText;
    private EditText tmp;
    private String res = "string ";
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.my_button);
        mResultEditText = (EditText) findViewById(R.id.result_text);
    }

    public void onClick(View view) {

        tmp = (EditText)findViewById(R.id.authors_text);
        res = tmp.getText().toString();
        tmp = (EditText)findViewById(R.id.article_text);
        res = res + tmp.getText().toString();
        tmp = (EditText)findViewById(R.id.journal_text);
        res = res + tmp.getText().toString();
        tmp = (EditText)findViewById(R.id.year_text);
        res = res + tmp.getText().toString();
        tmp = (EditText)findViewById(R.id.publisher_text);
        res = res + tmp.getText().toString();
        tmp = (EditText)findViewById(R.id.pages_text);
        res = res + tmp.getText().toString();
        mResultEditText.setText(res);
        res = null;
    }
    // метод для копирования текста в буфер обмена (не работает)
    public void onClick2(View view){
        String myString = "This text will be copied into clipboard";
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
