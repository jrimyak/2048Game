/**
 * TileTester.java 
 *
 * Assignment #:
 * 
 * Brief Program Description:
 * Tester for the Tile Class
 *
 */

public class TileTester 
{
   public static void main(String[] args)
   {
       Tile tile1 = new Tile(2,0,0);
       System.out.println(tile1);
       tile1.changeValue(4);
       tile1.changeRow(4);
       tile1.changeCol(4);
       System.out.println(tile1);
   }
}
