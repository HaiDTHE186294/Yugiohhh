package model.gamesession;

import model.common.constaint.PhaseType;
import model.common.model.*;
import model.gamesession.SummonAction;

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
        if (action instanceof SummonAction) {
            SummonAction summon = (SummonAction) action;
            int playerId = summon.getPlayerId();
            int x = summon.getX();
            int y = summon.getY();

            // Kiểm tra vùng hợp lệ cho từng player
            boolean valid = false;
            if (playerId == 0) { // Player 1 chỉ hàng 2,3
                valid = (y == 2 || y == 3);
            } else if (playerId == 1) { // Player 2 chỉ hàng 0,1
                valid = (y == 0 || y == 1);
            }
            if (!valid) return; // Không hợp lệ thì bỏ qua

            // Kiểm tra loại bài và hàng
            model.common.model.ICard card = summon.getCard();
            model.common.constaint.CardType type = card.getType();
            if (type == model.common.constaint.CardType.SPELL && !(y == 1 || y == 2)) return;
            if (type == model.common.constaint.CardType.MONSTER && !(y == 0 || y == 3)) return;

            IPlayer player = session.getCurrentPlayer();
            if (player.getHand().getCards().contains(card)) {
                boolean ok = player.summonMonster(card, x, y, true);
                if (ok && session instanceof model.gamesession.GameSession) {
                    model.gamesession.GameSession gs = (model.gamesession.GameSession) session;
                    gs.getBoard().placeCard(playerId, x, y, card, true);
                }
            }
        }
    }

    @Override
    public void onExit(IGameSession session) { }
}