package edu.upc.dsa;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class GameManagerImplTest {

    private HttpServer server;
    private WebTarget target;

    GameManager gm;

    @Before
    public void setUp() throws Exception {
        gm = new GameManagerImpl();
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);



        gm.addGame("game0001", "first game", 1);
        gm.initGame("game0001", "user0258");

    }

    @After
    public void tearDown() throws Exception {
        server.stop();
        this.gm = null;
    }
/**
    @Test
    public void testAddGame() {
        Assert.assertEquals(1, this.gm.size());

        gm.addGame("game0002","second game",2);
        gm.addGame("game0003","third game",2);

        Assert.assertEquals(3, this.gm.size());

    }

    @Test
    public void testgetGamesByUser() {
        gm.findAll("user0258");
    }

    @Test
    public void testDeleteGame() {
        Assert.assertEquals(1, this.gm.size());
        gm.deleteGame("user0258");
        Assert.assertEquals(0, this.gm.size());
    }


    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }**/
}
