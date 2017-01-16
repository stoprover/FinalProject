import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Subjects {
    private String user;
    private int subnum;
    private int goal;
    private String tests;
    private String quizzes;
    private String projects;
    private String homework;
    private String  breakdown;
    private String name;
    public int[] b;
    public int[] tG;
    public int[] qG;
    public int[] pG;
    public int[] hG;
    private double avg;
    private int finalAvg;
    private int num;
    private int result;
    private String[] subject;
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    private int uno;
    private int dos;
    private int numb;
    private ArrayList<String> data;
    private String[] dta;
  
    
    

  
    public void loadData(String fileName, String username){
    
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
	
	dta = new String[data.size()];
	for (int i = 0; i < data.size(); i++){
	    
	    dta[i] = data.get(i);
	    
	}
    
    }

    
    
    public Subjects(int x){
	 data = new ArrayList<String>();
	subnum = x;
        goal = 0;
<<<<<<< HEAD
	tests= "";
	quizzes = "";
	projects= "";
	homework = "";
	breakdown = "";
	name = "";
<<<<<<< HEAD
	dta = new String[300];
   
	
=======

>>>>>>> d400c89b6ea006c0ad8270a7e37f7e4a2dd3f445
	}

    public void fillSubject(){
	try{
	    int start = 2 + (7*subnum);
	    String[] subject = new String[7];
	    for (int i = 0; i < 7; i++){
		subject[i] = dta[start];
		start++;
	    }
	    goal = Integer.parseInt(subject[0]);
	    
	    name = subject[1];
	    
	    if (!(subject[3].equals(""))){
		tests = subject[3];}
	    else { tests = "100."; }

	    if (!(subject[4].equals(""))){
		quizzes = subject[4];}
	    else { quizzes = "100.";}

	    if (!(subject[5].equals(""))){		
		projects = subject[5];}
	    else{ projects = "100.";}

	    if (!subject[6].equals("")){
		homework = subject[6];}
	    else{ homework = "100.";}
	    
	    breakdown = subject[2];
	} catch(NumberFormatException e){
    	    System.out.println("");
    	    
     	}
	
	// for (int i = 0; i < data.size(); i++){
	//     dta[i] = data.get(i);
    }
    


    public int getGoal() {
	return goal;
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
    
    public  static String toString(int[] ary){
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

     public double combo1() {
	 double termq = (double)(b[1]);
	 double quizz = (((100 + (findAvg(qG) * qG.length))/(1+qG.length))*(termq/100))-((findAvg(qG) * b[1])/100);
	 double needed  = goal - avg - quizz;
	 double avgT = findAvg(tG);
	 double terms = tG.length;
	 double total = terms * avgT;
	 double res = (((avgT +(needed * terms)) * (terms+1)) - total);
	 if ( res < 100) {
	     num = 1;
	     return res;}
	 
	 res = ((((avgT +(needed * terms)) * (terms+2)) - total)/2);
	 if ( res < 100) {
	     num = 2;
	     return res;}

	 
	 res = ((((avgT +(needed * terms)) * (terms+3)) - total)/3);
	 if ( res < 100) {
	     num = 3;
	     return res;}

	      
	 return res;
    }

     public double combo2() {
	 double termq = (double)(b[1]);
	 double quizz = (((200 + (findAvg(qG) * qG.length))/(2+qG.length))*(termq/100))-((findAvg(qG) * b[1])/100);
	 double needed  = goal - avg - quizz;
	 double avgT = findAvg(tG);
	 double terms = tG.length;
	 double total = terms * avgT;
	 double res = (((avgT +(needed * terms)) * (terms+1)) - total);
	 if ( res < 100) {
	     numb = 1;
	     return res;}
	 
	 res = ((((avgT +(needed * terms)) * (terms+2)) - total)/2);
	 if ( res < 100) {
	     numb = 2;
	     return res;}

	 
	 res = ((((avgT +(needed * terms)) * (terms+3)) - total)/3);
	 if ( res < 100) {
	     numb = 3;
	     return res;}



	 return res;	       
	    
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

     public double fourTests() {
	double needed  = goal - avg;
	double avgT = findAvg(tG);
	double terms = tG.length;
	double total = terms * avgT;
	
	return ((((avgT +(needed * terms)) * (terms+4)) - total)/4);
    }

     public double fiveTests() {
	double needed  = goal - avg;
	double avgT = findAvg(tG);
	double terms = tG.length;
	double total = terms * avgT;
	
	return ((((avgT +(needed * terms)) * (terms+5)) - total)/5);
    }

     public double sixTests() {
	double needed  = goal - avg;
	double avgT = findAvg(tG);
	double terms = tG.length;
	double total = terms * avgT;
	
	return ((((avgT +(needed * terms)) * (terms+6)) - total)/6);
    }


    
    
    public String advise() {
	one = (int)(Math.round(nextTest()));
	two = (int)(Math.round(twoTests()));
	three = (int)(Math.round(threeTests()));
	four = (int)(Math.round(fourTests()));
	five = (int)(Math.round(fiveTests()));
	six = (int)(Math.round(sixTests()));
	finalAvg = (int)(Math.round(avg));
	uno = (int)(Math.round(combo1()));
	dos = (int)(Math.round(combo2()));

	if (one < 65){
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". You are on the right track to earning your goal of " + goal + ". Keep it up!";
	    return blah;
	}	    
	else if (one <= 100){
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". In order to reach your goal of " + goal + " you must score at least " + one + " \n on your next test.";
	    return blah;
	}

	else if (uno <= 100){
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". In order to reach your goal of " + goal + " you must score at least " + uno  + " \n on your next " + num + " test(s) and 100% on your next quiz";
	    return blah;
	}
		    
	else if (two<= 100) {
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". In order to reach your goal of " + goal + " you must score at least " + two + " \n on your two tests.";
	    return blah;
	}
	else if (dos <= 100){
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". In order to reach your goal of " + goal + " you must score at least " + dos  + " \n on your next " + numb + " test(s) and 100% on your next two quizzes";
	    return blah;
	}
	else if (three <= 100) {
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". In order to reach your goal of " + goal + " you must score at least " + three + " \n on your three tests.";
	    return blah;
	}
	else if (four <= 100) {
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". In order to reach your goal of " + goal + " you must score at least " + four + " \n on your four tests.";
	    return blah;
	}
	else if (five <= 100) {
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". In order to reach your goal of " + goal + " you must score at least " + five + " \n on your five tests.";
	    return blah;
	}
	else if (six <= 100) {
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". In order to reach your goal of " + goal + " you must score at least" + six + " \n on your two six tests.";
	    return blah;
	}
	else {
	    String blah = "Hi " + user + "! Your current average is " + finalAvg + ". It seems your goal of " + goal + " is very ambitious, but I am afraid that it will be difficult to reach this goal. You can change your goal to be more realistic. If you feel that you still want to reach this goal, you may need to have a conversation with your " + name + " teacher.";
	    return blah;}
	
	

	
    }

    public static void main (String[]args) {
	Subjects Physics =  new Subjects(0);
	Physics.loadData("Example.csv", "Bob");

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

	
	
/**import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Subjects {
    private String user;
    private int subnum;
    private int goal;
    private String tests;
    private String quizzes;
    private String projects;
    private String homework;
    private String  breakdown;
    private String name;
    public int[] b;
    public int[] tG;
    public int[] qG;
    public int[] pG;
    public int[] hG;
    private double avg;
    private ArrayList<String> data;
    private String[] dta;
    private String[] subject;
    

  
    public void loadData(String fileName, String username){
    
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
	
	for (int i = 0; i < data.size() - 1; i++){
	    dta[i] = data.get(i);
	}
    
    }

    
    
    public Subjects(int x){
	 data = new ArrayList<String>();
	subnum = x;
        goal = 90;
=======
>>>>>>> master
	tests= "";
	quizzes = "";
	projects= "";
	homework = "";
	breakdown = "";
	name = "";
	dta = new String[355];
   
	
	}

    public void fillSubject(){
	try{
	    int start = 2 + (7*subnum);
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
	} catch(NumberFormatException e){
    	    System.out.println("");
    	    
     	}
	
	for (int i = 0; i < data.size(); i++){
	    dta[i] = data.get(i);
	}
    }


    public int getGoal() {
	return goal;
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
    
    public  static String toString(int[] ary){
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
	one = (int)(Math.round(nextTest()));
	two = (int)(Math.round(twoTests()));
	three = (int)(Math.round(threeTests()));

	String blah = "Hi " + user + "! " +"In order to reach your goal of " + goal + " you must score " + one + " \n on your next test, or score " + two + "  on your next two tests,\n or " + three + " on your next three tests.   " ;

	return blah;
    }

    public static void main (String[]args) {
	Subjects Physics =  new Subjects(0);
	Physics.loadData("Example.csv", "Bob");

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
	
	
*/
    
