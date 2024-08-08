import java.util.*;

public class QuizGenerator {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Quiz> quizzes = new ArrayList<>();

    public static void main(String[] args) {
        // Load predefined quizzes
        loadPredefinedQuizzes();

        while (true) {
            System.out.println("Welcome to the Quiz Generator!");
            int choice = displayMenu();

            switch (choice) {
                case 1:
                    createQuiz();
                    break;
                case 2:
                    takeQuiz();
                    break;
                case 3:
                    System.out.println("Thank you for using the Quiz Generator. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int displayMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Create a new quiz");
        System.out.println("2. Take a quiz");
        System.out.println("3. Exit");
        System.out.print("> ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private static void createQuiz() {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        Quiz quiz = new Quiz(title);

        while (true) {
            System.out.print("Enter question text (or type 'done' to finish): ");
            String questionText = scanner.nextLine();
            if (questionText.equalsIgnoreCase("done")) break;

            System.out.print("Enter option A: ");
            String optionA = scanner.nextLine();
            System.out.print("Enter option B: ");
            String optionB = scanner.nextLine();
            System.out.print("Enter option C: ");
            String optionC = scanner.nextLine();
            System.out.print("Enter option D: ");
            String optionD = scanner.nextLine();

            System.out.print("Enter correct answer (A/B/C/D): ");
            String correctAnswer = scanner.nextLine();

            Question question = new Question(questionText, optionA, optionB, optionC, optionD, correctAnswer);
            quiz.addQuestion(question);
        }

        quizzes.add(quiz);
        System.out.println("Quiz created successfully!");
    }

    private static void takeQuiz() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available. Please create a quiz first.");
            return;
        }

        System.out.println("Available quizzes:");
        for (int i = 0; i < quizzes.size(); i++) {
            System.out.println((i + 1) + ". " + quizzes.get(i).getTitle());
        }

        System.out.print("Select a quiz to take: ");
        int quizChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (quizChoice < 1 || quizChoice > quizzes.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Quiz selectedQuiz = quizzes.get(quizChoice - 1);
        selectedQuiz.takeQuiz();
    }

    private static void loadPredefinedQuizzes() {
        // Technology Quiz
        Quiz techQuiz = new Quiz("Technology Quiz");

        techQuiz.addQuestion(new Question("What does CPU stand for?", 
                                          "Central Process Unit", 
                                          "Central Processing Unit", 
                                          "Computer Personal Unit", 
                                          "Central Processor Unit", 
                                          "B"));

        techQuiz.addQuestion(new Question("Which company developed the Java programming language?", 
                                          "Microsoft", 
                                          "Google", 
                                          "Sun Microsystems", 
                                          "Apple", 
                                          "C"));

        techQuiz.addQuestion(new Question("What is the main component of a computer's memory?", 
                                          "RAM", 
                                          "ROM", 
                                          "Cache", 
                                          "Hard Disk", 
                                          "A"));

        techQuiz.addQuestion(new Question("What does 'HTTP' stand for?", 
                                          "HyperText Transfer Protocol", 
                                          "HighText Transfer Protocol", 
                                          "HyperText Transmission Protocol", 
                                          "HyperTransfer Text Protocol", 
                                          "A"));

        techQuiz.addQuestion(new Question("What is the most popular programming language in 2024?", 
                                          "Java", 
                                          "Python", 
                                          "JavaScript", 
                                          "C#", 
                                          "B"));

        techQuiz.addQuestion(new Question("Which technology is used to make telephone calls over the Internet possible?", 
                                          "Bluetooth", 
                                          "VoIP", 
                                          "WiFi", 
                                          "Ethernet", 
                                          "B"));

        techQuiz.addQuestion(new Question("What does 'SSD' stand for?", 
                                          "Solid State Drive", 
                                          "Solid State Disk", 
                                          "Super Speed Drive", 
                                          "Super Solid Drive", 
                                          "A"));

        techQuiz.addQuestion(new Question("Which of the following is an example of a web browser?", 
                                          "Google", 
                                          "Bing", 
                                          "Firefox", 
                                          "Yahoo", 
                                          "C"));

        techQuiz.addQuestion(new Question("What is the full form of 'HTML'?", 
                                          "Hyper Transfer Markup Language", 
                                          "HyperText Markup Language", 
                                          "HyperText Markdown Language", 
                                          "Hyperlink Markup Language", 
                                          "B"));

        techQuiz.addQuestion(new Question("What is the main language used for Android app development?", 
                                          "Swift", 
                                          "Kotlin", 
                                          "C#", 
                                          "Ruby", 
                                          "B"));

        techQuiz.addQuestion(new Question("Who is known as the father of the computer?", 
                                          "Charles Babbage", 
                                          "Alan Turing", 
                                          "Bill Gates", 
                                          "Steve Jobs", 
                                          "A"));

        techQuiz.addQuestion(new Question("What does 'AI' stand for in technology?", 
                                          "Artificial Intelligence", 
                                          "Automated Intelligence", 
                                          "Artificial Information", 
                                          "Automated Information", 
                                          "A"));

        techQuiz.addQuestion(new Question("Which device is used to input data into a computer?", 
                                          "Monitor", 
                                          "Printer", 
                                          "Keyboard", 
                                          "Speakers", 
                                          "C"));

        techQuiz.addQuestion(new Question("Which programming language is primarily used for web development?", 
                                          "C", 
                                          "Java", 
                                          "HTML", 
                                          "CSS", 
                                          "C"));

        techQuiz.addQuestion(new Question("What does 'IoT' stand for?", 
                                          "Internet of Technology", 
                                          "Integration of Things", 
                                          "Internet of Things", 
                                          "Interconnection of Things", 
                                          "C"));

        techQuiz.addQuestion(new Question("What is the brain of the computer also known as?", 
                                          "CPU", 
                                          "RAM", 
                                          "Hard Drive", 
                                          "Motherboard", 
                                          "A"));

        techQuiz.addQuestion(new Question("Which of the following is a type of computer memory?", 
                                          "USB", 
                                          "SSD", 
                                          "DVD", 
                                          "RAM", 
                                          "D"));

        techQuiz.addQuestion(new Question("Which company is known for the operating system Windows?", 
                                          "Apple", 
                                          "Google", 
                                          "Microsoft", 
                                          "IBM", 
                                          "C"));

        techQuiz.addQuestion(new Question("What does 'GUI' stand for?", 
                                          "Graphical User Interface", 
                                          "Graphical User Integration", 
                                          "General User Interface", 
                                          "General User Integration", 
                                          "A"));

        techQuiz.addQuestion(new Question("What is the process of finding and fixing bugs in software?", 
                                          "Compiling", 
                                          "Executing", 
                                          "Debugging", 
                                          "Deploying", 
                                          "C"));

        quizzes.add(techQuiz);

        // Java Basics Quiz
        Quiz javaQuiz = new Quiz("Java Basics Quiz");

        javaQuiz.addQuestion(new Question("What is the size of int in Java?", "16 bits", "32 bits", "64 bits", "8 bits", "B"));
        javaQuiz.addQuestion(new Question("Which of the following is a valid declaration of a float?", "float f = 5.5;", "float f = (float)5.5;", "float f = 5.5f;", "float f = 5.5d;", "C"));
        javaQuiz.addQuestion(new Question("What is the default value of a boolean variable?", "true", "false", "0", "null", "B"));
        javaQuiz.addQuestion(new Question("Which method can be used to find the length of a string in Java?", "getLength()", "length()", "size()", "getSize()", "B"));
        javaQuiz.addQuestion(new Question("What does JVM stand for?", "Java Variable Machine", "Java Virtual Machine", "Java Version Machine", "Java Visual Machine", "B"));
        javaQuiz.addQuestion(new Question("Which keyword is used to define a class in Java?", "class", "def", "struct", "object", "A"));
        javaQuiz.addQuestion(new Question("What is the output of 5 + 2 * 3?", "11", "16", "13", "17", "A"));
        javaQuiz.addQuestion(new Question("Which of the following is not a Java feature?", "Dynamic", "Architecture Neutral", "Use of pointers", "Object-Oriented", "C"));
        javaQuiz.addQuestion(new Question("What is the size of a char in Java?", "8 bits", "16 bits", "32 bits", "64 bits", "B"));
   
        javaQuiz.addQuestion(new Question("Which of the following is used to handle exceptions in Java?", "try-catch", "if-else", "switch-case", "throw", "A"));
        javaQuiz.addQuestion(new Question("How do you declare an array in Java?", "int arr[];", "int[] arr;", "int arr;", "Both A and B", "D"));
        javaQuiz.addQuestion(new Question("What is the output of the expression 10 / 3?", "3", "3.333", "3.0", "2.5", "A"));
        javaQuiz.addQuestion(new Question("Which of the following methods is used to start a thread in Java?", "start()", "run()", "init()", "execute()", "A"));
        javaQuiz.addQuestion(new Question("What is the scope of a local variable in Java?", "Class level", "Method level", "Package level", "Global level", "B"));
        javaQuiz.addQuestion(new Question("Which operator is used for concatenation in Java?", "+", "-", "*", "/", "A"));
        javaQuiz.addQuestion(new Question("What does the final keyword signify in Java?", "A variable cannot be changed", "A method cannot be overridden", "A class cannot be subclassed", "All of the above", "D"));
        javaQuiz.addQuestion(new Question("Which access modifier makes a member accessible only within its own package?", "public", "protected", "default", "private", "C"));
        javaQuiz.addQuestion(new Question("What is the purpose of the super keyword in Java?", "Access parent class methods", "Access parent class variables", "Invoke parent class constructor", "All of the above", "D"));
        javaQuiz.addQuestion(new Question("How do you create an object of a class in Java?", "ClassName obj = new ClassName();", "ClassName obj = new ClassName;", "ClassName obj = ClassName();", "obj = new ClassName();", "A"));
        javaQuiz.addQuestion(new Question("Which of the following is an interface in Java?", "List", "ArrayList", "HashMap", "TreeSet", "A"));

        quizzes.add(javaQuiz);
    }
}
