package org.example.entity;

import java.util.ArrayList;
import java.util.Scanner;

/* This class contains the main game logic.
   Create an Instance of this class at the Main class'
   main method and execute the playGame() of this class.
   Thank you!......
 */
public class GamePlay {

    private ArrayList<Card> deck;

    private ArrayList<Player> players;

    private ArrayList<Card> drawPile;

    private ArrayList<Card> discardPile;

    public void playGame() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players max 4 and min 2");
        int numOfPlayers = sc.nextInt();

        /*
         * if the number of players > 4 or players < 2
         * will throw an Exception.
         */

        if (numOfPlayers < 2 || numOfPlayers > 4) {
            throw new Exception("Invalid number of players ... Retry again....");
        }

        /*
         * Creating and shuffling the deck simultaneously
         */

        deck = new Deck().getDeck();

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

        /*
         * at the first turn the top card of the draw will
         * act as the first card or the top card of discard pile.
         */

        discardPile = new ArrayList<>();
        discardPile.add(deck.get(0));
        deck.remove(0);

        /*
         * creating a draw pile
         * from the deck.
         */
        drawPile = new ArrayList<>();
        for (Card c : deck) {
            drawPile.add(c);
        }

        // game starts now

        int playerTurn = 0;
        int direction = 1;
        /*
         * cards to be taken/drawn by the particular
         * player from the draw pile during his turn.
         */

        int numCardsTake = 1;

        while (true) {
            /*
             * when the draw pile will be empty game will be
             * ended as a draw.
             */
            if (drawPile.size() < numCardsTake) {
                System.out.println("Game drawn !! ... Cards are less ... !!!");
                break;
            }

            playerTurn %= numOfPlayers;
            if (playerTurn < 0)
                playerTurn += numOfPlayers; 
                // if playerturn goes to negative integers.
            playerTurn %= numOfPlayers;

            // current player will atleast have 1 card ... it is guarranteed

            /*
             * following 2 variables initialisation
             * for checking the matching parameters.
             */
            boolean matched = false;
            int matchedNumber = -1;
            Card topDiscardCard = discardPile.get(discardPile.size() - 1); 
            // top card of the discard pile with whom the player will try to match his cards.
            System.out.println("Discard deck top card = " + discardPile.get(discardPile.size() - 1));

            /*
             * matching mechanism of Set of Cards of
             * Each player during his turn.
             */
            for (Card currentPlayerCard : players.get(playerTurn).getHand()) {
                /*
                 * Matching condition for each turn
                 * player will try to match each of his card
                 * with the discard pile top card if the cards have
                 * same numbers or same suits.
                 */

                if (currentPlayerCard.getNumber() == topDiscardCard.getNumber()
                        || currentPlayerCard.getSuit() == topDiscardCard.getSuit()) {
                    // checking if action card on discardPile top , so that they are not stackable

                    if (topDiscardCard.getNumber() == 1 || topDiscardCard.getNumber() == 11
                            || topDiscardCard.getNumber() == 12 || topDiscardCard.getNumber() == 13) {
                        if (currentPlayerCard.getNumber() == topDiscardCard.getNumber()) 
                        // player cannot play same action card even if available so he will skip.
                            continue;
                    }
                    // if cards get matched then this statement will be printed.
                    System.out.println("Cards matched for player " + players.get(playerTurn).getPlayerId()
                            + " Card and new Discard Deck top card = " + currentPlayerCard);

                    /*
                     * to check if the current player has to
                     * take more than one card or not, depending upon the
                     * action card which the previous player may have
                     * played.
                     */
                    if (numCardsTake > 1) {
                        while (numCardsTake-- > 0) {
                            System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card");
                            /*
                             * adding the card to player's hand and removing it
                             * from the discard pile.
                             */
                            players.get(playerTurn).addCard(drawPile.get(drawPile.size() - 1));
                            drawPile.remove(drawPile.size() - 1);
                        }
                        numCardsTake = 1;
                    }

                    /*
                     * if the player matches his card then
                     * he removes the matched card from his
                     * hand and place it to the discard pile.
                     */
                    players.get(playerTurn).removeCard(currentPlayerCard);
                    discardPile.add(currentPlayerCard);
                    matched = true;
                    matchedNumber = currentPlayerCard.getNumber();
                    break;
                }
            }

            /*
             * if not matched then the player have to take a card from
             * the draw pile and keep it with him.
             */

            if (matched == false) {
                System.out.println("No cards match for player " + players.get(playerTurn).getPlayerId() + " Taking "
                        + numCardsTake + " Card(s)");
                /*
                 * number of cards to be taken by the current player
                 * from the draw pile, depending upon the previous player's
                 * turn.
                 */
                while (numCardsTake-- > 0) {
                    System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card");
                    players.get(playerTurn).addCard(drawPile.get(drawPile.size() - 1));
                    drawPile.remove(drawPile.size() - 1);
                }
                numCardsTake = 1;
            }

            /*
             * if player has matched and is left with no cards
             * then, he has won the match. "Hurray!"
             */
            if (matched == true && players.get(playerTurn).getHand().size() == 0) {

                System.out.println("Congratulations player " + players.get(playerTurn).getPlayerId() + " won the match !!!");

                System.exit(0);
            }

            /* Bonus Section */

            /*
             * if the player has played the ACE card (Action card)
             * then the next player's turn will be skipped.
             */

            if (matched == true && matchedNumber == 1) {
                playerTurn += direction;
            }
            /*
             * if the player has played the KING card (Action card)
             * then the direction of the flow of the game would be reversed.
             */
            if (matched == true && matchedNumber == 13) {
                direction *= -1;
            }

            /*
             * if the player has played the JACK card (Action card)
             * then the next player have to take 4 cards from the
             * draw pile.
             */

            if (matched == true && matchedNumber == 11) {
                numCardsTake = 4;
            }
            /*
             * if the player has played the QUEEN card (Action card)
             * then the next player have to take 2 cards from the
             * draw pile.
             */
            if (matched == true && matchedNumber == 12) {
                numCardsTake = 2;
            }
            // to determine the next player whose gonna play.
            playerTurn += direction;

            System.out.println("=========================================");
        }
    }
}