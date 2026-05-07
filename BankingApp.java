import javax.swing.*;
import java.awt.event.*;

public class BankingApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Mini Bank");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JTextField amountField = new JTextField();
        amountField.setBounds(150, 70, 150, 30);
        frame.add(amountField);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 200, 300, 30);
        frame.add(resultLabel);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 120, 100, 30);
        frame.add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(200, 120, 100, 30);
        frame.add(withdrawBtn);

        JButton checkBtn = new JButton("Check Balance");
        checkBtn.setBounds(120, 160, 150, 30);
        frame.add(checkBtn);

        BankAccount account = new BankAccount("agam chauhan");

        depositBtn.addActionListener(e -> {
            try{
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                resultLabel.setText("Deposited!");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number!");
            }
        });

        withdrawBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.withdraw(amount);
                if (amount <= account.getBalance()) {
                    resultLabel.setText("Withdrawn!");
                } else {
                    resultLabel.setText("Insufficient funds!");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number!");
            }
        });

        checkBtn.addActionListener(e -> {
            resultLabel.setText("Balance: " + account.getBalance());
        });

        frame.setVisible(true);
    }
}