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

    public static void main(String[] args){	
	new GUI()	;
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

   
    public GUI(){

	    
	Subjects Physics =  new Subjects(1);
	Physics.loadData("Example.csv");
	int[] scoresT = Physics.getTests();
	int[] scoresQ = Physics.getQuizzes();
	int[] scoresP = Physics.getProjects();
	int[] scoresH = Physics.getHomework();
	String blah = (Physics.advise());

		
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
	for (int i = 0; i < scoresT.length ; i++){
	    String input = "" + scoresT[i];
	    listModel1.addElement(input);
	}
		subList1  = new JList<>(listModel1);

		DefaultListModel<String> listModel2 = new DefaultListModel<>();
		for (int i = 0; i < scoresQ.length ; i++){
		    String input = "" + scoresQ[i];
		    listModel2.addElement(input);
		}
		subList2  = new JList<>(listModel2);

		DefaultListModel<String> listModel3 = new DefaultListModel<>();
		for (int i = 0; i < scoresP.length ; i++){
		    String input = "" + scoresP[i];
		    listModel3.addElement(input);
		}
		subList3  = new JList<>(listModel3);

		DefaultListModel<String> listModel4 = new DefaultListModel<>();
		for (int i = 0; i < scoresH.length ; i++){
		    String input = "" + scoresH[i];
		    listModel4.addElement(input);
		}
		subList4  = new JList<>(listModel4);
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
