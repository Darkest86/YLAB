package com.tictactoerest.tictactoegame.gameClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Gameplay {

    Player[] Players;
    ArrayList<Step> Steps;
    String Winner;

    @JsonProperty(value = "Players")
    public Player[] getPlayers() {
        return Players;
    }

    public void setPlayers(Player[] players) {
        this.Players = players;
    }

    @JsonProperty(value = "Steps")
    public ArrayList<Step> getSteps() {
        return Steps;
    }

    public void setSteps(ArrayList<Step> Steps) {
        this.Steps = Steps;
    }

    @JsonProperty(value = "Game Result")
    public String getWinner() {
        return Winner;
    }

    public void setWinner(String winner) {
        this.Winner = winner;
    }
}
