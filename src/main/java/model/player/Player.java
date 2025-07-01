package model.player;

import model.card.Grave;
import model.card.Hand;
import model.common.model.*;

public class Player implements IPlayer {
    private String name;
    private int lifePoint;
    private IDeck deck;
    private IHand hand;
    private IGrave grave;

    // Constructor nhận deck
    public Player(IDeck deck) {
        this("Player", 8000, deck);
    }

    // Constructor đầy đủ
    public Player(String name, int lifePoint, IDeck deck) {
        this.name = name;
        this.lifePoint = lifePoint;
        this.deck = deck;
        this.hand = new Hand();
        this.grave = new Grave();
        // Draw 5 cards to start
        for (int i = 0; i < 5; i++) {
            ICard card = deck.draw();
            if (card != null) hand.addCard(card);
        }
    }

    // Constructor mẫu cho trường hợp chỉ có tên và điểm (deck để null)
    public Player(String name, int lifePoint) {
        this.name = name;
        this.lifePoint = lifePoint;
        this.deck = null; // hoặc new Deck(), nếu muốn tạo deck mặc định
        this.hand = new Hand();
        this.grave = new Grave();
        // Không rút bài nếu deck null
    }

    @Override
    public int getLifePoint() { return lifePoint; }
    @Override
    public void setLifePoint(int life) { this.lifePoint = life; }
    @Override
    public IDeck getDeck() { return deck; }
    @Override
    public IHand getHand() { return hand; }
    @Override
    public IGrave getGrave() { return grave; }

    @Override
    public ICard drawCard() {
        if (deck == null) return null;
        ICard card = deck.draw();
        if (card != null) hand.addCard(card);
        return card;
    }

    @Override
    public boolean summonMonster(ICard card, int x, int y, boolean faceUp) {
        if (hand.getCards().contains(card)) {
            hand.removeCard(card);
            // Board.placeCard(playerId, x, y, card, faceUp); // Controller sẽ gọi
            return true;
        }
        return false;
    }

    @Override
    public boolean activateCard(ICard card, Object... params) {
        if (card instanceof IEffectCard) {
            ((IEffectCard) card).activateEffect((ITarget) params[0]);
            return true;
        }
        return false;
    }

    @Override
    public void onPhaseAction(IPhase phase, IAction action) {
        // Tuỳ phase có thể xử lý khác nhau
    }

    // (Optional) Getter cho name
    public String getName() { return name; }

    public PlayerState getState() {
        return new PlayerState(
                lifePoint,
                hand.getCards(),
                deck != null ? deck.getCardCount() : 0,
                grave.getCards()
        );
    }
}