public class GameCharacter {
    protected int maxHealth;
    protected int currentHealth;
    protected int baseStrength;
    protected int currentStrength;

    public String getStatus(){
        return "GameCharacter{" +
                "maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", baseStrength=" + baseStrength +
                ", currentStrength=" + currentStrength +
                '}';
    }
}
