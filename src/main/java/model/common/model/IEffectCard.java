package model.common.model;

import model.gamesession.GameContext;

public interface IEffectCard extends ICard {
    // Kích hoạt hiệu ứng
    void activateEffect(ITarget target);

    boolean canActivate(GameContext context);

}
