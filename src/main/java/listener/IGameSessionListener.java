package listener;
import model.common.model.IPhase;
import model.gamesession.GameSessionState;

public interface IGameSessionListener {
    void onSessionStateChanged(GameSessionState state);
    void onPhaseChanged(IPhase newPhase);
}
