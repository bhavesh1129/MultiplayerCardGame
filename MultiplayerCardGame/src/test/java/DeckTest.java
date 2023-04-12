import org.example.entity.Card;
import org.example.entity.Deck;
import org.example.entity.Suits;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {
    @Test
    public void checkShuffling() {
        // Create an ArrayList of Cards to store an unshuffled deck
        ArrayList<Card> unShuffledDeck = new ArrayList<>();

        // Populate the unshuffled deck with all the cards of each suit
        for (Suits suit : Suits.values()) {
            for (int rank = 1; rank <= 13; rank++) {
                unShuffledDeck.add(new Card(rank, suit));
            }
        }

        // Create a new deck
        Deck deck = new Deck();
        // Get the shuffled deck
        ArrayList<Card> shuffledDeck = deck.getDeck();
        // Check if the new deck created is shuffled or not by comparing the string
        // representation of the decks
        Assert.assertEquals(false, unShuffledDeck.toString().equals(shuffledDeck.toString()));
    }

}
