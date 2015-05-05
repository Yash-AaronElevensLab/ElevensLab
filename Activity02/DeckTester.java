package Activity02;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		 String[] ranks = {"jack", "queen", "king"};
        String[] suits = {"blue", "red"};
        int[] pointValues = {11 , 12, 13};
        Deck d1 = new Deck(ranks, suits, pointValues);
        
        System.out.println("to String: \n" + d1.toString());
        System.out.println("Is the deck empty? : " + d1.isEmpty() + "...Should be false");
        System.out.println("Size of deck? : " + d1.size() + "... Should be 6 before dealt method" );
        System.out.println("Deal a card, then check size : " + d1.deal());
        System.out.println("size = " + d1.size());
	}
}
