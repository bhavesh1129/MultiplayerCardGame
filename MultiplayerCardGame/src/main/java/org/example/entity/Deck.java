// Define the package name
package org.example.entity;

// Import ArrayList and Collections from the java.util package
import java.util.ArrayList;
import java.util.Collections;

// Define the Deck class
public class Deck {
    // Define an ArrayList of Card objects to represent the deck
    private ArrayList<Card> deck;

    // Constructor for creating a deck of cards and shuffling them
    public Deck() {
        // Initialize the deck ArrayList
        deck = new ArrayList<>();

        // Loop through all the suits in the Suits enum
        for (Suits suits : Suits.values()) {
            // Loop through all the numbers from 1 to 13 to represent the cards in the suit
            for (int i = 1; i <= 13; i++) {
                // Create a new card object with the current suit and number and add it to the
                // deck
                deck.add(new Card(i, suits));
            }
        }

        // Shuffle the deck using the Collections.shuffle() method
        Collections.shuffle(deck);
    }

    // Method for getting the ArrayList of the deck
    public ArrayList<Card> getDeck() {
        return deck;
    }
}