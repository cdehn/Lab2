import java.util.Comparator;
public class Card {

	private int rank;
	private int suit;
	
	//constructor
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public static Comparator<Card> cardRank = new Comparator <Card>(){
		public int compare (Card card1, Card card2) {
			int card1 = card1.getRank();
			int card2 = card2.getRank();
		}
	}

	public int getSuit(){
		return suit;
	}
	
	public int getRank() {
		return rank;
	}
}


/*
* attributes: rank, suit, 
getSuit 
getRank 
Card(rank, suit)

*/