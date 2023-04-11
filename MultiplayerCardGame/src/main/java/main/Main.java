package main;

import java.util.Stack;
import entity.Card;

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
}
