package model.common.DTO;

public class AttackResult {
    private boolean attackerDestroyed;
    private boolean defenderDestroyed;
    private int lifePointChangeAttacker;
    private int lifePointChangeDefender;
    private String message; // Mô tả kết quả (vd: "Attacker wins", "Both destroyed", ...)

    public AttackResult(boolean attackerDestroyed, boolean defenderDestroyed, int abs) {
    }

}