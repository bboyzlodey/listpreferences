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
			create[7] = new StringBuilder(" - ");
			create[9] = new StringBuilder(". - №");
			create[11] = new StringBuilder(" - c. ");
			create[13] = create[7];
            createEditText = new EditText[6];
            texts = new StringBuilder[6];
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

//    public String fill(StringBuilder [] src){
//        int i = 0;
//        int j = 0;
//
//        while (i != this.create.length) {
//            if ((this.create[i].toString() == null) && j != src.length)
//            {
//                this.create[i] = src[j];
//                j++;
//            }
//            i++;
//        }
//        return (this.concatString());
//    }
    public String fill(){
        int i = 0;
        int j = 0;

        while (i != this.create.length) {
            if ((this.create[i] == null) && j != this.createEditText.length)
            {
                this.create[i] = new StringBuilder(this.createEditText[j].getText().toString());
                j++;
            }
            i++;
        }
        return (this.concatString().toString());
    }
}