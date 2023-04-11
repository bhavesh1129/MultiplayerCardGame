package main;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

import entity.Card;

/**
 * 
 * The Main class contains the main method which starts the game and handles
 * the input of the number of players, card distribution, draw pile and discard
 * pile.
 * 
 * It also contains a static and final member 'deck' which is a stack of cards,
 * and a static block which populates the deck with all the cards of different
 * suits and ranks.
 *
 */
public class Main {
    // Declaring the deck of cards as a static and final member
    public static final Stack<Card> deck = new Stack<>();

    // Declaring the static block to get the deck complete with all different cards
    // as soon as the class gets loaded to the memory
    static {
        // Completing all cards under Diamonds suit
        for (int i = 1; i <= 13; i++) {
            Card card = new Card("Diamonds", i);
            deck.push(card);
        }
        // Completing all cards under Spades suit
        for (int i = 1; i <= 13; i++) {
            Card card = new Card("Spades", i);
            deck.push(card);
        }
        // Completing all cards under Hearts suit
        for (int i = 1; i <= 13; i++) {
            Card card = new Card("Hearts", i);
            deck.push(card);
        }
        // Completing all cards under Clubs suit
        for (int i = 1; i <= 13; i++) {
            Card card = new Card("Clubs", i);
            deck.push(card);
        }
    }

    /**
     * 
     * The main method starts the game by taking the number of players as input,
     * distributing cards among all the players, creating draw pile and discard pile
     * and shuffling the deck of cards before starting the game.
     *
     */
    public static void main(String[] args) {
        // Shuffling the deck of cards before starting the game
        Collections.shuffle(deck);

        // Taking the number of players as input
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Please enter the number of players who will be participating in the game. The number of players must be between 2 and 4 (inclusive).");
        int noOfPlayers = sc.nextInt();

        // The player count must be between 2 and 4 (both inclusive)
        if (noOfPlayers >= 2 && noOfPlayers <= 4) {
            // Hand of cards of all players in a stack of stacks
            Stack<Stack<Card>> allPlayerHands = new Stack<>();

            // Distributing cards among all the players
            for (int i = 0; i < noOfPlayers; i++) {
                Stack<Card> singlePlayerCards = new Stack<>();

                // Each player starts with a hand of 5 cards
                for (int j = 0; j < 5; j++) {
                    singlePlayerCards.push(deck.pop());
                }
                allPlayerHands.push(singlePlayerCards);
            }
        }
        // Create the draw pile for the game
        Stack<Card> drawPile = new Stack<>();

        // Add all the undistributed cards to the draw pile
        drawPile.addAll(deck);

        // Filter the draw pile to get only the number cards except the action cards
        List<Card> onlyNumberCards = drawPile.stream().filter(
                card -> (card.getRank() != 1 &&
                        card.getRank() != 11 &&
                        card.getRank() != 12 &&
                        card.getRank() != 13))
                .collect(Collectors.toList());

        // Create a discard pile
        Stack<Card> discardPile = new Stack<>();

        // Add a number card from the draw pile to the discard pile to start the game
        discardPile.push(onlyNumberCards.get(onlyNumberCards.size() - 1));
    }
}
