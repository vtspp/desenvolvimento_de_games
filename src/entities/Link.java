package entities;

public class Link extends Player {

    public Link(String name, int hp, int force, int speed) {
        super(name, hp, force, speed);
    }

    @Override
    public int walk() {
        return getX();
    }

    @Override
    public boolean run() {
        return isRun();
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
