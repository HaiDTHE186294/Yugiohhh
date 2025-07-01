package controller;

import listener.IPlayerStateListener;
import model.common.model.IAction;
import model.common.model.IPhase;
import model.player.PlayerState;

public interface IPlayerController {
    // Khi người chơi thực hiện thao tác trong phase hiện tại
    void onPlayerAction(IAction action);

    // Lấy trạng thái của player (life point, hand, deck,...)
    PlayerState getPlayerState();

    // Xử lý khi cần cập nhật trạng thái (ví dụ phase mới, đổi lượt,...)
    void onPhaseChanged(IPhase newPhase);

    // Đăng ký listener để nhận sự kiện thay đổi
    void setPlayerStateListener(IPlayerStateListener listener);
}
