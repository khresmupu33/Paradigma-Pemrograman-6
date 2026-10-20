import java.util.ArrayList;
import java.util.Scanner;

public class GameMap {
    private boolean endGame = false;
    private Hero hero;
    private ArrayList<Monster> monsterGraveyard;

    public GameMap() {
        hero = new Hero();
        monsterGraveyard = new ArrayList<>();
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        int defeatedMonstersCount = 0;

        while (!endGame) {
            // Cek kondisi kalah
            if (hero.currentHealth <= 0) {
                System.out.println("Hero has been defeated. You lose!");
                endGame = true;
                break;
            }

            // Cek kondisi menang (setelah berhasil membunuh 3 monster)
            if (defeatedMonstersCount >= 3) {
                System.out.println("You have defeated all monsters.");
                endGame = true;
                break;
            }

            // Musuh selalu muncul kapan saja (tanpa kondisi acak/Math.random < 0.3)
            System.out.println("\nMonster found. Prepare for battle.");
            Monster monster = generateMonster();
            battle(hero, monster);

            // Cek jika monster berhasil dikalahkan di dalam battle
            if (monster.currentHealth <= 0) {
                System.out.println("You have defeated a monster!");
                monsterGraveyard.add(monster);
                defeatedMonstersCount++;
            }
        }
        scanner.close();
    }

    private void battle(Hero hero, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        while (hero.currentHealth > 0 && monster.currentHealth > 0) {
            System.out.println("\n[1] Attack enemy");
            System.out.println("[2] Swap weapon");
            System.out.println("[3] Show inventory");
            System.out.println("[4] Show status");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hero.attackEnemy(monster);
                    if (monster.currentHealth > 0) {
                        monster.attackEnemy(hero);
                    }
                    break;
                case 2:
                    hero.swapWeapon();
                    break;
                case 3:
                    hero.showAllInventory();
                    break;
                case 4:
                    System.out.println(hero.getStatus());
                    System.out.println(monster.getStatus());
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

            if (hero.currentHealth <= 0 || monster.currentHealth <= 0) {
                break;
            }
        }
    }

    public Monster generateMonster() {
        int health = 50 + (int) (Math.random() * 50);
        int strength = 5 + (int) (Math.random() * 10);
        boolean isFlying = Math.random() < 0.5;
        return new Monster(health, strength, isFlying);
    }

    public static void main(String[] args) {
        GameMap game = new GameMap();
        game.runGame();
    }
}