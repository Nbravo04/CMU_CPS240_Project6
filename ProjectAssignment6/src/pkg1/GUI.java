/*
 ============================================================================
 Name        : Program Assignment 6, GUI.java
 Author      : Nicholas Bravata
 Class		 : CPS240
 CRN		 : 22359097
 Date		 : 11/13/2018
 Description : The GUI for the Project. This class is the GUI and contains all
 			   the buttons and text fields/areas that are needed for the 
 			   project. Also has getters for the EventHandler Class.
 ============================================================================
 */
package pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame{

	final static int numRadioButtons = 4;
	JRadioButton[] radioButtons;
	JButton[] jbuttons;
	JTextArea text = new JTextArea(1,1);
	JTextArea questionBox = new JTextArea(2,1);
	JTextField score = new JTextField(15);
	JButton Start = new JButton();
	JButton Next = new JButton();
	JButton Submit = new JButton();
	
	public GUI(String title) {
		super(title);
		
		//Labels for radioButtons
		String[] labels = {"a", "b","c","d"};
		//Basic settings for setting up the GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(0,1));
		JPanel controlButtonsPanel = new JPanel(new GridLayout(1,1));
		ButtonGroup group = new ButtonGroup();
		jbuttons = new JButton[3];
		radioButtons = new JRadioButton[numRadioButtons];
		
		//Adds radio buttons to GUI and to a group
		for (int i = 0; i < numRadioButtons; i++) {
			radioButtons[i] = new JRadioButton();
			group.add(radioButtons[i]);
			panel.add(radioButtons[i]);
		}
		//calls setRadioButtonLabels() to give them text.
		setRadioButtonLabels(labels);
		Start.setText("Start");
		jbuttons[0] = Start;
		Next.setText("Next");
		jbuttons[1] = Next;
		Submit.setText("Submit");
		jbuttons[2] = Submit;
		
		
		
		add(panel, BorderLayout.WEST);
		add(controlButtonsPanel, BorderLayout.SOUTH);
		controlButtonsPanel.add(Start,BorderLayout.WEST);
		controlButtonsPanel.add(Next,BorderLayout.CENTER);
		controlButtonsPanel.add(Submit,BorderLayout.EAST);
		
		//Settings for the JTextArea, text, where the different question answers pop up
		text.setFont(new Font("TimesRoman",Font.PLAIN, 28));
		text.setForeground(Color.BLACK);
		text.setText("Please hit Start when ready. You cannot submit until you have answered all the questions!");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		add(text, BorderLayout.CENTER);
		
		//Settings for the JTextArea, questionBox, where the question is displayed.
		questionBox.setFont(new Font("TimesRoman", Font.BOLD, 14));
		questionBox.setForeground(Color.RED);
		questionBox.setText("Welecome to the CMU Testing Center");
		questionBox.setLineWrap(true);
		questionBox.setWrapStyleWord(true);
		add(questionBox, BorderLayout.NORTH);
		
		//Settings for the JTextField, score, where the score at the end of the test will be displayed.
		score.setFont(new Font("TimesRoman", Font.BOLD, 14));
		score.setForeground(Color.BLUE);
		score.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		score.setHorizontalAlignment(JTextField.CENTER);
		score.setText("...");
		controlButtonsPanel.add(score, BorderLayout.SOUTH);
			
		
		
	}//End GUI
	
	//Sets text for all label buttons
	public void setRadioButtonLabels(String[] lab) {
		for (int i = 0; i < 4; i++)
			radioButtons[i].setText(lab[i]);
	}
	
	//Getters
	public JTextArea getText() {
		return text;
	}
	
	public JTextArea getQuestionBox() {
		return questionBox;
	}
	
	public JTextField getScore() {
		return score;
	}
	
	public JRadioButton[] getRadioButtons() {
		return radioButtons;
	}
	
	public JButton[] getJButtons() {
		return jbuttons;
	}
	
}
