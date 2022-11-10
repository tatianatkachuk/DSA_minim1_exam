package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Partida {
    String idp;
    String idUser;

    int gamePoints;

    public Partida() {
        this.idp = RandomUtils.getId();
    }


    public Partida(String idp, String idUser) {
        this.setId(idp);
        this.setUserId(idUser);
    }

    public String getId() {
        return this.idp;
    }

    public void setId(String id) {
        this.idp=id;
    }

    public String getUserId() {
        return this.idUser;
    }

    public void setUserId(String id) {
        this.idUser=id;
    }

    public int getPoints() {
        return this.gamePoints;
    }

    public void setPoints(int p) {
        this.gamePoints=p;
    }


    @Override
    public String toString() {

        return "Partida [id ="+idp+"\n" +
                "id of user = " + idUser + "]";
    }

}
