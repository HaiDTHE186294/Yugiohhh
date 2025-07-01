package model.player;

import model.common.model.ICard;
import java.util.List;

public class PlayerState {
    private final int lifePoint;
    private final List<ICard> handCards;
    private final int deckCount;
    private final List<ICard> graveCards;

    public PlayerState(int lifePoint, List<ICard> handCards, int deckCount, List<ICard> graveCards) {
        this.lifePoint = lifePoint;
        this.handCards = handCards;
        this.deckCount = deckCount;
        this.graveCards = graveCards;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public List<ICard> getHandCards() {
        return handCards;
    }

    public int getDeckCount() {
        return deckCount;
    }

    public List<ICard> getGraveCards() {
        return graveCards;
    }
}