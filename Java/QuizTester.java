//Bozhidar Stoyanov, 0353616
//Program Tests the Quiz methods, creates different quizes with different sizes of questions and answers.
//You can fill the quiz with questions and answers and change them easily using our our Fillintheblanks class (aggregation).
import java.util.Scanner;

public class QuizTester{
	public static void main(String[] args){
		
		Scanner kb = new Scanner(System.in);
		Quiz quiz1 = new Quiz(); //Creating a no argument quiz with 5 questions and midterm quiz title
		FillInTheBlank fitb1 = new FillInTheBlank("Whats the capital of France?", "Paris");
		
		quiz1.setQuestion(0,fitb1);
		
		quiz1.printTest();
		quiz1.printAnswers();
		
		
		
		
		for(int r = 0;r < 5;r++){ //user input fill in the first quiz
			System.out.println("Please enter question: ");
			String userQ = kb.nextLine();
			System.out.println("Please enter answer: ");
			String userA = kb.nextLine();
			FillInTheBlank fitb = new FillInTheBlank(userQ,userA);
			quiz1.setQuestion(r,fitb);
		}
		
		
		
		
		System.out.println(quiz1);
		quiz1.printTest();
		quiz1.printAnswers();
		System.out.println("Please enter number of questions for the quiz: ");
		int n = kb.nextInt();
		
		
		Quiz quiz2 = new Quiz(n,"Final quiz"); //Creating another quiz with 3 questions and answers
		System.out.println(quiz2);
		quiz2.printTest();
		quiz2.printAnswers();
		
		for(int a = 0;a < n;a++){ //filling that quiz with user input again
			System.out.println("Please enter question: ");
			String userQu = kb.nextLine();
			System.out.println("Please enter answer: ");
			String userAn = kb.nextLine();
			FillInTheBlank fitb2 = new FillInTheBlank(userQu,userAn);
			quiz2.setQuestion(a,fitb2);
		}
		
		
		System.out.println(quiz2);
		quiz2.printTest();
		quiz2.printAnswers();
		
		
	
	}

}