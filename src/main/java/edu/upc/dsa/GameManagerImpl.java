package edu.upc.dsa;

import edu.upc.dsa.models.Game;
import edu.upc.dsa.models.Partida;
import org.apache.log4j.Logger;

import java.util.*;

public class GameManagerImpl implements GameManager {
    private List<Game> games; // games List
    private int lvl;
    private List<Partida> partidas; // partidas list
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);

    private static GameManager instance;
    public GameManagerImpl() {

        this.games = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    @Override
    public int size() {
        int s = this.games.size();
        logger.info("There are " + s + " games.");
        return s;
    }

    public static GameManager getInstance() {
        if (instance==null) instance = new GameManagerImpl();
        return instance;
    }

    @Override
    public List<Game> addGame(String idgame, String description, int level) {
        logger.info("new Game " + idgame + "\nwith description " +
                description + "\n and level " + level);
        Game g = new Game(idgame, description, level);
        this.games.add(g);
        logger.info("new Game added " + g);
        return games;
    }

    @Override
    public List<Partida> initGame(String idgame, String idUser) {
        logger.info("new Game " + idgame + "\nwith idUser " +
                idUser);
        Partida p = new Partida(idgame, idUser);
        // Search for game to init
        for (Game g: this.games) {
            if (g.getId().equals(idgame)){
                this.partidas.add(p);
            }
        }
        logger.info("new Partida added " + p);
        return partidas;
    }

    @Override
    public Game getLevel(String idUser) {
        logger.info("getLevel("+idUser+")");

        for (Partida p: this.partidas) {
            if (p.getUserId().equals(idUser)){
                String gid = p.getId();
                logger.info("Game found " + gid);

                for (Game g: this.games){
                    if (g.getId().equals(gid)) {
                        this.lvl = g.getLevel();
                        logger.info(" The Level is " + lvl );
                        return g;
                    }
                }
            }
        }
        logger.warn("not found " + idUser);
        return null;
    }

    @Override
    public int getPoints(String idUser) {
        logger.info("getPoints("+idUser+")");

        for (Partida p: this.partidas) {
            if (p.getUserId().equals(idUser)){
                logger.info("Partida found " + p + "\nwith " + p.getPoints() + " points");
                return p.getPoints();
            }
        }
        logger.warn("not found " + idUser);
        return 0;
    }

    @Override
    public Game updateLevel(String idUser, int points, String data) {
        logger.info("find user ("+idUser+")");

        for (Partida p: this.partidas) {
            if (p.getUserId().equals(idUser)) {
                logger.info("Partida found " + p + "\n" +
                        "with " + p.getPoints() + " points");
                int actualpoints = p.getPoints();
                int newpoints = actualpoints + 100;
                p.setPoints(newpoints);

                for (Game g: this.games) {
                    if (g.getId().equals(p.getId())){
                        int actuallvl = g.getLevel();
                        int newlvl = actuallvl + 1;
                        g.setLevel(newlvl);
                        logger.info("The level " + actuallvl +
                                        " was updated to " + newlvl);
                        return g;
                    }else{
                        logger.warn("not found " + p.getId());
                        return null;
                    }
                }
            }else {
                logger.warn("idUser not found " + idUser);
                return null;
            }
        }
        return null;
    }

    @Override
    public void deleteGame(String idUser) {
        logger.info("getGame("+idUser+")");

        for (Partida p: this.partidas) {
            if (p.getUserId().equals(idUser)){
                logger.info("Partida found " + p + "\nwith " + p.getPoints() + " points");
                String gid = p.getId();
                this.partidas.remove(p);

                for (Game g: this.games) {
                    if (g.getId().equals(gid)){
                        logger.info(games);
                        this.games.remove(g);
                        logger.info(games);
                    }else{
                        logger.warn("not found " + gid);
                    }
                }
            }else{
                logger.warn("not found " + idUser);
            }
        }
    }

    @Override
    public List<Partida> usersByPoints(String idgame) {
        List<Partida> plist = this.partidas;
        if (!plist.isEmpty()){
            Collections.sort(plist, new Comparator<Partida>() {
                @Override
                public int compare(Partida p1, Partida p2) {
                    return Double.compare(p1.getPoints(), p2.getPoints());
                }
            });
            return plist;
        }else return  null;
    }

    @Override
    public List<Game> findAll(String idUser) {
        List<Game> result = new ArrayList<>();
        logger.info("find all games("+idUser+")");

        for (Partida p: this.partidas) {
            if (p.getUserId().equals(idUser)){
                String gid = p.getId();
                logger.info("Game found " + gid);

                for (Game g: this.games){
                    if (g.getId().equals(gid)) {
                        result.add(g);
                        logger.info(" Game added " + g );
                    }
                }
            }
        }
        logger.warn("not found " + idUser);
        return result;
    }

    @Override
    public List<Game> findAllGames() {
        logger.info("find all games");

        return this.games;
    }

    @Override
    public List<Game> findActivity(String idUser, String idGame) {
        return null;
    }
}