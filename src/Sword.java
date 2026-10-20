public class Sword extends Item implements Weapon {
    public Sword() {
        this.name = "Sword";
    }

    @Override
    public int getDamage() {
        return 9;
    }

    @Override
    public void attack(GameCharacter character, GameCharacter target) {
        if (target instanceof Monster) {
            Monster monster = (Monster) target;
            if (monster.isFlyingUnit()) {
                System.out.println("Enemy out of range.");
                return;
            }
        }
        int damage =Math.max(0, character.currentStrength - target.currentStrength);
        if (damage < 0) damage = 0;

        target.currentHealth -= damage;
        if (target.currentHealth < 0) target.currentHealth = 0;

        System.out.println("Hero do " + damage + " damage to monster.");
    }

    @Override
    public String toString() {
        return "Name=" + name + ", Attack damage=" + getDamage();
    }
}