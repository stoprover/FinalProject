import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginGUI extends JFrame{
    //some standardization: sign up & sign in refer to creating an account, while log in refers to already having one and accessing it
    //to-do's:
    //possibility: make login buttons switch to a third card: janices.
    //change passLogInput and passSignInput to JPasswordField, rather than JTextField, and fix related methods in getting their info.
    
    private JFrame frame = new JFrame("LogSign");
    private JPanel panelBoth = new JPanel();
    private JPanel panelLog = new JPanel();
    private JPanel panelSign = new JPanel();
    private JLabel userLogLabel = new JLabel ("Username: ");
    private JLabel passLogLabel = new JLabel ("Password: ");
    private JTextField userLogInput = new JTextField(12);
    private JTextField passLogInput = new JTextField(12);
    //private JPasswordField passLogInput = new JPasswordField(12);
    private JLabel logMessage = new JLabel("Messages: ");
    private JButton toLogIn = new JButton ("Log in!");
    private JButton switchToSign = new JButton ("Sign up instead");
    private JLabel userSignLabel = new JLabel ("Username: ");
    private JLabel passSignLabel = new JLabel ("Password: ");
    private JTextField userSignInput = new JTextField(12);
    private JTextField passSignInput = new JTextField(12);
    // private JPasswordField passSignInput = new JPasswordField(12);
    private JLabel signMessage = new JLabel("Messages: ");
    private JButton toSignUp = new JButton("Sign up!");
    private JButton switchToLog = new JButton ("Log in instead");
    CardLayout cl = new CardLayout();

    public LoginGUI(){
<<<<<<< HEAD
	
	//Establishes the Card Layout, adds text fields, buttons, etc., to the individual cards.
=======
	//add buttons and textfields and other stuff to each individual card
>>>>>>> master
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
<<<<<<< HEAD

	//Adds the two cards to the main panel.
=======
	
	//Adding the two cards to the panel
>>>>>>> master
	panelBoth.add(panelLog, "1");
	panelBoth.add(panelSign, "2");
	cl.show(panelBoth, "1");
	//	this.show(panelBoth, "1");

<<<<<<< HEAD
	//What to do if log in is attempted
=======
	//Actions to be performed when someone tries to log in
>>>>>>> master
	toLogIn.addActionListener (new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    //Gets data inputted and data from Example.csv to later be compared.
		    String username = userLogInput.getText();
		    String password = passLogInput.getText();
		    if (username.contains("\n")){
			logMessage.setText("Messages: username cannot contain the new line character.");
			panelLog.add(logMessage);
			return;
		    }
		    for (int i = 0; i < username.length(); i++){
			if (username.charAt(i) == 44){
			    logMessage.setText("Messages: username cannot contain the comma character.");
			    panelLog.add(logMessage);
			    return;
			}
		    }
		    if (password.contains("\n")){
			logMessage.setText("Messages: password cannot contain the new line character.");
			panelLog.add(logMessage);
			return;
		    }
		    for (int i = 0; i < password.length(); i++){
			if (password.charAt(i) == 44){
			    logMessage.setText("Messages: password cannot contain the comma character.");
			    panelLog.add(logMessage);
			    return;
			}
		    }
		    /**int i = 0;
		    String password = "";
		    while(i < passLogInput.length){
			password += passLogInput[i];
			}*/
		    /**if (username.length() == 0){
			logMessage.setText("Input username");
		    }
		    if (password.length() == 0){
			logMessage.setText("Input password");
			}*/
		    
		    Login backend = new Login(username, password);
		    String results = backend.readFile("Example.csv");

		    //Username and password match those in Example.csv
		    if (results.equals("Success")){
			logMessage.setText("Messages: Success!");
			panelLog.add(logMessage);
			dispose();
			//new LoginGUI();
<<<<<<< HEAD
=======
			//new LoginGUI();
			//new LoginGUI();
>>>>>>> master
			new GUI("Example.csv", username);
		    }

		    //Username or password do not match those in Example.csv
		    else if (results.equals("Bad Pass")){
			logMessage.setText("Messages: The password inputted does not match this username.");
			panelLog.add(logMessage);
		    }
		    else if (results.equals("Bad User")){
			logMessage.setText("Messages: There is no such user.");
			panelLog.add(logMessage);

		    }

		    //No username or password inputted
		    else if (results.equals("Empty User")){
			logMessage.setText("Messages: Input your username.");
			panelLog.add(logMessage);
		    }
		    else if (results.equals("Empty Pass")){
			logMessage.setText("Messages: Input your password.");
			panelLog.add(logMessage);
		    }
		    else{
			logMessage.setText("Messages: Error. Please input your username and password.");
			panelLog.add(logMessage);
		    }
		    /**String apple = userLogInput.getText();
		    userSignInput.setText(apple);
		    dispose();//this should close the window, but that's a minor technicality
		    new LoginGUI();//this shoudl actually be nwhatever Janice chooses to be her main GUI.*/

		}
	    });

<<<<<<< HEAD
	//What to do if sign up is attempted
=======
	//Actions to be performed when someone tries to sign up
>>>>>>> master
	toSignUp.addActionListener( new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0){

		    //Gets data inputted and data from Example.csv
		    String username = userSignInput.getText();
		    String password = passSignInput.getText();
		    if (username.contains("\n")){
			signMessage.setText("Messages: username cannot contain the new line character.");
			panelSign.add(signMessage);
			return;
		    }
		    for (int i = 0; i < username.length(); i++){
			if (username.charAt(i) == 44){
			    signMessage.setText("Messages: username cannot contain the comma character.");
			    panelSign.add(signMessage);
			    return;
			}
		    }
		    if (password.contains("\n")){
			signMessage.setText("Messages: password cannot contain the new line character.");
			panelSign.add(signMessage);
			return;
		    }
		    for (int i = 0; i < password.length(); i++){
			if (password.charAt(i) == 44){
			    signMessage.setText("Messages: password cannot contain the comma character.");
			    panelSign.add(signMessage);
			    return;
			}
		    }
		    /**if (username.contains(",")){
		       signMessage.setText("Messages: */
		    CreateAcc create = new CreateAcc(username, password);
		    String results = create.writeFile("Example.csv");

		    //Username is acceptable
		    if (results.equals("Success")){
			signMessage.setText("Messages: Success!");
			panelSign.add(signMessage);
			dispose();
<<<<<<< HEAD
			new LoginGUI();//temporary
			//new GUI("Example.csv", username);
=======
			new LoginGUI();
			new GUI("Example.csv", username);
>>>>>>> d400c89b6ea006c0ad8270a7e37f7e4a2dd3f445
		    }

		    //No username or password inputted
		    else if (results.equals("Empty User")){
			signMessage.setText("Messages: Input a username.");
			panelSign.add(signMessage);
		    }
		    else if (results.equals("Empty Pass")){
			signMessage.setText("Messages: Input a password.");
			panelSign.add(signMessage);
		    }

		    //Inputted username already in use
		    else if (results.equals("User Used")){
			signMessage.setText("Messages: Sorry, that username is already in use.");
			panelSign.add(signMessage);
		    }
		    else{
			signMessage.setText("Messages: Error. Please input a username and password.");
			panelSign.add(signMessage);
		    }
		    //cl.show(panelBoth, "1");
		    //this.show(panelBoth, "1");
		}
	    });

<<<<<<< HEAD
	//Go from Log in card to Sign up card.
=======
	//Actions to be performed when someone tries to switch between login cards and sign up cards, or vice versa
>>>>>>> master
	switchToSign.addActionListener( new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    cl.show(panelBoth, "2");
		    //this.show(panelBoth, "2");
		}
	    });

	//Go from Sign up card to log in card.
	switchToLog.addActionListener( new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0){
		    cl.show(panelBoth, "1");
		    //this.show(panelBoth, "1");
		}
	    });

<<<<<<< HEAD
	//Add all this to the frame
=======
	//Adding stuff to the frame
>>>>>>> master
	frame.add(panelBoth);
	frame.setTitle("Log in or Sign up");
	frame.setSize(800,900);
	frame.setLocation(500,400);
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

