package listener;

import model.board.BoardState;

public interface IBoardStateListener {
    void onBoardStateChanged(BoardState newState);
}
