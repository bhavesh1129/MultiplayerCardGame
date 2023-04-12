// Define the package name
package org.example.entity;

// Import the Suits enum from org.example.enums package
import org.example.enums.Suits;

// Define the Card class
public class Card {
    // Define the number of the card
    private int cardNumber;

    // Define the suit of the card using the Suits enum
    private Suits cardSuit;

    // Empty constructor
    public Card() {
    }

    // Constructor with arguments
    public Card(int number, Suits suit) {
        // Assign the number and suit values to the cardNumber and cardSuit variables
        // respectively
        this.cardNumber = number;
        this.cardSuit = suit;
    }
}