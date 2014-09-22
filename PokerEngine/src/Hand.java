import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private ArrayList<Card> Cards = new ArrayList<Card>();
	private int handStrength;
	private int highCard;
	private int lowCard;
	private int kicker;
	private boolean bScored = false;
	private boolean royalFlush = false;
	private boolean bFlush = false;
	private boolean bStraight = false;
	private boolean bAce = false; 
	private boolean straightFlush = false;
	private boolean fourOfaKind = false;
	private boolean fullHouse = false;
	private boolean threeOfAKind = false;
	private boolean twoPair = false;
	private boolean onePair = false;
	private boolean noPair = false;

//constructor, draws five cards and sorts in order
public Hand() {
	Deck hDeck = new Deck();
	
	for (int i = 1; i < 6; i++) {
		Card drawCard = hDeck.drawFromDeck();
		Cards.add(drawCard);  //draws five cards
		Collections.sort(Cards, Card.cardRank); 
	}
}

public void evaluate(){	
	if (Cards.get(1).getSuit()== Cards.get(2).getSuit() && Cards.get(2).getSuit() == Cards.get(3).getSuit() && Cards.get(3).getSuit() == Cards.get(4).getSuit() && Cards.get(4).getSuit() == Cards.get(5).getSuit()){
		bFlush=true;
	}
	
	if (Cards.get(1).getRank()+1 == Cards.get(2).getRank() && Cards.get(2).getRank() +1 == Cards.get(3).getRank() && Cards.get(3).getRank() +1 == Cards.get(4).getRank() && Cards.get(4).getRank() +1 == Cards.get(5).getRank()){
		bStraight=true;
	}
	
	if(Cards.get(1).getRank() == Cards.get(4).getRank() || Cards.get(2).getRank() == Cards.get(5).getRank()) {
		fourOfaKind = true; 
	}
	
	if(Cards.get(1).getRank() == Cards.get(3).getRank() && Cards.get(4).getRank() == Cards.get(5).getRank() || Cards.get(1).getRank() == Cards.get(2).getRank() && Cards.get(3).getRank() == Cards.get(5).getRank()){
		fullHouse = true;
	}
	
	if (Cards.get(1).getRank() == Cards.get(3).getRank() || Cards.get(2).getRank() == Cards.get(4).getRank() || Cards.get(3).getRank() == Cards.get(5).getRank()){
		threeOfAKind = true;
		//three of a kind
	}
	
	if (Cards.get(1).getRank() == Cards.get(2).getRank() && Cards.get(3).getRank() == Cards.get(4).getRank() || Cards.get(1).getRank() == Cards.get(2).getRank() && Cards.get(4).getRank() == Cards.get(5).getRank() || Cards.get(2).getRank() == Cards.get(3).getRank() && Cards.get(4).getRank() == Cards.get(5).getRank() ){
		twoPair = true;
		//two pair 
	}
	
	if (Cards.get(1).getRank() == Cards.get(2).getRank() || Cards.get(2).getRank() == Cards.get(3).getRank() || Cards.get(3).getRank() == Cards.get(4).getRank() || Cards.get(4).getRank() == Cards.get(5).getRank() ){
		onePair = true;
		//one pair
	}
	
	if (Cards.get(5).getRank() == 14){
		bAce= true;
	}
	if (bFlush && bStraight && bAce == true)
		royalFlush = true;

	
	if ((bStraight && bFlush) ==true){
		straightFlush = true;
	}

}

private static boolean aceIsTrue(boolean bAce){
	if(Cards.get(5).getRank() == 14)
		bAce = true;
	}

private void handScore(int handStrength, int highCard, int lowCard, int kicker){
	this.handStrength=handStrength;
	this.highCard=highCard;
	this.lowCard=lowCard;
	this.kicker=kicker;
	this.bScored=true;	

	if (bFlush && bStraight && bAce)
		handScore(100, 0, 0, 0); 

	
	if ((bStraight && bFlush) ==true){
		handScore(90, Cards.get(5).getRank(), 0,0);
	}
			
	//four of a kind
	if(fourOfaKind == true && Cards.get(1).getRank() != Cards.get(2).getRank())
		handScore(80, Cards.get(2).getRank(), 0, Cards.get(1).getRank()); 
	if(fourOfaKind == true && Cards.get(5).getRank() != Cards.get(4).getRank())
		handScore(80, Cards.get(1).getRank(), 0, Cards.get(5).getRank());
	
	}
}
	


	// kicker is the fifth card if not all cards are used -- four of a kind, 2
	// pair
	// constructor pass in two things: 1. deck 2. number of cards	