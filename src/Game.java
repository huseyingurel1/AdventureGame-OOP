import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println(" Welcome to Adventure Game! ");
        System.out.println(" Please enter your name  :  ");

        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

//        Player player = new Player("Hüseyin");

        System.out.println(player.getName() + ", I want to play game with you ! Are you ready ? ");

        System.out.println("Select a character for start the game");

        player.selectChar();

        Location location = null;

        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("################## Locations ################## ");
            System.out.println();
            System.out.println("1- SafeHouse  --> It's safe for you here, there are no enemies here ");
            System.out.println("2- ToolStore  --> You can buy weapons or armor here ");
            System.out.println("3- Cave  --> Award <Food> , Be careful, the zombie may come out ! ");
            System.out.println("4- Forest  --> Award <Firewood> , Be careful, the vampire may come out ! ");
            System.out.println("5- River  --> Award <Water> , Be careful, the bear may come out ! ");
            System.out.println("0- EXIT  --> Exit The Game ");
            System.out.println("Please select the location you want to go to :  ");
            int selectLoc = scanner.nextInt();

            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                case 3 :
                    location = new Cave(player);
                    break;
                case 4 :
                    location = new Forest(player);
                    break;
                case 5 :
                    location = new River(player);
                    break;
                default:
                    System.out.println("Please Enter A Valid Number !");
            }

            if(location == null){
                System.out.println("Game Ended");
                break;
            }

            if(!location.onLocation())
            {
                System.out.println("Game Over!");
                break;
            }
        }
    }
}
