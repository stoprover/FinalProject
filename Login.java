import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Login{
    String username;
    String password;
    //Boolean goodPass;
    //Boolean goodUser;
    //Boolean goOn;
    //maybe private, maybe not
    public Login(String u, String p){
	username = u;
	password = p;
    }
    public String readFile(String name){
	try{
	    Scanner s = new Scanner(new File (name));
	    //goOn = true;//int i = 0;
	    while (s.hasNextLine()){//inefficient loop bc loops thru users even after the right one is found
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
/**import java.util.Scanner;
import java.io.File;
public class Login{
    /**public String look(){
	Scanner s = new Scanner(example.csv).useDelimiter("\\s*\n\\s*");
	//String[][] userpass = new String[][72];
	userpass.add(s.next());
	for (int i = 0; 
	}*/
/** public void readFile(File file){
	Scanner s = new Scanner (new File("example.csv"));
	System.out.println(s.nextLine());
	s.close();
    }
    public static void main(String[]args){
	readFile(example.csv);
	/**String fileName = "example.csv";
	File example = new File(fileName);
	Scanner s = new Scanner(example);
	s.useDelimiter(",");
	while(s.hasNext()){
	    System.out.print(s.next());
	}
	s.close();*/
    
	    //new String[72];//s.next();
	/**
	   http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
	*/
	//foreach:
    
    
//}
