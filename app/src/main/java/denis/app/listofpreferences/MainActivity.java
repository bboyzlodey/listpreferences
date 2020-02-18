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
        prefer.createEditText[5] = (EditText)findViewById(R.id.pages_text);
        prefer.createEditText[6] = (EditText)findViewById(R.id.pages_text2);
        prefer.createEditText[4] = (EditText)findViewById(R.id.numb_journal);
    }

    public void onClickGenerate(View view) {
        int i = 0;
        int j = 0;

        context = getApplicationContext();
        prefer.clear();
        while (i != prefer.createEditText.length)
        {
            prefer.texts[i] = new StringBuilder(prefer.createEditText[i].getText().toString());
            i++;
        }
        try {
            mResultEditText.setText(res = prefer.fill());
        }
        catch (StringIndexOutOfBoundsException e){
            prefer.createEditText[0].setHint("Например: Романов К.Г., Карпиевич П.А.");
            Toast.makeText(context, "Введите правильно авторов!", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(context, "Строка создана успешно. Хотите скопировать в буфер?", Toast.LENGTH_SHORT).show();
    }

    public void onClickCopyToClipboard(View view){
        context = getApplicationContext();
        ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
        Toast.makeText(context, "Скопировано успешно", Toast.LENGTH_SHORT).show();
        ClipData clip = ClipData.newPlainText("clip to clipboard", res);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(context, res, Toast.LENGTH_SHORT).show();
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

