import javax.swing.*;

public class TheForm1 {
    private JButton calculate;
    private JTextField inputFirstNumber;
    private JTextField inputSecondNumber;
    private JButton showTheWeatherButton;
    private JComboBox comboBox1;
    private JLabel weatherResult;
    private JLabel calculationResult;

    public JTextField getInputFirstNumber() {
        return inputFirstNumber;
    }

    public void setInputFirstNumber(JTextField inputFirstNumber) {
        this.inputFirstNumber = inputFirstNumber;
    }

    public JTextField getInputSecondNumber() {
        return inputSecondNumber;
    }

    public void setInputSecondNumber(JTextField inputSecondNumber) {
        this.inputSecondNumber = inputSecondNumber;
    }
}
