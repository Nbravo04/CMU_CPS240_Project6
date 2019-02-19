/*
 ============================================================================
 Name        : Program Assignment 6, QuestionBank.java
 Author      : Nicholas Bravata
 Class		 : CPS240
 CRN		 : 22359097
 Date		 : 11/13/2018
 Description : This class creates 3 arrays. 2 of type Question and 1 of type
 			   Integer. This class reads a question bank file and fills an 
 			   array full of questions. Also contains methods to generate a
 			   random question bank from the original given an amount of 
 			   questions greater than 5 but less then the max of the original 
 			   question bank.
 ============================================================================
 */
package pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuestionBank {
	ArrayList <Question> qBank = new ArrayList<Question>();
	ArrayList <Question> qBank2 = new ArrayList<Question>();
	ArrayList <Integer> index = new ArrayList<Integer>();
	
	
	//Constructor that reads "questionBank.txt" and makes an arraylist of type Question that contain all outcomes and answer to the question.
	QuestionBank() throws FileNotFoundException {
		File file = new File("questionBank.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("[\t\r\n]+");
		String question, a, b, c, d, ans;
		
		//Continues to read file until nothing is left.
		while (sc.hasNext()) {
			sc.next();
			question = sc.next();
			sc.next();
			a = sc.next();
			sc.next();
			b = sc.next();
			sc.next();
			c = sc.next();
			sc.next();
			d = sc.next();
			ans = sc.next();
			
			Question q = new Question(question, a, b, c, d, ans);
			qBank.add(q);
		}//End of While loop
		
		sc.close();//Close Scanner
		
	}//End of Constructor
	
	/*
	 * This method takes the provided qBank and selects m random questions.
	 * This method returns an arrayList of questions in random order.
	 */
	ArrayList<Question> randomQuestion(int m, int n){
		Random ranNum = new Random();
		//used to select random indexes in the original qBank
		for (int i = 0; i < m; i++ ) {
			int num = ranNum.nextInt(n);
			if(index.contains(num)) {
				i--;
			}//End If
			else {
				index.add(num);
			}//End Else
		}//End For
		
		for(int j=0; j < index.size(); j++) {
			qBank2.add(qBank.get(index.get(j)));
			//System.out.println(qBank.get(j).getQuestion());
		}
		return qBank2;
		
	}//End randomQuestion

	//Method returns the size of the qBank
	public int size() {
		return qBank.size();
	}
	
	//Method returns the question from a qBank at index n 
	public Question getqBank(int n) {
		Question q1 = qBank.get(n);
		return q1;
	}
}
