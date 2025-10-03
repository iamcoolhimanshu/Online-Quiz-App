package OnlineQuizApps;

import java.util.*;

class Question {
	String question;
	String[] options;
	int correctAnswer;

	public Question(String question, String[] options, int correctAnswer) {
		this.question = question;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}

	public boolean askQuestion(Scanner sc) {
		System.out.println("\n" + question);
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
		System.out.print("Enter your choice (1-4): ");
		int answer = sc.nextInt();
		return (answer - 1 == correctAnswer);
	}
}

public class QuizCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Create list of questions
		List<Question> questions = new ArrayList<>();
		questions.add(new Question("Which language is used for Android development?",
				new String[] { "Python", "Kotlin", "Swift", "Ruby" }, 1));
		questions.add(new Question("Which company developed Java?",
				new String[] { "Microsoft", "Apple", "Sun Microsystems", "Google" }, 2));
		questions.add(new Question("What does OOP stand for?", new String[] { "Object-Oriented Programming",
				"Open Operational Process", "Overloaded Option Parsing", "None of these" }, 0));
		questions.add(
				new Question("Which data structure uses FIFO?", new String[] { "Stack", "Queue", "Tree", "Graph" }, 1));

		int score = 0;

		for (Question q : questions) {
			if (q.askQuestion(sc)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println(" Wrong!");
			}
		}

		System.out.println("\n--- Quiz Finished ---");
		System.out.println("Your Score: " + score + "/" + questions.size());

		sc.close();
	}
}