public class Armor {
    private int id;
    private String name;
    private int defence;
    private int price;

    public Armor(int id, String name, int defence, int price) {
        this.id = id;
        this.name = name;
        this.defence = defence;
        this.price = price;
    }
    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"Basic armor   ",1,15);
        armorList[1] = new Armor(2,"Average armor ",3,25);
        armorList[2] = new Armor(3,"Advanced armor",5,40);

        return armorList;
    }

    public static Armor getArmorById(int id){
        for (Armor a : Armor.armors()){
            if(a.getId() == id){
                return a;
            }
        }
        return null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
