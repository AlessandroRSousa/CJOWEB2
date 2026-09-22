import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Random numberGenerator = new Random();

        int die1, die2, sum, attempts, option, guess;
        boolean isCorrect;

        // laço do jogo
        do {
            // inicialização do jogo
            die1 = numberGenerator.nextInt(6) + 1;
            die2 = numberGenerator.nextInt(6) + 1;
            sum = die1 + die2;
            attempts = 3;

            System.out.println("Dado 1: " + die1 + " - Dado 2: " + die2
                + " - Soma: " + sum
            );

            isCorrect = false;
            while(!isCorrect && attempts > 0){
                attempts--;
                guess = Integer.parseInt(JOptionPane.showInputDialog(
                    null, "Digite sua aposta:"));
                
                if(guess == sum){
                    isCorrect = true;
                }else{
                    JOptionPane.showMessageDialog(null, 
                        "Você errou! Você tem ainda " + attempts + " tentativa(s).");
                }
            }

            if(isCorrect){
                JOptionPane.showMessageDialog(null, 
                    "Parabéns! Você ganhou!");
            }else{
                JOptionPane.showMessageDialog(null, 
                    "Infelizmente você perdeu!");
            }

            option = JOptionPane.showConfirmDialog(
                null, "Deseja jogar novamente?");
        } while(option == 0);
    }
}
