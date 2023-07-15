import java.util.ArrayList;
import java.util.List;

interface CharacterInterface {
    void step();
    String getInfo();
    Coordinates getCoordinates();
}

class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

abstract class BaseHero implements CharacterInterface {
    protected String name;
    protected int health;
    protected int speed;
    protected Coordinates coordinates;

    public BaseHero(String name, int health, int speed, int x, int y) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.coordinates = new Coordinates(x, y);
    }

    public abstract void step();

    public String getInfo() {
        return getClass().getSimpleName();
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
}

class Peasant extends BaseHero {
    public Peasant(String name, int health, int speed, int x, int y) {
        super(name, health, speed, x, y);
    }

    public void step() {
        System.out.println(name + " делает шаг!");
    }
}

class Rogue extends BaseHero {
    public Rogue(String name, int health, int speed, int x, int y) {
        super(name, health, speed, x, y);
    }

    public void step() {
        System.out.println(name + " делает шаг!");
    }
}

public class Main {
    public static void main(String[] args) {
        List<CharacterInterface> heroes1 = new ArrayList<>();
        List<CharacterInterface> heroes2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            heroes1.add(new Peasant("Крестьянин " + (i + 1), 100, 5, i, i));
            heroes2.add(new Rogue("Разбойник " + (i + 1), 150, 10, i, i));
        }

        CharacterInterface closestEnemy = null;
        double closestDistance = Double.MAX_VALUE;

        for (CharacterInterface hero : heroes1) {
            for (CharacterInterface enemy : heroes2) {
                double distance = calculateDistance(hero, enemy);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestEnemy = enemy;
                }
            }
        }

        if (closestEnemy != null) {
            System.out.println("Наиболее приближенный противник:");
            System.out.println("Имя: " + closestEnemy.getInfo());
            System.out.println("Расстояние: " + closestDistance);
        }
    }

    public static double calculateDistance(CharacterInterface c1, CharacterInterface c2) {
        int dx = c2.getCoordinates().getX() - c1.getCoordinates().getX();
        int dy = c2.getCoordinates().getY() - c1.getCoordinates().getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}