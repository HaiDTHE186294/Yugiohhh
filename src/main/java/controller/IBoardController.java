package controller;

import listener.IBoardStateListener;
import model.board.BoardState;
import model.common.constaint.ActionType;

public interface IBoardController {
    // Xử lý thao tác lên 1 ô trên sân (ví dụ: click đặt bài, chọn bài, tấn công,...)
    void onCellAction(int playerId, int x, int y, ActionType actionType);

    // Xử lý khi bộ bài của người chơi bị click
    void onDeckClick(int playerId);

    // Xử lý khi mộ bài bị thao tác (ví dụ xem lại bài bị loại bỏ)
    void onGraveClick(int playerId);

    // Lấy trạng thái hiện tại của board để cập nhật view
    BoardState getCurrentState();

    // Đăng ký listener để nhận sự kiện thay đổi từ model
    void setBoardStateListener(IBoardStateListener listener);
}
