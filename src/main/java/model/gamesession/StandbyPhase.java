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
        // Thường không có action đặc biệt ở Standby Phase
    }

    @Override
    public void onExit(IGameSession session) { }
}