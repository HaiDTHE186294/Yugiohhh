package model.common.model;

import java.util.List;

public interface IHand {
    List<ICard> getCards();
    void addCard(ICard card);
    void removeCard(ICard card);
}
