import java.io.*;

public class CreateAcc{
    private String username;
    private String password;
    
    //Constructor, sets values for username and password
    public CreateAcc(String u, String p){
	username = u;
	password = p;
    }

    //Writing to a file
    public String writeFile(String name){

	//Making sure username and password are of acceptable length (for now, last two will be used rather than first two).
	/**if (username.length() < 8){
	    return "User Short";
	}
	if (password.length() < 8){
	    return "Pass Short";
	    }*/
	if (username.equals("")){
	    return "Empty User";
	}
	if (password.equals("")){
	    return "Empty Pass";
	}

	//Checking if the input username already exists
	Login attempt = new Login(username, password);
	
	//Creates the account by adding data to Example.csv
	if (attempt.readFile("Example.csv").equals("Bad User")){
	    Writer writer = null;
	    try{
		writer = new FileWriter(name, true);	    
<<<<<<< HEAD
		writer.write("\n" + username + "," + password + ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
=======
		writer.write("\n" + username + "," + password + ",0, , , , , , ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
	    //w.flush();
	    //w.close();
>>>>>>> master
	    }catch(IOException e){
		System.err.println("Exception thrown: " + e);
		e.printStackTrace();
	    }finally{
		if (writer!= null){
		    try{
			writer.close();
		    }catch (IOException e){
			System.err.println("Error closing file");
			e.printStackTrace();
		    }
		}
	    }
	    return "Success";
	}
	
	//Returns message if the username already exists.
	else{
	    return "User Used";
	}
    }
    public static void main(String[]args){
	CreateAcc c = new CreateAcc("", "1972");
	System.out.println(c.writeFile("passwords.csv"));
     	//CreateAcc d = new CreateAcc("tashad", "idk");
	//d.writeFile("passwords.csv");
    }
}
