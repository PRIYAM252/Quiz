import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener {

    // Questions
    String questions[] = {
            "1. Java was developed by?",
            "2. Java is a ____ language?",
            "3. Which component runs Java program?",
            "4. Java supports ____ programming?",
            "5. Which keyword is used to create an object?",
            "6. Which company originally developed Java?",
            "7. Java file extension is?",
            "8. Which method is entry point of Java program?",
            "9. Java is platform ____?",
            "10. Which keyword is used to inherit a class?"
    };

    // Options
    String options[][] = {
            {"Microsoft", "James Gosling", "Google", "Apple"},
            {"Programming", "Markup", "Styling", "Database"},
            {"JVM", "CPU", "Browser", "Compiler"},
            {"Procedural", "Object-Oriented", "Functional", "None"},
            {"class", "new", "object", "create"},
            {"Sun Microsystems", "Microsoft", "IBM", "Google"},
            {".java", ".class", ".js", ".py"},
            {"main()", "start()", "run()", "init()"},
            {"dependent", "independent", "closed", "none"},
            {"implement", "extends", "inherit", "this"}
    };

    // Correct answers index
    int answers[] = {1, 0, 0, 1, 1, 0, 0, 0, 1, 1};

    int current = 0;
    int score = 0;

    JLabel questionLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup bg;
    JButton nextButton;

    QuizApp() {

        setTitle("Java Quiz Application");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 50, 400, 30);
        add(questionLabel);

        opt1 = new JRadioButton();
        opt1.setBounds(50, 100, 300, 30);

        opt2 = new JRadioButton();
        opt2.setBounds(50, 140, 300, 30);

        opt3 = new JRadioButton();
        opt3.setBounds(50, 180, 300, 30);

        opt4 = new JRadioButton();
        opt4.setBounds(50, 220, 300, 30);

        bg = new ButtonGroup();
        bg.add(opt1);
        bg.add(opt2);
        bg.add(opt3);
        bg.add(opt4);

        add(opt1);
        add(opt2);
        add(opt3);
        add(opt4);

        nextButton = new JButton("Next");
        nextButton.setBounds(180, 280, 100, 30);
        nextButton.addActionListener(this);
        add(nextButton);

        loadQuestion();

        setVisible(true);
    }

    void loadQuestion() {
        questionLabel.setText(questions[current]);
        opt1.setText(options[current][0]);
        opt2.setText(options[current][1]);
        opt3.setText(options[current][2]);
        opt4.setText(options[current][3]);
        bg.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int selected = -1;

        if (opt1.isSelected()) selected = 0;
        if (opt2.isSelected()) selected = 1;
        if (opt3.isSelected()) selected = 2;
        if (opt4.isSelected()) selected = 3;

        if (selected == answers[current]) {
            score++;
        }

        current++;

        if (current < questions.length) {
            loadQuestion();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Quiz Finished!\nYour Score: " + score + " / " + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
