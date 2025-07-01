package model.card;

import model.common.model.ICard;
import model.common.model.IGrave;

import java.io.Serializable;

public class Grave implements IGrave {
    private static final long serialVersionUID = 1L;

    private final java.util.List<ICard> cards;

    public Grave() {
        this.cards = new java.util.ArrayList<>();
    }

    @Override
    public void addCard(ICard card) {
        cards.add(card);
    }

    @Override
    public ICard getLastCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(cards.size() - 1);
    }

    @Override
    public java.util.List<ICard> getCards() {
        return new java.util.ArrayList<>(cards);
    }
}
