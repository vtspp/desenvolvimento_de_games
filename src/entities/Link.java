package entities;

public class Link extends Player {

    public Link(String name, int hp, int force, int speed) {
        super(name, hp, force, speed);
    }

    @Override
    public Integer walk() {
        return getX();
    }

    @Override
    public Integer run() {
        return 0;
    }

    @Override
    public Integer jump() {
        return 0;
    }

    @Override
    public Integer attack() {
        return 0;
    }
}
