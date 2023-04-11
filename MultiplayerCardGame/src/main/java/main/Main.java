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

            // Creating a stack of cards named "drawPile"
            Stack<Card> drawPile = new Stack<>();

            // Copying all the remaining cards in the deck after distribution to the draw
            // pile
            drawPile.addAll(deck);

            // Filtering the draw pile to get only the number cards except the action cards
            List<Card> onlyNumberCards = drawPile.stream().filter(card -> (card.getRank() != 1 && card.getRank() != 11
                    && card.getRank() != 12 && card.getRank() != 13)).collect(Collectors.toList());

            // Here, drawPile is a stack data structure which stores the remaining cards in
            // the deck after the distribution of cards.
            // onlyNumberCards is a list which is created by applying a filter to the
            // drawPile stack. The filter is applied to exclude the action cards from the
            // draw pile, so that only the number cards are left. The filtered list is then
            // collected using the Collectors.toList() method.

            // Creating a discard pile
            Stack<Card> discardPile = new Stack<>();

            // Adding a number card from the draw pile to the discard pile to start the game
            discardPile.push(onlyNumberCards.get(onlyNumberCards.size() - 1));

            // Initializing a boolean variable to check if any cards are present
            boolean noCardsPresent = false;

            // Prompting the user to enter the starting player number
            System.out.println("Which player you want to start the game from?");
            int startingPlayer = sc.nextInt();
            System.out.println();

            // Closing the Scanner class here
            sc.close();

            // Checking if the starting player number is valid
            if (startingPlayer >= 1 && startingPlayer <= noOfPlayers) {
                // Initializing the current player number to the starting player number
                int currPlayer = startingPlayer - 1;
                // Marking the first round to be 1
                int round = 1;
                // Loop will run till any one player runs out of cards
                while (noCardsPresent == false) {
                    boolean isCardPresent = false;
                    // Displaying the suit and rank of the discard pile's top card for the current
                    // round
                    System.out.println("The suit and rank of the discard pile's top card are: "
                            + discardPile.peek().getSuit() + " and " + discardPile.peek().getRank()
                            + " respectively, for round " + (round++) + ".");

                    // Searching for the availability of the required type of card in the current
                    // player's hand
                    for (int i = 0; i < allPlayerHands.get(currPlayer).size(); i++) {
                        if (allPlayerHands.get(currPlayer).get(i).getSuit().equals(discardPile.peek().getSuit())
                                || (allPlayerHands.get(currPlayer).get(i).getRank() == discardPile.peek().getRank())) {
                            // If the card is present, removing it from the player's hand and adding it to
                            // the discard pile
                            isCardPresent = true;
                            discardPile.push(allPlayerHands.get(currPlayer).remove(i));
                            currPlayer++;
                            if (currPlayer == noOfPlayers) {
                                currPlayer = 0;
                            }
                            break;
                        }
                    }

                    // If the required type of card is not present in the current player's hand
                    if (isCardPresent == false) {
                        if (!drawPile.isEmpty()) {
                            // If there are cards in the draw pile, drawing a card from it
                            Card drawedCard = drawPile.pop();
                            if (drawedCard.getSuit().equals(discardPile.peek().getSuit())
                                    || drawedCard.getRank() == discardPile.peek().getRank()) {
                                // If the drawn card can be added to the discard pile, adding it
                                discardPile.push(drawedCard);
                            } else {
                                // If the drawn card cannot be added to the discard pile, adding it to the
                                // current player's hand
                                allPlayerHands.get(currPlayer).push(drawedCard);
                            }

                            currPlayer++;
                            if (currPlayer == noOfPlayers) {
                                currPlayer = 0;
                            }
                        }

                        // If the draw pile is empty for an instance
                        else {
                            System.out.println("Draw pile became empty. Match stopped. No one is the winner...!!!");
                            break;
                        }
                    }

                    // If current player played all their cards and ran out of cards
                    if (allPlayerHands.get(currPlayer).isEmpty()) {
                        noCardsPresent = true;
                        System.out.println();
                        System.out.println("******************************************************");
                        System.out.println("No of rounds played: " + (--round));
                        System.out.println();
                        System.out.println("Player " + (currPlayer + 1) + " is the winner...!!!");
                        System.out.println("******************************************************");
                        System.out.println();

                    }
                }

            } else { // If the number of players entered by the user is not between 2 and 4
                System.out.println("Please select a player between 1 and " + noOfPlayers
                        + ", because you have only selected " + noOfPlayers + " players for this game.");
            }

        } else {
            System.out.println("Number of players cannot be less than 2 and more than 4.");
        }
    }
}
