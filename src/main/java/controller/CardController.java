package controller;

import model.card.SpellCard;
import model.common.DTO.AttackResult;
import model.common.DTO.CardDetail;
import model.common.model.ICard;
import model.common.model.IMonsterCard;
import model.common.model.ITarget;

public class CardController implements ICardController {

    @Override
    public void onActivateEffect(SpellCard card, ITarget target) {
             card.activateEffect(target);
    }

    @Override
    public AttackResult onAttack(IMonsterCard attacker, IMonsterCard defender) {
             attacker.attack(defender);
        return null;
    }

    @Override
    public void onFlipCard(ICard card) {
        card.setFaceUp(!card.isFaceUp());
    }

    @Override
    public CardDetail getCardDetail(ICard card) {
        return card.getCardDetail();
    }
}