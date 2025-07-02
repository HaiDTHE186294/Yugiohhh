package view;

import javax.swing.*;
import java.awt.*;

public class GraveView extends JPanel {
    private JLabel graveLabel = new JLabel();
    public GraveView() {
        setPreferredSize(new Dimension(120, 100));
        setBackground(Color.PINK);
        graveLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(graveLabel);
        setGraveState(null);
    }
    public void setGraveState(String lastCardName) {
        graveLabel.setText("Grave: " + (lastCardName != null ? lastCardName : "Empty"));
    }
}