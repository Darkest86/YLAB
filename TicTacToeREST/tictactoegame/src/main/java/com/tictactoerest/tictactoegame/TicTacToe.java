package com.tictactoerest.tictactoegame;

import com.tictactoerest.tictactoegame.gameClasses.Game;
import com.tictactoerest.tictactoegame.loggers.DOM;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

import static com.tictactoerest.tictactoegame.menuInterface.userFriendlyConsoleMenu.mainMenu;

public class TicTacToe {
    public static Scanner scan = new Scanner(System.in);
    public static Game game = new Game();
    public static DOM log = new DOM();
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        while (mainMenu()) {}
    }
}
