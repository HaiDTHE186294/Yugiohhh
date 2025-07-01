package model.common.model;
import model.common.constaint.PhaseType;

public interface IPhase {
        PhaseType getPhaseType(); // DRAW, STANDBY, SETTING, BATTLE, END
        void onEnter(IGameSession session);
        void onAction(IAction action, IGameSession session);
        void onExit(IGameSession session);
    }

