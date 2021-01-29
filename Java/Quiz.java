//Bozhidar Stoyanov, 0353616
//This class uses aggretation to store questions and answers in an array of FillInTheblank. It prints the questions, answers and sets the question and answer.

public class Quiz{
	private int numQuestions;
	private String title;
	private FillInTheBlank[] quiz;
	
	public Quiz(){ //no argument consctructor
		numQuestions = 5;
		title = "Midterm quiz";
		quiz = new FillInTheBlank[5];
	}
	public  Quiz(int numQs, String t){ //argumented constructor
		numQuestions = numQs;
		title = t;
		quiz = new FillInTheBlank[numQs];
	}
	public Quiz(Quiz in){ //copy constructor
		numQuestions = in.numQuestions;
		title = in.title;
	}
	public void setTitle(String t){ //setter
		title = t;
	}
	public String getTitle(){ //getter
		return title;
	}
	public void setQuestion(int in, FillInTheBlank  questionIn){ //setter using aggregation 
		if(in >= 0 && in <=quiz.length){
			quiz[in] = questionIn;
		}
		else{
			System.out.println("index out of bounds.");
		}
	}
	public FillInTheBlank getQuestion(int index){
		return quiz[index-1];
	}
	public void printTest(){ //setter: prints questions
		System.out.println(title);
		
		if(quiz != null){
			for(int i = 0;i < quiz.length;i++){
				if(quiz[i] != null){
					System.out.println(i+1 + ": " + quiz[i].getQuestion());
				}
				else{
					System.out.println(i+1 + ": No question yet.");
				}
			}
		}
		else{
			System.out.println("The quiz is empty.");
		}
	}
	public void printAnswers(){ //setter: prints answers
		
			for(int a = 0;a < quiz.length;a++){
				
					System.out.println(a+1 + ": " + quiz[a].getAnswer());
				
				
			}
		
			
	}
	public String toString(){ //tostring override method
		return "Quiz title: " + title + ", number of questions: " + numQuestions;
	}
	

}