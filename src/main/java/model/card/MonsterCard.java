package model.card;

import model.common.constaint.CardType;
import model.common.model.IMonsterCard;
import model.common.model.ICard;
import model.common.DTO.AttackResult;
import model.common.DTO.CardDetail;
import model.common.constaint.MonsterType;

public class MonsterCard implements IMonsterCard {
    private String name;
    private int atk;
    private int def;
    private int star;
    private MonsterType type;
    private boolean faceUp;

    public MonsterCard(String name, int atk, int def, int star, MonsterType type) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.star = star;
        this.type = type;
        this.faceUp = false;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getAtk() { return atk; }

    @Override
    public int getDef() { return def; }

    @Override
    public int getStar() { return star; }

    @Override
    public MonsterType getMonsterType() { return type; }

    @Override
    public AttackResult attack(IMonsterCard defender) {
        int damage = this.atk - defender.getDef();
        boolean attackerDestroyed = false;
        boolean defenderDestroyed = false;

        if (damage > 0) {
            defenderDestroyed = true;
        } else if (damage < 0) {
            attackerDestroyed = true;
        }

        return new AttackResult(attackerDestroyed, defenderDestroyed, Math.abs(damage));
    }

    @Override
    public boolean canBeSummoned(int sacrifices) {
        if (star <= 4) return true;
        if (star <= 6 && sacrifices >= 1) return true;
        if (star > 6 && sacrifices >= 2) return true;
        return false;
    }

    @Override
    public CardType getType() { return CardType.MONSTER; }

    @Override
    public java.awt.Image getImage(boolean faceUp) {
        // TODO: Trả về ảnh minh họa cho card, có thể trả null nếu chưa làm UI
        return null;
    }

    @Override
    public void setFaceUp(boolean faceUp) { this.faceUp = faceUp; }

    @Override
    public boolean isFaceUp() { return faceUp; }

    @Override
    public CardDetail getCardDetail() {
        return new CardDetail(
                name,
                CardType.MONSTER,
                "", // description nếu có, hoặc truyền vào constructor MonsterCard
                atk,
                def,
                star,
                type,
                faceUp
        );
    }
}