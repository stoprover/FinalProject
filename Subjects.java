

public class Subjects {

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

  

    public Subjects(String n, String b, String te, String qu, String pr, String hw){

	    name = n;
	    tests = te;
	    quizzes = qu;
	    projects = pr;
	    homework = hw;
	    breakdown = b;
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
	int terms = ary.length;
	int avg = sum / terms;
	return avg;
    }

    public  double average() {

	double rawT = findAvg(tG) * b[0] ;
	double rawQ = findAvg(qG) * b[1] ;
	double rawP = findAvg(pG) * b[2];
	double rawH = findAvg(hG) * b[3];

	double avg = (rawT + rawQ + rawP + rawH)/100;

	return avg;
    }
	    
	

    public static void main (String[]args) {
	Subjects Physics =  new Subjects("Physics", "50.20.20.10.", "98.87.81.92.95.", "100.100.80.80.", "100.", "90.100.90.");

	System.out.println (Physics.getName());
	System.out.println (toString(Physics.getBreakdown()));
	System.out.println (toString(Physics.getTests()));
	System.out.println (toString(Physics.getQuizzes()));
	System.out.println (toString(Physics.getProjects()));
	System.out.println (toString(Physics.getHomework()));
	System.out.println (Physics.average());
        
    }

}
	
	

    
