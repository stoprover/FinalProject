import java.io.File;
import java.io.FileNotException;
import java.io.util.Scanner;

public class Subjects {

    private String tests;
    private String quizzes;
    private String projects;
    private String homework;
    private String  breakdown;
    private String name;


  

	public Subjects(String n, String te, String qu, String pr, String hw, int t, int q, int p, int h){

	    name = n;
	    String tests = te;
	    String quizzes = qu;
	    String projects = pr;
	    String homework = hw;
	    String breakdown = b;
	}
    

	public String  getName() {
	    return name;
	}


	public int[] getTests() {
	
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
	}
    }
	
	

    
