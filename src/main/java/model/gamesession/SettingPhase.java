package model.gamesession;

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
        // Xử lý rút bài, đặt bài, úp bài theo action từ Controller
        // Controller sẽ validate hợp lệ rồi gọi model
    }

    @Override
    public void onExit(IGameSession session) { }
}