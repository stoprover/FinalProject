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
	this.setSize(700, 800);
        
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Robo-Counselor: Grade Manager");
	JPanel panel = new JPanel();
	//-----------------------------------------------------------------

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
	    
	
	//ADD STUFF
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
	
	
    }

}

//Ref:::https://examples.javacodegeeks.com/desktop-java/swing/jtabbedpane/create-jtabbedpane-example/
