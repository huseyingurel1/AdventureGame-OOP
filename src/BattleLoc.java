
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
        if(  (this.getPlayer().getInventory().isFood() && this.getObstacle().getId() ==1) ||
             (this.getPlayer().getInventory().isFirewood() && this.getObstacle().getId() ==2) ||
             (this.getPlayer().getInventory().isWater() && this.getObstacle().getId() ==3)
        ){
            System.out.println("Bu bölgenin ödülü zaten alındı ! Lütfen başka bir bölge seçiniz !");
            return true ;
        }else {
            int obsNum = this.randomObstacleNumber();
            String pluralSuffix = "s";
            if (obsNum == 1) {
                pluralSuffix = "";
            }
            System.out.println("You are in the " + this.getName());
            System.out.println("Be careful !! There are " + obsNum + " " + this.getObstacle().getName() + pluralSuffix + " here!!");

            System.out.println("<F>ight or <M>ove away");
            String selectCase = scanner.nextLine().toUpperCase();
            if (selectCase.equals("F") && combat(obsNum)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz !");
                if (this.getObstacle().getId() == 1) {
                    this.getPlayer().getInventory().setFood(true);
                    System.out.println("Magara ödülü alindi(Yemek)");
                } else if (this.getObstacle().getId() == 2) {
                    this.getPlayer().getInventory().setFirewood(true);
                    System.out.println("Orman ödülü alindi(Odun)");
                } else if (this.getObstacle().getId() == 3) {
                    this.getPlayer().getInventory().setWater(true);
                    System.out.println("Nehir ödülü alindi(Su)");
                }

                return true;
            }

            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Öldünüz !");
                return false;
            }
            return true;
        }
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
                    Random r = new Random();
                    int randomHitNum =r.nextInt(2);

                    if(randomHitNum == 1){
                        System.out.println("You Shot !");
                        obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    }else{
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
                    }
                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                if(this.getObstacle().getName().equals("Snake")){
                    System.out.println("Yılanı yendiniz, Rastgele ganimet seçiliyor ...");
                    String kazanilanUrun = randomLoot();
                    System.out.println("***********************************************");
                    System.out.println("************ KAZANILAN EŞYA *******************");
                    System.out.println("            "+ kazanilanUrun + "               ");
                    System.out.println("***********************************************");

                }else{
                    System.out.println("Düşmanı Yendiniz !");
                    System.out.println(this.getObstacle().getAward() + " para kazandınız !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
                }
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
    public String randomLoot(){
        String esya;
        Random r = new Random();
        int randomNumber = r.nextInt(100) + 1;
        int randomNumber2 = r.nextInt(100) + 1;
        System.out.println(randomNumber);
        System.out.println(randomNumber2);

        if(randomNumber <=15){
            System.out.println("weapon %15");
            if(randomNumber2 <=20){
                esya= "Tüfek";
            } else if (randomNumber2<=50) {
                esya= "Kılıç";
            }else {
                esya= "Tabanca";
            }
        } else if(randomNumber <=30){
            System.out.println("armor %15");
            if(randomNumber2 <=20){
                esya= "Ağır Zırh";
            } else if (randomNumber2<=50) {
                esya= "Orta Zırh";
            }else {
                esya= "Hafif Zırh";
            }
        } else if(randomNumber <=55){
            System.out.println("gold %15");
            if(randomNumber2 <=20){
                esya= "10 Para";
            } else if (randomNumber2<=50) {
                esya= "5 Para";
            }else {
                esya= "1 Para";
            }
        }else{
            esya= "nothing";
        }
        return esya;
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
