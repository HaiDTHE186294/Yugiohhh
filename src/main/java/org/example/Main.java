package org.example;

import controller.BoardController;
import controller.PlayerController;
import model.board.Board;
import model.common.constaint.MonsterType;
import model.player.Player;
import model.card.Deck;
import model.card.MonsterCard;
import model.card.SpellCard;
import model.common.model.IDeck;
import model.common.model.ICard;
import model.card.Grave;
import view.GameMainFrame;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Tạo vài lá bài mẫu
        List<ICard> cards1 = new ArrayList<>();
        cards1.add(new MonsterCard("Blue-Eyes White Dragon", 3000, 2500, 8, MonsterType.CYBERSE));
        cards1.add(new MonsterCard("Dark Magician", 2500, 2100, 7, MonsterType.CYBERSE));
        cards1.add(new SpellCard("Monster Reborn"));
        cards1.add(new SpellCard("Raigeki"));
        cards1.add(new MonsterCard("Kuriboh", 300, 200, 1, MonsterType.CYBERSE));

        // Deck cho player 1
        IDeck deck1 = new Deck(cards1);

        List<ICard> cards2 = new ArrayList<>();
        cards2.add(new MonsterCard("Red-Eyes Black Dragon", 2400, 2000, 7, MonsterType.CYBERSE));
        cards2.add(new MonsterCard("Summoned Skull", 2500, 1200, 6, MonsterType.CYBERSE));
        cards2.add(new SpellCard("Pot of Greed"));
        cards2.add(new SpellCard("Fissure"));
        cards2.add(new MonsterCard("Celtic Guardian", 1400, 1200, 4, MonsterType.CYBERSE));

        // Deck cho player 2
        IDeck deck2 = new Deck(cards2);

        // Khởi tạo 2 player với deck
        Player player1 = new Player("Player 1", 8000, deck1);
        Player player2 = new Player("Player 2", 8000, deck2);

        List<Player> players = Arrays.asList(player1, player2);

        // Chuẩn bị map decks và graves cho Board
        Map<Integer, IDeck> decks = new HashMap<>();
        Map<Integer, model.common.model.IGrave> graves = new HashMap<>();
        for (int i = 0; i < players.size(); ++i) {
            decks.put(i, players.get(i).getDeck());
            graves.put(i, players.get(i).getGrave());
        }

        Board board = new Board(5, 5, players.size(), decks, graves);

        // Khởi tạo controller
        BoardController boardController = new BoardController(board);
        PlayerController player1Controller = new PlayerController(player1);
        // Nếu muốn chơi 2 người thì cần thêm PlayerController cho player2

        // Khởi tạo view
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GameMainFrame(boardController, player1Controller);
        });
    }
}