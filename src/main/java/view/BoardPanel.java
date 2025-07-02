package view;

import model.board.BoardState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {
    private int width, height;
    private List<JButton> cellButtons = new ArrayList<>();

    public BoardPanel(int width, int height) {
        super(new GridLayout(height, width));
        this.width = width;
        this.height = height;
        for (int i = 0; i < width * height; i++) {
            JButton btn = new JButton();
            cellButtons.add(btn);
            this.add(btn);
        }
    }

    public void setState(BoardState state) {
        // render board theo state
        for (int y = 0; y < height; ++y)
            for (int x = 0; x < width; ++x) {
                int idx = y * width + x;
                JButton btn = cellButtons.get(idx);
                var card = state.getPlayground()[x][y].getCard();
                btn.setText(card != null ? card.getName() : "");
            }
    }

    public void addCellListener(BoardCellListener listener) {
        for (int i = 0; i < cellButtons.size(); ++i) {
            final int idx = i;
            cellButtons.get(i).addActionListener(e -> {
                int x = idx % width;
                int y = idx / width;
                listener.onCellClicked(x, y);
            });
        }
    }

    public interface BoardCellListener {
        void onCellClicked(int x, int y);
    }
}