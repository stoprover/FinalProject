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
    private JButton toLogIn = new JButton ("Log in!");
    private JButton switchToSign = new JButton ("Sign up instead");
    private JLabel userSignLabel = new JLabel ("Username: ");
    private JLabel passSignLabel = new JLabel ("Password: ");
    private JTextField userSignInput = new JTextField(12);
    private JPasswordField passSignInput = new JPasswordField(12); 
    private JButton toSignUp = new JButton("Sign up!");
    private JButton switchToLog = new JButton ("Log in instead");
    CardLayout cl = new CardLayout();

    public LoginGUI(){
	panelBoth.setLayout(cl);
	panelLog.add(userLogLabel);
	panelLog.add(userLogInput);
	panelLog.add(passLogLabel);
	panelLog.add(passLogInput);
	panelLog.add(toLogIn);
	panelLog.add(switchToSign);
	panelSign.add(userSignLabel);
	panelSign.add(userSignInput);
	panelSign.add(passSignLabel);
	panelSign.add(passSignInput);
	panelSign.add(toSignUp);
	panelSign.add(switchToLog);
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
		    dispose();
		    new LoginGUI();
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
/**import java.awt.*;
=======
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
=======
import java.awt.*;
>>>>>>> 1e9352717887cb5cd62685b4ec6c2851f562eb2e
import java.awt.event.*;
import javax.swing.*;
public class LoginGUI extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

    public LoginGUI() {
	this.setTitle("My first GUI");
<<<<<<< HEAD
=======
>>>>>>> 1695bcdde7dc0eb4b8b232089887b81e2babee8f
>>>>>>> 1e9352717887cb5cd62685b4ec6c2851f562eb2e
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
<<<<<<< HEAD
=======
<<<<<<< HEAD
	pane.setLayout(new CardLayout());

pickAnAct = new JCheck
	lesgo = new JButton("Let's go!");
=======
>>>>>>> 1e9352717887cb5cd62685b4ec6c2851f562eb2e
	pane.setLayout(new BoxLayout(pane, CardLayout));
	JButton b = new JButton("ByteMe");
	b.addActionListener(this);
	b.setActionCommand("Byte");
	JButton b2 = new JButton("No...");
	b2.addActionListener(this);
	b2.setActionCommand("NotByte");
	t = new JTextField(10);
	JCheckBox c = new JCheckBox("OverClock");
	j = new JLabel("Meaning of life is... ");
	pane.add(c);
	pane.add(t);
	pane.add(b);
	pane.add(b2);
	pane.add(j);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("Byte")){
	    String s = t.getText();
	    s += "-0101000";
	    j.setText(s);
	}
	if(event.equals("NotByte")){
	    j.setText("Fish");
	}
    }
    public static void main(String[] args) {
	LoginGUI g = new LoginGUI();
	g.setVisible(true);
  }
}
    /**JPanel cards;
    final static String Login = "Log in!";
    final static String Create = "Create an account!";
    public void addComponentToPane (Container pane){
	JPanel comboBoxPane = new JPanel(); //a new pane is created
	String comboBoxItems[] = { Login, Create }; //these are the choices in the combobox
	JComboBox choose = new JComboBox (comboBoxItems); //combobox gets choices assigned to it
	choose.setEditable (false);
	choose.addItemListener (this);
	comboBoxPane.add(choose);

	JPanel login = new JPanel();
	login.add(new JLabel("username"));
	login.add(new JLabel("password"));
	login.add(new JTextField("userinput"));
	login.add(new JTextField("passinput"));
	login.add(new JButton("Sign in!"));

	JPanel create = new JPanel();
	create.add(new JLabel("first name"));
	create.add(new JLabel("last name"));
	create.add(new JLabel("OSIS"));
	create.add(new JLabel("username"));
	create.add(new JLabel("password"));
	create.add(new JTextField("firstInput"));
	create.add(new JTextField("lastInput"));
	create.add(new JTextField("OSISInput"));
	create.add(new JTextField("userInput"));
	create.add(new JTextField("passInput"));
	create.add(new JButton("Create account!"));

	cards = new JPanel(new CardLayout());
	cards.add(login, Login);
	cards.add(create, Create);
	pane.add(comboBoxPane, BorderLayout.PAGE_START);
	pane.add(cards, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent e){
	CardLayout cl = (CardLayout)(cards.getLayout());
	cl.show(cards, (String)e.getItem());
    }
    public static void createAndShowGUI(){
	JFrame frame = new JFrame("Log in or sign up");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	LoginGUI login = new LoginGUI();
	login.addComponentToPane(frame.getContentPane());
	frame.pack();
	frame.setVisible(true);
    }
    public static void main(String[]args){
	javax.swing.SwingUtilities.invokeLater(new Runnable(){
		public void run(){
		    createAndShowGUI();
		}
	    });
    }
}
	
/**	private Container pane;
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
lesgo = new JButton("Let's go!");*/

/**<<<<<<< HEAD
=======
>>>>>>> 1695bcdde7dc0eb4b8b232089887b81e2babee8f
>>>>>>> 1e9352717887cb5cd62685b4ec6c2851f562eb2e*/
