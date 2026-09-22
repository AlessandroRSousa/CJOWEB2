import javax.swing.JOptionPane;

public class App3 {
    public static void main(String[] args) throws Exception {
        int number1, number2, sum;
        number1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));
        number2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número"));
        sum = number1 + number2;
        JOptionPane.showMessageDialog(null, "Soma = " + sum);
    }
}
