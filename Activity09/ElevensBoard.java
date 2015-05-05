package Activity09;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
        {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;

    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *    false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        boolean king = false;
        boolean queen = false;
        boolean jack = false;
        List<Card> cardList = new ArrayList();
        if(selectedCards.size() == 2){
            if(cardAt(selectedCards.get(0)).pointValue() 
            + cardAt(selectedCards.get(1)).pointValue() == 11)
                return true;
            else
                return false;
        }
        else 
            return((selectedCards.size() == 3) && containsJQK(selectedCards));
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        List<Integer> pointCards = new ArrayList();
        List<Integer> faceCards = new ArrayList();
        for(Integer i : cardIndexes()){
            Card c = cardAt(i);
            if(c.rank().equals("king")
            || c.rank().equals("queen")
            || c.rank().equals("jack"))
                faceCards.add(i);
            else
                pointCards.add(i);
        }
        if(containsPairSum11(pointCards))
            return true;
        else
            return(containsJQK(faceCards));
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        for(int i1 = 0; i1 < selectedCards.size(); i1++){
            for(int i2 = 0; i2< selectedCards.size(); i2++){
                if(cardAt(selectedCards.get(i1)).pointValue()
                   + cardAt(selectedCards.get(i2)).pointValue() == 11)
                   return true;
            }
        }
        return false;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
        boolean king = false,
        queen = false,
        jack = false;
        for(Integer i : selectedCards){
            if(cardAt(i).rank().equals("king"))
                king = true;
            else if(cardAt(i).rank().equals("queen"))
                queen = true;
            else if(cardAt(i).rank().equals("jack"))
                jack = true;
        }
        return(king && queen && jack);
    }
}
