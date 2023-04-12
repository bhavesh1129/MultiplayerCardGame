import org.example.entity.Player;
import org.example.entity.Suits;
import org.example.entity.Card;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    /*
     * This test checks if a card can be added to a player's hand.
     * It creates a card with rank 1 and suit CLUBS and adds it to the player's
     * hand.
     * Then, it checks if the size of the player's hand is 1.
     */
    @Test
    public void testAddingCardToPlayerHand() {

        // Create a new card with rank 1 and suit CLUBS
        Card card = new Card(1, Suits.CLUBS);

        // Create a new player with an empty hand
        Player player = new Player(0);

        // Add the card to the player's hand
        player.addCard(card);

        // Get the size of the player's hand
        int handSize = player.getHand().size();

        // Check if the size of the player's hand is 1
        Assert.assertEquals(1, handSize);
    }

    /*
     * This test checks if a card can be removed from a player's hand.
     * It creates a card with rank 1 and suit CLUBS and adds it to the player's
     * hand.
     * Then, it removes the card from the player's hand and checks if the size of
     * the player's hand is 0.
     */
    @Test
    public void testRemovingCardFromPlayerHand() {

        // Create a new card with rank 1 and suit CLUBS
        Card card = new Card(1, Suits.CLUBS);

        // Create a new player with an empty hand
        Player player = new Player(0);

        // Add the card to the player's hand
        player.addCard(card);

        // Remove the card from the player's hand
        player.removeCard(card);

        // Get the size of the player's hand
        int handSize = player.getHand().size();

        // Check if the size of the player's hand is 0
        Assert.assertEquals(0, handSize);
    }
}