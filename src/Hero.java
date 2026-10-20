import java.util.ArrayList;

public class Hero extends GameCharacter {
    private ArrayList<Item> inventory;
    private Weapon mainWeapon;
    public Hero() {
        inventory=new ArrayList<>();
        inventory.add(new Sword());
        inventory.add(new Bow());
        maxHealth=200;
        currentHealth=200;
        baseStrength=20;
        equip((Weapon) inventory.get(0));
    }
    public void equip(Weapon weapon){
        this.mainWeapon=weapon;
        this.currentStrength =this.baseStrength+weapon.getDamage();
    }
    public void swapWeapon(){
        if (mainWeapon instanceof Sword){
            equip((Weapon) inventory.get(1));
        } else{
            equip((Weapon) inventory.get(0));
        }
    }
    public void showAllInventory(){
        for (Item item:inventory){
            System.out.println(item.toString());
        }
    }
    public void attackEnemy(GameCharacter gameCharacter){
        if (this.mainWeapon != null) {
            this.mainWeapon.attack(this, gameCharacter);
        }
    }
}
