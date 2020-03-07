import java.awt.event.KeyEvent;
import java.awt.*;


public class Runner {


    private boolean selected;



    public static void main(String[] args) {
        ;
        new Runner();

    }


    public Runner(){

        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        for (int r = 0; true; r++) {

            for (int i = 0; true; i++) {
                splashScreen();
                StdDraw.show();

            }
        }
    }


    public static void splashScreen(){

        int option = 0;

        for (int r = 0; true; r++) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.text(50,60, "1. Single Player");
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.text(50,50, "2. Two Player");
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.text(50,40, "3. Controls");
            StdDraw.show();
            if (StdDraw.isKeyPressed(KeyEvent.VK_1)) {
                option = 1;
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
                option = 2;
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_3)) {
                option = 3;
            }
            if (option == 1) {
                StdDraw.clear();
                singlePlayer();
            }
            if (option == 2) {
                StdDraw.clear();
                twoPlayer();
            }
            if (option == 3) {
                StdDraw.clear();
                controls();
            }

        }
    }


    public static void singlePlayer(){ //single

        Player player1 = new Player(40,10, 1,1, Color.BLUE,1);


        while(true){
            StdDraw.picture(50,50,"pixil-frame-0.png");//firstscreen
            player1.draw();

            if (StdDraw.hasNextKeyTyped()) {//controls
                if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {

                    player1.moveLeft();
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {

                    player1.moveRight();
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)){//escape button
                    StdDraw.clear();
                    splashScreen();
                }
            }

        StdDraw.show();
        }
    }


    public static void twoPlayer(){

        Player player1 = new Player(40,10, 1,5, Color.BLUE,1);
        Player player2 = new Player(60,10,1,5, Color.RED,2);


        while(true){
            StdDraw.picture(50,50,"pixil-frame-0.png");//firstscreen
            player1.draw();
            player2.draw();

            if (StdDraw.hasNextKeyTyped()) { //controls
                if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {

                    player1.moveLeft();
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {

                    player1.moveRight();
                }
                if (StdDraw.isKeyPressed(37)) {

                    player2.moveLeft();
                }
                if (StdDraw.isKeyPressed(39)) {

                    player2.moveRight();
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)){//escape button
                    StdDraw.clear();
                    splashScreen();
                }
            }
            StdDraw.show();
        }


    }


    public static void controls(){

        for (int r = 0; true; r++) {
            StdDraw.textLeft(50,50, "Player");

            if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)){//escape button
                StdDraw.clear();
                splashScreen();
            }
        }
    }


    public static void firstScreen(){

    }
    public static void nextScreen(){

    }
}


