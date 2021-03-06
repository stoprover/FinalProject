import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.*;

public class GUI extends JFrame{

    //Really not necessary, but helps me keep track.
    private String scoresQ;
    private String scoresT;
    private String scoresP;
    private String scoresH;
    private String blah;
    private String name;
    private ArrayList<String> data;
    private String[] subNames;
    private int subnum;
    
    
   
 
    // MAIN
    public static void main(String[] args){
	new GUI("Example.csv", "Bob")	;
    }


    private void loader (int x, String fileName,String user) {
	Subjects nom = new Subjects(x);
	try{
	    //Subjects nom =  new Subjects(x);
	    nom.loadData(fileName,user);
	    nom.fillSubject();
	    scoresT = toString(nom.getTests());
	    scoresQ = toString(nom.getQuizzes());
	    scoresP = toString(nom.getProjects());
	    scoresH = toString(nom.getHomework());
	    nom.nextTest();
	    nom.twoTests();
	    nom.threeTests();
	    nom.getBreakdown();
	    nom.getTests();
	    nom.getQuizzes();
	    nom.getProjects();
	    nom.getHomework();
	    nom.average();
	    nom.nextTest();
	    blah = nom.advise();
	}catch (NumberFormatException e){
	    //Subjects nom =  new Subjects(x);
	    nom.loadData(fileName,user);
	    nom.fillSubject();
	    scoresT = "";
	    scoresQ = "";
	    scoresP = "";
	    scoresH = "";
	    blah = "";
	}
    }
	
	

    
    //Features 
    private JLabel sub;
    private JLabel portion2;
    private JLabel portion1;
    private JLabel portion3;
    private JLabel portion4;
    private JComboBox<String> subList;
    private JList subList1;
    private JList subList2;
    private JList subList3;
    private JList subList4;
    private JTextArea advice;
    private JButton go;
    private JLabel G1;
    private JLabel G2;
    private JLabel G3;
    private JLabel G4;
    
    //toString for the grade data
    private static String toString(int[] ary){
	String x = " ";
	int y = 0;
	for(int i = 0; i < ary.length; i++){
	    y++;	 	
	    x = x + "#" + y + ": " +  ary[i] + "    ";	 	
	}
	return x;
    }
   
    // GUI STUFF
    //public GUI(String fileName, String user){
    public GUI(final String fileName, final String user){
	// Get Subjects
	data = new ArrayList<String>();
	
     	try{ Scanner qw = new Scanner(new File (fileName)).useDelimiter(",");
	    //Add Subject names for the comboBox
	    String temp = "";
	    while (!temp.equals(user)){	
		qw.nextLine();
		temp = qw.next();	  
	    }	    
	    qw.next();
	    qw.next();
	    data.add(qw.next());	 
	    for(int i = 0; i < 9; i++){
		qw.next();
		qw.next();
		qw.next();
		qw.next();
		qw.next();
		qw.next();
		data.add(qw.next());		
	    }

     	}catch(FileNotFoundException e){
    	    System.out.println("File does not exist");
    	    System.exit(1);
     	}
    

	while (data.remove("")) {
	    data.remove("");
	}
	
	subNames = new String[data.size()];
	for (int i = 0; i < data.size(); i++){
	    subNames[i] = data.get(i);
	}
	data.trimToSize();

	//------------------------
	loader(0, fileName , user);

		
	//Dimensions

	final JFrame frame = new JFrame("Robo-Counselor: Grade Manager");
	frame.setSize(750, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel panel = new JPanel();
	//-----------------------------------------------------------------panel begins

	//GRID LAYOUT
	panel.setLayout(new GridLayout(0,1,4,4));
	        
	this.add(panel);
	this.setVisible(true);//opens window
		
	//Grade Labels
	G1 = new JLabel("      " + scoresT);
	G1.setFont(new Font("Serif", Font.PLAIN, 15));
	G2 = new JLabel("      " + scoresQ);
	G2.setFont(new Font("Serif", Font.PLAIN, 15));
	G3 = new JLabel("      " + scoresP);
	G3.setFont(new Font("Serif", Font.PLAIN, 15));
	G4 = new JLabel("      " + scoresH);
	G4.setFont(new Font("Serif", Font.PLAIN, 15));


	//ComboBoxes
	String[] function = new String[3];
	function[0] = "Grade Tracker";
	function[1] = "Sleep Tracker";
	function[2]= "Activity Tracker";
	final JComboBox<String> funcList = new JComboBox<>(function);
	//JComboBox<String> funcList = new JComboBox<>(function);
	funcList.setFont(new Font("Serif", Font.PLAIN, 18));
	String selectedfunc = (String) funcList.getSelectedItem();
	System.out.println("Welcome to " + selectedfunc);

	subList = new JComboBox<>(subNames);
	subList.setFont(new Font("Serif", Font.PLAIN, 18));
       	String selectedsub = (String) subList.getSelectedItem();
	System.out.println("You seleted the subject: " + selectedsub);

	//Titles

	sub = new JLabel("     " + selectedsub);
	sub.setFont(new Font("Serif", Font.BOLD, 25));

	portion1 = new JLabel("         Tests         ");
	portion1.setFont(new Font("Serif", Font.BOLD, 20));
	portion2 = new JLabel("         Quizzes         ");
	portion2.setFont(new Font("Serif", Font.BOLD, 20));
	portion3 = new JLabel("         Projects         ");
	portion3.setFont(new Font("Serif", Font.BOLD, 20));
	portion4 = new JLabel("         Homework         ");
	portion4.setFont(new Font("Serif", Font.BOLD, 20));

	advice = new JTextArea(2500, 2000);
	advice.setText(blah);
	advice.setWrapStyleWord(true);
	advice.setLineWrap(true);
	advice.setOpaque(false);
	advice.setEditable(false);
	advice.setFocusable(false);	
	advice.setFont(new Font("Lucida Handwriting", Font.PLAIN, 12));

	//JButton

	go  = new JButton("Go!");
	go.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{String selectedfunc = (String) funcList.getSelectedItem();
		    if (selectedfunc != "Grade Tracker") {
			G2.setText("");
			G1.setText("");
			G3.setText("");
			G4.setText("");
			advice.setText("");
			portion1.setText("");
			portion2.setText("");
			portion3.setText("");
			portion4.setText("");
			sub.setText( "   >_< Oops! This feature is not available!");
		    }
		    else {										
		    //Change Subject Name
		    String selectedsub = (String) subList.getSelectedItem();
		    System.out.println("You seleted the subject: " + selectedsub);
		    sub.setText("     " + selectedsub);

		    int index = -1;
		    for (int i=0;i<subNames.length;i++) {
			if (subNames[i].equals(selectedsub)) {
			    index = i;
			    break;
			}
		    }
		    
		    //Load Grade information
		    loader(index, fileName, user);
		    //Fill
		    G2.setText("      " + scoresQ);
		    G1.setText("      " + scoresT);
		    G3.setText("      " + scoresP);
		    G4.setText("      " + scoresH);
		    advice.setText(blah);
		    portion1.setText("         Tests         ");
		    portion2.setText("         Quizzes         ");
		    portion3.setText("         Projects         ");
		    portion4.setText("         Homework         ");
		    }
		}
	    });
	    
	
	//ADD STUFF into Panel
	panel.add(funcList);
	panel.add(subList);
	panel.add(go);
	panel.add(sub);
	panel.add(portion1);
	panel.add(G1);
	panel.add(portion2);
	panel.add(G2);
	panel.add(portion3);
	panel.add(G3);
	panel.add(portion4);
	panel.add(G4);
	panel.add(advice);
	//-----------------------------------------------------Panel ends
	//-----------------------------------------------------Panel2 begins

	JPanel panel2 = new JPanel();
	panel2.setLayout(new GridLayout(0,1,4,4));
      	this.add(panel2);
	this.setVisible(true);

	////Spinners
	SpinnerNumberModel goalCh = new SpinnerNumberModel(90, 65, 105, 1 );
	JSpinner spinnerGoal = new JSpinner(goalCh);
	spinnerGoal.setFont(new Font("Serif", Font.PLAIN, 18));
	SpinnerNumberModel gradeT = new SpinnerNumberModel(90, 65, 105, 1 );
	JSpinner spinnerT = new JSpinner(gradeT);
	spinnerT.setFont(new Font("Serif", Font.PLAIN, 18));
	SpinnerNumberModel gradeQ = new SpinnerNumberModel(90, 65, 105, 1 );
	JSpinner spinnerQ = new JSpinner(gradeQ);
	spinnerQ.setFont(new Font("Serif", Font.PLAIN, 18));
	SpinnerNumberModel gradeP = new SpinnerNumberModel(90, 65, 105, 1 );
	JSpinner spinnerP = new JSpinner(gradeP);
	spinnerP.setFont(new Font("Serif", Font.PLAIN, 18));
	SpinnerNumberModel gradeH = new SpinnerNumberModel(90, 65, 105, 1 );
	JSpinner spinnerH = new JSpinner(gradeH);
	spinnerH.setFont(new Font("Serif", Font.PLAIN, 18));

	//Labels
	JLabel changeGoal = new JLabel("Change your Goal");
	changeGoal.setFont(new Font("Serif", Font.PLAIN, 15));
	JLabel changeT = new JLabel("Add a Test");
	changeT.setFont(new Font("Serif", Font.PLAIN, 15));
	JLabel changeQ = new JLabel("Add a Quiz");
	changeQ.setFont(new Font("Serif", Font.PLAIN, 15));
	JLabel changeP = new JLabel("Add a Project");
	changeP.setFont(new Font("Serif", Font.PLAIN, 15));
	JLabel changeH = new JLabel("Add a Homework");
	changeH.setFont(new Font("Serif", Font.PLAIN, 15));

	//Buttons
	JButton addGoal = new JButton ("Change my goal");
	addGoal.setFont(new Font("Serif", Font.PLAIN, 15));
	JButton addT  = new JButton("Add");
	addT.setFont(new Font("Serif", Font.PLAIN, 15));
	JButton addQ  = new JButton("Add");
	addQ.setFont(new Font("Serif", Font.PLAIN, 15));
	JButton addP  = new JButton("Add");
	addP.setFont(new Font("Serif", Font.PLAIN, 15));
	JButton addH  = new JButton("Add");
	addH.setFont(new Font("Serif", Font.PLAIN, 15));
	
	//ComboBoxes
	JComboBox<String> subsList = new JComboBox<>(subNames);
	subsList.setFont(new Font("Serif", Font.PLAIN, 18));
       	String subselected = (String) subsList.getSelectedItem();
	System.out.println("You seleted the subject: " + subselected);
	    
	panel2.add(subsList);
	panel2.add(changeGoal);
	panel2.add(spinnerGoal);
	panel2.add(addGoal);
	panel2.add(changeT);
	panel2.add(spinnerT);
	panel2.add(addT);
	panel2.add(changeQ);
	panel2.add(spinnerQ);
	panel2.add(addQ);
	panel2.add(changeP);
	panel2.add(spinnerP);
	panel2.add(addP);
	panel2.add(changeH);
	panel2.add(spinnerH);
	panel2.add(addH);

	//----------------------------------------------------Panel2 ends
	//----------------------------------------------------Panel3 begins

	JPanel panel3 = new JPanel();
	panel3.setLayout(new GridLayout(0,1,4,4));
      	this.add(panel3);
	this.setVisible(true);
	
	JLabel addWel = new JLabel("Hello, here you can add a new Subject to manage!");
	addWel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 18));
	JLabel addName = new JLabel("Type in the name of your new subject below");
	addName.setFont(new Font("Serif", Font.PLAIN, 18));
	
        final JTextField inputName = new JTextField();
	inputName.setFont(new Font("Serif", Font.PLAIN, 18));
	JLabel goalEnt = new JLabel("Type in the goal average of your new subject below");
	goalEnt.setFont(new Font("Serif", Font.PLAIN, 18));
	JLabel insEnt = new JLabel("Type in the breakdown of your new subject below");
	insEnt.setFont(new Font("Serif", Font.PLAIN, 18));
	JLabel tEnt = new JLabel("Value of tests (in percent)");
	tEnt.setFont(new Font("Serif", Font.PLAIN, 18));
	JLabel qEnt = new JLabel("Value of quizzes (in percent)");
	qEnt.setFont(new Font("Serif", Font.PLAIN, 18));
	JLabel pEnt = new JLabel("Value of projects (in percent)");
	pEnt.setFont(new Font("Serif", Font.PLAIN, 18));
	JLabel hEnt = new JLabel("Value of homework (in percent)");
	hEnt.setFont(new Font("Serif", Font.PLAIN, 18));
	final JLabel errMsg = new JLabel("");
	errMsg.setFont(new Font("Serif", Font.PLAIN, 18));
	
	
        
	SpinnerNumberModel goalT = new SpinnerNumberModel(90, 0, 100, 1 );
	final JSpinner inputGoal = new JSpinner(goalT);
	int goalVal = (Integer) inputGoal.getValue();
	inputGoal.setFont(new Font("Serif", Font.PLAIN, 18));
	
	SpinnerNumberModel gT = new SpinnerNumberModel(60, 0, 100, 5 );
	final JSpinner inputT = new JSpinner(gT);
	inputT.setFont(new Font("Serif", Font.PLAIN, 18));
	int testVal = (Integer) inputT.getValue();
	
	SpinnerNumberModel gQ = new SpinnerNumberModel(30, 0, 100, 5 );
	final JSpinner inputQ = new JSpinner(gQ);
	inputQ.setFont(new Font("Serif", Font.PLAIN, 18));
	int quizVal = (Integer) inputQ.getValue();

	
	SpinnerNumberModel gP = new SpinnerNumberModel(5, 0, 100, 5 );
	final JSpinner inputP = new JSpinner(gP);
	inputP.setFont(new Font("Serif", Font.PLAIN, 18));
	int projVal = (Integer) inputP.getValue();

	
	SpinnerNumberModel gH = new SpinnerNumberModel(5, 0, 100, 5 );
	final JSpinner inputH = new JSpinner(gH);
	inputH.setFont(new Font("Serif", Font.PLAIN, 18));
	int homeVal = (Integer) inputH.getValue();

	JButton addAll  = new JButton("Add New Subject");
	addAll.setFont(new Font("Serif", Font.PLAIN, 15));
	//----------------------Button does stuff yay!!!
	

	addAll.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    String newname = (String) inputName.getText();
		    int goalVal = (Integer) inputGoal.getValue();
		    int testVal = (Integer) inputT.getValue();
		    int quizVal = (Integer) inputQ.getValue();
		    int projVal = (Integer) inputP.getValue();
		    int homeVal = (Integer) inputH.getValue();
		    int total = testVal + quizVal + projVal + homeVal;
		    if (total != 100){
			errMsg.setText("Your breakdown does not add up to 100%");
		    }
		    else if (newname.equals("")){
			errMsg.setText("Please enter a subject Name!");
		    }
		    else{
			errMsg.setText("Success! Your subject has been added.");
			String brkdwn = "" + testVal + "." + "" + quizVal + "." + "" + projVal + "." + "" + homeVal + ".";
			System.out.println("New Subject Added!:" + " BreakDown- " +  brkdwn + " Goal- " + goalVal + " Name- " +  newname);
		    }
			
		    
		    
		}
	    });




	

	// make sure the breakdown = 100

	panel3.add(addWel);
	panel3.add(addName);
	panel3.add(inputName);
	panel3.add(goalEnt);
	panel3.add(inputGoal);
	panel3.add(tEnt);
	panel3.add(inputT);
	panel3.add(qEnt);
	panel3.add(inputQ);
	panel3.add(pEnt);
	panel3.add(inputP);
	panel3.add(hEnt);
	panel3.add(inputH);
	panel3.add(addAll);
	panel3.add(errMsg);
	
       
	

	


	//----------------------------------------------------Panel3 ends
	//TABS-----------------------------------------------------------------------
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Get Advice", panel);
	tabbedPane.addTab("Manage your information", panel2);
	tabbedPane.addTab("Add new Subject", panel3);
	frame.getContentPane().add(tabbedPane);
	

	
    }

}
