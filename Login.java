import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Login{
    private String username;
    private String password;
    public Login(String u, String p){
	username = u;
	password = p;
    }
    public String readFile(String name){
	try{
	    Scanner s = new Scanner(new File (name));
	    while (s.hasNextLine()){
		String nextAcc = s.nextLine();
		String nextUser = nextAcc.substring(0, nextAcc.indexOf(','));
		if (username.equals("")){
		    return "Empty User";
		}
		if (password.equals("")){
		    return "Empty Pass";
		}
		if (nextUser.equals(username)){
		    String restOfAcc = nextAcc.substring(nextAcc.indexOf(',') + 1, nextAcc.length());
		    String nextPass = restOfAcc.substring(0, restOfAcc.indexOf(','));
		    if (nextPass.equals(password)){
			return "Success";
		    }
		    else {
			return "Bad Pass";
		    }
		}
		if (!(s.hasNextLine())){
		    return "Bad User";
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	    System.exit(1);
	}
	return "error";
    }
    public static void main(String[]args){
	Login l = new Login("Bob", "1234567890");
	System.out.println(l.readFile("Example.csv"));
	Login m = new Login("Bob", "lkjbsdf");
	System.out.println(m.readFile("Example.csv"));
	Login n = new Login("sdlfk", "lkg");
	System.out.println(n.readFile("Example.csv"));
    }
}
