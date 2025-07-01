package model.common.model;
import model.common.DTO.AttackResult;
import model.common.constaint.MonsterType;

public interface IMonsterCard extends ICard {
    int getAtk();
    int getDef();
    int getStar();
    MonsterType getMonsterType();

    AttackResult attack(IMonsterCard defender);
    boolean canBeSummoned(int sacrifices);
}