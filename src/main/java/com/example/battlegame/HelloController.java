package com.example.battlegame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;

    private Classes knight = new Classes("knight");
    private Classes mage = new Classes("mage");
    private Classes archer = new Classes("archer");
    private Classes bard = new Classes("bard");
    private Classes shooter = new Classes("shooter");

    private Player p1;
    private ArrayList<Player> compPlayers;

    private Classes[] fighterclasses = {knight, mage, archer, bard, shooter};

    @FXML
    protected void onHelloButtonClick() {
        p1 = new Player("Ayush", knight);
    }

    @FXML
    protected void updateCompPlayers(){
        Random random = new Random();
        int index = random.nextInt(fighterclasses.length);
        compPlayers.add(new Player(fighterclasses[index], p1));
    }
}