import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Subjects {
    private int subnum;
    private int goal;
    private String tests;
    private String quizzes;
    private String projects;
    private String homework;
    private String  breakdown;
    private String name;
    private int[] b;
    private int[] tG;
    private int[] qG;
    private int[] pG;
    private int[] hG;
    private double avg;
    private ArrayList<String> data;
    private String[] dta;
    private String[] subject;

  
 public void loadData(String fileName){
    
     	try{
     	    Scanner qw = new Scanner(new File (fileName)).useDelimiter(",");
	    while(qw.hasNext()){
		data.add(qw.next());
	    }
     	}catch(FileNotFoundException e){
    	    System.out.println("Does not exist");
    	    System.exit(1);
     	}
	
	for (int i = 0; i < data.size(); i++){
	    dta[i] = data.get(i);
	}
    
    }

    
    
    public Subjects(int x){
	 data = new ArrayList<String>();
	subnum = x;
        goal = 95;
	tests= "";
	quizzes = "";
	projects= "";
	homework = "";
	breakdown = "";
	name = "";
	dta = new String[200];
   
	
	}

    public void fillSubject(){
	int start = 2 + (0*subnum);
	String[] subject = new String[7];
	for (int i = 0; i < 7; i++){
	    subject[i] = dta[start];
	    start++;
	}
	goal = Integer.parseInt(subject[0]);
	name = subject[1];
	tests = subject[3];
	quizzes = subject[4] ;
	projects = subject[5];
	homework = subject[6];
	breakdown = subject[2];
    }

	public String  getName() {
	    return name;
	}

 

    
    public int[] getBreakdown(){
	int dotAmount = 0;

	for (int i = 0; i <  breakdown.length(); i++){
	    if (breakdown.charAt(i) == '.') {
		dotAmount++;}
	}

	 b = new int[dotAmount];

	String temp = breakdown;

	for (int index = 0; temp.length()> 0; index++){
	    String val = "";
	    int end =0;
	    for (int i = 0; temp.charAt(i) != '.'; i++) {
		end++;
	    }
	    val = temp.substring(0,end);
	    int intval = Integer.parseInt(val);
	    b[index] = intval;
	    temp = temp.substring(end+1);
	}  

	return b;
    }
    
    public int[] getTests(){
	int dotAmount = 0;

	for (int i = 0; i <  tests.length(); i++){
	    if (tests.charAt(i) == '.') {
		dotAmount++;}
	}

        tG = new int[dotAmount];

	String temp = tests;

	for (int index = 0; temp.length()> 0; index++){
	    String val = "";
	    int end =0;
	    for (int i = 0; temp.charAt(i) != '.'; i++) {
		end++;
	    }
	    val = temp.substring(0,end);
	    int intval = Integer.parseInt(val);
	    tG[index] = intval;
	    temp = temp.substring(end+1);
	}  

	return tG;
    }

     public int[] getQuizzes(){
	int dotAmount = 0;

	for (int i = 0; i <  quizzes.length(); i++){
	    if (quizzes.charAt(i) == '.') {
		dotAmount++;}
	}

         qG = new int[dotAmount];

	String temp = quizzes;

	for (int index = 0; temp.length()> 0; index++){
	    String val = "";
	    int end =0;
	    for (int i = 0; temp.charAt(i) != '.'; i++) {
		end++;
	    }
	    val = temp.substring(0,end);
	    int intval = Integer.parseInt(val);
	    qG[index] = intval;
	    temp = temp.substring(end+1);
	}  

	return qG;
    }

     public int[] getProjects(){
	int dotAmount = 0;

	for (int i = 0; i <  projects.length(); i++){
	    if (projects.charAt(i) == '.') {
		dotAmount++;}
	}

         pG = new int[dotAmount];

	String temp = projects;

	for (int index = 0; temp.length()> 0; index++){
	    String val = "";
	    int end =0;
	    for (int i = 0; temp.charAt(i) != '.'; i++) {
		end++;
	    }
	    val = temp.substring(0,end);
	    int intval = Integer.parseInt(val);
	    pG[index] = intval;
	    temp = temp.substring(end+1);
	}  

	return pG;
    }

     public int[] getHomework(){
	int dotAmount = 0;

	for (int i = 0; i <  homework.length(); i++){
	    if (homework.charAt(i) == '.') {
		dotAmount++;}
	}

         hG = new int[dotAmount];

	String temp = homework;

	for (int index = 0; temp.length()> 0; index++){
	    String val = "";
	    int end =0;
	    for (int i = 0; temp.charAt(i) != '.'; i++) {
		end++;
	    }
	    val = temp.substring(0,end);
	    int intval = Integer.parseInt(val);
	    hG[index] = intval;
	    temp = temp.substring(end+1);
	}  

	return hG;
    }

     private static String toString(int[] ary){
      String x = "[ ";
      for(int i = 0; i < ary.length; i++){
	  if (i < ary.length-1){
	  x = x + ary[i] + ", ";
	  }
	  else { x = x + ary[ary.length-1] + "]";}
      }
      return x;
     }

    private static double findAvg (int[] ary) {
	int sum = 0;
	for(int i = 0; i < ary.length; i++){
	    sum += ary[i];
	}
	double terms = ary.length;
	double average  = sum / terms;
	return average;
    }

    public  double average() {

	double rawT = findAvg(tG) * b[0] ;
	double rawQ = findAvg(qG) * b[1] ;
	double rawP = findAvg(pG) * b[2];
	double rawH = findAvg(hG) * b[3];

        avg = (rawT + rawQ + rawP + rawH)/100;

	return avg;
    }	    

    public double nextTest() {
	double needed  = goal - avg;
	double avgT = findAvg(tG);
	double terms = tG.length;
	double total = terms * avgT;
	
	return (((avgT +(needed * terms)) * (terms+1)) - total);
	    
    }

    public double twoTests() {
	double needed  = goal - avg;
	double avgT = findAvg(tG);
	double terms = tG.length;
	double total = terms * avgT;
	
	return ((((avgT +(needed * terms)) * (terms+2)) - total)/2);
    }

    public double threeTests() {
	double needed  = goal - avg;
	double avgT = findAvg(tG);
	double terms = tG.length;
	double total = terms * avgT;
	
	return ((((avgT +(needed * terms)) * (terms+3)) - total)/3);
    }

    
    public String advise() {
	return ("In order to reach your goal of " + goal + " you must score " + nextTest() + " on your next test, or score " + twoTests() + " on your next two tests, or " + threeTests() + " on your next three tests.");
    }

    public static void main (String[]args) {
	Subjects Physics =  new Subjects(1);
	Physics.loadData("Example.csv");

	Physics.fillSubject();
	System.out.println (Physics.getName());
	 System.out.println (toString(Physics.getBreakdown()));
	 System.out.println (toString(Physics.getTests()));
	 System.out.println (toString(Physics.getQuizzes()));
	 System.out.println (toString(Physics.getProjects()));
	 System.out.println (toString(Physics.getHomework()));
	 System.out.println (Physics.average());
	 System.out.println (Physics.nextTest());
	 System.out.println (Physics.twoTests());
	 System.out.println (Physics.threeTests());
	 System.out.println (Physics.advise());
    }

    

}
	
	

    
