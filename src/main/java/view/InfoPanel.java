package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel {
    private JLabel phaseLabel = new JLabel();
    private JLabel playerLabel = new JLabel();
    private JLabel lifeLabel = new JLabel();
    private JButton endTurnButton = new JButton("Kết thúc lượt");

    public InfoPanel() {
        setLayout(new FlowLayout());
        add(phaseLabel);
        add(playerLabel);
        add(lifeLabel);
        add(endTurnButton);
    }

    public void setPhase(String phase) {
        phaseLabel.setText("Phase: " + phase);
    }

    public void setPlayer(String player) {
        playerLabel.setText("Player: " + player);
    }

    public void setLife(int life) {
        lifeLabel.setText("Life: " + life);
    }

    public void addEndTurnListener(ActionListener listener) {
        endTurnButton.addActionListener(listener);
    }

}