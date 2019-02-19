/*
 ============================================================================
 Name        : Program Assignment 6, EventHandler.java
 Author      : Nicholas Bravata
 Class		 : CPS240
 CRN		 : 22359097
 Date		 : 11/13/2018
 Description : This class sets up ActionListeners for all the buttons as well
 			   as calls certain functions based on what was pressed. Also 
 			   updates the GUI based on certain buttons.
 ============================================================================
 */
package pkg1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventHandler implements ActionListener {
	
	GUI view;
	ArrayList<Question> questions;
	Question q;
	JTextArea text;
	JTextField score;
	JTextArea questionBox;
	JRadioButton[] rbuttons;
	JButton[] jbuttons;
	int questionsAnswered;
	int index = 0;
	int[] responses;
	int MAX;
	
	//EventHandler Constructor that creates the EventHandler for the project.
	public EventHandler(GUI view, ArrayList<Question> q2, int max) {
		this.view = view;
		MAX = max;
		responses = new int[MAX];
		questions = q2;
		text = view.getText();
		score = view.getScore();
		questionBox = view.getQuestionBox();
		rbuttons = view.getRadioButtons();
		jbuttons = view.getJButtons();
		questionsAnswered = 500;
		
		registerRadioButtons();
		registerJButtons();
	
	}

	//A Loop that adds ActionListeners to all JRadioButtons
	private void registerRadioButtons() {
		for (JRadioButton rb : rbuttons) {
			rb.addActionListener(this);
		}
	}
	//A loop that adds ActionListeners to all JButtons
	private void registerJButtons() {
		for (JButton jb: jbuttons) {
			jb.addActionListener(this);
		}
	}
	
	//Method that performs certain things based on which button was pressed. Also keeps a count of the user inputs on the radioButtons
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		//If the JButton was clicked.
		if (source instanceof JButton) {
			JButton jb = (JButton)source;
			//Start Button hit
			if (jb.getText() == "Start" && questionsAnswered != 0) {
				questionsAnswered = 0;
				q = questions.get(questionsAnswered);
				questionBox.setForeground(Color.BLACK); //Set font from RED to BLACK
				fillGUI(q);//Fill GUI with new Question
				index = 0;
			}//End if
			//Next button hit
			if(jb.getText() == "Next" && (questionsAnswered != MAX) && questionsAnswered != 500) { 
				CheckRadioButton();
				questionsAnswered++;
				//If there is another question do this...
				if(questionsAnswered != MAX) {
					q = questions.get(questionsAnswered);
					questionBox.setText(q.getQuestion());
					fillGUI(q);
				}
				//If that was the last question this....
				else {
					text.setText("FINSHED! Please hit submit to see your score. Your score will be in the bottom right.");
					questionBox.setText("DONE! GOOD JOB!");
				}
			}//End of next if 
			//Submit Button hit
			if(jb.getText() == "Submit" && (questionsAnswered == MAX)) {
				answerKey();
			}//End of Submit if
		}//End if
	}//End actionPreformed
	
	//This updates the GUI with a completely new question.
	private void fillGUI(Question q) {
		int num = questionsAnswered + 1;
		questionBox.setText(num + ". " + q.getQuestion());
		text.setText("(a) " + q.getA() +"\n \n" +
					 "(b) " + q.getB() +"\n \n" +
					 "(c) " + q.getC() +"\n \n" +
					 "(d) " + q.getD() );
	}
	
	//This method checks the array of the users_answers and compares it to the actual answer of the question.
	private void answerKey() {
		int correct = 0;
		int user_ans;
		String ans;
		for(int i = 0; i< MAX; i++) {
			ans = questions.get(i).getAns();
			System.out.println(ans);
			user_ans = responses[i];
			if(user_ans == 0 && ans.charAt(0) == 'a') {
				correct++;
			}
			if(user_ans == 1 && ans.charAt(0) == 'b') {
				correct++;
			}
			if(user_ans == 2 && ans.charAt(0)== 'c') {
				correct++;
			}
			if(user_ans == 3 && ans.charAt(0) == 'd') {
				correct++;
			}
		}//End For
		score.setText("Score: " + correct + "/" + MAX);
	}//End answerKey
	
	//This method checks to see which radio button was selected from the question.
	private void CheckRadioButton() {
		int count = 0;
		for(JRadioButton rb: rbuttons) {
			if(rb.isSelected()) {
				responses[index] = count;
				System.out.println(count);
				index++;
			}//end if
			else {
				count++;
			}//end else
		}//end for
	}//End CheckRadioButton
}