import run.Run;
import graphics.Screen;

public class Application {

    public static void main(String[] args) {
        // Cria a tela do game
        Screen screen = new Screen(1080, 720, "Meu Primeiro Game");
        screen.create();
        screen.configure(false, true);
        screen.close();
        //screen.run();

        // Executa o game com threads
        Run run = new Run(screen);
        run.start();
    }
}
