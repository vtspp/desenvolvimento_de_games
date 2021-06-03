package entities;

public class Link extends Player {

    public Link(String name, int hp, int force, int speed) {
        super(name, hp, force, speed);
    }


    @Override
    public boolean right() {
        return isRight();
    }

    @Override
    public boolean left() {
        return isLeft();
    }

    @Override
    public boolean up() {
        return isUp();
    }

    @Override
    public boolean down() {
        return isDown();
    }

    @Override
    public boolean run() {
        return isRun();
    }

    @Override
    public boolean jump() {
        return isJump();
    }

    @Override
    public boolean attack() {
        return isAttack();
    }
}
