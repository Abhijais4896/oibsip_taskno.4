import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineExamSystem {
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton option1RadioButton;
    private JRadioButton option2RadioButton;
    private JRadioButton option3RadioButton;
    private JRadioButton option4RadioButton;
    private JButton submitButton;
    private JLabel resultLabel;
    private ButtonGroup buttonGroup;

    private String[] questions = {
            "Question 1: What is the capital of France?",
            "Question 2: Which is the largest planet in our solar system?",
            "Question 3: Who painted the Mona Lisa?",
            "Question 4: What is the chemical symbol for gold?",
            "Question 5: What is the largest ocean in the world?"
    };

    private String[] correctAnswers = {
            "Paris",
            "Jupiter",
            "Leonardo da Vinci",
            "Au",
            "Pacific"
    };

    private int currentQuestion = 0;
    private int score = 0;

    public OnlineExamSystem() {
        // Create the main frame
        frame = new JFrame("Online Exam System");

        // Create the components
        questionLabel = new JLabel(questions[currentQuestion]);
        option1RadioButton = new JRadioButton("Option 1");
        option2RadioButton = new JRadioButton("Option 2");
        option3RadioButton = new JRadioButton("Option 3");
        option4RadioButton = new JRadioButton("Option 4");
        submitButton = new JButton("Submit");
        resultLabel = new JLabel("");

        // Group the radio buttons together
        buttonGroup = new ButtonGroup();
        buttonGroup.add(option1RadioButton);
        buttonGroup.add(option2RadioButton);
        buttonGroup.add(option3RadioButton);
        buttonGroup.add(option4RadioButton);

        // Set up the layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.add(questionLabel);
        panel.add(option1RadioButton);
        panel.add(option2RadioButton);
        panel.add(option3RadioButton);
        panel.add(option4RadioButton);
        panel.add(submitButton);
        panel.add(resultLabel);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAnswer = getSelectedAnswer();

                // Check if the selected answer is correct
                if (selectedAnswer != null && selectedAnswer.equals(correctAnswers[currentQuestion])) {
                    score++;
                }

                // Move to the next question or display the final score
                if (currentQuestion < questions.length - 1) {
                    currentQuestion++;
                    displayQuestion();
                } else {
                    displayFinalScore();
                }
            }
        });

        // Set up the main frame
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Display the first question
        displayQuestion();
    }

    private void displayQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        option1RadioButton.setText("Option 1");
        option2RadioButton.setText("Option 2");
        option3RadioButton.setText("Option 3");
        option4RadioButton.setText("Option 4");
        resultLabel.setText("");
        buttonGroup.clearSelection();
    }

    private void displayFinalScore() {
        questionLabel.setText("Exam finished. Your score is: " + score + " out of " + questions.length);
        option1RadioButton.setText("");
        option2RadioButton.setText("");
        option3RadioButton.setText("");
        option4RadioButton.setText("");
        submitButton.setEnabled(false);
    }

    private String getSelectedAnswer() {
        if (option1RadioButton.isSelected()) {
            return "Option 1";
        } else if (option2RadioButton.isSelected()) {
            return "Option 2";
        } else if (option3RadioButton.isSelected()) {
            return "Option 3";
        } else if (option4RadioButton.isSelected()) {
            return "Option 4";
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OnlineExamSystem();
            }
        });
    }
}
