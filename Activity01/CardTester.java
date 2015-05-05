package Activity01;


/**
 * Write a description of class CardTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardTester
{
   public static void main(String[] agrs)
    {
        String[] ranks = {"jack", "queen", "king"};
        String[] suits = {"blue", "red"};
        int[] pointValues = {11 , 12, 13};
        Card card1 = new Card("jack", "blue", 11);
        
        System.out.println(" Test Suit:" + card1.suit());
        System.out.println(" Test Rank:" + card1.rank());
        System.out.println(" Test Value:" + card1.pointValue());
    }
}
