import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class InputGrades {
     private String user;
    private int goal;
    private String tests;
    private String quizzes;
    private String projects;
    private String homework;
    private String breakdown;
    private String name;
    private ArrayList<String> data;
    private String[] dta;

    

    public InputGrades(String fileName, String username, int subNum){
    
     	try{ Scanner qw = new Scanner(new File (fileName)).useDelimiter(",");
	    // Add data
	    String temp = "";
	    while (!temp.equals(username)){
		qw.nextLine();
		temp = qw.next();
	    }
	    user = temp;
	    data.add(temp);
	    while(qw.hasNext()){
		data.add(qw.next());	
	    }

     	}catch(FileNotFoundException e){
    	    System.out.println("Does not exist");
    	    System.exit(1);
     	}
	System.out.println(data.size());
	dta = new String[data.size()];
	for (int i = 0; i < data.size(); i++){
	    
	    dta[i] = data.get(i);
	    
	}


	int start = 2 + (7*subNum);
	String[] subject = new String[7];
	for (int i = 0; i < 7; i++){
	    subject[i] = dta[start];
	    start++;
	}
	goal = Integer.parseInt(subject[0]);
	    
	name = subject[1];
	tests = subject[3];
	quizzes = subject[4];
	projects = subject[5];
	homework = subject[6];
    	breakdown = subject[2];
    }


    public void adder(int val, int type, int subNum, String username, String fileName) throws IOException{
	String valStr = val + ".";
	String temp = "";
	try{
	    Scanner xw = new Scanner(new File (fileName)).useDelimiter(",");
	    Writer wr = null;
	    while (!temp.equals(username)){
		xw.nextLine();
		temp = xw.next();
	    }
	
	    if (type == 1 ){
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next(); 
		tests += valStr;
		wr.write(tests);}
	    else if (type == 2){
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		quizzes += valStr;
		wr.write(quizzes);}
	    else if(type == 3){
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next(); 
		projects += valStr;
		wr.write(projects);}
	    else if(type == 4){
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next();
		xw.next(); 
		homework += valStr;
		wr.write(homework);}
	}catch(FileNotFoundException e){
	    System.out.println("Does not exist");
    	    System.exit(1);
	}
    
    }

    public static void main(String[]args){
	InputGrades x = new InputGrades("Example.csv", "Bob", 0);
	x.adder(94, 1, 0, "Bob", "Example.csv");
    }
		
	
		
		       
	    


    
    
}

    












