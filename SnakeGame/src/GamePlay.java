import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private int[] snakeXLength = new int[750];
    private int[] snakeYLength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private int lengthOfSnake = 3;

    private ImageIcon rightMouth;
    private ImageIcon leftMouth;
    private ImageIcon upMouth;
    private ImageIcon downMouth;

    private int score;

    private Timer timer;
    private int delay = 150;

    private int moves = 0;
    private ImageIcon snakeImage;
    private ImageIcon titleImage;

    private int enemyxpos[] = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450
    ,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int enemyypos[] = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450
            ,475,500,525,550,575,600,625};

    private ImageIcon enemyimage;

    private Random random = new Random();

    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);
    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }
    public void paint(Graphics g){

        if(moves == 0){

            snakeXLength[2] = 50;
            snakeXLength[1] = 75;
            snakeXLength[0] = 100;

            snakeYLength[2] = 100;
            snakeYLength[1] = 100;
            snakeYLength[0] = 100;
        }
        //title Image border
        g.setColor(Color.WHITE);
        g.drawRect(24,10,851,55);

        //draw the title Image
        titleImage = new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this,g,25,11);

        //Border for GamePlay
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);

        // scores for gameplay
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores: " + score, 780, 30);

        // Length of Snake
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: " + lengthOfSnake, 780, 50);

        //background for Image
        g.setColor(Color.BLACK);
        g.fillRect(25,75,850,576);

        //Snake Position at start
        rightMouth = new ImageIcon("rightmouth.png");
        rightMouth.paintIcon(this,g,snakeXLength[0],snakeYLength[0]);

        //Length of Snake
        for(int i =0; i<lengthOfSnake; i++){
            if(i == 0 && right){
                rightMouth = new ImageIcon("rightmouth.png");
                rightMouth.paintIcon(this,g,snakeXLength[i],snakeYLength[i]);
            }

            if(i == 0 && left){
                leftMouth = new ImageIcon("leftmouth.png");
                leftMouth.paintIcon(this,g,snakeXLength[i],snakeYLength[i]);
            }

            if(i == 0 && up){
                upMouth = new ImageIcon("upmouth.png");
                upMouth.paintIcon(this,g,snakeXLength[i],snakeYLength[i]);
            }

            if(i == 0 && down){
                downMouth = new ImageIcon("downmouth.png");
                downMouth.paintIcon(this,g,snakeXLength[i],snakeYLength[i]);
            }

            if(i!= 0){
                snakeImage = new ImageIcon("snakeimage.png");
                snakeImage.paintIcon(this,g,snakeXLength[i],snakeYLength[i]);
            }
        }

        enemyimage = new ImageIcon("enemy.png");
        enemyimage.paintIcon(this,g,enemyxpos[xpos],enemyypos[ypos]);

        if(enemyxpos[xpos] == snakeXLength[0] && enemyypos[ypos] == snakeYLength[0]){
            score++;
            lengthOfSnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }

        for(int i = 1; i< lengthOfSnake; i++){
            if(snakeXLength[i] == snakeXLength[0] && snakeYLength[i] == snakeYLength[0]) {
                right = false;
                left = false;
                up = false;
                down = false;

                g.setColor(Color.WHITE);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over", 300, 300);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Space to Restart", 350, 340);
            }
        }

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(right){
            for(int i = lengthOfSnake - 1; i>=0; i--){
                snakeYLength[i+1] = snakeYLength[i];
            }
            for(int i = lengthOfSnake - 1; i>= 0; i--){
                if(i == 0){
                    snakeXLength[i] += 25;
                }
                else{
                    snakeXLength[i] = snakeXLength[i-1];
                }
                if(snakeXLength[i] > 850){
                    snakeXLength[i] = 25;
                }
            }
            repaint();
        }
        if(left){
            for(int i = lengthOfSnake - 1; i>=0; i--){
                snakeYLength[i+1] = snakeYLength[i];
            }
            for(int i = lengthOfSnake - 1; i>= 0; i--){
                if(i == 0){
                    snakeXLength[i] -= 25;
                }
                else{
                    snakeXLength[i] = snakeXLength[i-1];
                }
                if(snakeXLength[i] < 25){
                    snakeXLength[i] = 850;
                }
            }
            repaint();
        }
        if(up){
            for(int i = lengthOfSnake - 1; i>=0; i--){
                snakeXLength[i+1] = snakeXLength[i];
            }
            for(int i = lengthOfSnake - 1; i>= 0; i--){
                if(i == 0){
                    snakeYLength[i] -= 25;
                }
                else{
                    snakeYLength[i] = snakeYLength[i-1];
                }
                if(snakeYLength[i] < 75){
                    snakeYLength[i] = 625;
                }
            }
            repaint();
        }
        if(down){
            for(int i = lengthOfSnake - 1; i>=0; i--){
                snakeXLength[i+1] = snakeXLength[i];
            }
            for(int i = lengthOfSnake - 1; i>= 0; i--){
                if(i == 0){
                    snakeYLength[i] += 25;
                }
                else{
                    snakeYLength[i] = snakeYLength[i-1];
                }
                if(snakeYLength[i] > 625){
                    snakeYLength[i] = 75;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            moves = 0;
            score = 0;
            lengthOfSnake = 3;
            repaint();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;
            left = true;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }

        if(e.getKeyCode() ==  KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            down = true;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
