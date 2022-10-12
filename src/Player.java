import java.sql.SQLOutput;
import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private int health;
    private int money;
    private String charName;

    private Scanner scanner = new Scanner(System.in);

    public Player(String name){
        this.name = name;
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



    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
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

}
