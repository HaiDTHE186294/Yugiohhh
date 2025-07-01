package view;

import controller.IBoardController;
import controller.IPlayerController;
import listener.IBoardStateListener;
import listener.IPlayerStateListener;
import model.board.BoardState;
import model.common.constaint.ActionType;
import model.player.PlayerState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main game window
public class GameMainFrame extends JFrame implements IBoardStateListener, IPlayerStateListener {
    private IBoardController boardController;
    private IPlayerController playerController;

    private JPanel boardPanel;
    private JPanel handPanel;
    private JButton deckButton;
    private JButton graveButton;
    private JLabel lifePointLabel;

    public GameMainFrame(IBoardController boardController, IPlayerController playerController) {
        this.boardController = boardController;
        this.playerController = playerController;

        setTitle("Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Board
        boardPanel = new JPanel(new GridLayout(3, 5)); // Ví dụ: 3 hàng x 5 cột
        for (int i = 0; i < 15; i++) {
            JButton cellBtn = new JButton();
            final int cellIdx = i;
            cellBtn.addActionListener(e -> onBoardCellClicked(cellIdx));
            boardPanel.add(cellBtn);
        }
        add(boardPanel, BorderLayout.CENTER);

        // Hand
        handPanel = new JPanel(new FlowLayout());
        add(handPanel, BorderLayout.SOUTH);

        // Deck & Grave
        JPanel deckGravePanel = new JPanel();
        deckButton = new JButton("Deck");
        deckButton.addActionListener(e -> boardController.onDeckClick(0)); // 0: playerId mẫu
        deckGravePanel.add(deckButton);

        graveButton = new JButton("Grave");
        graveButton.addActionListener(e -> boardController.onGraveClick(0));
        deckGravePanel.add(graveButton);

        lifePointLabel = new JLabel("Life: 8000");
        deckGravePanel.add(lifePointLabel);

        add(deckGravePanel, BorderLayout.NORTH);

        setSize(800, 600);
        setVisible(true);

        // Đăng ký listener
        boardController.setBoardStateListener(this);
        playerController.setPlayerStateListener(this);

        // Lấy trạng thái ban đầu
        updateBoard(boardController.getCurrentState());
        updatePlayer(playerController.getPlayerState());
    }

    // Khi click 1 ô trên bàn
    private void onBoardCellClicked(int cellIdx) {
        int x = cellIdx % 5;
        int y = cellIdx / 5;
        boardController.onCellAction(0, x, y, ActionType.SUMMON); // Thay null bằng action phù hợp
    }

    @Override
    public void onBoardStateChanged(BoardState state) {
        updateBoard(state);
    }

    @Override
    public void onPlayerStateChanged(PlayerState state) {
        updatePlayer(state);
    }

    private void updateBoard(BoardState state) {
        // TODO: Vẽ lại boardPanel dựa trên state
    }

    private void updatePlayer(PlayerState state) {
        // Cập nhật handPanel, lifePointLabel, v.v.
        handPanel.removeAll();
        for (int i = 0; i < state.getHandCards().size(); i++) {
            JButton cardBtn = new JButton(state.getHandCards().get(i).getName());
            final int cardIdx = i;
            cardBtn.addActionListener(e -> {
                // Gọi PlayerController xử lý chơi bài này
                // playerController.onPlayerAction(...);
            });
            handPanel.add(cardBtn);
        }
        lifePointLabel.setText("Life: " + state.getLifePoint());
        handPanel.revalidate();
        handPanel.repaint();
    }
}