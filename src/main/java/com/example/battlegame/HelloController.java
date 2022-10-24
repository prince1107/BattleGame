package com.example.battlegame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

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
    private ArrayList<Player> compPlayers = new ArrayList<>();

    private Classes[] fighterclasses = {knight, mage, archer, bard, shooter};

    private Player battleplayer1;
    private Player battleplayer2;

    @FXML
    protected void onHelloButtonClick() {
        p1 = new Player("Ayush", knight);
        updateCompPlayers();
        System.out.println(compPlayers);
        printStats(p1);
        for (Player player:compPlayers) {
            printStats(player);
        }

        startBattle();
        attack(battleplayer1,battleplayer2);
//        attack(battleplayer2,battleplayer1);

        System.out.println(battleplayer1.getAttributes()[2]);
        System.out.println(battleplayer2.getAttributes()[2]);
    }

    @FXML
    protected void updateCompPlayers(){
        Random random = new Random();
        int index = random.nextInt(fighterclasses.length);
        compPlayers.add(new Player(fighterclasses[index], p1));
    }

    @FXML
    protected void printStats(Player player){
        System.out.println("Name: " + player.getName());
        System.out.println("Attributes: " + player.getAttributes()[2]);
        System.out.println("Class: " + player.getFighterClass().getClassName());
        System.out.print("Attacks: ");
        for (Attack attack: player.getFighterClass().getAttacks()) {
            System.out.print(attack.getAttackName() + "," + attack.getAttackDamage() + "  ");
        }
        System.out.println("Level: " + player.getPlayerlevel());
    }

    @FXML
    protected void startBattle(){
        battleplayer1 = p1;
        battleplayer2 = compPlayers.get(compPlayers.size()-1);
    }

    protected void attack(Player attacker, Player attacked){
        int damage = attacker.getFighterClass().getAttacks().get(1).getAttackDamage();
        int damageDealt = attacked.getAttributes()[3] - damage * attacker.getAttributes()[0]/40 * attacker.getAttributes()[1]/40;
        System.out.println(damageDealt);
        System.out.println(attacked.getAttributes()[2]);
        attacked.changeAttributes(2,damageDealt);
    }

    @FXML
    public void showCompStats(MouseEvent mouseEvent) {
    }
}