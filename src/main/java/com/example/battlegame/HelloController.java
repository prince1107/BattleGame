package com.example.battlegame;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Random;

public class HelloController {

    @FXML
    private ListView<?> classesListView;

    @FXML
    private Label classSetup, nameSetup, weaponSetup;
    @FXML
    private ImageView playerSetupPic;

    @FXML
    private TextField nameField;

    @FXML
    private SplitMenuButton weaponMenu;

    @FXML
    private Button createCharacterButton;

    @FXML
    private ListView<String> playerStats, inventoryView1, opponentsView, opponentsStats;

    @FXML
    private Label playerStatsLabel, inventoryLabel1, opponentsLabel, opponentStatsLabel, goToBattleLabel;

    @FXML
    private ImageView playerPic, compPic;

    @FXML
    private ListView<?> playerInventory, playerAttacks;

    @FXML
    private Label battleResultLabel, compHealthLabel, compLabel, playerHealthLabel, playerLabel, playerInventoryLabel, playerAttackLabel;

    @FXML
    private ProgressBar compHealthBar, playerHealthBar;

    @FXML
    private Label coinsLabel, inventoryLabel, shopLabel, statsLabel;

    @FXML
    private ListView<?> inventoryView, shopView, statsView;
    
    private Classes knight = new Classes("knight");
    private Classes mage = new Classes("mage");
    private Classes archer = new Classes("archer");
    private Classes bard = new Classes("bard");
    private Classes shooter = new Classes("shooter");

    private Items leatherArmor = new Items("leatherArmor", 0,0,-1,10,20);
    private Items ironArmor = new Items("ironArmor", 0,0,-1,20,40);
    private Items goldArmor = new Items("goldArmor", 0,0,-1,30,60);
    private Items diamondArmor = new Items("diamondArmor", 0,0,-1,40,80);
    private Items legendaryArmor = new Items("legendaryArmor", 0,0,-1,50,100);

    private Items basicHealthPotion = new Items("basicHealthPotion", 0,10,0,0,20);
    private Items goodHealthPotion = new Items("goodHealthPotion", 0,50,0,0,100);
    private Items basicSpeedPotion = new Items("basicSpeedPotion", 0,0,10,0,20);
    private Items goodSpeedPotion = new Items("goodSpeedPotion", 0,0,50,0,100);

    private Player p1;
    private ArrayList<Player> compPlayers = new ArrayList<>();

    private Classes[] fighterclasses = {knight, mage, archer, bard, shooter};

    private Player battleplayer1;
    private Player battleplayer2;

    @FXML
    protected void onHelloButtonClick() {
        p1 = new Player("Ayush", knight);
        updateCompPlayers();
        updateCompPlayers();
        updateCompPlayers();
        opponentsView.getItems().clear();
        for (int i = 1; i <= 3; i++) {
            opponentsView.getItems().add(compPlayers.get(compPlayers.size()-i).getFighterClass().getClassName());
        }

        goToBattleLabel.setVisible(false);

        startBattle();
        attack(battleplayer1,battleplayer2);
//        attack(battleplayer2,battleplayer1);
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
        int index = opponentsView.getSelectionModel().getSelectedIndex();
        battleplayer2 = compPlayers.get(index);
        compPlayers.remove(index);
        goToBattleLabel.setVisible(true);
    }

    protected void attack(Player attacker, Player attacked){
        int damage = attacker.getFighterClass().getAttacks().get(1).getAttackDamage();
        int damageDealt = attacked.getAttributes()[3] - damage * attacker.getAttributes()[0]/40 * attacker.getAttributes()[1]/40;
        System.out.println(damageDealt);
        System.out.println(attacked.getAttributes()[2]);
        attacked.changeAttributes(2,damageDealt);
    }

    @FXML
    public void showCompStats() {
    }

    public void useItem() {
    }

    public void buyItem() {
    }

    public void attack() {
    }
}