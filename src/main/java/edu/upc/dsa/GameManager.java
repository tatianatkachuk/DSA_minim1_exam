package edu.upc.dsa;

import edu.upc.dsa.models.Game;
import edu.upc.dsa.models.Partida;

import java.util.List;


public interface GameManager {

    public int size();

    // Game creation
    public List<Game> addGame(String idgame, String description, int level);

    // Game init --> add game
    public List<Partida> initGame(String idgame, String idUser);

    // Get Level of the game
    public Game getLevel(String idUser);

    // Get points
    public int getPoints(String idUser);

    // Change level
    public Game updateLevel(String idUser, int points, String data);

    // Finish game
    public void deleteGame(String idUser);

    // Get users of game by points
    List<Partida> usersByPoints(String idgame);

    // Get games of user
    public List<Game> findAll(String idUser);

    public List<Game> findAllGames();

    // Get user's game activity
    public List<Game> findActivity(String idUser, String idGame);
}
