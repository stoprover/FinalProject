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
    private JList subList;
    private JLabel advice;

   
	public GUI(){
		
	        //-----------------------------------------------------------------
		this.setSize(600, 700);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Robo-Counselor: Grade Manager");
		JPanel panel = new JPanel();
		//-----------------------------------------------------------------

	        panel.setLayout(new GridLayout(0,1,4,4));
	        
		this.add(panel);
		this.setVisible(true);//opens window
		
		//------------------------
		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("APUSH");
		listModel.addElement("Physics");
		listModel.addElement("PreCalculus");
		subList  = new JList<>(listModel);
        	//------------------------
		sub = new JLabel("Physics");
		advice = new JLabel("In order to reach your goal of _____, you must score _______ on you next test.");
	


		
		panel.add(sub);
	        panel.add(subList);
		   	
		panel.add(advice);
	}

}
