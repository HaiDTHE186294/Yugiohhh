package listener;

import model.common.constaint.ActionType;

// Lắng nghe các sự kiện trên bàn chơi (Board)
public interface IBoardListener {
    // Khi người chơi thao tác lên một ô trên sân (bàn)
    void onCellAction(int playerId, int x, int y, ActionType actionType);

    // Khi trạng thái board thay đổi (ví dụ: có bài mới được đặt, bài bị hủy, ...)
    void onBoardChanged();
}