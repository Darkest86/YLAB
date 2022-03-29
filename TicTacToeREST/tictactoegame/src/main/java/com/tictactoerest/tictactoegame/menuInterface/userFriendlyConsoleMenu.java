package com.tictactoerest.tictactoegame.menuInterface;

import com.tictactoerest.tictactoegame.gameClasses.Game;
import com.tictactoerest.tictactoegame.gameClasses.Player;
import com.tictactoerest.tictactoegame.loggers.GameHistory;
import com.tictactoerest.tictactoegame.parsers.Jackson_JSON;
import com.tictactoerest.tictactoegame.parsers.SAX_DOM_XML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.tictactoerest.tictactoegame.TicTacToe.*;
import static com.tictactoerest.tictactoegame.fileFilters.*;

public class userFriendlyConsoleMenu {
    static boolean notExit = true;

    public static void loadGame() throws ParserConfigurationException, IOException, SAXException {
        String gamePath = null;
        while (gamePath == null && notExit) {
            gamePath = loadList();
        }
        if (gamePath != null) {
            if (notExit) {
                if (json) {
                    Jackson_JSON parser = new Jackson_JSON();
                    parser.parse(gamePath);
                } else {
                    SAX_DOM_XML parser = new SAX_DOM_XML();
                    try {
                        parser.parse(gamePath);
                    } catch (ParserConfigurationException | SAXException | IOException pce) {
                        System.out.println(pce.getMessage());
                    }
                }
            }
        }
    }

    public static void setPlayerInfo(Game game){
        String name1, name2;
        System.out.println("Enter player 1 name:");
        name1 = scan.nextLine();
        System.out.println("Enter player 2 name:");
        name2 = scan.nextLine();
        game.setPlayers(new Player[]{new Player(1, name1, "X"), new Player(2, name2, "O")});
        System.out.println("Game started");
    }

    public static void startGame() throws IOException {
        game.initialize();
        setPlayerInfo(game);
        log.setPlayers(game.getPlayers());
        log.start();

        while (game.getTurnsLeft() > 0 && game.gameContinue) {
            int pos;
            do {
                System.out.println("Enter number from 1 to 9 (left up corner is 1, right up is 3, right down is 9)");
                game.out();
                pos = Integer.parseInt(scan.nextLine()) - 1;
            }
            while (game.notPossibleTurn(pos));
        }
    }

    public static String loadList() {
        String path = null;
        while (true) {
            System.out.println("Load XML (X)\nLoad JSON (J)\nBack (B)");
            String s = scan.nextLine();
            if (s.equals("X")) {
                json = false;
                break;
            }
            if (s.equals("J")) {
                json = true;
                break;
            }
            if (s.equals("B")) {
                notExit = false;
                break;
            }
            if (!s.equals("X") && !s.equals("J"))
                System.out.println("Invalid input. Try again.");
            System.out.println();
        }
        if (notExit)
            if (json)
                path = loaders.loadGame(loaders.loadListJSON());
            else
                path = loaders.loadGame(loaders.loadListXML());
        return path;
    }

    public static boolean mainMenu() throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Start new game? (G)\nLoad game? (L)\nExit? (E)");
        String s = scan.nextLine();
        if (s.equals("G"))
            startGame();
        if (s.equals("L"))
            loadGame();
        if (s.equals("E"))
            return false;
        if (!s.equals("G") && !s.equals("L"))
            System.out.println("Invalid input. Try again.");
        System.out.println();
        return true;
    }
}
