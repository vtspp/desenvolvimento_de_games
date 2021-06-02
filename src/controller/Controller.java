package controller;

import entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class Controller  implements KeyListener {

    private List<Player> players;

    private int x;
    private int y;

    public Controller(List<Player> players) {
        this.players = players;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_RIGHT:
            case VK_D:
                players.forEach(player -> player.setX(++x));
                break;

            case VK_LEFT:
            case VK_A:
                players.forEach(player -> player.setX(--x));
                break;

            case VK_DOWN:
            case VK_X:
                players.forEach(player -> player.setY(++y));
                break;

            case VK_UP:
            case VK_W:
                players.forEach(player -> player.setY(--y));
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        x = 0; // Valor inicial que sempre iniciará
        y = 0;
        switch (e.getKeyCode()) {
            case VK_RIGHT:
            case VK_D:
            case VK_LEFT:
            case VK_A:
                players.forEach(player -> player.setX(x));
                break;

            case VK_DOWN:
            case VK_X:
            case VK_UP:
            case VK_W:
                players.forEach(player -> player.setY(y));
                break;
        }
    }
}
