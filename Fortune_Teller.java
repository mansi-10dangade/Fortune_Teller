package pf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Fortune_Teller extends JFrame implements ActionListener {
    private JTextField monthField, yearField;
    private JButton fortuneButton;
    private JLabel fortuneLabel;

    private final String[] fortunes = {
            "You will find new opportunities this year.",
            "A pleasant surprise awaits you soon.",
            "Take risks, they will pay off in unexpected ways.",
            "Your creativity will flourish in the coming months.",
            "A long-held dream will finally come true."
    };

    public Fortune_Teller() {
        setTitle("Fortune Teller");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JLabel birthDateLabel = new JLabel("Enter your birth month and year:");
        add(birthDateLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        monthField = new JTextField(5);
        inputPanel.add(monthField);

        yearField = new JTextField(5);
        inputPanel.add(yearField);

        add(inputPanel);

        fortuneButton = new JButton("Get Fortune");
        fortuneButton.addActionListener(this);
        add(fortuneButton);

        fortuneLabel = new JLabel();
        add(fortuneLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fortuneButton) {
            String month = monthField.getText().trim();
            String year = yearField.getText().trim();

            
            String fortune = generateFortune(month, year);

            fortuneLabel.setText("Your fortune: " + fortune);
        }
    }

    private String generateFortune(String month, String year) {
       
        int index = new Random().nextInt(fortunes.length);
        return fortunes[index];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Fortune_Teller());
    }
}