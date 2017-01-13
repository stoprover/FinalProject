public class SubDriver {
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
