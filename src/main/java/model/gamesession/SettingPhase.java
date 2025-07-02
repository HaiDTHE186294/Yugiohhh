package model.gamesession;

import model.common.constaint.CardType;
import model.common.constaint.PhaseType;
import model.common.model.*;

public class SettingPhase implements IPhase {
    @Override
    public PhaseType getPhaseType() { return PhaseType.SETTING; }

    @Override
    public void onEnter(IGameSession session) {
        // Cho phép người chơi đặt bài, úp/xuống bài, v.v.
        // Có thể gửi thông báo cho Controller/View để user thao tác
    }

    @Override
    public void onAction(IAction action, IGameSession session) {
        if (action instanceof CardAction) {
            CardAction summon = (CardAction) action;
            int playerId = summon.getPlayerId();
            int x = summon.getX();
            int y = summon.getY();
            System.out.println("SummonAction: playerId=" + playerId + ", card=" + summon.getCard().getName() + ", x=" + x + ", y=" + y);

            // Kiểm tra vùng hợp lệ cho từng player
            boolean valid = false;
            if (playerId == 0) { // Player 1 chỉ hàng 2,3
                valid = (y == 2 || y == 3);
            } else if (playerId == 1) { // Player 2 chỉ hàng 0,1
                valid = (y == 0 || y == 1);
            }
            if (!valid) return; // Không hợp lệ thì bỏ qua

            // Kiểm tra loại bài và hàng
            ICard card = summon.getCard();
            CardType type = card.getType();
            if (type == model.common.constaint.CardType.SPELL && !(y == 1 || y == 2)) return;
            if (type == model.common.constaint.CardType.MONSTER && !(y == 0 || y == 3)) return;

            IPlayer player = session.getCurrentPlayer();
            if (player.getHand().getCards().contains(card)) {
                boolean ok = player.summonMonster(card, x, y, true);
                if (ok && session instanceof GameSession gs) {
                    gs.getBoard().placeCard(playerId, x, y, card, true);
                    System.out.println("valid=" + valid);
                }
            }
        }
    }

    @Override
    public void onExit(IGameSession session) { }
}