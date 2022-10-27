package com.example.battlegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Random;

public class HelloController {

    public Button refreshShopButton;
    public Button startBattleButton;
    public Button createCharacterButton2;
    @FXML
    private ListView<String> classesListView;

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

    private Items ironSword = new Items("ironSword", 20,0,-1,0,40);
    private Items goldSword = new Items("goldSword", 30,0,-1,0,60);
    private Items diamondSword = new Items("diamondSword", 40,0,-1,0,80);
    private Items legendarySword = new Items("legendarySword", 50,0,-1,0,100);

    private Items ironBow = new Items("ironBow", 20,0,-1,0,40);
    private Items goldBow = new Items("goldBow", 30,0,-1,0,60);
    private Items diamondBow = new Items("diamondBow", 40,0,-1,0,80);
    private Items legendaryBow = new Items("legendaryBow", 50,0,-1,0,100);

    private Items ironAxe = new Items("ironAxe", 20,0,-1,0,40);
    private Items goldAxe = new Items("goldAxe", 30,0,-1,0,60);
    private Items diamondAxe = new Items("diamondAxe", 40,0,-1,0,80);
    private Items legendaryAxe = new Items("legendaryAxe", 50,0,-1,0,100);

    private Items[] startingWeapons = {ironSword, ironBow, ironAxe};

    private Items[] allWeapons = {leatherArmor, ironArmor, goldArmor, diamondArmor, legendaryArmor, basicHealthPotion, goodHealthPotion, basicSpeedPotion, goodSpeedPotion, ironSword, goldSword, diamondSword, legendarySword, ironBow, goldBow, diamondBow,legendaryBow, ironAxe, goldAxe, diamondAxe, legendaryAxe};

    private Shop shop = new Shop(allWeapons);

    private Player p1;
    private ArrayList<Player> compPlayers = new ArrayList<>();

    private Classes[] fighterclasses = {knight, mage, archer, bard, shooter};

    private Player battleplayer1;
    private Player battleplayer2;

    private OwnedItems selectedStartingItem;

    EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            String selectedItemName = ((MenuItem)e.getSource()).getText();

            Items selectedItem = null;

            for (Items items:startingWeapons) {
                if(selectedItemName == items.getName()){
                    selectedItem = items;
                }
            }

            selectedStartingItem = new OwnedItems(selectedItem);
        }
    };


    @FXML
    protected void createCharacter() {
        String name = nameField.getText();
        int index = classesListView.getSelectionModel().getSelectedIndex();
        Classes fighterclass = fighterclasses[index];
        p1 = new Player(name, fighterclass);
        p1.getInventory().addItem(selectedStartingItem);

        updateCompPlayers();
        updateCompPlayers();
        updateCompPlayers();
        opponentsView.getItems().clear();
        for (int i = 1; i <= 3; i++) {
            opponentsView.getItems().add(compPlayers.get(compPlayers.size()-i).getFighterClass().getClassName());
        }

        printStats(playerStats, p1);
    }

    @FXML
    protected void onHelloButtonClick() {
        classesListView.getItems().clear();
        for (Classes fighterClass: fighterclasses) {
            classesListView.getItems().add(fighterClass.getClassName());
        }

        weaponMenu.getItems().clear();
        for (Items items: startingWeapons) {
            weaponMenu.getItems().add(new MenuItem(items.getName()));
        }

        for (MenuItem items: weaponMenu.getItems()) {
            items.setOnAction(event1);
        }

        goToBattleLabel.setVisible(false);
    }

    @FXML
    protected void updateCompPlayers(){
        Random random = new Random();
        int index = random.nextInt(fighterclasses.length);
        compPlayers.add(new Player(fighterclasses[index], p1));
    }

    @FXML
    protected void printStats(ListView listview, Player player){
        ArrayList<String> tempArray = new ArrayList<>();
        tempArray.add("Name: " + player.getName());
        tempArray.add("Attributes: " + player.getAttributes()[2]);
        tempArray.add("Class: " + player.getFighterClass().getClassName());
        tempArray.add("Attacks: ");
        for (Attack attack: player.getFighterClass().getAttacks()) {
            tempArray.add(attack.getAttackName() + "," + attack.getAttackDamage() + "  ");
        }
        tempArray.add("Level: " + player.getPlayerlevel());

        listview.getItems().clear();
        listview.getItems().addAll(tempArray);
    }

    @FXML
    protected void startBattle(){
        battleplayer1 = p1;
        int index = opponentsView.getSelectionModel().getSelectedIndex();
        battleplayer2 = compPlayers.get(index);
        compPlayers.remove(index);
        goToBattleLabel.setVisible(true);

        ArrayList<String> tempList = new ArrayList<>();

        for (Attack attack: battleplayer1.getFighterClass().getAttacks()) {
            tempList.add(attack.getAttackName() + "; Damage: " + attack.getAttackDamage());
        }
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
        int index = opponentsView.getSelectionModel().getSelectedIndex();
        Player selectedPlayer = compPlayers.get(index);
        printStats(opponentsStats, selectedPlayer);
    }

    public void useItem() {
    }

    public void buyItem() {
    }

    public void attack() {
        attack(battleplayer1, battleplayer2);
    }

    public void refreshShop() {
        shop.randomizeShop(shopView);
    }
}