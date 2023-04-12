package org.example.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class GamePlay {

    // Define the deck of the game
    private ArrayList<Card> deck;

    // Define the players in the game
    private ArrayList<Player> players;

    // Define the draw pile in the game
    private ArrayList<Card> drawPile;

    // Define the discard pile in the game
    private ArrayList<Card> discardPile;

    /*
     * This method is for playing the game and initializing the deck,
     * players, draw pile and discard pile. It also throws an exception
     * if the number of players is less than 2 or more than 4.
     */
    public void playGame() throws Exception {

        Scanner sc = new Scanner(System.in);
        // Get the number of players
        int numOfPlayers = sc.nextInt();

        // Check if the number of players is between 2 to 4
        if (numOfPlayers < 2 || numOfPlayers > 4) {
            throw new Exception("Invalid number of players... Retry again....");
        }

        // Create a new deck
        deck = new Deck().getDeck();

        // Initialize players and give them 5 cards each
        players = new ArrayList<>();
        for (int i = 1; i <= numOfPlayers; i++) {
            Player p = new Player(i);

            // adding 5 - 5 cards in each player
            for (int j = 1; j <= 5; j++) {
                p.addCard(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
            players.add(p);
        }

        // Initialize discard pile with the first card from the deck
        discardPile = new ArrayList<>();
        discardPile.add(deck.get(0));
        deck.remove(0);

        // Initialize draw pile with remaining cards from the deck
        drawPile = new ArrayList<>();
        for (Card c : deck) {
            drawPile.add(c);
        }
    }
}
