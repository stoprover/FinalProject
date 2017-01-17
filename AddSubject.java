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

    //sets fileName and username variables to be used throughout rest of class
    public AddSubject(String f, String u){
	fileName = f;
	username = u;
    }

    //cruft that i will leave for now in case it will be needed in the future
    public String getOtherInfo(){
	try{
	    Scanner s = new Scanner(new File (fileName));
	    while(s.hasNextLine()){
		String nextAcc = s.nextLine();
		String nextUser = nextAcc.substring(0, nextAcc.indexOf(','));
		if (nextUser.equals(username)){
		    restOfAcc = nextAcc.substring(nextAcc.indexOf(',') + 1, nextAcc.length());
		    restOfAcc = restOfAcc.substring(restOfAcc.indexOf(',') + 1, restOfAcc.length());
		    System.out.println(restOfAcc);
		    return "AccFound";
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	    System.exit(1);
	}
	return "AccError";
    }

    //Also cruft
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

    //processes a string array into the correct format that Tests, HW, Projects, and Quizzes need for Example.csv
    public String process(String[]grades){
	String sum = "";
	for (int i = 0; i < grades.length; i++){
	    sum += grades[i] + ".";
	}
	return sum;
    }

    //Might also be cruft
    public int findWhere(){
	return restOfAcc.indexOf(",,,,,,,"); 
    }

    //goal, brkdwn, subname would be variables created in gui from input
    //Goal might be determined the way add a new test/quiz/etc. is determined (the number with arrows, idk what that's called.
    //BrkDwn would be determined like goal, but with a set of four of those things
    //Subname would be a testfield
    //I think BrkDwn might also need to be processed, possibly use the process function above but idk
    //the gui can have something so that if tests, quizzes, etc. are not added, there will just be one 100 inputted for that category.
    //thisfunction properly formats all the data so that it may be added.
    public String createClass(int goal, String SubName, String BrkDwn, String[]T, String[]Q, String[]P, String[]H){
	    String newString = goal + "," + SubName + "," + BrkDwn + "," + process(T) + "," + process(Q) + "," + process(P) + "," + process(H) + ",";
	    return newString;
    }

    //this function adds the data to Example.csv
    public void addClass(int goal, String SubName, String BrkDwn, String[]T, String[]Q, String[]P, String[]H){
	String tempFileName = "temp_Example.csv";

	BufferedReader br = null;
	BufferedWriter bw = null;
	try{
	    br = new BufferedReader(new FileReader(fileName));
	    bw = new BufferedWriter(new FileWriter(tempFileName));
	    String line;
	    while ((line = br.readLine()) != null) {
		//System.out.println("line" + line);
		//System.out.println("Bob,1234567890,95,Physics,50.20.20.10.,98.87.81.92.95.,100.100.80.80.,100.,90.100.90.,95,PreCalculus,50.20.20.10.,60.80.77.92.95.,100.100.80.0.,50.,100.100.100.,94,English,60.20.10.10.,96.43.65.,76.56.90.99.,100.100.,80.90.100.,94,CS,60.20.10.10.,100.100.100.,100.100.100.100.,100.100.,100.100.100.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,".contains("Bob"));
		//System.out.println(line.contains(username));
		if (line.contains(username)){
		    String beg = line.substring(0, line.indexOf(",,,,,,,") + 1);
		    String mid = (line.substring((line.indexOf(",,,,,,,") + 1), (line.indexOf(",,,,,,,") + 8)));
		    String end = (line.substring((line.indexOf(",,,,,,,") + 8), (line.lastIndexOf(",") + 1))) ;
		    //System.out.println("end:" + end);
		    line = line.replace(beg+mid+end, ""+beg+(createClass(goal, SubName, BrkDwn, T, Q, P, H))+end);
		    System.out.println("begmidend" + beg+mid+end);
		}
		bw.write(line+"\n");
	    }
	}catch (Exception e){
	    return;
	    //
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
	T[0] = "100";
	T[1] = "100";
	T[2] = "100";
	//System.out.println(a.process(T));
	//System.out.println(a.findWhere());
	String[]Q = new String[4];
	Q[0] = "100";
	Q[1] = "100";
	Q[2] = "100";
	Q[3] = "100";
	String[]P = new String[2];
	P[0] = "100";
	P[1] = "100";
	String[]H = new String[3];
	H[0] = "100";
	H[1] = "100";
	H[2] = "100";
	//System.out.println(a.createClass("100", "CS", "60.20.10.10.", T, Q, P, H));
	a.addClass(94, "CS", "60.20.10.10.", T, Q, P, H);
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
