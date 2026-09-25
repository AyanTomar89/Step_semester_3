class Character {
    private int health;
    private final int maxHealth;

    Character(int max) {
        maxHealth = max;
        health = max;
    }

    void takeDamage(int x) {
        health = Math.max(0, health - x);
    }

    void heal(int x) {
        health = Math.min(maxHealth, health + x);
    }

    int getHealth() {
        return health;
    }
}

public class HealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println(c.getHealth());
        c.heal(50);
        System.out.println(c.getHealth());
        c.takeDamage(150);
        System.out.println(c.getHealth());
    }
}