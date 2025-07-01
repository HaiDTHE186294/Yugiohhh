package model.card;
import model.common.model.ICard;
import model.common.model.ITarget;

public interface IEffectCard extends ICard {
    // Kích hoạt hiệu ứng
    void activateEffect(ITarget target);
}
