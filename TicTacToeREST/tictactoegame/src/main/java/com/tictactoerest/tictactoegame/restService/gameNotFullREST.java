package com.tictactoerest.tictactoegame.restService;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tictactoerest.tictactoegame.gameClasses.Game;
import com.tictactoerest.tictactoegame.gameClasses.Gameplay;
import com.tictactoerest.tictactoegame.gameClasses.Player;
import com.tictactoerest.tictactoegame.loggers.DOM;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.tictactoerest.tictactoegame.TicTacToe.game;
import static com.tictactoerest.tictactoegame.TicTacToe.log;
import static com.tictactoerest.tictactoegame.menuInterface.loaders.loadListJSON;

@RestController
public class gameNotFullREST {

    public static ArrayList<File> gameList = loadListJSON();

    @GetMapping("/gameplay/current-game")
    public Game GameplayPrint(){
        return game;
    }

    @GetMapping("/gameplay/load")
    public String GameplayHistoryPrint(){
        String result = "";
        for (int i = 0; i < gameList.size(); i++) {
            result += (i + 1) + ". " + gameList.get(i) + "<br>";
        }
        return result;
    }

    @GetMapping("/gameplay/load/{id}")
    public Gameplay getById(@PathVariable int id) throws IOException {
        if (id > gameList.size() && id < 1)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        Gameplay gameLoad = mapper.readValue(gameList.get(id-1), Gameplay.class);
        return gameLoad;
    }

    @GetMapping("/gameplay/new-game")
    public Game newGame(@RequestParam(value = "player1", defaultValue = "P1") String name1, @RequestParam(value = "player2", defaultValue = "P2") String name2){
        game.initialize();
        Player[] players = {new Player(1, name1, "X"), new Player(2, name2, "O")};
        game.setPlayers(players);
        log = new DOM();
        log.setPlayers(players);
        log.start();
        return game;
    }

    @GetMapping("/gameplay/current-game/step")
    public Game newStep(@RequestParam(value = "setMark") int pos) throws IOException {
        pos--;
        if (game.getTurnsLeft() == 0)
            return null;
        if (!game.gameContinue)
            return null;
        if (game.notPossibleTurn(pos))
            return null;
        return game;
    }

    @DeleteMapping("/gameplay/load/{id}")
    public ArrayList<File> deleteById(@PathVariable int id){
        if (id > gameList.size() && id < 1)
            return null;
        gameList.get(id-1).delete();
        gameList.remove(id-1);
        return gameList;
    }

    @ResponseBody
    @RequestMapping(value = "/gameplay/add-game", headers = {"content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Gameplay addGame(@RequestBody Gameplay newGame) throws IOException {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        File f = new File(System.getProperty("user.dir") + "\\LogsJSON\\" + "import_" + formatForDateNow.format(new Date()) + ".json");
        mapper.writerWithDefaultPrettyPrinter().writeValue(f, newGame);
        gameList.add(f);
        return newGame;
    }

}
