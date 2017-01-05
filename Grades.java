public class Grades {
    private String date;
    private double score;

    public Grade(String d, double s) {
	date = d;
	score = s;
    }

    public toDisplay() {
	return (date + "     " + score);
    }


}
