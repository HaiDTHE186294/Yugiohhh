package view;

import controller.IBoardController;
import controller.IPlayerController;
import listener.IBoardStateListener;
import listener.IPlayerStateListener;
import model.board.BoardState;
import model.common.constaint.ActionType;
import model.player.PlayerState;
import model.common.model.IGameSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main game window
public class GameMainFrame extends JFrame implements IBoardStateListener, IPlayerStateListener {
    private IGameSession gameSession;

    private JPanel boardPanel;
    private JPanel handPanel;
    private JButton deckButton;
    private JButton graveButton;
    private JLabel lifePointLabel;
    private JButton endTurnButton;
    private int selectedHandCardIndex = -1;
    private JLabel phaseLabel, currentPlayerLabel;

    public GameMainFrame(IGameSession gameSession) {
        this.gameSession = gameSession;

        setTitle("Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Board
        int width = 10, height = 4;
        boardPanel = new JPanel(new GridLayout(height, width));
        for (int i = 0; i < width * height; i++) {
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
        deckGravePanel.add(deckButton);

        graveButton = new JButton("Grave");
        deckGravePanel.add(graveButton);

        lifePointLabel = new JLabel("Life: 8000");
        deckGravePanel.add(lifePointLabel);

        phaseLabel = new JLabel();
        currentPlayerLabel = new JLabel();
        deckGravePanel.add(phaseLabel);
        deckGravePanel.add(currentPlayerLabel);

        // Nút kết thúc lượt
        endTurnButton = new JButton("Kết thúc lượt");
        endTurnButton.addActionListener(e -> {
            gameSession.nextPhase();
            model.gamesession.GameSessionState sessionState = gameSession.getCurrentState();
            if (sessionState != null && sessionState.getBoardState() != null) {
                updateBoard(sessionState.getBoardState());
            }
            int currentIdx = sessionState.getCurrentPlayerIndex();
            if (currentIdx == 0 && sessionState.getPlayer1State() != null) {
                updatePlayer(sessionState.getPlayer1State());
            } else if (currentIdx == 1 && sessionState.getPlayer2State() != null) {
                updatePlayer(sessionState.getPlayer2State());
            }
            updatePhaseAndPlayerLabel(sessionState);
        });
        deckGravePanel.add(endTurnButton);

        add(deckGravePanel, BorderLayout.NORTH);

        setSize(800, 600);
        setVisible(true);

        // TODO: Đăng ký listener với gameSession nếu cần
        // Lấy trạng thái ban đầu từ gameSession để update UI
        model.gamesession.GameSessionState sessionState = gameSession.getCurrentState();
        if (sessionState != null && sessionState.getBoardState() != null) {
            updateBoard(sessionState.getBoardState());
        }
        if (sessionState != null && sessionState.getPlayer1State() != null) {
            updatePlayer(sessionState.getPlayer1State());
        }
        updatePhaseAndPlayerLabel(sessionState);
    }

    // Khi click 1 ô trên bàn
    private void onBoardCellClicked(int cellIdx) {
        int x = cellIdx % 10;
        int y = cellIdx / 10;
        model.gamesession.GameSessionState sessionState = gameSession.getCurrentState();
        int currentIdx = sessionState.getCurrentPlayerIndex();
        if (selectedHandCardIndex != -1) {
            PlayerState playerState = (currentIdx == 0) ? sessionState.getPlayer1State() : sessionState.getPlayer2State();
            model.common.model.ICard card = playerState.getHandCards().get(selectedHandCardIndex);
            model.gamesession.SummonAction action = new model.gamesession.SummonAction(currentIdx, card, x, y);
            gameSession.handleAction(action);

            // Cập nhật lại UI
            sessionState = gameSession.getCurrentState();
            updateBoard(sessionState.getBoardState());
            if (currentIdx == 0) updatePlayer(sessionState.getPlayer1State());
            else updatePlayer(sessionState.getPlayer2State());
            updatePhaseAndPlayerLabel(sessionState);

            selectedHandCardIndex = -1;
        }
    }

    @Override
    public void onBoardStateChanged(BoardState state) {
        updateBoard(state);
    }

    @Override
    public void onPlayerStateChanged(PlayerState state) {
        // Cập nhật handPanel, lifePointLabel, v.v.
        handPanel.removeAll();
        for (int i = 0; i < state.getHandCards().size(); i++) {
            JButton cardBtn = new JButton(state.getHandCards().get(i).getName());
            final int cardIdx = i;
            cardBtn.addActionListener(e -> {
                selectedHandCardIndex = cardIdx; // Lưu lại lá bài được chọn
            });
            handPanel.add(cardBtn);
        }
        lifePointLabel.setText("Life: " + state.getLifePoint());
        handPanel.revalidate();
        handPanel.repaint();
    }

    private void updateBoard(BoardState state) {
        if (state == null) return;
        model.board.CellState[][] playground = state.getPlayground();
        int w = playground.length;
        int h = playground[0].length;
        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                int idx = y * w + x;
                if (idx < boardPanel.getComponentCount()) {
                    JButton btn = (JButton) boardPanel.getComponent(idx);
                    model.common.model.ICard card = playground[x][y].getCard();
                    if (card != null) {
                        btn.setText(card.getName());
                    } else {
                        btn.setText("");
                    }
                }
            }
        }
    }

    private void updatePlayer(PlayerState state) {
        handPanel.removeAll();
        for (int i = 0; i < state.getHandCards().size(); i++) {
            JButton cardBtn = new JButton(state.getHandCards().get(i).getName());
            final int cardIdx = i;
            cardBtn.addActionListener(e -> {
                selectedHandCardIndex = cardIdx; // Lưu lại lá bài được chọn
            });
            handPanel.add(cardBtn);
        }
        lifePointLabel.setText("Life: " + state.getLifePoint());
        handPanel.revalidate();
        handPanel.repaint();
    }

    private void updatePhaseAndPlayerLabel(model.gamesession.GameSessionState sessionState) {
        if (sessionState == null) return;
        phaseLabel.setText("Phase: " + sessionState.getCurrentPhase().getPhaseType());
        int idx = sessionState.getCurrentPlayerIndex();
        currentPlayerLabel.setText("Lượt: " + (idx == 0 ? "Player 1" : "Player 2"));
    }
}