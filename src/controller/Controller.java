package controller;

import entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class Controller  implements KeyListener {

    private List<Player> players;

    public Controller(List<Player> players) {
        this.players = players;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = 0;
        int y = 0;
        int result;

        switch (e.getKeyCode()) {
            case VK_RIGHT:
                 result = ++x;
                players.forEach(player -> player.setX(result));
                System.out.println("Direita");
                break;
            case VK_D:
                result = ++x;
                players.forEach(player -> player.setX(result));
                System.out.println("Right");
                break;
            case VK_LEFT:
                result = --x;
                players.forEach(player -> player.setX(result));
                System.out.println("Esquerda");
                break;
            case VK_A:
                result = --x;
                players.forEach(player -> player.setX(result));
                System.out.println("Left");

                break;
            case VK_DOWN:
                result = ++y;
                players.forEach(player -> player.setY(result));
                System.out.println("Baixo");
                break;
            case VK_X:
                result = --y;
                players.forEach(player -> player.setY(result));
                System.out.println("Down");
                break;
            case VK_UP:
                result = --y;
                players.forEach(player -> player.setY(result));
                System.out.println("Cima");
                break;
            case VK_W:
                result = --y;
                players.forEach(player -> player.setY(result));
                System.out.println("Up");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int w = 0;
        int z = 0;
        int result;

        switch (e.getKeyCode()) {
            case VK_RIGHT:
                result = ++w;
                players.forEach(player -> player.setX(result));
                System.out.println("Direita");
                break;
            case VK_D:
                result = ++w;
                players.forEach(player -> player.setX(result));
                System.out.println("Right");
                break;
            case VK_LEFT:
                result = --w;
                players.forEach(player -> player.setX(result));
                System.out.println("Esquerda");
                break;
            case VK_A:
                result = --w;
                players.forEach(player -> player.setX(result));
                System.out.println("Left");

                break;
            case VK_DOWN:
                result = ++z;
                players.forEach(player -> player.setY(result));
                System.out.println("Baixo");
                break;
            case VK_X:
                result = --z;
                players.forEach(player -> player.setY(result));
                System.out.println("Down");
                break;
            case VK_UP:
                result = --z;
                players.forEach(player -> player.setY(result));
                System.out.println("Cima");
                break;
            case VK_W:
                result = --z;
                players.forEach(player -> player.setY(result));
                System.out.println("Up");
                break;
        }
    }
}
