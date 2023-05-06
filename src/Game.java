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
            System.out.println();
            System.out.println("############## Locations ##############");
            System.out.println();
            System.out.println("1- SafeHouse  --> It's safe for you here, there are no enemies here ");
            System.out.println("2- ToolStore  --> You can buy weapons or armor here ");
            System.out.println("Please select the location you want to go to :  ");
            int selectLoc = scanner.nextInt();

            switch (selectLoc){
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                case 3 :
                    location = new SafeHouse(player);
            }

            if(!location.onLocation())
            {
                System.out.println("Game Over!");
                break;
            }
        }
    }
}
