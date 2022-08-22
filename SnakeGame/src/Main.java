import javax.swing.JFrame;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePlay gameplay = new GamePlay();

        frame.setTitle("Snake Game");
        frame.setBounds(10,10,900,700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.DARK_GRAY);

        frame.add(gameplay);
    }
}