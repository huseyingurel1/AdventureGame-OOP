import java.awt.datatransfer.StringSelection;
import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle,String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNum = this.randomObstacleNumber();
        String pluralSuffix = "s";
        if(obsNum==1){
            pluralSuffix="";
        }
        System.out.println("You are in the " + this.getName());
        System.out.println("Be careful !! There are "+ obsNum + " " +this.getObstacle().getName()+ pluralSuffix + " here!!");

        System.out.println("<F>ight or <M>ove away");
        String selectCase = scanner.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("F")){
            System.out.println("Fight is starting !!");
            //Savaşma İşlemi
        }
        return true;

    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
