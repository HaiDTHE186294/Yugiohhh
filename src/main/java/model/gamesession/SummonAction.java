package model.gamesession;

import model.common.model.IAction;
import model.common.model.ICard;

public class SummonAction implements IAction {
    private int playerId;
    private ICard card;
    private int x, y;
    public SummonAction(int playerId, ICard card, int x, int y) {
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
    public model.common.constaint.ActionType getType() {
        return model.common.constaint.ActionType.SUMMON;
    }
    @Override
    public Object getData() {
        return this;
    }
}