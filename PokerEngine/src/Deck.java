import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private int numberOfcards;
	private final int deckSize = 52;

	// no args constructor adds card to deck
	public Deck() {
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				Card addCard = new Card(j, i);
				deck.add(addCard);
			}
		}
		shuffleDeck();
	}

	// method shuffles deck
	public void shuffleDeck() {
		Collections.shuffle(this.deck,new Random());
	}

	// method draws from deck
	public Card drawFromDeck() {
		Card drawCard = deck.get(0);
		deck.remove(0);
		return drawCard;
	}

	// method returns how many cards are
	// remaining to be drawn
	public int cardsRemain() {
		return deck.size();
	}
}