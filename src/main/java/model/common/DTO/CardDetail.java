package model.common.DTO;

import model.common.constaint.CardType;
import model.common.constaint.MonsterType;

public class CardDetail {
    private String name;
    private CardType type;
    private String description;
    private int atk;
    private int def;
    private int star;
    private MonsterType monsterType;
    private boolean faceUp; // Nếu muốn truyền trạng thái úp/ngửa

    // Constructor đầy đủ
    public CardDetail(String name, CardType type, String description, int atk, int def, int star, MonsterType monsterType, boolean faceUp) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.atk = atk;
        this.def = def;
        this.star = star;
        this.monsterType = monsterType;
        this.faceUp = faceUp;
    }

    // Getter
    public String getName() { return name; }
    public CardType getType() { return type; }
    public String getDescription() { return description; }
    public int getAtk() { return atk; }
    public int getDef() { return def; }
    public int getStar() { return star; }
    public MonsterType getMonsterType() { return monsterType; }
    public boolean isFaceUp() { return faceUp; }

    // Setter (nếu cần)
    public void setName(String name) { this.name = name; }
    public void setType(CardType type) { this.type = type; }
    public void setDescription(String description) { this.description = description; }
    public void setAtk(int atk) { this.atk = atk; }
    public void setDef(int def) { this.def = def; }
    public void setStar(int star) { this.star = star; }
    public void setMonsterType(MonsterType monsterType) { this.monsterType = monsterType; }
    public void setFaceUp(boolean faceUp) { this.faceUp = faceUp; }
}