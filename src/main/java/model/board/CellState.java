package model.board;

import model.common.model.ICard;

public class CellState {
    private ICard card;
    private boolean faceUp;

    public CellState() {
        this.card = null;
        this.faceUp = false;
    }

    // Constructor dùng cho deep copy
    public CellState(ICard card, boolean faceUp) {
        this.card = card;
        this.faceUp = faceUp;
    }

    public ICard getCard() { return card; }
    public void setCard(ICard card) { this.card = card; }
    public boolean isFaceUp() { return faceUp; }
    public void setFaceUp(boolean faceUp) { this.faceUp = faceUp; }
}