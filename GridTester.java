import java.util.Scanner;
/**
 * GridTester.java 
 *
 * Assignment #:
 * 
 * Brief Program Description:
 * This tests the grid, mostly the slide methods, and is essentially a text based version of 2048
 *
 */

public class GridTester 
{
    public static void main(String[] args)
    {
        
         Grid g= new Grid(); 
        g.printGame();
        System.out.println("\n");

        g.addNew2();
        g.printGame();
        System.out.println("\n");
        
        g.addNew2();
        g.printGame();
        System.out.println("\n");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("move: ");
        String input = scan.nextLine();

       

        while(!input .equals( "quit"))
        {
            if(input.equals("up"))
            {

              

                g.slideUp();
                g.printGame();
                System.out.println("\n");
                
                  g.addNew2();
                g.printGame();
                System.out.println("\n");
            }

            if(input.equals("left"))
            {

              

                g.slideLeft();
                g.printGame();
                System.out.println("\n");
                
                  g.addNew2();
                g.printGame();
                System.out.println("\n");
            }

            if(input.equals("down"))
            {

                

                g.slideDown();
                g.printGame();
                System.out.println("\n");
                
                g.addNew2();
                g.printGame();
                System.out.println("\n");
            }

            if(input.equals("right"))
            {


                g.slideRight();
                g.printGame();
                System.out.println("\n");
                
                
                g.addNew2();
                g.printGame();
                System.out.println("\n");
            }
            System.out.println("Make your move");
            input = scan.nextLine();
        }
    }
}
