package model.session;

import listener.IGameSessionListener;
import model.common.model.*;
import model.gamesession.*;

public class GameSession implements IGameSession {
    private IPlayer[] players;
    private int currentPlayerIdx;
    private IPhase currentPhase;
    private IGameSessionListener listener;

    public GameSession(IPlayer p1, IPlayer p2) {
        this.players = new IPlayer[] {p1, p2};
        this.currentPlayerIdx = 0;
        this.currentPhase = new DrawPhase();
    }

    @Override
    public IPlayer getCurrentPlayer() { return players[currentPlayerIdx]; }

    @Override
    public IPlayer getOpponentPlayer() { return players[1 - currentPlayerIdx]; }

    @Override
    public void nextPhase() {
        currentPhase.onExit(this);
        // Chuyển phase tiếp theo (ví dụ: DRAW -> STANDBY -> ...), code mẫu
        switch (currentPhase.getPhaseType()) {
            case DRAW: currentPhase = new StandbyPhase(); break;
            case STANDBY: currentPhase = new SettingPhase(); break;
            case SETTING: currentPhase = new BattlePhase(); break;
            case BATTLE: currentPhase = new EndPhase(); break;
            case END:
                // Đổi lượt
                currentPlayerIdx = 1 - currentPlayerIdx;
                currentPhase = new DrawPhase();
                break;
        }
        currentPhase.onEnter(this);
        if (listener != null) listener.onPhaseChanged(currentPhase);
    }

    @Override
    public IPhase getCurrentPhase() { return currentPhase; }

    @Override
    public void handleAction(IAction action) {
        currentPhase.onAction(action, this);
    }

    @Override
    public void start() {
        currentPhase.onEnter(this);
    }

    @Override
    public void setGameSessionListener(IGameSessionListener listener) {
        this.listener = listener;
    }
}