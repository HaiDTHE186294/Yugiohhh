package view;

import javax.swing.*;
import java.awt.*;

public class DeckView extends JPanel {
    private JLabel deckLabel = new JLabel();
    public DeckView() {
        setPreferredSize(new Dimension(120, 100));
        setBackground(Color.LIGHT_GRAY);
        deckLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(deckLabel);
        setDeckState(10);
    }
    public void setDeckState(int cardCount) {
        deckLabel.setText(cardCount > 0 ? "Deck: " + cardCount : "Deck: Empty");
    }
}