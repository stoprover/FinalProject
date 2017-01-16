import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AddSubject{
    private String fileName;
    private String username;
    private String restOfAcc;
    // private String newString;
    public AddSubject(String f, String u){
	fileName = f;
	username = u;
    }
    public String getOtherInfo(){
	try{
	    Scanner s = new Scanner(new File (fileName));
	    while(s.hasNextLine()){
		String nextAcc = s.nextLine();
		//System.out.println(nextAcc);
		String nextUser = nextAcc.substring(0, nextAcc.indexOf(','));
		if (nextUser.equals(username)){
		    restOfAcc = nextAcc.substring(nextAcc.indexOf(',') + 1, nextAcc.length());
		    restOfAcc = restOfAcc.substring(restOfAcc.indexOf(',') + 1, restOfAcc.length());
		    System.out.println(restOfAcc);
		    return "AccFound";
		}
		/**else{
		    return "AccError";
		    }*/
	    }
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	    System.exit(1);
	}
	return "AccError";
    }
    /**public boolean canBeAdded(){
	System.out.println(restOfAcc.charAt((restOfAcc.lastIndexOf(',') - 1)));
	if (restOfAcc.charAt((restOfAcc.lastIndexOf(',') - 1)) == 44){
	    return true;
	}
	else{
	    return false;
	}
	}*/
    //get all the info about the class from GUI. Process test/quiz/proj/hw info into correct format
    //find location to add this stuff in
    //add in correct order.
    //there may need to be some way to create the array that is the input for process, as well as string for breakdown 
    public String process(String[]grades){
	String sum = "";
	for (int i = 0; i < grades.length; i++){
	    sum += grades[i] + ".";
	}
	return sum;
	//blah;
    }
    public int findWhere(){
	return restOfAcc.indexOf(",,,,,,,"); 
    }//goal, brkdwn, subname would be variables created in gui from input.
    public String createClass(String goal, String SubName, String BrkDwn, String[]T, String[]Q, String[]P, String[]H){
	//if (this.canBeAdded()){
	    String newString = goal + "," + SubName + "," + BrkDwn + "," + process(T) + "," + process(Q) + "," + process(P) + "," + process(H) + ",";
	    //System.out.println(newString);
	    return newString;
	    //}
	    //else{
	    //return "";
	    // }
    }
    public void addClass(String goal, String SubName, String BrkDwn, String[]T, String[]Q, String[]P, String[]H){
	String tempFileName = "temp_Example.csv";

	BufferedReader br = null;
	BufferedWriter bw = null;
	try{
	    br = new BufferedReader(new FileReader(fileName));
	    bw = new BufferedWriter(new FileWriter(tempFileName));
	    String line;
	    while ((line = br.readLine()) != null) {
		if (line.contains(username)){
		    String beg = line.substring(0, line.indexOf(",,,,,,,") + 1);
		    String mid = (line.substring((line.indexOf(",,,,,,,") + 1), (line.indexOf(",,,,,,,") + 8)));
		    String end = (line.substring((line.indexOf(",,,,,,,") + 8), (line.lastIndexOf(",") + 1))) ;
		    line = line.replace(beg+mid+end, ""+beg+(createClass(goal, SubName, BrkDwn, T, Q, P, H))+end);
		}
		bw.write(line+"\n");
	    }
	}catch (Exception e){
	    return;
	}finally{
	    try{
		if (br != null){
		    br.close();
		}
	    }catch (IOException e) {
		//
	    }
	    try {
		if (bw != null){
		    bw.close();
		}
	    }catch (IOException e){
		//
	    }
	}
	File oldFile = new File(fileName);
	oldFile.delete();

	File newFile = new File(tempFileName);
	newFile.renameTo(oldFile);
    }
		
    public static void main(String[]args){
	AddSubject a = new AddSubject("Example.csv", "Bob");
	//System.out.println(a.getOtherInfo());
	//System.out.println(a.canBeAdded());
	String[]T = new String[3];
	T[0] = "96";
	T[1] = "43";
	T[2] = "65";
	//System.out.println(a.process(T));
	//System.out.println(a.findWhere());
	String[]Q = new String[4];
	Q[0] = "76";
	Q[1] = "56";
	Q[2] = "90";
	Q[3] = "99";
	String[]P = new String[2];
	P[0] = "100";
	P[1] = "100";
	String[]H = new String[3];
	H[0] = "80";
	H[1] = "90";
	H[2] = "100";
	//System.out.println(a.createClass("94", "English", "60.20.10.10.", T, Q, P, H));
	a.addClass("94", "English", "60.20.10.10.", T, Q, P, H);
    	/**AddSubject b = new AddSubject("Example.csv", "lkasjdhflkasjdhf");
	System.out.println(b.getOtherInfo());
	System.out.println(b.canBeAdded());*/
	/**AddSubject c = new AddSubject("E.csv", "Bob");
	System.out.println(c.getOtherInfo());
	System.out.println(c.canBeAdded());*/
	//AddSubject d = new AddSubject("Example.csv", "asdf");
	//System.out.println(d.getOtherInfo());
	//	System.out.println(d.canBeAdded());
    }
    
}
