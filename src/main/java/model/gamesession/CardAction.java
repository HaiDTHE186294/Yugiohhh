package model.gamesession;

import model.common.model.IAction;
import model.common.model.ICard;
import model.common.constaint.ActionType;

public class CardAction implements IAction {
    private int playerId;
    private ICard card;
    private int x, y;
    public CardAction(int playerId, ICard card, int x, int y) {
        this.playerId = playerId;
        this.card = card;
        this.x = x;
        this.y = y;
    }
    public int getPlayerId() { return playerId; }
    public ICard getCard() { return card; }
    public int getX() { return x; }
    public int getY() { return y; }
    @Override
    public ActionType getType() {
        return ActionType.SUMMON;
        //Thực ra là SUMMON với kích hoạt Spell, vì đang giống nhau, Tấn công thì cần Action khác
    }
    @Override
    public Object getData() {
        return this;
    }
}