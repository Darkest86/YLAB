package com.tictactoerest.tictactoegame.gameClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tictactoerest.tictactoegame.loggers.GameHistory;
import com.tictactoerest.tictactoegame.parsers.Jackson_JSON;

import java.io.IOException;
import java.util.ArrayList;

import static com.tictactoerest.tictactoegame.TicTacToe.log;

public class Game {
    int[][] Map;
    int turnsLeft;
    public boolean gameContinue;
    ArrayList<Step> steps;
    Player[] players;
    Player winner;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void initialize(){
        this.Map = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        this.turnsLeft = 9;
        this.steps = new ArrayList<>();
        this.players = new Player[2];
        this.gameContinue = true;
        this.winner = null;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public int[][] getMap() {
        return Map;
    }

    public void setMark(int x) {
        this.Map[x / 3][x % 3] = -1 + 2 * (this.turnsLeft % 2);
        this.steps.add(new Step(10-this.turnsLeft, (this.turnsLeft - 1) % 2 + 1, x + 1));
        this.turnsLeft--;
    }

    public void out() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| ");
                switch (this.Map[i][j]) {
                    case -1 -> System.out.print("O ");
                    case 1 -> System.out.print("X ");
                    case 0 -> System.out.print("- ");
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }

    public boolean checkNoWin() throws IOException {
        int h1 = 0, h2 = 0, h3 = 0, v1 = 0, v2 = 0, v3 = 0, d1 = 0, d2 = 0;
        for (int i = 0; i < 3; i++) {
            h1 += this.Map[0][i];
            h2 += this.Map[1][i];
            h3 += this.Map[2][i];
            v1 += this.Map[i][0];
            v2 += this.Map[i][1];
            v3 += this.Map[i][2];
            d1 += this.Map[i][i];
            d2 += this.Map[2 - i][i];
        }
        if (h1 == 3 || h2 == 3 || h3 == 3 || v1 == 3 || v2 == 3 || v3 == 3 || d1 == 3 || d2 == 3) {
            GameHistory.GameEndWin(this.players, 0);
            log.endLog(this.players[0]);
            Jackson_JSON.gameResult = this.players[0];
            Jackson_JSON.serialize();
            System.out.println(this.players[0].getName() + " won!");
            setWinner(this.players[0]);
            return false;
        }
        if (h1 == -3 || h2 == -3 || h3 == -3 || v1 == -3 || v2 == -3 || v3 == -3 || d1 == -3 || d2 == -3) {
            GameHistory.GameEndWin(this.players, 1);
            log.endLog(this.players[1]);
            Jackson_JSON.gameResult = this.players[1];
            Jackson_JSON.serialize();
            System.out.println(this.players[1].getName() + " won!");
            setWinner(this.players[1]);
            return false;
        }
        if (this.getTurnsLeft() == 0 && this.gameContinue) {
            log.endLog();
            Jackson_JSON.gameResult = null;
            Jackson_JSON.serialize();
            GameHistory.GameDraw(this.getPlayers());
            System.out.println("Draw!");
        }
        return true;
    }

    public boolean notPossibleTurn(int x) throws IOException {
        if (x < 9) {
            if (this.Map[x / 3][x % 3] == 0) {
                this.setMark(x);
                log.addStep(x, 9 - this.getTurnsLeft());
                this.gameContinue = this.checkNoWin();
                return false;
            } else
                System.out.println("Invalid input. Try again.");
        } else
            System.out.println("Invalid input. Try again.");
        return true;
    }
}