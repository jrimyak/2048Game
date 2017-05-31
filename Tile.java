
import java.awt.*;

/**
 * Tile.java  
 *
 * 
 * Brief Program Description:
 * Represents a tile in 2048
 *
 */
public class Tile
{
    private int value;
    private int row;
    private int col;

    /**
     * Constructor for the Tile class
     * @param value         the value of the tile
     * @param row           the row at which the tile is at
     * @param col           the col at which the tile is at 
     */
    public Tile(int value, int row, int col)
    {
        this.value = value;
        this.row = row;
        this.col = col;

    }

    /**
     * draws a tile based on it's value, color, and position on the board
     * @Param Graphics g, a grahpics engine that helps draw shape and colors
     * 
     */
    public void draw(Graphics g) {

        Color c=Color.BLACK;
        if(this.value==0)
        {
            c= Color.BLACK;
        }
        else if(this.value==2)
        {
            c=Color.RED;

        }
        else if(this.value==4)
        {c=new Color(118,4,4);//maroon

        }
        else if(this.value==8)
        {c=Color.ORANGE;

        }
        else if(this.value==16)
        {
            c=Color.YELLOW;
        }
        else if(this.value==32)
        {c=new Color(123,249,152);//mint green

        }
        else if(this.value==64)
        {
            c=new Color(5,61,18);//dark green
        }else if(this.value==128)
        {
            c=new Color(122,241,255);//light blue
        }else if(this.value==256)
        {
            c=new Color(22,88,243);//indigo
        }
        else if(this.value==512)
        {
            c=new Color(43,0,185);//violet
        }
        else if(this.value==1024)
        {
            c=new Color(53,0,107);//dark Purple
        }
        else if(this.value==2048)
        {
            c=Color.BLACK;
        }


        g.setFont(new Font("TimesRoman",1,40));
        g.setColor(c);
        g.fillRect(row,col,125,125);
        g.setColor(Color.WHITE);
        g.drawRect(row,col,125,125);
        g.setColor(Color.BLACK);

        if(this.value==2048)
        {
            c=Color.WHITE;
        }
        String len=""+value;
        if(len.length()==1)
        {
            g.drawString(""+value,row+50,col+70);
        }
        else if(len.length()==2)
        {
            g.drawString(""+value,row+40,col+70);
        }
        else if(len.length()==3)
        {
            g.drawString(""+value,row+30,col+70);
        }
        else if(len.length()==4)
        {
            g.drawString(""+value,row+20,col+70);
        }
    }

    /**
     * An empty constructor for the Tile class
     * */
    public Tile()
    {

    }

    /**
     * An accessor for the value of the tile
     * @return value        the value of the tile 
     */
    public int getValue()
    {

        return value;
    }

    /**
     * An accessor for the row of the tile
     * @return row          the row for the position of the tile
     */
    public int getRow()
    {
        return row;
    }

    /**
     * An accessor for the col of the tile
     * @return col          the col for the position of the tile
     */
    public int getCol()
    {
        return col;
    }

    /**
     * A mutator for the value
     * @param the value that the tile will become
     * 
     */
    public void changeValue(int val)
    {
        value = val;
    }

    /**
     * A mutator for the row 
     * @param the row that the tile will become 
     */
    public void changeRow(int newRow)
    {
        row = newRow;
    }

    /**
     * A mutator for the col
     * @param the col that the tile will become 
     */
    public void changeCol(int newCol)
    {
        col = newCol;
    }

    /**
     * A toString method for the tile class
     * @return a pretty printing for the tile
     */
    public String toString()
    {
        return "The tile has a value of " + getValue() + " a row of " + getRow() + " a column of " + getCol();
    }
}

