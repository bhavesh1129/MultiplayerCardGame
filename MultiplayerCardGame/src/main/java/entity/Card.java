package entity;

public class Card {
	// Instance variables for suit and rank
	private String suit;
	private int rank;

	// Default constructor
	public Card() {
		super();
	}

	// Parameterized constructor to set suit and rank
	public Card(String suit, int rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	// Override toString() method to return string representation of the Card object
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}

	// Getter method to get the suit of the card
	public String getSuit() {
		return suit;
	}

	// Setter method to set the suit of the card
	public void setSuit(String suit) {
		this.suit = suit;
	}

	// Getter method to get the rank of the card
	public int getRank() {
		return rank;
	}

	// Setter method to set the rank of the card
	public void setRank(int rank) {
		this.rank = rank;
	}

}
