import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

class MathQuizGame extends JFrame implements ActionListener {

    // Background panel to load an image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            try {
                // Load the uploaded image file
                backgroundImage = new ImageIcon("C:\\Users\\Joseph\\Downloads\\mathlogo.jpg").getImage();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to load background image!");
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    // UI Components
    JLabel titleLabel = new JLabel("Math Quiz Game");
    JLabel subTitleLabel = new JLabel("------------------------------");
    JLabel questionLabel = new JLabel();
    JLabel answerLabel = new JLabel("Answer: ");
    JLabel gameOverLabel = new JLabel();
    JLabel scoreLabel = new JLabel("Score: ");

    JButton playButton = new JButton("PLAY");
    JButton restartButton = new JButton("RESTART");
    JButton exitButton = new JButton("EXIT");

    JTextField answerField = new JTextField(10);
    JTextField scoreField = new JTextField(5);

    Font titleFont = new Font("Tahoma", Font.BOLD, 50);
    Font questionFont = new Font("Tahoma", Font.BOLD, 35);
    Font answerFont = new Font("Tahoma", Font.BOLD, 30);

    Random random = new Random();
    int digit1, digit2, correctAnswer;
    String operator;
    int rightCounter = 0;
    int questionCounter = 0;
    final int LIMIT = 5; // Max number of questions

    public MathQuizGame() {
        // Set up background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        // Title
        titleLabel.setBounds(200, 20, 500, 70);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.white);

        subTitleLabel.setBounds(220, 80, 400, 40);
        subTitleLabel.setFont(questionFont);
        subTitleLabel.setForeground(Color.white);

        // Question
        questionLabel.setBounds(150, 150, 500, 60);
        questionLabel.setFont(questionFont);
        questionLabel.setForeground(Color.yellow);

        // Answer Field
        answerLabel.setBounds(150, 250, 200, 50);
        answerLabel.setFont(answerFont);
        answerLabel.setForeground(Color.white);

        answerField.setBounds(300, 250, 200, 50);
        answerField.setFont(answerFont);

        // Buttons
        playButton.setBounds(50, 350, 150, 60);
        playButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        playButton.setBackground(Color.orange);

        restartButton.setBounds(300, 350, 150, 60);
        restartButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        restartButton.setBackground(Color.green);

        exitButton.setBounds(550, 350, 150, 60);
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        exitButton.setBackground(Color.red);

        scoreLabel.setBounds(150, 450, 200, 50);
        scoreLabel.setFont(answerFont);
        scoreLabel.setForeground(Color.white);

        scoreField.setBounds(300, 450, 100, 50);
        scoreField.setFont(answerFont);
        scoreField.setEditable(false);
        scoreField.setText("0");

        // Add components to background panel
        backgroundPanel.add(titleLabel);
        backgroundPanel.add(subTitleLabel);
        backgroundPanel.add(questionLabel);
        backgroundPanel.add(answerLabel);
        backgroundPanel.add(answerField);
        backgroundPanel.add(playButton);
        backgroundPanel.add(restartButton);
        backgroundPanel.add(exitButton);
        backgroundPanel.add(scoreLabel);
        backgroundPanel.add(scoreField);

        // Frame settings
        setContentPane(backgroundPanel);
        setTitle("Math Quiz Game");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Add action listeners
        playButton.addActionListener(this);
        restartButton.addActionListener(this);
        exitButton.addActionListener(this);
        answerField.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            questionCounter = 0;
            rightCounter = 0;
            scoreField.setText("0");
            answerField.setEditable(true);
            nextQuestion();
        } else if (e.getSource() == restartButton) {
            resetGame();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == answerField) {
            checkAnswer();
        }
    }

    private void nextQuestion() {
        if (questionCounter < LIMIT) {
            digit1 = random.nextInt(10) + 1;  // Random number between 1 and 10
            digit2 = random.nextInt(10) + 1;  // Random number between 1 and 10

            // Randomly choose an operator
            int operation = random.nextInt(4);  // 0: +, 1: -, 2: *, 3: /
            switch (operation) {
                case 0:
                    operator = "+";
                    correctAnswer = digit1 + digit2;
                    break;
                case 1:
                    operator = "-";
                    correctAnswer = digit1 - digit2;
                    break;
                case 2:
                    operator = "*";
                    correctAnswer = digit1 * digit2;
                    break;
                case 3:
                    operator = "/";
                    // Ensure no division by zero
                    while (digit2 == 0) {
                        digit2 = random.nextInt(10) + 1;
                    }
                    correctAnswer = digit1 / digit2;
                    break;
            }

            // Display question
            questionLabel.setText("What is " + digit1 + " " + operator + " " + digit2 + " ?");
            questionCounter++;
        } else {
            endGame();
        }
    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(answerField.getText().trim());
            if (userAnswer == correctAnswer) {
                rightCounter++;
                scoreField.setText(String.valueOf(rightCounter));
            }
            nextQuestion();
            answerField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
            answerField.setText("");
        }
    }

    private void resetGame() {
        questionCounter = 0;
        rightCounter = 0;
        scoreField.setText("0");
        questionLabel.setText("");
        answerField.setText("");
        answerField.setEditable(false);
    }

    private void endGame() {
        questionLabel.setText("Game Over! Score: " + rightCounter);
        answerField.setEditable(false);
    }

    public static void main(String[] args) {
        new MathQuizGame();
    }
}
