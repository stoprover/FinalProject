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
    JPanel panelBoth = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    JButton buttonOne = new JButton ("swtich to 2");
    JButton buttonSecond = new JButton("Switch to 1");
    CardLayout cl = new CardLayout();

    public LearningCL(){
	panelBoth.setLayout(cl);

	panelFirst.add(buttonOne);
	panelSecond.add(buttonSecond);
	//panelFirst.setBackground(Color.BLUE);
	//panelSecond.setBackground(Color.GREEN);

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
