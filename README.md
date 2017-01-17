# FinalProject

*****Important things to note:
     Galina Gorina is the name of Steven's computer; all commits that were done by "Galina Gorina" were actually done by Steven.
     

WORKING FEATURES:
----------------------------------------------------------------------
- LoginGUI can login existing accounts
  	   - If the wrong combination is entered, then an error message is shown.
	   - There is an option to Sign up that opens a new window of the LoginGUI.
	   - The options to Sign up and to Log in give correct error messages, the former if the username is already in use, if the username or password are empty strings, or if the username or password include commas, and the latter if the username or password are empty string, the username does not exist, or the password does not match the username.
	   - When the correct combination is given, the main GUI with your personal info is opened.
- The first tab (get advice) fully functions.
       	   - It displays updated grade information and appropriate advice. The GUI displays reasonable advice.
    	   - Sleep Tracker and Activity Tracker are features that we never got around to.
- The third tab (Add a new Subject) is set up.
      	   - Gives the correct error messages if the breakdown does not add up to 100% or if a name is not given.


UNRESOLVED BUGS:
----------------------------------------------------------------------
- Create an account button does not function since "GUI.java" cannot open a new window for an account without subjects in it, and new accounts do not have any subjects in them. In the GUI, creating an account will give error messages if the username or password are empty strings, contain commas, or if the username is the same as a preexisting username. The backend in order to create an account, "CreateAcc.java", works correctly, and if one were to input an allowed username and password, this data would be added to the CSV file storing data for all accounts (this file is called "Example.csv"). In addition, a new window to log in or sign up would open, showing that this backend does work.
- Error messages for logging in and signing up are cut off due to the size of the window. We were unable to change the size of the window in code. Thus, it is necessary to physically make the GUI window larger or maximized in order for these error messages to not be cut off.
- Adding new Subject information is not available (Tab 2 is essentially not working) since "InputGrades.java" has some problems and is incomplete.
- Tab 3 is set up and a backend in order to add a subject (called "AddSubject.java") also works effectively, but there are problems in creating a new subject in "Example.csv". "AddSubject.java", when run in terminal, produces effective results, modifying "Example.csv" by creating a temporary CSV file with preexisting info from "Example.csv" and the new subject info, deleting the original "Example.csv", and renaming the temporary CSV file to "Example.csv" (the same as the original file). However, this does not occur when run through GUI. Though the GUI can give correct error messages (see above in WORKING FEATURES), and creates a temporary CSV file with the new subject information, it does not delete or replace the old CSV file, despite approximately 8 hours of debugging and testing by both Janice and Steven to try to make it do so.

- In order to prevent problems with empty grade categories, all empty grade categories have a temporary "#1: 100" grade.
- Sleep tracking and activity tracking is not available, due to a lack of time to work on these features.




UNDERSTANDING our CODE:
--------------------------------------------------------------------
Here's a guide to seeing how individual parts of our code work.

- To use the code as a normal user would interact with it (through the LoginGUI) look at the directions under HOW TO USE OUR PROGRAM

- To directly open Bob's Grade Track compile and run "GUI.java"

- To see functions of how grades are loaded and processed look at or compile and run "Subjects.java"

- To see how the code for the Login functions look at "Login.java"

- As of now, you are unable to edit the grades of subjects. If you wish to look how we store this data you can look at "Example.csv"


HOW TO USE OUR PROGRAM:
--------------------------------------------------------------------
There are two available accounts:
        (username) (password)
      - konstans, weshallpass
      - Bob, 1234567890


1. To login to these accounts, compile and run "LoginGUI.java"
2. Enter either account's username and password and press the "Log in!" button
3. Wow! The GUI with the corresponding information shows up. Feel free to explore the dropdown menus on the "Get advice" tab

