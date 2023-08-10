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
        String selectCase = scanner.nextLine().toUpperCase();
        if(selectCase.equals("F") && combat(obsNum)){
           System.out.println(this.getName() + " tüm düşmanları yendiniz !");
           return true;
        }

        if(this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz !");
            return false;
        }
        return true;

    }

    public boolean combat(int obsNum){
        for (int i=1; i <=obsNum; i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStatus();
            obstacleStatus(i);
            while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth() >0){
                System.out.println("<H>it or <M>ove away  : ");
                String selectCombat = scanner.nextLine().toUpperCase();
                if("H".equals(selectCombat)){
                    System.out.println("You Shot !");
                    obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + "  hit you !" );
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
                        if(obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz !");
                System.out.println(this.getObstacle().getAward() + " para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Your Healt:" + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "'s  Healt:" + this.getObstacle().getHealth());
        System.out.println("-----------------");
    }
    public void playerStatus(){
         this.getPlayer().printInfo();
    }
    public void obstacleStatus(int i){
         this.getObstacle().printInfo(i);
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
