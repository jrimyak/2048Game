/**
 * Grid.java
 * 
 * 
 * Group Project
 * BPD - The GUI that will display the game board during play.
 */
import java.util.Random;
public class Grid 
{
    private Tile[][] grid;
    private int score;
    private static int high;
    /**
     * Prints out the game's board of tiles in a 2D array
     */
    public void printGame() 
    {
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++) 
            { 
                System.out.printf("%d\t", grid[col][row].getValue());
            }
            System.out.println(); 
        }
    }

    /**
     * Constructor for the Grid class
     */
    public Grid()
    { 
        score=0;

        grid = new Tile[4][4];
        for (int col = 0; col < 4; col++) 
        {
            for (int row = 0; row < 4; row++)
            {
                grid[col][row] = new Tile(0, row, col);
            }
        }
    }

    /**
     * checks whether the player has 2048
     * @return a boolean value whether something is true or false
     */
    public boolean win()
    {
        for (int col = 0; col < 4; col++) 
        {
            for (int row = 0; row < 4; row++) 
            {
                if(grid[col][row].getValue() == 2048)
                {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * @return: a 2d array of tiles
     * returns a reference to the grid, or the 2d array of tiles
     */
    public Tile[][] getGrid()
    {
        return grid;
    }

    /**
     * Slides all of the game tiles as far left as possible
     */
    public void slideLeft() 
    { 

        int destCol;
        for (int row = 0; row <= 3; row++) 
        {
            destCol = 0;
            for (int column = 0; column <= 3; column++)
            {
                if (destCol == column || grid[column][row].getValue() == 0)
                {
                    continue;
                } 
                else if (grid[column][row].getValue() == grid[destCol][row].getValue()) 
                {
                    if(grid[destCol][row].getValue()==0)
                    {
                        grid[destCol][row].changeValue(grid[destCol][row].getValue()+2);
                    }
                    grid[destCol][row].changeValue(grid[destCol][row].getValue() * 2); 
                    score+=grid[destCol][row].getValue();
                    if(score>high)
                    {
                        high=score;
                    }
                    grid[column][row].changeValue(0);
                    destCol++;
                } 
                else 
                {
                    if (grid[destCol][row].getValue() != 0)
                        destCol++;
                    if (destCol != column) 
                    {
                        grid[destCol][row].changeValue(grid[column][row].getValue());
                        grid[column][row].changeValue(0);
                    }
                }
            }
        }

    }

    /**
     * Slides all of the game tiles as far right as possible
     */
    public void slideRight() 
    { 

        int destCol;
        for (int row = 0; row <= 3; row++) 
        {
            destCol = 3;
            for (int column = 3; column >= 0; column--)
            {
                if (destCol == column || grid[column][row].getValue() == 0)
                {
                    continue;
                } 
                else if (grid[column][row].getValue() == grid[destCol][row].getValue()) 
                {
                    if(grid[destCol][row].getValue()==0)
                    {
                        grid[destCol][row].changeValue(grid[destCol][row].getValue()+2);
                    }
                    grid[destCol][row].changeValue(grid[destCol][row].getValue() * 2); 
                    score+=grid[destCol][row].getValue();
                    if(score>high)
                    {
                        high=score;
                    }
                    grid[column][row].changeValue(0);
                    destCol--;
                } 
                else 
                {
                    if (grid[destCol][row].getValue() != 0)
                        destCol--;
                    if (destCol != column) 
                    {
                        grid[destCol][row].changeValue(grid[column][row].getValue());
                        grid[column][row].changeValue(0);
                    }
                }
            }
        } 

    } 

    /**
     * Slides all of the game tiles as far up as possible
     */
    public void slideUp()
    {
        int destRow;
        for (int column = 0; column < 4; column++)
        {
            destRow = 0;
            for (int row = 0; row < 4; row++)
            {
                if (destRow == row || grid[column][row].getValue() == 0) 
                {
                    continue;
                }
                else if (grid[column][row].getValue() == grid[column][destRow].getValue()) 
                {
                    if(grid[column][destRow].getValue() == 0)
                    {
                        grid[column][destRow].changeValue(grid[column][destRow].getValue() +2);
                    }
                    grid[column][destRow].changeValue(grid[column][destRow].getValue() * 2); 
                    score+=grid[column][destRow].getValue();
                    if(score>high)
                    {
                        high=score;
                    }
                    grid[column][row].changeValue(0);
                    destRow++;
                } 
                else
                {
                    if (grid[column][destRow].getValue() != 0)
                        destRow++;
                    if (destRow != row)
                    {
                        grid[column][destRow].changeValue(grid[column][row].getValue());
                        grid[column][row].changeValue(0);
                    }
                } 
                //                 if(grid[column][destRow].getValue() == grid[column][destRow+1].getValue())
                //                 {
                //                     grid[column][destRow+1].changeValue(0);
                //                     grid[column][destRow].changeValue(grid[column][destRow].getValue() * 2);
                //                 }
            }

        } 
    }

    /**
     * Slides all of the game tiles as far down as possible
     */
    public void slideDown() 
    { 
        int destRow;
        for (int column = 0; column < 4; column++) 
        { 
            destRow = 3;
            for (int row = 3; row >= 0; row--)
            {
                if (destRow == row || grid[column][row].getValue() == 0) 
                {
                    continue;
                }
                else if (grid[column][row].getValue() == grid[column][destRow].getValue()) 
                {
                    if(grid[column][destRow].getValue() == 0)
                    {
                        grid[column][destRow].changeValue(grid[column][destRow].getValue()+2);
                    }
                    grid[column][destRow].changeValue(grid[column][destRow].getValue()*2); 
                    score+=grid[column][destRow].getValue();
                    if(score>high)
                    {
                        high=score;
                    }
                    grid[column][row].changeValue(0);
                    destRow--;
                }
                else
                {
                    if (grid[column][destRow].getValue() != 0)
                        destRow--;
                    if (destRow != row)
                    {
                        grid[column][destRow].changeValue(grid[column][row].getValue());
                        grid[column][row].changeValue(0);
                    } 
                }
            }
        }
    }

    /**
     * Adds a new tile of value 2 to the game board
     * 
     * @return  boolean     Returns whether it's possible to add another tile or whether the game board is full
     */
    public boolean addNew2() 
    { 
        int col;
        int row;
        Random random = new Random();
        if (isFull()) 
            return false;
        do
        {
            col = random.nextInt(4); 
            row = random.nextInt(4);
        } 
        while (grid[col][row].getValue() != 0);
        grid[col][row].changeValue(2); 
        return true;
    }

    /**
     * Returns whether the game board has any available moves to be made
     * 
     * @return  boolean     Returns true if it's possible for more moves to be made, false if not
     */
    public boolean canPlay()
    {
        if (!isFull())
        {
            return true;
        }
        //four corners
        if(grid[0][0].getValue() == grid[0][1].getValue() || grid[0][0].getValue() == grid[1][0].getValue())
        {
            return true;
        }
        if(grid[3][0].getValue() == grid[3][1].getValue() || grid[3][0].getValue() == grid[2][0].getValue())
        {
            return true;
        }
        if(grid[3][3].getValue() == grid[3][2].getValue() || grid[3][3].getValue() == grid[2][3].getValue())
        {
            return true;
        }
        if(grid[0][3].getValue() == grid[1][3].getValue() || grid[0][3].getValue() == grid[0][2].getValue())
        {
            return true;
        }
        //between corners
        if(grid[1][0].getValue() == grid[2][0].getValue() || grid[3][1].getValue() == grid[3][2].getValue())
        {
            return true;
        }
        if(grid[0][1].getValue() == grid[0][2].getValue() || grid[1][3].getValue() == grid[2][3].getValue())
        {
            return true;
        }

        for (int col = 1; col < 3; col++) 
        {
            for (int row = 1; row < 3; row++) 
            {
                if (grid[col][row].getValue() == grid[col - 1][row].getValue() ||
                grid[col][row].getValue() == grid[col][row - 1].getValue()     ||
                grid[col][row].getValue() == grid[col + 1][row].getValue() || 
                grid[col][row].getValue() == grid[col][row + 1].getValue())
                {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Resets the score and clears the board by making all of the values of each tile 0.
     */

    public void clear()
    {

        score=0;
        for (int col = 0; col < 4; col++) 
        {
            for (int row = 0; row < 4; row++) 
            {
                grid[col][row].changeValue(0);
            }

        }

    }

    /**
     * returns the score of the player
     * @return int: the current score of the player
     */
    public int getScore()
    {
        return score;
    }

    /**
     * returns the high score of the game
     * @return int: the current high score
     */
    public int getHighScore()
    {
        return high;
    }

    /**
     * Returns whether there are any open spaces on the board
     * 
     * @return  boolean     Returns true if all spaces on the board have tile objects, false if not
     */
    public boolean isFull()
    {
        for (int column = 0; column < 4; column++)
        {
            for (int row = 0; row < 4; row++) 
            { 
                if (grid[column][row].getValue() == 0)
                    return false;
            } 
        }
        return true; 
    }
}
