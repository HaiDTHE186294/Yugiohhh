package model.common.model;

import listener.IGameSessionListener;

public interface IGameSession {
    // Lấy player hiện tại
    IPlayer getCurrentPlayer();
    IPlayer getOpponentPlayer();

    // Chuyển phase
    void nextPhase();
    IPhase getCurrentPhase();

    // Xử lý thao tác từ UI (có thể chuyển về cho phase)
    void handleAction(IAction action);

    // Bắt đầu trận đấu
    void start();

    // Lắng nghe sự kiện thay đổi trạng thái (cho View)
    void setGameSessionListener(IGameSessionListener listener);

    // Lấy trạng thái tổng thể của session
    model.gamesession.GameSessionState getCurrentState();
}
