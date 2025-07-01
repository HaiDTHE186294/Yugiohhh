package model.common.model;

public interface IPlayer {
    int getLifePoint();
    void setLifePoint(int life);

    IDeck getDeck();
    IHand getHand();
    IGrave getGrave();

    // Thực hiện thao tác rút bài
    ICard drawCard();

    // Triệu hồi quái vật
    boolean summonMonster(ICard card, int x, int y, boolean faceUp);

    // Kích hoạt bài phép, bẫy
    boolean activateCard(ICard card, Object... params);

    // Được gọi khi cần thực hiện thao tác ở một phase nào đó
    void onPhaseAction(IPhase phase, IAction action);
}
