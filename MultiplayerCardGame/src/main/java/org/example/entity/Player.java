// Define the package name
package org.example.entity;

// Import ArrayList from the java.util package
import java.util.ArrayList;

// Define the Player class
public class Player {
    // Define the player's id
    private int playerId;

    // Define an ArrayList of Card objects to represent the player's hand
    private ArrayList<Card> hand = new ArrayList<>();

    // Player constructor with playerId as parameter
    public Player(int playerId) {
        this.playerId = playerId;
    }

    // Method for adding a card to the player's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    // Method for removing a card from the player's hand
    public void removeCard(Card card) {
        hand.remove(card);
    }

    // Method for getting the player's id
    public int getPlayerId() {
        return playerId;
    }

    // Method for getting the player's hand of cards
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Override toString() method to return player's id and hand of cards
    @Override
    public String toString() {
        return playerId + " " + hand.toString();
    }
}