package controller.card;

import model.common.DTO.AttackResult;
import model.common.DTO.CardDetail;
import model.common.model.ICard;
import model.card.IMonsterCard;
import model.common.model.ITarget;


public interface ICardController {

    void onActivateEffect(ICard card, ITarget target);


    AttackResult onAttack(IMonsterCard attacker, IMonsterCard defender);


    void onFlipCard(ICard card);

    CardDetail getCardDetail(ICard card);
}
