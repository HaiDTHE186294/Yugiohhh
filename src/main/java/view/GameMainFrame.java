package view;

import model.common.model.ICard;
import model.gamesession.CardAction;
import model.player.PlayerState;
import model.gamesession.GameSessionState;
import model.common.model.IGameSession;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameMainFrame extends JFrame {
    private BoardPanel boardPanel;
    private HandPanel handPanel;
    private InfoPanel infoPanel;
    private IGameSession gameSession;
    private int selectedHandCardIndex = -1;
    private DeckView deckView;
    private GraveView graveView;

    public GameMainFrame(IGameSession gameSession) {
        this.gameSession = gameSession;
        setTitle("Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardPanel = new BoardPanel(5, 4);
        handPanel = new HandPanel();
        deckView = new DeckView();
        graveView = new GraveView();
        infoPanel = new InfoPanel();
        JPanel sidePanel = new JPanel(new GridLayout(2, 1));
        sidePanel.add(deckView);
        sidePanel.add(graveView);

        add(sidePanel, BorderLayout.EAST);
        add(boardPanel, BorderLayout.CENTER);
        add(handPanel, BorderLayout.SOUTH);
        add(infoPanel, BorderLayout.NORTH);

        // Lắng nghe thao tác
        boardPanel.addCellListener(this::onBoardCellClicked);
        handPanel.addCardListener(this::onHandCardClicked);
        infoPanel.addEndTurnListener(e -> {
            gameSession.nextPhase();
            updateFromSession();
        });

        // Update UI lần đầu
        updateFromSession();

        setSize(900, 650);
        setVisible(true);
    }

    private void updateFromSession() {
        GameSessionState sessionState = gameSession.getCurrentState();
        boardPanel.setState(sessionState.getBoardState());
        PlayerState playerState = sessionState.getCurrentPlayerIndex() == 0
                ? sessionState.getPlayer1State()
                : sessionState.getPlayer2State();
        handPanel.setHandState(playerState);
        infoPanel.setPhase(sessionState.getCurrentPhase().getPhaseType().toString());
        infoPanel.setPlayer("Player " + (sessionState.getCurrentPlayerIndex() + 1));
        infoPanel.setLife(playerState.getLifePoint());
        deckView.setDeckState(playerState.getDeckCount());
        List<ICard> graveCards = playerState.getGraveCards();
        graveView.setGraveState(
                graveCards.isEmpty() ? null : graveCards.get(graveCards.size()-1).getName()
        );
    }

    private void onBoardCellClicked(int x, int y) {
        var sessionState = gameSession.getCurrentState();
        var playerState = sessionState.getCurrentPlayerIndex() == 0
                ? sessionState.getPlayer1State()
                : sessionState.getPlayer2State();

        if (selectedHandCardIndex != -1) {
            var card = playerState.getHandCards().get(selectedHandCardIndex);
            //Đóng gói thao tác để gửi đến game session
            var action = new CardAction(sessionState.getCurrentPlayerIndex(), card, x, y);
            gameSession.handleAction(action);
            selectedHandCardIndex = -1;
        } else {
            var action = new CardAction(sessionState.getCurrentPlayerIndex(), null, x, y);
            gameSession.handleAction(action);
        }

        updateFromSession();
    }

    private void onHandCardClicked(int idx) {
        selectedHandCardIndex = idx;
    }
}