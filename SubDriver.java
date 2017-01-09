public class SubDriver {
    public static void main (String[]args) {
	Subjects Physics =  new Subjects("Physics", "50.20.20.10.", "98.87.81.92.95.", "100.100.80.80.", "100.", "90.100.90.");

	System.out.println (Physics.getName());
	System.out.println (toString(Physics.getTests()));
	System.out.println (toString(Physics.getQuizzes()));
    }
}
	
