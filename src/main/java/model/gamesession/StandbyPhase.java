package model.gamesession;

import model.common.constaint.PhaseType;
import model.common.model.*;

public class StandbyPhase implements IPhase {
    @Override
    public PhaseType getPhaseType() { return PhaseType.STANDBY; }

    @Override
    public void onEnter(IGameSession session) {
        // Có thể xử lý hiệu ứng kéo dài, hiệu ứng kích hoạt đầu lượt ở đây
        // Ví dụ: session.getCurrentPlayer().triggerContinuousEffects();
    }

    @Override
    public void onAction(IAction action, IGameSession session) {
        if (action instanceof CardAction) {
            CardAction cardAction = (CardAction) action;
                IPlayer player = session.getCurrentPlayer();
                ICard card = cardAction.getCard();
                if (player.getHand().getCards().contains(card)
                        && card.getType() == model.common.constaint.CardType.SPELL) {
                    player.getHand().removeCard(card);
                    System.out.println("Active Spell Card: " + card.getName());
                }
            }
        }


    @Override
    public void onExit(IGameSession session) { }
}