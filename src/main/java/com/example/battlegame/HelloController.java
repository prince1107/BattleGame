package com.example.battlegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public Button refreshShopButton;
    public Button startBattleButton;
    public Button createCharacterButton2;
    public Button compAttackButton;
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
    private Button createCharacterButton, hardModeButton;

    @FXML
    private ListView<String> playerStats, inventoryView1, opponentsView, opponentsStats;

    @FXML
    private Label playerStatsLabel, inventoryLabel1, opponentsLabel, opponentStatsLabel, goToBattleLabel;

    @FXML
    private ImageView playerPic, compPic;

    @FXML
    private ListView<String> playerInventory, playerAttacks;

    @FXML
    private Label battleResultLabel, compHealthLabel, compLabel, playerHealthLabel, playerLabel, playerInventoryLabel, playerAttackLabel;

    @FXML
    private ProgressBar compHealthBar, playerHealthBar;

    @FXML
    private Label coinsLabel, inventoryLabel, shopLabel, statsLabel;

    @FXML
    private ListView<String> inventoryView, shopView, statsView;
    
    private Classes knight = new Classes("knight");
    private Classes mage = new Classes("mage");
    private Classes archer = new Classes("archer");
    private Classes bard = new Classes("bard");
    private Classes shooter = new Classes("shooter");
    private Classes boss1 = new Classes("boss1");
    private Classes boss2 = new Classes("boss2");

    private Items leatherArmor = new Items("leatherArmor", 0,0,-1,10,20);
    private Items ironArmor = new Items("ironArmor", 0,0,-1,20,40);
    private Items goldArmor = new Items("goldArmor", 0,0,-1,30,60);
    private Items diamondArmor = new Items("diamondArmor", 0,0,-1,40,80);
    private Items legendaryArmor = new Items("legendaryArmor", 0,0,-1,50,100);

    private Items basicHealthPotion = new Items("basicHealthPotion", 0,10,0,0,20);
    private Items goodHealthPotion = new Items("goodHealthPotion", 0,50,0,0,100);
    private Items basicSpeedPotion = new Items("basicSpeedPotion", 0,0,10,0,20);
    private Items goodSpeedPotion = new Items("goodSpeedPotion", 0,0,50,0,100);

    private Items ironSword = new Items("ironSword", 20,0,0,0,40);
    private Items goldSword = new Items("goldSword", 30,0,0,0,60);
    private Items diamondSword = new Items("diamondSword", 40,0,0,0,80);
    private Items legendarySword = new Items("legendarySword", 50,0,0,0,100);

    private Items ironBow = new Items("ironBow", 20,0,0,0,40);
    private Items goldBow = new Items("goldBow", 30,0,0,0,60);
    private Items diamondBow = new Items("diamondBow", 40,0,0,0,80);
    private Items legendaryBow = new Items("legendaryBow", 50,0,0,0,100);

    private Items ironAxe = new Items("ironAxe", 20,0,0,0,40);
    private Items goldAxe = new Items("goldAxe", 30,0,0,0,60);
    private Items diamondAxe = new Items("diamondAxe", 40,0,0,0,80);
    private Items legendaryAxe = new Items("legendaryAxe", 50,0,0,0,100);

    private Items[] startingWeapons = {ironSword, ironBow, ironAxe};

    private Items[] allItems = {leatherArmor, ironArmor, goldArmor, diamondArmor, legendaryArmor, basicHealthPotion, goodHealthPotion, basicSpeedPotion, goodSpeedPotion, ironSword, goldSword, diamondSword, legendarySword, ironBow, goldBow, diamondBow,legendaryBow, ironAxe, goldAxe, diamondAxe, legendaryAxe};

    private Items[] hardItems = {leatherArmor, ironArmor, goldArmor, diamondArmor, legendaryArmor, basicSpeedPotion, goodSpeedPotion, ironSword, goldSword, diamondSword, legendarySword, ironBow, goldBow, diamondBow,legendaryBow, ironAxe, goldAxe, diamondAxe, legendaryAxe};

    private Shop shop;

    private Player p1;
    private ArrayList<Player> compPlayers = new ArrayList<>();

    private Classes[] fighterclasses = {knight, mage, archer, bard, shooter};

    private Player battleplayer1;
    private Player battleplayer2;

    private int turn = 0;

    private Items selectedWeapon;

    private OwnedItems selectedStartingItem;

    private int extramoney = 0;

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
    private boolean hardmode;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
    protected void createCharacter() {
        String name = nameField.getText();
        int index = classesListView.getSelectionModel().getSelectedIndex();
        Classes fighterclass = fighterclasses[index];
        p1 = new Player(name, fighterclass);
        p1.getInventory().addItem(selectedStartingItem);

        updateCompPlayers();
        updateCompPlayers();
        updateCompPlayers();
        displayOpponents();

        printStats(playerStats, p1);
        displayItems();

        playerSetupPic.setImage(fighterclass.getImage());

        setShop();

        p1.changeCoins(extramoney);
    }

    private void setShop() {
        if (hardmode){
            shop = new Shop(hardItems);
        } else {
            shop = new Shop(allItems);
        }
    }

    private void displayOpponents() {
        opponentsView.getItems().clear();
        for (int i = 1; i <= 3; i++) {
            opponentsView.getItems().add(compPlayers.get(compPlayers.size()-i).getFighterClass().getClassName());
        }
    }

    @FXML
    protected void updateCompPlayers(){
        int bosschance = (int) (Math.random()*15);
        if (bosschance == 0){
            compPlayers.add(new Player(boss1, p1, "Stomp-Chomp"));
        } else if (bosschance == 1) {
            compPlayers.add(new Player(boss2, p1, "Fire Stalker"));
        } else {
            Random random = new Random();
            int index = random.nextInt(fighterclasses.length);
            compPlayers.add(new Player(fighterclasses[index], p1));
        }
    }

    @FXML
    protected void printStats(ListView listview, Player player){
        ArrayList<String> tempArray = new ArrayList<>();
        tempArray.add("Name: " + player.getName());
        tempArray.add("Strength: " + p1.getAttributes()[0]);
        tempArray.add("Speed: " + p1.getAttributes()[1]);
        tempArray.add("Health: " + p1.getAttributes()[2]);
        tempArray.add("Defense: " + p1.getAttributes()[3]);
        tempArray.add("Class: " + player.getFighterClass().getClassName());
        tempArray.add("Attacks: ");
        for (Attack attack: player.getFighterClass().getAttacks()) {
            tempArray.add(attack.getAttackName() + "," + attack.getAttackDamage() + "  ");
        }
        tempArray.add("Level: " + player.getPlayerlevel());
        tempArray.add("Coins: " + player.getCoins());
        tempArray.add("XP: " + player.getXp());

        listview.getItems().clear();
        listview.getItems().addAll(tempArray);
        coinsLabel.setText("Coins: " + p1.getCoins());
    }

    @FXML
    protected void startBattle(){
        turn = 0;
        battleplayer1 = p1;
        int index = opponentsView.getSelectionModel().getSelectedIndex();
        battleplayer2 = compPlayers.get(compPlayers.size()-index-1);
        updateCompPlayers();
        displayOpponents();
        compPlayers.remove(index);
        goToBattleLabel.setVisible(true);

        ArrayList<String> tempList = new ArrayList<>();

        for (Attack attack: battleplayer1.getFighterClass().getAttacks()) {
            tempList.add(attack.getAttackName() + "; Damage: " + attack.getAttackDamage());
        }

        playerAttacks.getItems().clear();
        playerAttacks.getItems().addAll(tempList);
        setbattleVisibility(true);
        compAttackButton.setVisible(true);
        compHealthLabel.setText("COMP Health: " + Math.round(battleplayer2.getAttributes()[2]*100)/100);
        playerHealthLabel.setText("Your Health: " + Math.round(battleplayer1.getAttributes()[2]*100)/100);

        playerPic.setImage(battleplayer1.getFighterClass().getImage());
        compPic.setImage(battleplayer2.getFighterClass().getImage());

        battleResultLabel.setText("The Battle Has Started");
    }

    protected void attack(Player attacker, Player attacked, int attackindex){
        if (attacker.getFighterClass().getAttacks().get(attackindex).getAttackName().equals("Flee")){
            setbattleVisibility(false);
            battleResultLabel.setText("You fled the battle, go fight someone else");
        }
        else if (attacker.getFighterClass().getAttacks().get(attackindex).getAttackName().equals("Strength++")){
            attacker.changeAttributes(0,5);
            battleResultLabel.setText(attacker.getName() + " is stronger now");
        }
        else if (attacker.getFighterClass().getAttacks().get(attackindex).getAttackName().equals("Speed++")){
            attacker.changeAttributes(1,5);
            battleResultLabel.setText(attacker.getName() + " is faster now");
        }
        else if (attacker.getFighterClass().getAttacks().get(attackindex).getAttackName().equals("Health Song")){
            if (hardmode){
                battleResultLabel.setText(attacker.getName() + " can't heal, its hardmode");
            } else {
                attacker.changeAttributes(2, 10);
                battleResultLabel.setText(attacker.getName() + " healed");
            }
        }
        else if (attacker.getFighterClass().getAttacks().get(attackindex).getAttackName().equals("Health++")) {
            if (hardmode){
                battleResultLabel.setText(attacker.getName() + " can't heal, its hardmode");
            } else {
                attacker.changeAttributes(2, 5);
                battleResultLabel.setText(attacker.getName() + " healed");
            }
        }
        else if (attacker.getFighterClass().getAttacks().get(attackindex).getAttackName().equals("Weaken")){
            attacker.changeAttributes(0,-5);
            battleResultLabel.setText(attacker.getName() + " weakened " + attacked.getName());
        }
        else if (attacker.getFighterClass().getAttacks().get(attackindex).getAttackName().equals("Slow")){
            attacked.changeAttributes(1,-5);
            battleResultLabel.setText(attacker.getName() + " slowed " + attacked.getName());
        }
        else {
            int damagechance = (int) (Math.random() * 25);
            double damagemultiplier = 1;

            if (damagechance == 0) {
                damagemultiplier = 0;
            }
            if (damagechance == 1) {
                damagemultiplier = 1.5;
            }

            int turnsSinceUsed = turn - attacker.getFighterClass().getAttacks().get(attackindex).getLastused();

            if (turnsSinceUsed < attacker.getFighterClass().getAttacks().get(attackindex).getCooldown()){
                battleResultLabel.setText(attacker.getName() + " missed because their cooldown wasn't over");
            }

            double damage = attacker.getFighterClass().getAttacks().get(attackindex).getAttackDamage() * damagemultiplier * attacker.getPlayerlevel();
            double damageDealt = attacked.getAttributes()[3]/15 - damage * attacker.getAttributes()[0] / 50 * attacker.getAttributes()[1] / 50 + selectedWeapon.getDamage() / 10;
            damageDealt = Math.round(damageDealt*100)/100;
            attacked.changeAttributes(2, (damageDealt));

            if (damagemultiplier == 0){
                battleResultLabel.setText(attacker.getName() + " missed");
            } else if (damagemultiplier == 1.5) {
                battleResultLabel.setText(attacker.getName() + " did a critical hit - " + damageDealt + " damage");
            } else {
                battleResultLabel.setText(attacker.getName() + " did " + damageDealt + " damage");
            }

            if (attacked.getAttributes()[2] < 0){
                attacked.setAttributes(2,0);
            }
        }

        if (battleplayer1.getAttributes()[2] > 200){
            battleplayer1.setAttributes(2,200);
        }
        if (battleplayer2.getAttributes()[2] > 200){
            battleplayer2.setAttributes(2,200);
        }

        compHealthLabel.setText("COMP Health: " + battleplayer2.getAttributes()[2]);
        playerHealthLabel.setText("Your Health: " + battleplayer1.getAttributes()[2]);

        playerHealthBar.setProgress(battleplayer1.getAttributes()[2]/200);
        compHealthBar.setProgress(battleplayer2.getAttributes()[2]/200);

        if (checkDead()){
            setbattleVisibility(false);
            compAttackButton.setVisible(false);
            if (battleplayer2.getAttributes()[2]<=0){
                if (battleplayer2.getFighterClass().getClassName() == "boss1"){
                    p1.changeCoins(40*turn);
                    p1.changeXp(25*turn);
                    battleResultLabel.setText("You won the boss battle!  GOOD JOB! You earned " + (40 * turn) + " xp & " + (25 * turn) + "coins");
                } else if (battleplayer2.getFighterClass().getClassName() == "boss2"){
                    p1.changeCoins(50*turn);
                    p1.changeXp(30*turn);
                    battleResultLabel.setText("You won the boss battle!  GOOD JOB! You earned " + (50 * turn) + " xp & " + (30 * turn) + "coins");
                } else {
                    p1.changeCoins(15*turn);
                    p1.changeXp(25*turn);
                    battleResultLabel.setText("You won the battle! You earned " + (25 * turn) + " xp & " + (15 * turn) + "coins");
                }
                while (p1.getXp() >= 300) {
                    p1.changePlayerlevel(1);
                    p1.changeXp(-300);
                }
            }

            if (battleplayer1.getAttributes()[2]<=0){
                battleResultLabel.setText("You died! Go back to the Setup Tab!");
                extramoney = 200;
            }
        }
        printStats(playerStats, p1);
        coinsLabel.setText("Coins: " + p1.getCoins());
    }

    private void setbattleVisibility(boolean visibility) {
        compHealthLabel.setVisible(visibility);
        compHealthBar.setVisible(visibility);
        compPic.setVisible(visibility);
        compLabel.setVisible(visibility);
        playerHealthLabel.setVisible(visibility);
        playerHealthBar.setVisible(visibility);
        playerPic.setVisible(visibility);
        playerLabel.setVisible(visibility);
        playerInventoryLabel.setVisible(visibility);
        playerInventory.setVisible(visibility);
        playerAttackLabel.setVisible(visibility);
        playerAttacks.setVisible(visibility);
    }

    private boolean checkDead() {
        if (battleplayer1.getAttributes()[2]<=0){
            return true;
        } else if (battleplayer2.getAttributes()[2]<=0){
            return true;
        }
        return false;
    }

    @FXML
    public void showCompStats() {
        int index = opponentsView.getSelectionModel().getSelectedIndex();
        Player selectedPlayer = compPlayers.get(compPlayers.size()-index-1);
        printStats(opponentsStats, selectedPlayer);
    }

    public void useItem() {
        int index = inventoryView.getSelectionModel().getSelectedIndex();

        if (p1.getInventory().getItemsOwned().get(index).getItem().getDamage() > 0){
            selectedWeapon = p1.getInventory().getItemsOwned().get(index).getItem();
        } else {
            p1.changeAttributes(1, p1.getInventory().getItemsOwned().get(index).getItem().getSpeed());
            p1.changeAttributes(2, p1.getInventory().getItemsOwned().get(index).getItem().getHealing());
            p1.changeAttributes(3, p1.getInventory().getItemsOwned().get(index).getItem().getDefense());
            p1.getInventory().getItemsOwned().get(index).changeNumItems(-1);
            if (p1.getInventory().getItemsOwned().get(index).getNumItems() == 0) {
                p1.getInventory().getItemsOwned().remove(index);
            }
        }

        displayItems();
    }

    public void useItem1() {
        int index = inventoryView1.getSelectionModel().getSelectedIndex();

        if (p1.getInventory().getItemsOwned().get(index).getItem().getDamage() > 0){
            selectedWeapon = p1.getInventory().getItemsOwned().get(index).getItem();
        } else {
            p1.changeAttributes(1, p1.getInventory().getItemsOwned().get(index).getItem().getSpeed());
            p1.changeAttributes(2, p1.getInventory().getItemsOwned().get(index).getItem().getHealing());
            p1.changeAttributes(3, p1.getInventory().getItemsOwned().get(index).getItem().getDefense());
            p1.getInventory().getItemsOwned().get(index).changeNumItems(-1);
            if (p1.getInventory().getItemsOwned().get(index).getNumItems() == 0) {
                p1.getInventory().getItemsOwned().remove(index);
            }
        }

        displayItems();
    }

    public void useItem2() {
        int index = playerInventory.getSelectionModel().getSelectedIndex();

        if (p1.getInventory().getItemsOwned().get(index).getItem().getDamage() > 0){
            selectedWeapon = p1.getInventory().getItemsOwned().get(index).getItem();
        } else {
            p1.changeAttributes(1, p1.getInventory().getItemsOwned().get(index).getItem().getSpeed());
            p1.changeAttributes(2, p1.getInventory().getItemsOwned().get(index).getItem().getHealing());
            p1.changeAttributes(3, p1.getInventory().getItemsOwned().get(index).getItem().getDefense());
            p1.getInventory().getItemsOwned().get(index).changeNumItems(-1);
            if (p1.getInventory().getItemsOwned().get(index).getNumItems() == 0) {
                p1.getInventory().getItemsOwned().remove(index);
            }
        }

        displayItems();
    }

    public void displayItems() {
        inventoryView.getItems().clear();
        for (OwnedItems item: p1.getInventory().getItemsOwned()) {
            inventoryView.getItems().add(item.getItem().getName() + "; Number: " + item.getNumItems());
        }

        inventoryView1.getItems().clear();
        for (OwnedItems item: p1.getInventory().getItemsOwned()) {
            inventoryView1.getItems().add(item.getItem().getName() + "; Number: " + item.getNumItems());
        }

        playerInventory.getItems().clear();
        for (OwnedItems item: p1.getInventory().getItemsOwned()) {
            playerInventory.getItems().add(item.getItem().getName() + "; Number: " + item.getNumItems());
        }

        statsView.getItems().clear();
        statsView.getItems().add("Strength: " + p1.getAttributes()[0]);
        statsView.getItems().add("Speed: " + p1.getAttributes()[1]);
        statsView.getItems().add("Health: " + p1.getAttributes()[2]);
        statsView.getItems().add("Defense: " + p1.getAttributes()[3]);
    }

    public void buyItem() {
        int index = shopView.getSelectionModel().getSelectedIndex();
        int price = shop.getCurrentList().get(index).getShopPrice();

        if (p1.getCoins()>=price){
            Items tempItem = shop.getCurrentList().get(index);

            boolean owned = false;

            for (OwnedItems items: p1.getInventory().getItemsOwned()) {
                if (items.getItem() == tempItem){
                    owned = true;
                }
            }

            if (owned){
                for (OwnedItems items: p1.getInventory().getItemsOwned()) {
                    if (items.getItem() == tempItem){
                        items.changeNumItems(1);
                    }
                }
            } else {
                p1.getInventory().addItem(new OwnedItems(tempItem));
            }
            p1.changeCoins(price*-1);
        } else {
            System.out.println("Not enough Money");
        }

        displayItems();
        coinsLabel.setText("Coins: " + p1.getCoins());
    }

    public void attack() {
        if (!checkDead()) {
            attack(battleplayer1, battleplayer2, playerAttacks.getSelectionModel().getSelectedIndex());
        }
        turn++;
        setbattleVisibility(false);
    }
    public void compAttack() {
        int attackindex = (int) (Math.random() * 5);
        System.out.println(attackindex);
        if (!checkDead()) {
            attack(battleplayer2, battleplayer1, attackindex);
        }
        setbattleVisibility(true);
    }


    public void refreshShop() {
        shop.randomizeShop(shopView);
        printStats(playerStats, p1);
        coinsLabel.setText("Coins: " + p1.getCoins());
    }

    public void setHardMode() {
        this.hardmode = true;
    }
}