import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	private List<Card> cards;
	private Random rand = new Random();

	public Deck() {
		String[] SUITS = {
			"C", "D", "H", "S"
		};

		String[] RANKS = {
			"2", "3", "4", "5", "6", "7", "8", "9", "10",
			"J", "Q", "K", "A"
		};

		// initialize deck
		int n = SUITS.length * RANKS.length;

		this.cards = new ArrayList<Card>();

		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				Card newCard = new Card(SUITS[j], RANKS[i]);
				this.cards.add(newCard);
			}
		}
	}

	public void shuffle() {
		// TODO: Implement simpler shuffling algorithm.
		Collections.shuffle(this.cards);
	}

	public boolean isEmpty() {
		return this.cards.size() == 0;
	}

	public Card draw() {
		int r = this.rand.nextInt(this.cards.size());
		return this.cards.remove(r);
	}

	public ArrayList<Card> deal(int nCards) {
		ArrayList<Card> dealtCards = new ArrayList<Card>();
		for (int i = 0; i < nCards; i++) {
			int r = this.rand.nextInt(this.cards.size());
			dealtCards.add(this.cards.remove(r));
		}
		assert dealtCards.size() == nCards;
		return dealtCards;

	}
}