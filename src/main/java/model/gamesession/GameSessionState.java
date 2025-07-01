package model.gamesession;
import model.player.PlayerState;
import model.board.BoardState;
import model.common.model.IPhase;

public class GameSessionState {
    private final PlayerState player1State;
    private final PlayerState player2State;
    private final BoardState boardState;
    private final IPhase currentPhase;
    private final int currentPlayerIndex; // 0 hoặc 1

    public GameSessionState(PlayerState player1State,
                            PlayerState player2State,
                            BoardState boardState,
                            IPhase currentPhase,
                            int currentPlayerIndex) {
        this.player1State = player1State;
        this.player2State = player2State;
        this.boardState = boardState;
        this.currentPhase = currentPhase;
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public PlayerState getPlayer1State() {
        return player1State;
    }

    public PlayerState getPlayer2State() {
        return player2State;
    }

    public BoardState getBoardState() {
        return boardState;
    }

    public IPhase getCurrentPhase() {
        return currentPhase;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
}