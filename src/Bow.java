public class Bow extends Item implements Weapon {
    public Bow() {
        this.name = "Bow";
    }

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public void attack(GameCharacter character, GameCharacter target) {
        int damage =Math.max(0, character.currentStrength - target.currentStrength);
        if (damage < 0) damage = 0;

        target.currentHealth -= damage;
        if (target.currentHealth < 0) target.currentHealth = 0;

        System.out.println("Hero do " + damage + " damage to monster.");
    }

    @Override
    public String toString() {
        return "Name=" + name + ", attack damage=" + getDamage();
    }
}