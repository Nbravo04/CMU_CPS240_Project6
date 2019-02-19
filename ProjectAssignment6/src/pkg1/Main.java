/*
 ============================================================================
 Name        : Program Assignment 6, Main.java
 Author      : Nicholas Bravata
 Class		 : CPS240
 CRN		 : 22359097
 Date		 : 11/13/2018
 Description : This is the Main for this project. Just calls the constructors 
 			   for all the classes and prompts the user for an input 4 < m < 38
 			   and then passes that to get those amount of questions.
 ============================================================================
 */
package pkg1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		QuestionBank q1 = new QuestionBank();

		//Make scanner to get amount of questions.
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a number of Questions you want from 5 to " + q1.size()+ ".");
		int m = userInput.nextInt();
		//If not in range while loop = true.
		while(m < 5 || m>37) {
			System.out.println("Invalid range...");
			System.out.println("Enter a number of Questions you want from 5 to " + q1.size()+ ".");
			m = userInput.nextInt();
		}
		userInput.close();//Close scanner
		
		//Creates a new qBank of m random questions.
		ArrayList <Question> q2 = q1.randomQuestion(m, q1.size());
		
		//Creates and turns the GUI visable.
		GUI gui = new GUI("Test In Progress");
		gui.setVisible(true);
		
		//Creates the EventHandler or controller.
		EventHandler controller = new EventHandler(gui, q2, m);
		
		
	}//End Main
	

}
