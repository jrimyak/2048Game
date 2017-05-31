import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Class Game - write a description of the class here
 * 
 * This is the graphical version of 2048, which utilizes the grid class in order to accurately 
 * display the values of the tiles. This uses the draw method of the tile, in addition to drawing
 * a grid, displaying score, and keeping track of when the player starts and loses. 
 */
public class Game extends JPanel implements ActionListener, KeyListener
{
    //intial values--starting off the screen
    Timer timer;
    Tile test;
    Grid grid;

    // JFrame frame;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        Game game= new Game();
        JOptionPane.showMessageDialog(null, "                                     "+
            "  Welcome to 2048!\n"+
            "Directions: Press the arrow keys to move the grid.\n"
            +"Like numbers combine, and your score is based on what the result is.\n"+
            "Authors: Jesse Brodacz, Alex Beckerman," 
            +" Justin Kastler, Jake Imyak","Start",JOptionPane.INFORMATION_MESSAGE);

        frame.setTitle("2048");

        frame.setLayout(new BorderLayout());

        frame.add(game, BorderLayout.CENTER);
        game.addKeyListener(game);
        frame.addKeyListener(game);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

        game.setUpGame();
    }

    /**
     * Sets up the game by starting the timer and adding the 2's, in addition to creating all of the frames 
     */
    public void setUpGame() {

        if(timer != null) {
            timer.stop();
        }
        //grid.clear();

        timer= new Timer(100,this);
        timer.start();

        grid.clear();
        grid.addNew2();
        grid.addNew2();

    }

    /**
     * Constructor for the game, which sets its dimensions, and instantiates the score and grid
     */
    public Game()
    {

        setPreferredSize(new Dimension(750, 500));

        grid=new Grid();
    }

    public void actionPerformed(ActionEvent ae)
    {

        repaint();
    }

    /**
     * Not used, only here to fulfill the interface
     */
    public void keyReleased(KeyEvent evt){

    }

    /**
     * @param KeyEvent: registers the keys in order to utilize them for commands
     * When the respective arrow key is pressed, the grid slides in that direction. 
     */
    public void keyPressed(KeyEvent evt){
        int key= evt.getKeyCode();

        switch (key)
        {

            case(KeyEvent.VK_UP):
            grid.slideUp();
            grid.addNew2();

            if(!grid.canPlay())
            {
                //grid.addNew2();
                //timer.stop();
                JOptionPane.showMessageDialog(null,"Game Over!","Lose",JOptionPane.INFORMATION_MESSAGE);

                setUpGame();
            }
            if(grid.win() == true)
            {
                JOptionPane.showMessageDialog(null, "You Won", "Growth Mindset Achieved", JOptionPane.INFORMATION_MESSAGE);
            }
            break;
            case(KeyEvent.VK_DOWN):
            grid.slideDown();
            grid.addNew2();

            if(!grid.canPlay())
            {
                //grid.addNew2();
                //timer.stop();
                JOptionPane.showMessageDialog(null,"Game Over!","Lose",JOptionPane.INFORMATION_MESSAGE);

                setUpGame();
            }
            if(grid.win() == true)
            {
                JOptionPane.showMessageDialog(null, "You Won", "Growth Mindset Achieved", JOptionPane.INFORMATION_MESSAGE);
            }
            break;
            case(KeyEvent.VK_LEFT):
            grid.slideLeft();
            grid.addNew2();

            if(!grid.canPlay())
            {
                //grid.addNew2();
                //timer.stop();
                JOptionPane.showMessageDialog(null,"Game Over!","Lose",JOptionPane.INFORMATION_MESSAGE);

                //grid.clear();
                //timer.stop();
                setUpGame();

            }
            if(grid.win() == true)
            {
                JOptionPane.showMessageDialog(null, "You Won", "Growth Mindset Achieved", JOptionPane.INFORMATION_MESSAGE);
            }
            break;
            case(KeyEvent.VK_RIGHT):
            grid.slideRight();
            grid.addNew2();

            if(!grid.canPlay())
            {
                //grid.addNew2();
                //timer.stop();
                JOptionPane.showMessageDialog(null,"Game Over!","Lose",JOptionPane.INFORMATION_MESSAGE);

                setUpGame();

            }
            if(grid.win() == true)
            {
                JOptionPane.showMessageDialog(null, "You Won", "Growth Mindset Achieved", JOptionPane.INFORMATION_MESSAGE);
            }

            break;
        }

    }

    /**
     * Not used, only here to fulfill the interface
     */
    public void keyTyped(KeyEvent evt){

    }

    /**
     * @param Graphics g, a graphics engine that helps draw pictures
     * Creates the grid for the game, displays the score, and 
     */
    public void paint(Graphics g)
    {   

        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        for(int x=0; x<500;x+=125)
        {
            for(int y=0; y<500;y+=125)
            {
                g.setColor(Color.BLACK);
                g.drawRect(x,y,125,125);
            } 
        }

        g.setFont(new Font("TimesRoman",1,40));
        g.drawString("Score",520,150);
        int score=grid.getScore();
        g.drawString(""+score,520,190);

        g.drawString("High Score",520,300);
        score=grid.getHighScore();
        g.drawString(""+score,520,340);
        int row=0;
        int col=0;
        for(int r=0;r<4;r++)
        {

            for(int c=0;c<4;c++)
            {
                grid.getGrid()[r][c].changeCol(col);
                grid.getGrid()[r][c].changeRow(row);

                col+=125;

            }
            col=0;
            row+=125;

        }

        for(int r=0;r<4;r++)
        {

            for(int c=0;c<4;c++)
            {
                grid.getGrid()[r][c].draw(g);

            }

        }

    }
}
