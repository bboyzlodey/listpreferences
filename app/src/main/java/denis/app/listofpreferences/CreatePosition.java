package denis.app.listofpreferences;

import java.util.Arrays;

public class CreatePosition{
    StringBuilder [] create;

    /*
    *
    * one == 1 the be article
     */
    CreatePosition(int one){
        if (one == 1)
        {
            create = new StringBuilder[15];
        }
    }
    public StringBuilder concat(StringBuilder [] conc) {
        int i;
        StringBuilder tmp = new StringBuilder();

        i = 0;

        while (i != conc.create.length) {
            tmp.append(conc[i]);
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