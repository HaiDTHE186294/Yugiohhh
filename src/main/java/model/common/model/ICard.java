package model.common.model;

import model.common.constaint.CardType;

import java.awt.*;

public interface ICard {
    String getName();
    CardType getType(); // MONSTER, SPELL, TRAP

    Image getImage(boolean faceUp);

    void setFaceUp(boolean faceUp);
    boolean isFaceUp();
}
