package denis.app.listofpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;



// Протестировать отдельно. Работает ли!?
//        | |
//        | |
// private CreatePosition prefer = new CreatePosition(typeOfPosition);

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mResultEditText;
    private EditText tmp;
    private String res;
    private int count;
    private CreatePosition prefer = new CreatePosition((byte)0);
    Context context;
    byte typeOfPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.my_button);
        mResultEditText = (EditText) findViewById(R.id.result_text);
        prefer.createEditText[0] = (EditText)findViewById(R.id.authors_text);
        prefer.createEditText[1] = (EditText)findViewById(R.id.article_text);
        prefer.createEditText[2] = (EditText)findViewById(R.id.journal_text);
        prefer.createEditText[3] = (EditText)findViewById(R.id.year_text);
        prefer.createEditText[4] = (EditText)findViewById(R.id.publisher_text);
        prefer.createEditText[5] = (EditText)findViewById(R.id.pages_text);
//        prefer = new CreatePosition(typeOfPosition);
    }

    public void onClickGenerate(View view) {
        int i = 0;
        int j = 0;

        while (i != prefer.createEditText.length)
        {
            prefer.texts[i] = new StringBuilder((res = prefer.createEditText[i].getText().toString()));
            i++;
        }
        mResultEditText.setText(prefer.fill());
        context = getApplicationContext();
        Toast.makeText(context, "Строка создана успешно. Хотите скопировать в буфер?", Toast.LENGTH_SHORT).show();
    }
    // метод для копирования текста в буфер обмена (не работает)
    public void onClickCopyToClipboard(View view){
        context = getApplicationContext();
        ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
        Toast.makeText(context, "Copy button", Toast.LENGTH_SHORT).show();
        ClipData clip = ClipData.newPlainText("clip to clipboard", "Hello World!");
        clipboard.setPrimaryClip(clip);
    }

    public void onClickInfo(View view){
        context = getApplicationContext();
        Toast.makeText(context, "Info button", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_about);
    }
    public void onClick4(View view){
        setContentView(R.layout.activity_main);
    }
}

