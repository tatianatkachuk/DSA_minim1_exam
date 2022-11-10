package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Game {
    String idgame;
    String description;
    int level;


    public Game() {
        this.idgame = RandomUtils.getId();
    }


   /** public Game(String description, int level) {
        this();
        this.setDescription(description);
        this.setLevel(level);
    }**/

    public Game(String idgame, String description, int level) {
        this.setId(idgame);
        this.setDescription(description);
        this.setLevel(level);
    }

    public String getId() {
        return this.idgame;
    }

    public void setId(String id) {
        this.idgame=id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int lvl) {
        this.level = lvl;
    }

    @Override
    public String toString() {

        return "Game [id ="+idgame+"\n" +
                "description = " + description + "\n" +
                "level = " + level +"]";
    }

}
