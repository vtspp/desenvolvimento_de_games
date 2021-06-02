package graphics;

import controller.Controller;
import entities.Game;
import entities.Link;
import entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class Screen extends Canvas implements Runnable{

        private int width;
        private int height;
        private String title;
        private JFrame jFrame;
        private Graphics graphics;
        private Sprite sprite;
        private int position;
        private float frame = 0;
        private  float maxFrames = 1.5f;
        private  int animation = 0;
        private final int maxAnimation = 1044;

        private List<Player> players;
        private Game game;

        public Screen (int width, int height, String title) {
            jFrame = new JFrame(title);
            this.width = width;
            this.height = height;
            this.title = title;
        }

        public void create () {
            this.setPreferredSize(new Dimension(this.width, this.height));
            jFrame.add(this);
        }

        public void configure (boolean resize, boolean visible) {
            jFrame.setResizable(resize);
            jFrame.setVisible(visible);
            jFrame.setLocationRelativeTo(this);
            jFrame.pack();
        }

        public void update () {

            if (isNull(players)) {
                players = new ArrayList<>();
                players.add(new Link("Link", 100, 70, 1));
            }

            if (isNull(game)) new Game(this, new Controller(players), players);

            frame += 0.5f;
            if (frame > maxFrames) {
                frame = 0;

                int walk = players.get(0).walk();

                if (walk >= 1) {
                    animation += 116;
                    position ++;
                }
                if (walk <= -1) {
                    animation = 464;
                    position --;
                }

                if (walk == 0) animation = 464;

                if (animation == maxAnimation) {
                    animation =  0;
                }
            }
        }

        public void clean () {
            graphics.setColor(new Color(255, 255, 255));
            graphics.fillRect(0,0,width, height);
        }

        public void render () {
            BufferStrategy bufferStrategy = this.getBufferStrategy();

            if (isNull(bufferStrategy)) {
                this.createBufferStrategy(3);
                return;
            }

            if (isNull(graphics)) graphics = bufferStrategy.getDrawGraphics();

            if (isNull(sprite)) sprite = new Sprite("/images/link.png");

            graphics.drawImage(sprite.getImageByPosition(animation,0, 116, 116), position, 300,null);

            bufferStrategy.show();

            clean(); // Limpa a tela
        }

        public void close () {
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

    @Override
    public void run() {
            double frame = 0.0D;
            double seconds = 0;
            double numberOfFrames = 60.0D;
            double ns = 1000000000 / numberOfFrames;
            long lastTime = System.nanoTime();
            long time = System.currentTimeMillis();

        while (true) {
            long now = System.nanoTime();
            seconds += (now - lastTime) / ns;
            lastTime = now;

            if (seconds >= 1) {

                update(); // Atualiza o game
                render(); // Render

                frame++;
                seconds--;
            }
            if (System.currentTimeMillis() - time >= 1000) {
                System.out.println("FPS: " + frame);
                frame = 0;
                time += 1000;
            }
        }
    }
}