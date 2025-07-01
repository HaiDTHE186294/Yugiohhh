package controller;

import listener.IPlayerStateListener;
import model.common.model.IAction;
import model.common.model.IPhase;
import model.common.model.IPlayer;
import model.player.PlayerState;

public class PlayerController implements IPlayerController {
    private final IPlayer player;
    private IPlayerStateListener listener;

    public PlayerController(IPlayer player) {
        this.player = player;
    }

    @Override
    public void onPlayerAction(IAction action) {
        // TODO: Xử lý action của người chơi (rút, đặt, kích hoạt effect,...)
        // player.performAction(action);
        notifyPlayerStateChanged();
    }

    @Override
    public PlayerState getPlayerState() {
        return new PlayerState(
                player.getLifePoint(),
                player.getHand().getCards(),
                player.getDeck().getCardCount(),
                player.getGrave().getCards()
                // ... các trường khác nếu có
        );
    }

    @Override
    public void onPhaseChanged(IPhase newPhase) {
        // TODO: Cập nhật trạng thái khi phase mới, reset hành động nếu cần
        notifyPlayerStateChanged();
    }

    @Override
    public void setPlayerStateListener(IPlayerStateListener listener) {
        this.listener = listener;
    }

    private void notifyPlayerStateChanged() {
        if (listener != null) {
            listener.onPlayerStateChanged(getPlayerState());
        }
    }
}