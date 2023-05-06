import javax.sound.midi.Soundbank;

public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the SafeHouse !");
        System.out.println("Your health is renewed !");
        return true;
    }
}
