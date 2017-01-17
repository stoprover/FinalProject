# FinalProject

*****Important things to note:
     Galina Gorina is the name of Steven's computer; all commits that were done by "Galina Gorina" were actually done by Steven.
     
DESCRIPTION:
----------------------------------------------------------------------
<p>This project is a "Robo-Guidance Counselor." It allows users to register for an account or log in to an account that already exists, and view data on their grades for the different subjects they are taking. Grade categories include tests, quizzes, projects, and homework. In addition, the program allows users to determine the scores they should get on future tests to obtain their goal grade for the course, when these grades are factored in to the preexisting data. </p>


WORKING FEATURES:
----------------------------------------------------------------------
- LoginGUI can login existing accounts
	   - Users can log in or sign up (from the first window opened).
	   - Users can switch between log in and sign up.
	   - The options to Sign up and to Log in give correct error messages; Sign up gives error messages if the username is already in use, if the username or password are empty strings, or if the username or password include commas; and Log in gives error messages if the username or password are empty string, the username does not exist, or the password does not match the username.
	   - Upon signing up with an acceptable username and password, a new window of the LoginGUI will open.
	   - When the correct combination of username and password is given, the main GUI with the user's personal and grade information will open.
- The "Grade Tracker" in the first tab (get advice) fully functions.
       	   - It displays updated grade information and appropriate advice. The GUI displays reasonable advice; for instance, it will tell the user grades that they should get on their next tests in order to achieve their goal report card grade. However, if the goal grade cannot be obtained with tests that are out of 100 points, the user will be informed that their goal is unreasonable. In addition, if the goal grade is lower than the user's current grade, they will be congratulated and will be told that they are on the right track to achieving their goal grade or above.
- The third tab (Add a new Subject) is somewhat set up.
      	   - Gives the correct error messages if the breakdown does not add up to 100% or if a name is not given.


UNRESOLVED BUGS:
----------------------------------------------------------------------
- Accounts that are created cannot be used, since "GUI.java" cannot open a new window for an account without subjects in it, and new accounts do not have any subjects in them. The backend in order to create an account, "CreateAcc.java", works correctly, and if one were to input an allowed username and password, this data would be added to the CSV file storing data for all accounts (this file is called "Example.csv"). In addition, a new window to log in or sign up would open, showing that this backend does work.
- Error messages for logging in and signing up are cut off due to the size of the window. We were unable to change the size of the window through the code. Thus, it is necessary to physically make the GUI window larger or to maximize it in order for these error messages to not be cut off.
- Sleep Tracker and Activity Tracker in Tab 1 are features that we did not have time to code.
- Adding new Subject information is not available (Tab 2 is essentially not working) since "InputGrades.java" has some problems and is incomplete due to a lack of time.
- Tab 3 is set up with error messages and features in the GUI. A backend (called "AddSubject.java") to add a subject also works effectively, but there are problems in creating a new subject in "Example.csv". "AddSubject.java", when run in terminal with its preexisting main, produces effective results, modifying "Example.csv" by creating a temporary CSV file with preexisting info from "Example.csv" and the new subject info, deleting the original "Example.csv", and renaming the temporary CSV file to "Example.csv" (the same as the original file). However, this does not occur when run through GUI. Though the GUI can give correct error messages (see above in WORKING FEATURES), and creates a temporary CSV file with the new subject information, it does not delete or replace the old CSV file, despite approximately 8 hours of debugging and testing by both Janice and Steven to try to make it do so.
- In order to prevent problems with empty grade categories, all empty grade categories have a temporary "#1: 100" grade.




UNDERSTANDING our CODE:
--------------------------------------------------------------------
Here's a guide to seeing how individual parts of our code work.

- To use the code as a normal user would interact with it (through the LoginGUI), look at the directions under HOW TO USE OUR PROGRAM

- To directly open a user's Grade Track and to see how the GUI showing a user's information functions, look at or compile and run "GUI.java"

- To see functions of how grades are loaded and processed, look at or compile and run "Subjects.java"

- To see how the code for the Login functions, look at "Login.java"

- To see how the code for the Sign up functions, look at "CreateAcc.java"

- To see how the code to add a subject functions, look at "AddSubject.java"

- To see how the GUI allowing users to sign up or log in functions, look at "LoginGUI.java"

- As of now, you are unable to edit the grades of subjects. If you wish to look how we store users' usernames, passwords, subjects, and grades, you can look at "Example.csv"



HOW TO USE OUR PROGRAM:
--------------------------------------------------------------------
There are two working accounts:
        (username) (password)
      - konstans, weshallpass
      - Bob, 1234567890


1. To login to these accounts, compile and run "LoginGUI.java"
2. Enter either account's username and password and press the "Log in!" button
3. Wow! The GUI with the corresponding information shows up. Feel free to explore the dropdown menus on the "Get advice" tab.
4. If you wish to sign up for an account (though new accounts cannot be used), switch to the sign up tab (this is still in the Login GUI), enter your desired username and password, and press the "Sign up!" button.

