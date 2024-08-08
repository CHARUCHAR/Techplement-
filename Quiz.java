import java.util.*;

public class Quiz {
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            System.out.println("A. " + question.getOptionA());
            System.out.println("B. " + question.getOptionB());
            System.out.println("C. " + question.getOptionC());
            System.out.println("D. " + question.getOptionD());
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().toUpperCase();

            if (answer.equals(question.getCorrectAnswer())) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect! The correct answer was " + question.getCorrectAnswer());
            }
        }

        System.out.println("Your score: " + score + "/" + questions.size());
    }
}
