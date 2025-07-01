package model.board;

import model.common.model.ICard;
import java.util.List;

public class BoardState {
    private final CellState[][] playground;

    public BoardState(CellState[][] playground) {
        // Deep copy để tránh bị sửa ngoài ý muốn
        int w = playground.length;
        int h = playground[0].length;
        this.playground = new CellState[w][h];
        for (int i = 0; i < w; ++i)
            for (int j = 0; j < h; ++j)
                this.playground[i][j] = new CellState(playground[i][j].getCard(), playground[i][j].isFaceUp());
    }

    public CellState[][] getPlayground() {
        return playground;
    }

    // Có thể mở rộng thêm các trạng thái khác nếu cần
}