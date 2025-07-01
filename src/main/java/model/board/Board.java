package model.board;

import listener.IBoardListener;
import model.common.model.*;
import java.util.*;

public class Board implements IBoard {
    private CellState[][] playground;
    private Map<Integer, IDeck> playerDecks = new HashMap<>();
    private Map<Integer, IGrave> playerGraves = new HashMap<>();
    private IBoardListener boardListener;

    public Board(int width, int height, int numPlayers, Map<Integer, IDeck> decks, Map<Integer, IGrave> graves) {
        playground = new CellState[width][height];
        for (int i = 0; i < width; ++i)
            for (int j = 0; j < height; ++j)
                playground[i][j] = new CellState();
        this.playerDecks.putAll(decks);
        this.playerGraves.putAll(graves);
    }

    @Override
    public CellState[][] getPlaygroundState() {
        return playground;
    }

    @Override
    public boolean hasDeck(int playerId) {
        return playerDecks.get(playerId) != null && playerDecks.get(playerId).getCardCount() > 0;
    }

    @Override
    public ICard getLastGraveCard(int playerId) {
        return playerGraves.get(playerId).getLastCard();
    }

    @Override
    public boolean placeCard(int playerId, int x, int y, ICard card, boolean faceUp) {
        if (playground[x][y].getCard() == null) {
            playground[x][y].setCard(card);
            playground[x][y].setFaceUp(faceUp);
            if (boardListener != null) boardListener.onBoardChanged();
            return true;
        }
        return false;
    }

    @Override
    public ICard getCardAt(int x, int y) {
        return playground[x][y].getCard();
    }


    @Override
    public boolean moveToGrave(int playerId, int x, int y) {
        ICard card = getCardAt(x, y);
        if (card != null) {
            IGrave grave = playerGraves.get(playerId);
            if (grave != null) {
                grave.addCard(card);
                playground[x][y].setCard(null);
                if (boardListener != null) boardListener.onBoardChanged();
                return true;
            }
        }
        return false;
    }

    @Override
    public void setBoardListener(IBoardListener listener) {
        this.boardListener = listener;
    }
}