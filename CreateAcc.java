package textfiles;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CreateAcc{
    private String username;
    private String password;
    public CreateAcc(String u, String p){
	username = u;
	password = p;
    }
    public void writeFile(String name, String text) throws IOException{
	//try{
	    FileWriter w = new FileWriter(name);

	    w.write(text);
	    w.close();
    }
	    /**
	    PrintWriter pl = new PrintWriter(w);
	    pl.printf("%s" + "%n", text);
	    pl.close();
	}catch(IOException e){
	    System.out.println("idk");
	}
	}*/
    public static void main (String[]args){
	CreateAcc c = new CreateAcc("a", "b");
	c.writeFile("Example.csv", "\na");
    }
}
