package model.common.model;

public interface IEffect {
    void apply(ITarget target); // hiệu ứng ngay lập tức
    default boolean isContinuous() { return false; } // Hiệu ứng tức thời hay kéo dài
    default void onTurnStart(IGameSession session) {} // Gọi vào đầu mỗi lượt
    default void onTurnEnd(IGameSession session) {}   // Gọi vào cuối mỗi lượt
    default boolean isExpired() { return false; }     // Kiểm tra đã hết hiệu lực chưa
}