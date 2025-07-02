package model.common.model;
import model.common.constaint.ActionType;

public interface IAction {
    // DTO
    ActionType getType();
    Object getData();
}
