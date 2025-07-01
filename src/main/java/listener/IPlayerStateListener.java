package listener;

import model.player.PlayerState;

public interface IPlayerStateListener {
    void onPlayerStateChanged(PlayerState newState);
}
