package Layout;
import javax.swing.*;
import java.awt.*;
public class LoginGUI implements Itemlistener{
	JPanel cards;
	final static String Login = "Log in!";
	final static String CreateAcc = "Create an account!";
	public void addComp (Container pane){
    JPanel comboBoxPane = new JPanel();
String
	private Container pane;
	private JCheckBox pickAnAct;
	private JButton lesgo;
	private JLabel username;
	private JLabel passname;
	private JTextField userinput;
	private JTextField passinput;
	public LoginGUI(){
    this.setTitle("Log in or sign up");
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new CardLayout());

pickAnAct = new JCheck
    lesgo = new JButton("Let's go!");

