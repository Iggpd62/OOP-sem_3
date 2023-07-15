public class Character {    protected String name;
    protected int health;
    protected int speed;

    public Character(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public void attack() {
        System.out.println(name + " наносит удар!");
    }

    public void defend() {
        System.out.println(name + " защищается!");
    }

    public void move() {
        System.out.println(name + " двигается!");
    }
}
