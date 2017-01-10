import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginGUI extends JFrame{
    //some standardization: sign up/sign in refers to creating an account, log in refers to already having one
    //to-do's: if there is already such a username as being inputted to signup, forbid it
    //password field (later problem)
    //possibility: make login buttons switch to a third card: janices.
    private JFrame frame = new JFrame("LogSign");
    private JPanel panelBoth = new JPanel();
    private JPanel panelLog = new JPanel();
    private JPanel panelSign = new JPanel();
    private JLabel userLogLabel = new JLabel ("Username: ");
    private JLabel passLogLabel = new JLabel ("Password: ");
    private JTextField userLogInput = new JTextField(12);
    private JPasswordField passLogInput = new JPasswordField(12);
    private JTextField logMessage = new JTextField(12);
    private JButton toLogIn = new JButton ("Log in!");
    private JButton switchToSign = new JButton ("Sign up instead");
    private JLabel userSignLabel = new JLabel ("Username: ");
    private JLabel passSignLabel = new JLabel ("Password: ");
    private JTextField userSignInput = new JTextField(12);
    private JPasswordField passSignInput = new JPasswordField(12);
    private JTextField signMessage = new JTextField(12);
    private JButton toSignUp = new JButton("Sign up!");
    private JButton switchToLog = new JButton ("Log in instead");
    Boolean goodPass;
    Boolean goodUser;
    CardLayout cl = new CardLayout();

    public LoginGUI(){
	panelBoth.setLayout(cl);
	panelLog.add(userLogLabel);
	panelLog.add(userLogInput);
	panelLog.add(passLogLabel);
	panelLog.add(passLogInput);
	panelLog.add(toLogIn);
	panelLog.add(switchToSign);
	panelLog.add(logMessage);
	panelSign.add(userSignLabel);
	panelSign.add(userSignInput);
	panelSign.add(passSignLabel);
	panelSign.add(passSignInput);
	panelSign.add(toSignUp);
	panelSign.add(switchToLog);
	panelSign.add(signMessage);
	//panelLog.setBackground(Color.BLUE);
	//panelSign.setBackground(Color.GREEN);

	panelBoth.add(panelLog, "1");
	panelBoth.add(panelSign, "2");
	cl.show(panelBoth, "1");
	//	this.show(panelBoth, "1");

	toLogIn.addActionListener (new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    String apple = userLogInput.getText();
		    userSignInput.setText(apple);
		    dispose();//this should close the window, but that's a minor technicality
		    new LoginGUI();//this shoudl actually be nwhatever Janice chooses to be her main GUI.

		}
	    });

	switchToSign.addActionListener( new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    cl.show(panelBoth, "2");
		    //this.show(panelBoth, "2");
		}
	    });
	switchToLog.addActionListener( new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    cl.show(panelBoth, "1");
		    //this.show(panelBoth, "1");
		}
	    });

	frame.add(panelBoth);
	frame.setTitle("Log in or Sign up");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
    }
    public String getInfo(JTextField jt){
	String text = jt.getText();
	System.out.println(text);
	return text;
    }

    public static void main(String[]args){
        LoginGUI l = new LoginGUI();
	l.setVisible(true);
	//	getInfo(userLogInput);
	//System.out.println(this.getInfo(userLogInput));
	/**	SwingUtilities.invokeLater(new Runnable(){
		//@Override
		public void run(){
		    new LearningCL();
		}
		});*/
    }
}

