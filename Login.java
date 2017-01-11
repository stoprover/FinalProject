import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Login{
    String username;
    String password;
    //maybe private, maybe not
    public Login(String u, String p){
	username = u;
	password = p;
    }
    public String readFile(String name){
	try{
	    Scanner s = new Scanner(new File (name));
	    //goOn = true;//int i = 0;
	    while (s.hasNextLine()){
		/**i++;
	    }
	    for (int j = 0; j < i; j++){*/
		String nextAcc = s.nextLine();
		String nextUser = nextAcc.substring(0, nextAcc.indexOf(','));
		if (username.equals("")){
		    return "Empty User";
		}
		if (password.equals("")){
		    return "Empty Pass";
		}
		//System.out.println("|" + nextUser + "|");
		//System.out.println("|" + username + "|");
		if (nextUser.equals(username)){
		    String restOfAcc = nextAcc.substring(nextAcc.indexOf(',') + 1, nextAcc.length());
		    String nextPass = restOfAcc.substring(0, restOfAcc.indexOf(','));
		    //System.out.println("|" + nextPass + "|");
		    //System.out.println("|" + password + "|");
		    if (nextPass.equals(password)){
			//goodPass = true;
			//System.out.println("Success");
			return "Success";
			//goOn = false;
			//j = i;
		    }
		    else {
			/**goodPass = false;
			System.out.println("Bad Pass");
			//j = i;
			goOn = false;*/
			return "Bad Pass";
		    }
		}
		if (!(s.hasNextLine())){
		    /** goodUser = false;
			System.out.println("Bad User");*/
		    return "Bad User";
		}
		//return "Error";
		    
		//System.out.println(nextAcc);
		//System.out.println(s.next());
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
