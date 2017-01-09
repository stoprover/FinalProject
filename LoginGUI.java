<<<<<<< HEAD
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
import java.awt.event.*;
import javax.swing.*;
public class LoginGUI extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

    public LoginGUI() {
	this.setTitle("My first GUI");
>>>>>>> 1695bcdde7dc0eb4b8b232089887b81e2babee8f
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
<<<<<<< HEAD
	pane.setLayout(new CardLayout());

pickAnAct = new JCheck
	lesgo = new JButton("Let's go!");
=======
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

>>>>>>> 1695bcdde7dc0eb4b8b232089887b81e2babee8f
