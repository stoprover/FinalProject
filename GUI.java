import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.*;



public class GUI extends JFrame {

    private String scoresQ;
    private String scoresT;
    private String  scoresP;
    private String scoresH;
    private String blah;
    private String name;


    
    public static void main(String[] args){
	

	new GUI("Example.csv", "Bob")	;
    }

     
    private JLabel sub;
    private JLabel portion2;
    private JLabel portion1;
    private JLabel portion3;
    private JLabel portion4;
    private JList subList1;
    private JList subList2;
    private JList subList3;
    private JList subList4;
    private JLabel advice;
    
 private static String toString(int[] ary){
	   String x = " ";
	   int y = 0;
	     for(int i = 0; i < ary.length; i++){
		 y++;
	 	
	 	    x = x + "#" + y + ": " +  ary[i] + "    ";
	 	
	 	
	     }
	     return x;
	 }
   
    public GUI(String fileName, String user){

	Subjects Physics =  new Subjects(0);
	Physics.loadData(fileName,user);
	Physics.fillSubject();
	scoresT = toString(Physics.getTests());
	scoresQ = toString(Physics.getQuizzes());
	scoresP = toString(Physics.getProjects());
	scoresH = toString(Physics.getHomework());
	blah = (Physics.advise());
	name = Physics.getName();
		
	//-----------------------------------------------------------------
	this.setSize(1000, 800);
        
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Robo-Counselor: Grade Manager");
	JPanel panel = new JPanel();
	//-----------------------------------------------------------------

	panel.setLayout(new GridLayout(0,1,4,4));
	        
	this.add(panel);
	this.setVisible(true);//opens window
		
	//------------------------
	DefaultListModel<String> listModel1 = new DefaultListModel<>();
	listModel1.addElement(scoresT);
	subList1  = new JList<>(listModel1);
	subList1.setFont(new Font("Serif", Font.PLAIN, 20));
	
	DefaultListModel<String> listModel2 = new DefaultListModel<>();
	listModel2.addElement(scoresQ);
	subList2  = new JList<>(listModel2);
	subList2.setFont(new Font("Serif", Font.PLAIN, 20));
	
	DefaultListModel<String> listModel3 = new DefaultListModel<>();
	listModel3.addElement(scoresP);
	subList3  = new JList<>(listModel3);
	subList3.setFont(new Font("Serif", Font.PLAIN, 20));
	
	DefaultListModel<String> listModel4 = new DefaultListModel<>();
	listModel4.addElement(scoresH);
	subList4  = new JList<>(listModel4);
	subList4.setFont(new Font("Serif", Font.PLAIN, 20));

	
        	//------------------------
		sub = new JLabel("     Physics         ");
		sub.setFont(new Font("Serif", Font.PLAIN, 30));

		portion1 = new JLabel("         Tests         ");
		portion1.setFont(new Font("Serif", Font.PLAIN, 25));
		portion2 = new JLabel("         Quizzes         ");
		portion2.setFont(new Font("Serif", Font.PLAIN, 25));
		portion3 = new JLabel("         Projects         ");
		portion3.setFont(new Font("Serif", Font.PLAIN, 25));
		portion4 = new JLabel("         Homework         ");
		portion4.setFont(new Font("Serif", Font.PLAIN, 25));
		
		advice = new JLabel(blah);
		advice.setFont(new Font("Serif", Font.PLAIN, 15));
		System.out.println(blah);


		
		panel.add(sub);
		panel.add(portion1);
	        panel.add(subList1);
		panel.add(portion2);
	        panel.add(subList2);
		panel.add(portion3);
	        panel.add(subList3);
		panel.add(portion4);
	        panel.add(subList4);
		panel.add(advice);
	}

}
