package controller;

import listener.IBoardStateListener;
import model.board.BoardState;

import model.common.constaint.ActionType;
import model.common.model.IBoard;

public class BoardController implements IBoardController {
    private final IBoard board;
    private IBoardStateListener listener;

    public BoardController(IBoard board) {
        this.board = board;
    }

    @Override
    public void onCellAction(int playerId, int x, int y, ActionType actionType) {
        // Xử lý actionType: đặt bài, tấn công, lật bài, v.v.
        // Sau khi xử lý, gọi notifyBoardStateChanged()
    }

    @Override
    public void onDeckClick(int playerId) {
        // Xử lý rút bài cho playerId
        // notifyBoardStateChanged();
    }

    @Override
    public void onGraveClick(int playerId) {
        // Xử lý tương tác mộ bài (có thể show lên view)
    }

    @Override
    public BoardState getCurrentState() {
        return new BoardState(board.getPlaygroundState());
    }

    @Override
    public void setBoardStateListener(IBoardStateListener listener) {
        this.listener = listener;
    }

    private void notifyBoardStateChanged() {
        if (listener != null) {
            listener.onBoardStateChanged(getCurrentState());
        }
    }
}