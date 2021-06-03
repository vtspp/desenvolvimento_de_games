package controller;

import entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Controller  implements KeyListener {

    private Player player;

    public Controller(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_RIGHT:
            case VK_D:
                player.setRight(true);
                break;

            case VK_LEFT:
            case VK_A:
                player.setLeft(true);
                break;

            case VK_DOWN:
            case VK_X:
                player.setDown(true);
                break;

            case VK_UP:
            case VK_W:
                player.setUp(true);
                break;

            case VK_R:
                player.setRun(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_RIGHT:
            case VK_D:
                player.setRight(false);
                break;

            case VK_LEFT:
            case VK_A:
                player.setLeft(false);
                break;

            case VK_DOWN:
            case VK_X:
                player.setDown(false);
                break;

            case VK_UP:
            case VK_W:
                player.setUp(false);
                break;

            case VK_R:
                player.setRun(false);
                break;
        }
    }
}
