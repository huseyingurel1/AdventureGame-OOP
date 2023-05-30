import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private int health;
    private int money;
    private String charName;

    private Scanner scanner = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("\n ******  Characters  ******" );
        for( GameChar gameChar : charList){
            System.out.println("ID : " + gameChar.getId() +
                    "\t Character => " + gameChar.getName() +
                    "\t Damage : " + gameChar.getDamage() +
                    "\t Health : "+ gameChar.getHealth() +
                    "\t Money : " + gameChar.getMoney());
        }
        System.out.println("---------------------------------------");
        System.out.print("Enter a character ID : ");

        int selectCharID = scanner.nextInt();
        System.out.println("---------------------------------------");

        switch( selectCharID ){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Selected Character => " + this.getCharName() +
                "\tDamage :" + this.getDamage() +
                "\tHealth :" + this.getHealth()+
                "\tMoney :" + this.getMoney());

    }

    public void initPlayer(GameChar gameChar){
            this.setDamage(gameChar.getDamage());
            this.setHealth(gameChar.getHealth());
            this.setMoney(gameChar.getMoney());
            this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("################ Player Info ################");
        System.out.println(
                "Your Weapon :" +this.getInventory().getWeapon().getName() +
                "\nYour Armor :" + this.getInventory().getArmor().getName() +
                "\nYour Defence :" + this.getInventory().getArmor().getDefence() +
                "\nYour Damage :" + this.getDamage() +
                "\nYour Health :" + this.getHealth()+
                "\nYour Money :" + this.getMoney());
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName){
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
