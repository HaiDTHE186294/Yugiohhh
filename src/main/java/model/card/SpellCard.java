package model.card;

import model.common.DTO.CardDetail;
import model.common.constaint.CardType;
import model.common.model.IEffectCard;
import model.common.model.ICard;
import model.common.model.ITarget;

public class SpellCard implements IEffectCard {
    private String name;
    private boolean faceUp;

    public SpellCard(String name) {
        this.name = name;
    }

    @Override
    public void activateEffect(ITarget target) {
        // TODO: Gọi effect cụ thể, ví dụ: target.applyEffect(...)
    }

    @Override
    public String getName() { return name; }

    @Override
    public CardType getType() { return CardType.SPELL; }

    @Override
    public java.awt.Image getImage(boolean faceUp) { return null; }

    @Override
    public void setFaceUp(boolean faceUp) { this.faceUp = faceUp; }

    @Override
    public boolean isFaceUp() { return faceUp; }

    @Override
    public CardDetail getCardDetail() {
        // Điền các trường phù hợp cho SpellCard
        return new CardDetail(
                name,
                CardType.SPELL,
                "Spell card", // hoặc mô tả chi tiết hơn nếu có
                0, // atk
                0, // def
                0, // star
                null, // monsterType
                faceUp
        );
    }
}