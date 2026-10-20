public class Monster extends GameCharacter {
    private boolean flyingUnit;

    public Monster(int maxHealth, int baseStrength, boolean flyingUnit) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.baseStrength = baseStrength;
        this.currentStrength = baseStrength;
        this.flyingUnit = flyingUnit;
    }

    public boolean isFlyingUnit() {
        return flyingUnit;
    }

    public void setFlyingUnit(boolean flyingUnit) {
        this.flyingUnit = flyingUnit;
    }

    public void attackEnemy(GameCharacter gameCharacter) {
       int damage = (int) (Math.random() * this.currentStrength * 3);
        gameCharacter.currentHealth -= damage;
        if (gameCharacter.currentHealth < 0) gameCharacter.currentHealth = 0;

        System.out.println("Monster do " + damage + " damage to hero.");
    }
}