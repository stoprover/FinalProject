import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LearningCL extends JFrame{
    JFrame frame = new JFrame("CardLayout learning");
<<<<<<< HEAD
    JPanel panelBoth = new JPanel();
=======
    JPanel panelCont = new JPanel();
>>>>>>> 1e9352717887cb5cd62685b4ec6c2851f562eb2e
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    JButton buttonOne = new JButton ("swtich to 2");
    JButton buttonSecond = new JButton("Switch to 1");
    CardLayout cl = new CardLayout();

    public LearningCL(){
<<<<<<< HEAD
	panelBoth.setLayout(cl);
=======
	panelCont.setLayout(cl);
>>>>>>> 1e9352717887cb5cd62685b4ec6c2851f562eb2e

	panelFirst.add(buttonOne);
	panelSecond.add(buttonSecond);
	//panelFirst.setBackground(Color.BLUE);
	//panelSecond.setBackground(Color.GREEN);

<<<<<<< HEAD
	panelBoth.add(panelFirst, "1");
	panelBoth.add(panelSecond, "2");
	cl.show(panelBoth, "1");

	buttonOne.addActionListener( new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    cl.show(panelBoth, "2");
		}
	    });
	buttonSecond.addActionListener( new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    cl.show(panelBoth, "1");
		}
	    });

	frame.add(panelBoth);
	frame.setTitle("Log in or Sign up");
=======
	panelCont.add(panelFirst, "1");
	panelCont.add(panelSecond, "2");
	cl.show(panelCont, "1");

	buttonOne.addActionListener( new ActionListener () {
	//buttonOne.setActionCommand({
		@Override
		public void actionPerformed(ActionEvent arg0){
		    cl.show(panelCont, "2");
		}
	    });
	buttonSecond.addActionListener( new ActionListener () {//(this) { //new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    cl.show(panelCont, "1");
		}
	    });

	frame.add(panelCont);
>>>>>>> 1e9352717887cb5cd62685b4ec6c2851f562eb2e
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[]args){
	LearningCL l = new LearningCL();
	l.setVisible(true);
	/**	SwingUtilities.invokeLater(new Runnable(){
		//@Override
		public void run(){
		    new LearningCL();
		}
		});*/
    }
}
