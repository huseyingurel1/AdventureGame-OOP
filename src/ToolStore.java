public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------ Welcome to ToolStore ! ------");
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
            // TODO: 5/6/2023 print methodları yazılacak
            case 1 :
                printWeapons();
                break;
            case 2 :
//                printArmors();
                break;
            case 3 :
                System.out.println("exit kodu yazılacak");
                break;
            default :
        }
        return true;
    }

    public void printWeapons(){
        System.out.println("################## Weapons #####################");
        for(Weapon w : Weapon.weapons()){
            System.out.println("< ID : " + w.getId() + "\tName : "+  w.getName() + "\t< Damage : "+ w.getDamage() + "\t Price : "+ w.getPrice() + " >");
        }
    }
}
