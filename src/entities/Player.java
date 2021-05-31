package entities;

import interfaces.Action;

import java.io.Serializable;

public abstract class Player implements Action, Serializable {
    private final static long serialVersionUID = 1L;

    private String name;
    private int hp;
    private int force;
    private int speed;

    public Player(String name, int hp, int force, int speed) {
        this.name = name;
        this.hp = hp;
        this.force = force;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
