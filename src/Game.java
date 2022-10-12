import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println(" Welcome to Adventure Game! ");
        System.out.println(" Please enter your name  :  ");

        // String playerName = scanner.nextLine();

        Player player = new Player("Hüseyin");

        System.out.println(player.getName() + "   I want to play game with you ! Are you ready ? ");

        System.out.println("Select a character for start the game");

        player.selectChar();




    }
}
