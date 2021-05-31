package run;

import graphics.Screen;

public class Run {

        private Thread thread;

        public Run(Screen screen) {
            thread = new Thread(screen);
        }

        public void start () {
            thread.start();
        }

        public void stop () throws InterruptedException {
            thread.join();
        }
}

