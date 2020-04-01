import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.ArrayList;


public class Runner {

    static private ArrayList<Sword> swords;
    static private int times1;
    static private int times2;

    static private int time1;
    static private int time2;

    static private int increment1;
    static private int increment2;

    static final double gravity = -.0618;
    static double jumpPower=1.5;
    static boolean priority;



    public static void main(String[] args) throws InterruptedException {
        new Runner();
    }


    public Runner(){
        times1 = 0;
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


    public static void splashScreen(){//title screen

        int option = 0;

        for (int r = 0; true; r++) {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.text(50,70, "NIDHOGG");
            StdDraw.setPenColor(Color.RED);
            StdDraw.text(50,50, "1. Single Player");
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.text(50,40, "2. Two Player");
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.text(50,30, "3. Controls");
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
            if (option == 1) {//singleplayer
                StdDraw.clear();
                singlePlayer();

            }
            if (option == 2) {//multiplayer
                StdDraw.clear();
                twoPlayer();

            }
            if (option == 3) {//controls
                StdDraw.clear();
                controls();
            }

        }
    }


    public static void singlePlayer(){ //single

        Player player1 = new Player(20,8, 1,1.5, Color.BLUE,1, true, true);
        time1=0;
        times1=0;
        double dt=0;


        for(int i = 0; true; i++){
            increment1 = 1;
            if(time1!=times1) {
                increment1=2;
            }
            times1+=increment1;
            time1++;

            //StdDraw.picture(50,50,"bruh.png");
            //StdDraw.picture(50,50,"Sunia.png"); //first screen
            StdDraw.picture(50,50,"Background1.png"); //first screen
            player1.draw();

            System.out.print(player1.getX());
            System.out.print(" " + player1.getY());
            System.out.print(" " + player1.getVelY());
            System.out.println(" "+dt);

            player1.update(dt, gravity);

            if(player1.getY()<8){
                dt = 0;
                player1.setVelY(jumpPower);
                player1.setY(8);

            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
                dt = jumpPower;
            }

            if (StdDraw.hasNextKeyTyped()) {//controls
                if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
                    player1.moveLeft();
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
                    player1.moveRight();
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_W) && (times1==time1)){
                    player1.moveUp();
                    time1 += 6;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_S) && (times1==time1)){
                    player1.moveDown();
                    time1 += 6;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_1) && (time1==times1)) {
                    player1.attack();
                    time1 += 20;
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

        Player player1 = new Player(20,8, 1,2, Color.BLUE, 1, false, true);
        Player player2 = new Player(80,8,1,2, Color.RED, 2, true, true);
        time1=0;
        times1=0;
        time2=0;
        times2=0;

        double dt1=0;
        double dt2=0;

        while(true){
            increment1 = 1;
            if(time1!=times1) {
                increment1=2;
            }
            times1+=increment1;
            time1++;

            increment2 = 1;
            if(time2!=times2) {
                increment2=2;
            }
            times2+=increment2;
            time2++;


            //StdDraw.picture(50,50,"bruh.png");
            //StdDraw.picture(50,50,"Sunia.png");//firstscreen
            StdDraw.picture(50,50,"Background1.png"); //first screen
            //StdDraw.picture(50,50,"Dad.png"); //first screen
            //StdDraw.picture(50,50,"BrickDaddy.png"); //first screen

            player1.draw();
            player2.draw();

            player1.update(dt1, gravity);
            player2.update(dt2, gravity);

            if(player1.getY()<8){
                dt1 = 0;
                player1.setVelY(jumpPower);
                player1.setY(8);

            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
                dt1 = jumpPower;
            }

            if(player2.getY()<8){
                dt2 = 0;
                player2.setVelY(jumpPower);
                player2.setY(8);

            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_M)) {
                dt2 = jumpPower;
            }

            if (StdDraw.hasNextKeyTyped()) { //controls
                if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {//player1
                    player1.moveLeft();
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
                    player1.moveRight();
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_W) && (times1==time1)){
                    player1.moveUp();
                    time1 += 6;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_S) && (times1==time1)){
                    player1.moveDown();
                    time1 += 6;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_1) && (times1==time1)) {
                    player1.attack();
                    time1 += 20;
                }


                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {//player2
                    player2.moveLeft();
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
                    player2.moveRight();
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && (times2==time2)){
                    player2.moveUp();
                    time2 += 8;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && (times2==time2)){
                    player2.moveDown();
                    time2 += 8;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_N) && (times2==time2)) {
                    player2.attack();
                    time2 += 26;
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

        while(true) {

            StdDraw.text(25,70, "Player 1 Controls");
            StdDraw.text(25, 60, "Move Right: D");
            StdDraw.text(25, 50, "Move Left: A");
            StdDraw.text(25, 40, "Attack: 1");
            StdDraw.text(25, 30, "Jump: 2");
            StdDraw.text(75,70, "Player 2 Controls");
            StdDraw.text(75, 60, "Move Right: Right Arrow");
            StdDraw.text(75, 50, "Move Left: Left Arrow");
            StdDraw.text(75, 40, "Attack: N");
            StdDraw.text(75, 30, "Jump: M");
            StdDraw.text(50, 15, "Exit: Escape");


            if (StdDraw.hasNextKeyTyped()) {
                if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {//escape button
                    StdDraw.clear();
                    splashScreen();
                }
            }
            StdDraw.show();
        }
    }
}
