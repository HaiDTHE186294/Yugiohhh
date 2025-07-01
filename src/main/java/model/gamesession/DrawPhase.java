package model.gamesession;

import model.common.constaint.ActionType;
import model.common.constaint.PhaseType;
import model.common.model.IAction;
import model.common.model.IGameSession;
import model.common.model.IPhase;

public class DrawPhase implements IPhase {
    @Override
    public PhaseType getPhaseType() { return PhaseType.DRAW; }

    @Override
    public void onEnter(IGameSession session) {
        session.getCurrentPlayer().drawCard();
        // Có thể notify listener hoặc cập nhật trạng thái
    }

    @Override
    public void onAction(IAction action, IGameSession session) {
        // Draw phase thường không có action đặc biệt
    }

    @Override
    public void onExit(IGameSession session) { }
}