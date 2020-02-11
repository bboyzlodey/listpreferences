package denis.app.listofpreferences;

import java.util.Arrays;

class CreatePosition{
    StringBuilder [] create;

    /*
    *
    * one == 1 the be article
     */
    CreatePosition(int one){
        if (one == 1)
        {
            create = new StringBuilder[15];
			create[1] = new StringBuilder(" ");
			create[3] = new StringBuilder(" // ");
			create[5] = create[1];
			create[7] = new StringBuilder(" - ");
			create[9] = new StringBuilder(" - ¹");
			create[11] = new StringBuilder(" - ñ. ");
			create[13] = create[7];
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