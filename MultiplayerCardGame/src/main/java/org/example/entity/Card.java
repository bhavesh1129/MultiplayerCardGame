// Define the package name
package org.example.entity;

// Define the Card class
/**
 * 
 * The Card class represents a playing card in a deck.
 * 
 * It has a cardNumber and a cardSuit (using the Suits enum).
 * 
 */
public class Card {
    // Define the cardNumber of the card
    private int cardNumber;
    // Define the cardSuit of the card using the Suits enum
    private Suits cardSuit;

    /**
     * 
     * Sets the cardNumber of the card.
     * 
     * @param cardNumber an integer representing the card number
     * 
     */
    public void setNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 
     * Sets the cardSuit of the card.
     * 
     * @param cardSuit a Suits enum representing the card suit
     */
    public void setSuit(Suits cardSuit) {
        this.cardSuit = cardSuit;
    }

    /**
     * 
     * Gets the cardNumber of the card.
     * 
     * @return an integer representing the card number
     * 
     */
    public int getNumber() {
        return cardNumber;
    }

    /**
     * 
     * Gets the cardSuit of the card.
     * 
     * @return a Suits enum representing the card suit
     * 
     */
    public Suits getSuit() {
        return cardSuit;
    }

    /**
     * Constructor with no arguments.
     */
    Card() {
    }

    /**
     * 
     * Constructor with arguments.
     * 
     * @param num an integer representing the card number
     * @param s   a Suits enum representing the card suit
     *
     */
    public Card(int num, Suits s) {
        cardNumber = num;
        cardSuit = s;
    }

    /**
     * 
     * Returns a string representation of the card.
     * 
     * @return a string representing the card number and suit
     * 
     */
    public String toString() {
        return cardNumber + " " + cardSuit;
    }
}