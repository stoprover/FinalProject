import java.io.*;

public class CreateAcc{
    private String username;
    private String password;
    public CreateAcc(String u, String p){
	username = u;
	password = p;
    }
    public String writeFile(String name){//)throws IOException{
	/**if (username.length() < 8){
	    return "User Short";
	}
	if (password.length() < 8){
	    return "Pass Short";
	    }*/
	if (username.equals("")){
	    return "Empty User";
	}
	if (password.equals("")){
	    return "Empty Pass";
	}
	Login attempt = new Login(username, password);
	if (attempt.readFile("Example.csv").equals("Bad User")){
	    Writer writer = null;
	    try{
		writer = new FileWriter(name, true);	    
		writer.write("\n" + username + "," + password + ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
	    //w.flush();
	    //w.close();
	    }catch(IOException e){
		System.err.println("Exception thrown: " + e);
		e.printStackTrace();
	    }finally{
		if (writer!= null){
		    try{
			writer.close();
		    }catch (IOException e){
			System.err.println("Error closing file");
			e.printStackTrace();
		    }
		}
	    }
	    return "Success";
	}
	else{
	    return "User Used";
	}
    }
    public static void main(String[]args){
	CreateAcc c = new CreateAcc("", "1972");
	System.out.println(c.writeFile("passwords.csv"));
     	//CreateAcc d = new CreateAcc("tashad", "idk");
	//d.writeFile("passwords.csv");
    }
}
		
/**package textfiles;

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
/**public static void main (String[]args){
	CreateAcc c = new CreateAcc("a", "b");
	c.writeFile("Example.csv", "\na");
    }
    }*/
