package model.common.model;

import listener.IBoardListener;
import model.board.CellState;
import model.board.BoardState;

public interface IBoard {
    // Lấy trạng thái tổng thể của sân (ma trận các ô)
    CellState[][] getPlaygroundState();

    // Lấy trạng thái bộ bài của player (còn bài hay không)
    boolean hasDeck(int playerId);

    // Lấy lá bài cuối cùng ở mộ bài của player
    ICard getLastGraveCard(int playerId);

    // Đặt một quân bài lên sân
    boolean placeCard(int playerId, int x, int y, ICard card, boolean faceUp);

    // Lấy quân bài ở vị trí sân
    ICard getCardAt(int x, int y);


    boolean moveToGrave(int playerId, int x, int y);

    // Lắng nghe sự kiện thao tác từ View/UI
    void setBoardListener(IBoardListener listener);

    BoardState getState();
}
