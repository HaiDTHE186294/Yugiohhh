package model.common.model;

public interface IDeck {
    int getCardCount();
    ICard draw();
    void shuffle();
}
