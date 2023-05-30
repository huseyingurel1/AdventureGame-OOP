public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------ Welcome to ToolStore ! ------");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.println("Your choice : ");
            int selectCase = scanner.nextInt();
            while( selectCase < 1 && selectCase > 3){
                System.out.println("Invalid choice, please try again : ");
                selectCase = scanner.nextInt();
            }

            switch(selectCase){
                case 1 :
                    printWeapons();
                    buyWeapon();
                    break;
                case 2 :
                    printArmors();
                    buyArmor();
                    break;
                case 3 :
                    System.out.println("Have a nice day "+this.getPlayer().getCharName() + " " + this.getPlayer().getName());
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapons(){
        System.out.println("################## Weapons #####################");
        for(Weapon w : Weapon.weapons()){
            System.out.println(
                    "< ID : " + w.getId() +
                    "\tName : "+  w.getName() +
                    "\t< Damage : "+ w.getDamage() +
                    "\t Price : "+ w.getPrice() + " >");
        }
        System.out.println("0 - EXIT");
    }
    public void buyWeapon(){

        System.out.println("Please select a weapon :");

        int selectWeaponID = scanner.nextInt();
        while( selectWeaponID < 0 && selectWeaponID > Weapon.weapons().length){
            System.out.println("Invalid choice, please try again : ");
            selectWeaponID = scanner.nextInt();
        }
        if(selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println(" You don't have enough money for this weapon !");
                } else {
                    System.out.println(selectedWeapon.getName() + "  has been purchased ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your remaining money is : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("New weapon  " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmors(){
        System.out.println("################## Armors #####################");
        for(Armor a : Armor.armors()){
            System.out.println(
                    "< ID : " + a.getId() +
                    "\tName : "+  a.getName() +
                    "\t< Defence : "+ a.getDefence() +
                    "\t Price : "+ a.getPrice() + " >");
        }
        System.out.println("0 - EXIT");

    }

    public void buyArmor(){
        System.out.println("Please select a armor :");

        int selectArmorID = scanner.nextInt();
        while( selectArmorID < 0 && selectArmorID > Armor.armors().length){
            System.out.println("Invalid choice, please try again : ");
            selectArmorID = scanner.nextInt();
        }

        if(selectArmorID != 0){

            Armor selectedArmor = Armor.getArmorById(selectArmorID);

            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println(" You don't have enough money for this armor !");
                }else {
                    System.out.println(selectedArmor.getName() + "  has been purchased ");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your remaining money is : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("New armor  " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }
}
