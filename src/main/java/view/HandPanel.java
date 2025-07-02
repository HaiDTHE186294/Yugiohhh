package view;

import model.player.PlayerState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class HandPanel extends JPanel {
    private List<JButton> cardButtons = new ArrayList<>();
    private HandCardListener cardListener;

    public HandPanel() {
        super(new FlowLayout());
    }

    public void setHandState(PlayerState state) {
        removeAll();
        cardButtons.clear();
        for (int i = 0; i < state.getHandCards().size(); i++) {
            JButton btn = new JButton(state.getHandCards().get(i).getName());
            cardButtons.add(btn);
            add(btn);
        }
        // Gán lại listener cho các nút mới
        if (cardListener != null) {
            for (int i = 0; i < cardButtons.size(); ++i) {
                final int idx = i;
                cardButtons.get(i).addActionListener(e -> cardListener.onCardClicked(idx));
            }
        }
        revalidate();
        repaint();
    }

    public void addCardListener(HandCardListener listener) {
        this.cardListener = listener;
        for (int i = 0; i < cardButtons.size(); ++i) {
            final int idx = i;
            cardButtons.get(i).addActionListener(e -> cardListener.onCardClicked(idx));
        }
    }

    public interface HandCardListener {
        void onCardClicked(int idx);
    }
}
