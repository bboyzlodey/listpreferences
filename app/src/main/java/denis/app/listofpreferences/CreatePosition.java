package denis.app.listofpreferences;

import java.util.Arrays;
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

class CreatePosition{
    StringBuilder [] create;
    EditText [] createEditText;
    /*
    *
    * type == 0 the be article
    * Идея сосотит в том, что бы сделать массив объектов
    */
    CreatePosition(byte type){
        if (type == 0)
        {
            create = new StringBuilder[15];
			create[1] = new StringBuilder(" ");
			create[3] = new StringBuilder(" // ");
			create[5] = create[1];
			create[7] = new StringBuilder(" - ");
			create[9] = new StringBuilder(" - �");
			create[11] = new StringBuilder(" - �. ");
			create[13] = create[7];
            createEditText = new EditText[6];
            createEditText[0] = (EditText)findViewById(R.id.authors_text);
            createEditText[1] = (EditText)findViewById(R.id.article_text);
            createEditText[2] = (EditText)findViewById(R.id.journal_text);
            createEditText[3] = (EditText)findViewById(R.id.year_text);
            createEditText[4] = (EditText)findViewById(R.id.publisher_text);
            createEditText[5] = (EditText)findViewById(R.id.pages_text);
        }
    }
	
	public void initiliz(){
		iht i = 0;
			
		while(i < this.create.length)
		{
			if (this.create[i] == null)
				this.create[i] = new StringBuilder();
			i++;
		}
	}

    public StringBuilder concat() {
        int i;
        StringBuilder tmp = new StringBuilder();

        i = 0;
        while (i != this.create.length) {
            tmp.append(this.create[i]);
            i++;
        }
        return tmp;
    }

    public String concatString(StringBuilder [] conc){
        return (Arrays.toString(conc));
    }

    public String concatString(){
        return (Arrays.toString(this.create));
    }

    public String fill(StringBuilder [] src){
        int i = 0;
        int j = 0;

        while (i != this.create.length) {
            if ((this.create[i].toString() == null) && j != src.length)
            {
                this.create[i] = src[j];
                j++;
            }
            i++;
        }
        return (this.concatString());
    }
}