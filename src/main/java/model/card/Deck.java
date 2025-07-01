// model/card/Deck.java
package model.card;

import model.common.model.IDeck;
import model.common.model.ICard;
import java.util.*;

public class Deck implements IDeck {
    private List<ICard> cards = new ArrayList<>();

    public Deck(List<ICard> cards) {
        this.cards.addAll(cards);
        shuffle();
    }

    @Override
    public int getCardCount() { return cards.size(); }

    @Override
    public ICard draw() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }

    @Override
    public void shuffle() { Collections.shuffle(cards); }
}