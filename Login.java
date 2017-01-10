import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Login{
    public void readFile(String name){
	try{
	    Scanner s = new Scanner(new File (name));
	    while (s.hasNext()){
		System.out.println(s.next());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	    System.exit(1);
	}
    }
    public static void main(String[]args){
	Login l = new Login();
	l.readFile("Example2.csv");
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
    }
    
	    //new String[72];//s.next();
	/**
	   http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
	*/
	//foreach:
    
    
//}
