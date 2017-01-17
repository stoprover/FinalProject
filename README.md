# FinalProject

*****Important things to note:
     Galina Gorina is the name of Steven's computer; all commits that were done by "Galina Gorina" were actually done by Steven.
     

WORKING FEATURES:
----------------------------------------------------------------------
- LoginGUI can login existing accounts
  	   - If the wrong combination is entered, then an error message is shown.
	   - There is an option to Sign up that changes the appearance of the LoginGUI.
	   - When the correct combination is given, the main GUI with your personal info is opened.
- The first tab (get advice) fully functions.
       	   - It displays updated grade information and appropriate advice. The GUI displays reasonable advice.
    	   - Sleep Tracker and Activity Tracker are features that we never got around to.
- The third tab (Add a new Subject) is set up.
      	   - Gives the correct error messages if the breakdown does not add up to 100% or if a name is not given.
      	   - Can add a new subject.


UNRESOLVED BUGS:
----------------------------------------------------------------------
- Create an account button does not function since there are bugs within "CreateAcc.java"
- Adding new Subject information is not available (Tab 2 is essentially not working) since "InputGrades.java" has some problems.

- In order to prevent problems with empty grade categories, all empty grade categories have a temporary "#1: 100" grade.





UNDERSTANDING our CODE:
--------------------------------------------------------------------
Here's a guide to seeing how individual parts of our code work.

- To use the code as a normal user would interact with it (thru the LoginGUI) look at the directions under HOW TO USE OUR PROGRAM

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
2. Enter either account username and password and press the "Log in!" button
3. Wow! The GUI with the corresponding information shows up. Feel free to explore the dropdown menus on the "Get advice" tab
4. You may also add new subjects with the appropriate grade goal and breakdown in the third tab "Add new subject" tab

