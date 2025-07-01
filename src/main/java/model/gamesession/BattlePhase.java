package model.gamesession;

import model.common.constaint.PhaseType;
import model.common.model.*;

public class BattlePhase implements IPhase {
    @Override
    public PhaseType getPhaseType() { return PhaseType.BATTLE; }

    @Override
    public void onEnter(IGameSession session) {
        // Có thể reset trạng thái tấn công của quái vật, chuẩn bị cho Player thao tác tấn công
    }

    @Override
    public void onAction(IAction action, IGameSession session) {
        // Xử lý tấn công, gọi controller xử lý tấn công giữa các quái vật
        // Ví dụ: nếu action là ATTACK, gọi CardController.onAttack(...)
    }

    @Override
    public void onExit(IGameSession session) { }
}