package model.common.model;


import model.common.constaint.TargetType;

public interface ITarget {
    // Mỗi loại target phải trả ra kiểu đối tượng đích (Player, Card, ...)
    TargetType getTargetType();

    // Có thể cung cấp method lấy đối tượng thực tế (nếu cần)
    Object getTargetObject();
}