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
        notifyPlayerStateChanged();
    }

    @Override
    public PlayerState getPlayerState() {
        return new PlayerState(
                player.getLifePoint(),
                player.getHand().getCards(),
                player.getDeck().getCardCount(),
                player.getGrave().getCards()
        );
    }

    @Override
    public void onPhaseChanged(IPhase newPhase) {
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