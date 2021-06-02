import controller.Controller;
import entities.Game;
import entities.Link;
import entities.Player;
import run.Run;
import graphics.Screen;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Cria a tela do game
        Screen screen = new Screen(1080, 720, "Meu Primeiro Game");
        screen.create();
        screen.configure(false, true);
        screen.close();

        // Execução sem threads
        //screen.run();

        // Executa o game com threads
        Run run = new Run(screen);
        run.start();
    }
}
