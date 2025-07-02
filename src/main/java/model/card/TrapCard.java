package model.card;

import model.common.DTO.CardDetail;
import model.common.constaint.CardType;
import model.common.model.IEffectCard;
import model.common.model.ICard;
import model.common.model.ITarget;
import java.util.List;
import model.common.model.IEffect;
import model.gamesession.GameContext;

public class TrapCard implements IEffectCard {
    private String name;
    private boolean faceUp;
    private List<IEffect> effects;

    public TrapCard(String name, List<IEffect> effects) {
        this.name = name;
        this.effects = effects;
        this.faceUp = false;
    }

    public TrapCard(String name) {
        this.name = name;
    }

    @Override
    public void activateEffect(ITarget target) {
        for (IEffect effect : effects) {
            effect.apply(target);
        }
    }


    @Override
    public boolean canActivate(GameContext context) {
        return context != null && context.isBeingAttacked();
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