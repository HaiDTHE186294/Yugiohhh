package model.card;

import model.common.model.ICard;
import model.common.model.IHand;

public class Hand implements IHand {
    private final java.util.List<ICard> cards;

    public Hand() {
        this.cards = new java.util.ArrayList<>();
    }

    @Override
    public java.util.List<ICard> getCards() {
        return new java.util.ArrayList<>(cards);
    }

    @Override
    public void addCard(ICard card) {
        if (card != null) {
            cards.add(card);
        }
    }

    @Override
    public void removeCard(ICard card) {
        cards.remove(card);
    }

}
