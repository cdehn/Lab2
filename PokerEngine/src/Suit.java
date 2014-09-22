
public enum Suit {

		DIAMONDS(0), CLUBS(1), HEARTS(2), SPADES(3);
	
		private int suit;
		Suit(int suitValue){
			this.suit=suitValue;
		}

		public int getSuit(){
			return suit;
		}

}
