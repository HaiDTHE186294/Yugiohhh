package model.gamesession;


import model.common.model.IGameSession;
import model.common.model.IPlayer;
import model.common.model.IBoard;
import model.common.model.IPhase;

public class GameContext {
    private IGameSession session;
    private IPlayer currentPlayer;
    private IPlayer opponentPlayer;
    private IBoard board;
    private IPhase currentPhase;
    private boolean beingAttacked;

    // Constructor
    public GameContext(IGameSession session, boolean beingAttacked) {
        this.session = session;
        this.currentPlayer = session.getCurrentPlayer();
        this.opponentPlayer = session.getOpponentPlayer();
        this.board = session instanceof GameSession ? ((GameSession)session).getBoard() : null;
        this.currentPhase = session.getCurrentPhase();
        this.beingAttacked = beingAttacked;
    }

    // Getter
    public IGameSession getSession() { return session; }
    public IPlayer getCurrentPlayer() { return currentPlayer; }
    public IPlayer getOpponentPlayer() { return opponentPlayer; }
    public IBoard getBoard() { return board; }
    public IPhase getCurrentPhase() { return currentPhase; }
    public boolean isBeingAttacked() { return beingAttacked; }
}