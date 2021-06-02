package entities;

public class Link extends Player {

    public Link(String name, int hp, int force, int speed) {
        super(name, hp, force, speed);
    }

    @Override
    public int walk() {
        System.out.println("Link Andou " + getX());
        return getX();
    }

    @Override
    public int run() {
        return 0;
    }

    @Override
    public int jump() {
        return 0;
    }

    @Override
    public int attack() {
        return 0;
    }
}
