package com.tictactoerest.tictactoegame.parsers;

import com.fasterxml.jackson.databind.*;
import com.tictactoerest.tictactoegame.gameClasses.Game;
import com.tictactoerest.tictactoegame.gameClasses.Gameplay;
import com.tictactoerest.tictactoegame.gameClasses.Player;
import com.tictactoerest.tictactoegame.gameClasses.Step;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.tictactoerest.tictactoegame.TicTacToe.game;
import static com.tictactoerest.tictactoegame.restService.gameNotFullREST.gameList;

public class Jackson_JSON implements parser{

    @Override
    public void parse(String path) {
        Gameplay game;
        ObjectMapper objMapper = new ObjectMapper();
        try {
            Game map = new Game();
            map.initialize();
            objMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            File jsonF = new File(path);
            game = objMapper.readValue(jsonF, Gameplay.class);
            for (Step s : game.getSteps()) {
                map.setMark(s.getCellId() - 1);
                map.out();
            }
            if (!game.getWinner().equals("\"Draw\"")) {
                Player winner;
                winner = objMapper.readValue(game.getWinner(), Player.class);
                System.out.println(winner.getName() + " as Player " + winner.getId() + "(" + winner.getMark() + ") is winner");
            }
            else
                System.out.println("Draw between players " + game.getPlayers()[0].getName() + " and " + game.getPlayers()[1].getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player gameResult = new Player();

    public static void serialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        Gameplay g = new Gameplay();
        g.setPlayers(game.getPlayers());
        g.setSteps(game.getSteps());
        if (gameResult != null)
            g.setWinner(mapper.writeValueAsString(gameResult));
        else
            g.setWinner("\"Draw\"");
        File f;
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        File dir = new File(System.getProperty("user.dir") + "\\LogsJSON\\");
        if (!dir.exists())
            dir.mkdir();
        f = new File(dir.getPath() + "\\" + formatForDateNow.format(new Date()) + "_" + game.getPlayers()[0].getName() + "_vs_" + game.getPlayers()[1].getName() + ".json");
        if (!f.exists())
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        mapper.writerWithDefaultPrettyPrinter().writeValue(f, g);
        gameList.add(f);
    }
}