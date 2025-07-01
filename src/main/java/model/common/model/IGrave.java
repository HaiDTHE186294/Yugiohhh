package model.common.model;

import java.util.List;

public interface IGrave {
    void addCard(ICard card);
    ICard getLastCard();
    List<ICard> getCards();
}
