package entities;

import controller.Controller;
import interfaces.Action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Action, Serializable {
    private final static long serialVersionUID = 1L;

    private String name;
    private int hp;
    private int force;
    private int speed;
    private int x;
    private int y;
    private Controller controller;
    private List<Player> players = new ArrayList<>();

    public Player(String name, int hp, int force, int speed) {
        this.name = name;
        this.hp = hp;
        this.force = force;
        this.speed = speed;
        this.controller = new Controller(players);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
