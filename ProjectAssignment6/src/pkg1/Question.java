/*
 ============================================================================
 Name        : Program Assignment 6, Question.java
 Author      : Nicholas Bravata
 Class		 : CPS240
 CRN		 : 22359097
 Date		 : 11/13/2018
 Description : Base Question class. Creates a question given strings and also
 			   has getters to retrieve info later in the GUI and EventHandler
 ============================================================================
 */
package pkg1;

public class Question {
		String question, a, b, c, d, ans;
	
		//Constructor for Question. Takes in 6 strings and assigns them to parts of the question to easily obtain them later.
		Question(String question, String a, String b, String c, String d, String ans) {
			this.question = question;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.ans = ans;
		}// End Constructor 

		//Getters
		public String getQuestion() {
			return question;
		}

		public String getA() {
			return a;
		}

		public String getB() {
			return b;
		}

		public String getC() {
			return c;
		}

		public String getD() {
			return d;
		}

		public String getAns() {
			return ans;
		}
}//End Class
