package graphics;

import controller.Controller;
import entities.Link;
import entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static java.util.Objects.isNull;
import static util.Direction.*;

public class Screen extends Canvas implements Runnable{

        private int width;
        private int height;
        private int positionX;
        private int positionY;
        private int direction;
        private float frame;
        private  float maxFrames = 1f;
        private  int animation;
        private int maxAnimation;
        private JFrame jFrame;
        private BufferStrategy bufferStrategy;
        private Graphics graphics;
        private Sprite sprite;
        private Player player;
        private Controller controller;

        public Screen (int width, int height, String title) {
            jFrame = new JFrame(title);
            this.width = width;
            this.height = height;
            initialize();
        }

        public void initialize () {

            if (isNull(player)) {
                player = new Link("Link", 100, 70, 1);
            }

            if (isNull(controller)) controller = new Controller(player);

            this.addKeyListener(controller); // Inicializa os controles

            if (isNull(sprite)) sprite = new Sprite("/images/link.png");
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

            /**
             * @Author: Victor Pinho
             * @Since: 06/06/2021
             *
             * Observações:
             * Levando em conta um conjunto de sprite de 116 x 116.
             *
             * @param animation : Posição x em relação o conjunto de sprites, onde o primeiro está em 0.
             * @param direction : Posição y em relação o conjunto de sprites, onde o primeiro está em 0. Cada posição y contém as imagens que mostram a direção do personagem.
             * @param positionX :  Coordenada que guarda a posição do personagem na tela.
             * @param positionY :  Coordenada que guarda a posição do personagem na tela.
             */

            frame += 0.5f;
            if (frame > maxFrames) {
                frame = 0;

                // Direções do player se um botão é pressionado
                boolean right = player.right();
                boolean left = player.left();
                boolean up = player.up();
                boolean down = player.down();

                // Posiciona o sprite na posição inicial
                if (!right && direction == RIGHT) {
                    direction =STOP_RIGHT;
                    animation = 0;
                }
                if (!left && direction == LEFT) {
                    direction = STOP_LEFT;
                    animation = 0;
                }
                if (!up && direction == UP) {
                    direction = STOP_UP;
                    animation = 0;
                }
                if (!down && direction == DOWN) {
                    direction = STOP_DOWN;
                    animation = 0;
                }

                if (right) {
                    maxAnimation = 1160;
                    animation += 116;
                    direction = 0;
                    positionX++ ;
                }
                if (left) {
                    maxAnimation = 1160;
                    animation += 116;
                    direction = 116;
                    positionY-- ;
                }
                if (up) {
                    maxAnimation = 1160;
                    animation += 116;
                    direction = 348;
                    positionY-- ;
                }
                if (down) {
                    maxAnimation = 1160;
                    animation += 116;
                    direction = 232;
                    positionY++ ;
                }

                // Verifica e controla se o personagem deve correr
                boolean run = player.isRun();
                if (run && right || run && left) {
                    maxFrames = 0;
                    // Desloca o personagem com maior agilidade
                    if (direction == RIGHT) ++positionX;
                    if (direction == LEFT) --positionX;
                }
                else maxFrames = 1f;

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

            if (isNull(bufferStrategy)) {
                this.createBufferStrategy(3);
            }

            bufferStrategy = this.getBufferStrategy();

            if (isNull(graphics)) graphics = bufferStrategy.getDrawGraphics();

            graphics.drawImage(sprite.getImageByPosition(animation,direction, 116, 116), positionX, positionY,null);

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