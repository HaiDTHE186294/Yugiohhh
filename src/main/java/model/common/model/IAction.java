package model.common.model;
import model.common.constaint.ActionType;

public interface IAction {
    // Thông tin thao tác (tùy phase, có thể là rút bài, đặt bài, tấn công, ...)
    ActionType getType();
    Object getData();
}
