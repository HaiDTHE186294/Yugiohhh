package model.gamesession;

import model.common.constaint.PhaseType;
import model.common.model.*;

public class EndPhase implements IPhase {
    @Override
    public PhaseType getPhaseType() { return PhaseType.END; }

    @Override
    public void onEnter(IGameSession session) {
        // Xử lý hiệu ứng kết thúc lượt, dọn dẹp trạng thái tạm, v.v.
    }

    @Override
    public void onAction(IAction action, IGameSession session) {
        // Thường không có action đặc biệt, hoặc chỉ END_TURN
    }

    @Override
    public void onExit(IGameSession session) { }
}