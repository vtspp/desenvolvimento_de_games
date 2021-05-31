package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

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

        public Screen (int width, int height, String title) {
            jFrame = new JFrame(title);
            this.width = width;
            this.height = height;
            this.title = title;
        }

        @Override
        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        @Override
        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public JFrame getJFrame() {
            return jFrame;
        }

        public void setJFrame(JFrame jFrame) {
            this.jFrame = jFrame;
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
            frame += 0.5f;
            if (frame > maxFrames) {
                frame = 0;

                animation += 116; // No próximo loop a segunda animação será renderizada

                if (animation == maxAnimation) {
                    animation =  0;
                }
                position++;
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