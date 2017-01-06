import java.io.File;
import java.io.FileNotException;
import java.io.util.Scanner;



public class Subjects {

    private String tests;
    private String quizzes;
    private String projects;
    private String homework;
    private int[] breakdown;
    private String name;

    public Subject(String n, String te, String qu, String pr, String hw, int t, int q, int p, int h){
	name = n;
	String tests = te;
	String quizzes = qu;
	String projects = pr;
	String homework = hw;
	int[] breakdown = new int[4];
	breakdown[0]= t;
	breakdown[1]= q;
	breakdown[2]= p;
	breakdown[3]= h;
    }

    public getName() {
	return name;
    }

    public getTests(){
	int dotAmount = 0;
	for (int i = 0; i < tests.length(); i++){
	    if (tests.charAt(i) == '.') {
		dotAmount++;}
	}

	int[] tG = new int[dotAmount];

	
	for (int i = 0; i < tG.length; i++){
	    int index = 0;
	    String temp = tests;
	    String val = "";	    
	    int end = 0;
	    for (; tests.charAt(i) != '.'; end++) {
		end++;
	    }
	    val = tests.substring(0,end);
	    int intval = Integer.parseInt(val);
	    tG[index] = intval;
	    index++;
		    }
		


    

    

   
	
	
	
	
	
	

    
