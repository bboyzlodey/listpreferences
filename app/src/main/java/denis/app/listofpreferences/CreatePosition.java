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

class CreatePosition {
    StringBuilder [] create;
    EditText [] createEditText;
    StringBuilder [] texts;
    /*
    *
    * type == 0 the be article
    * Идея состoит в том, что бы сделать массив объектов
    */
    CreatePosition(byte type){
        if (type == 0)
        {
            create = new StringBuilder[15];
			create[1] = new StringBuilder(" ");
			create[3] = new StringBuilder(" // ");
			create[5] = create[1];
			create[7] = new StringBuilder(". - ");
			create[9] = new StringBuilder(". - №");
			create[11] = new StringBuilder(" - c. ");
			create[13] = new StringBuilder(" - ");
            createEditText = new EditText[7];
            texts = new StringBuilder[7];
        }
    }
	
	public void initiliz(){
		int i = 0;
			
		while(i < this.create.length)
		{
			if (this.create[i] == null)
				this.create[i] = new StringBuilder();
			i++;
		}
	}

    public StringBuilder concatString() {
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

    public String concatStringToArray(){
        return (Arrays.toString(this.create));
    }


    public String fill(){
        int i = 1;
        int j = 1;

        while (i != this.create.length) {
            if ((this.create[i] == null) && j != this.createEditText.length)
            {
                if (i == 4)
                {
                    this.create[i] = new StringBuilder(this.createEditText[0].getText().toString());
                    i++;
                    continue;
                }
                this.create[i] = new StringBuilder(this.createEditText[j].getText().toString());
                j++;
            }
            i++;
            this.create[0] = firstAuthor(this.createEditText[0].getText().toString());
        }
        return (this.concatString().toString());
    }
    static public StringBuilder firstAuthor(String oneAuthor)
    {
        return (new StringBuilder(oneAuthor.substring(0,oneAuthor.indexOf('.', oneAuthor.indexOf('.') + 1) + 1)));
    }
    public void clear(){
        if (this.create[0] == null)
            return;
        this.create[0] = null;
        this.create[2] = null;
        this.create[4] = null;
        this.create[6] = null;
        this.create[8] = null;
        this.create[10] = null;
        this.create[12] = null;
        this.create[14] = null;
    }
}