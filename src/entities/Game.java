package entities;

import controller.Controller;
import graphics.Screen;

import java.util.List;

public class Game {

    private Screen screen;
    private Controller controller;
    private List<Player> players;

    public Game(Screen screen, Controller controller, List<Player> players) {
        this.screen = screen;
        this.controller = controller;
        this.players = players;
        screen.addKeyListener(controller);
    }

    public Screen getScreen() {
        return screen;
    }

    public Controller getController() {
        return controller;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
