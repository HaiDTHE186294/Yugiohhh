package model.gamesession;

import listener.IGameSessionListener;
import model.common.model.*;
import model.gamesession.*;
import model.player.PlayerState;
import model.board.BoardState;

public class GameSession implements IGameSession {
    private IPlayer[] players;
    private int currentPlayerIdx;
    private IPhase currentPhase;
    private IGameSessionListener listener;
    private model.common.model.IBoard board;

    public GameSession(IPlayer p1, IPlayer p2, model.common.model.IBoard board) {
        this.players = new IPlayer[] {p1, p2};
        this.currentPlayerIdx = 0;
        this.currentPhase = new DrawPhase();
        this.board = board;
    }

    @Override
    public IPlayer getCurrentPlayer() { return players[currentPlayerIdx]; }

    @Override
    public IPlayer getOpponentPlayer() { return players[1 - currentPlayerIdx]; }

    @Override
    public void nextPhase() {
        currentPhase.onExit(this);
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

    public GameSessionState getCurrentState() {
        PlayerState p1State = players[0] instanceof model.player.Player ? ((model.player.Player)players[0]).getState() : null;
        PlayerState p2State = players[1] instanceof model.player.Player ? ((model.player.Player)players[1]).getState() : null;
        BoardState boardState = board != null ? board.getState() : null;
        return new GameSessionState(p1State, p2State, boardState, currentPhase, currentPlayerIdx);
    }

    public IBoard getBoard() {
        return board;
    }
}