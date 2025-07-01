package controller;

import model.card.SpellCard;
import model.common.DTO.AttackResult;
import model.common.DTO.CardDetail;
import model.common.model.ICard;
import model.common.model.IMonsterCard;
import model.common.model.ITarget;


public interface ICardController {

    void onActivateEffect(SpellCard card, ITarget target);


    AttackResult onAttack(IMonsterCard attacker, IMonsterCard defender);


    void onFlipCard(ICard card);

    CardDetail getCardDetail(ICard card);
}
