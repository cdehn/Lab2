
public class Play {

    public static void main(String[] args) {
    	Deck deck = new Deck();
    	Hand h = new Hand(); 
    	Hand h1 = new Hand();
    	
        System.out.println("The deck is now shuffled");   
    	System.out.println("There is " + deck.cardsRemain() + "cards remaining in the deck");
    
    	h.handScore();
    	h1.handScore();
    	
    	if(h.handScore() > h1.handScore())
    		System.out.println("The first hand wins!");
    	if(h.handScore() < h1.handScore())
    		System.out.println("The second hand wins!");
    	else
    		System.out.println("There is a tie");
    	
    	/*
    	 * need to know number of deck
    	 * need to know how many players
    	 * play is in different project??
    	 */
    }
}