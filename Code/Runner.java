import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Runner {
    static private ArrayList<Sword> swords;
    static private int times1, times2;
    static private int time1, time2;
    static private int increment1, increment2;
    static final double gravity = -.0618;
    static double jumpPower = 1.5;
    static boolean priority=true, parry;
    static int scorePlayer1 ,scorePlayer2, time, freeze;
    static Font font = new Font("Comic Sans", Font.BOLD, 25);
    static ArrayList<Enemy> enemies = new ArrayList<Enemy>();


    public static void main(String[] args) {
        new Runner();
    }
/*
    public static void time(int time) { //test timer

    final Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        int i = time;

        String seconds = Integer.toString(i);
        public void run () {
            if(time == 0) {
                System.out.println(i++);
            }
            else{
                System.out.println(i--);
            }
            if (i < 0)
                timer.cancel();
        }
    },0,1000);
    }
    */

    public Runner(){
        times1 = 0;
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        for (int r = 0; true; r++) {
                splashScreen();
                StdDraw.show();

        }
    }

    public static void enemyCollision(Player player1, Enemy enemy){

    }

    public static void playerCollision(Player player1, Player player2) {
        if (player1.getSword().getHitBoxS().equals(player2.getHitboxP())&&priority){
            scorePlayer1++;
            twoPlayer(time, scorePlayer1, scorePlayer2);




        }
        if ( player2.getSword().getHitBoxS().equals(player1.getHitboxP())&&!priority){
            scorePlayer2++;
            twoPlayer(time, scorePlayer1, scorePlayer2);

        }
        if(player1.getSword().getHitBoxS().equals(player2.getSword().getHitBoxS())){
            player1.parry();
            player2.parry();
        }


    }

    public static void splashScreen(){//title screen
        int option = 0;
        StdDraw.setFont(font);
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
                //time(0);
                singlePlayer(0,0);

            }
            if (option == 2) {//multiplayer
                StdDraw.clear();
                twoPlayer(0,0,0);

            }
            if (option == 3) {//controls
                StdDraw.clear();
                //time(0);
                controls();
            }
        }
    }
    public static void singlePlayer(int beginTime, int score){ //singleplayer
        Player player1 = new Player(20,8, 1,1.5, Color.BLUE,1, true, true,0);
        time1=0;
        times1=0;
        double dt=0;
        time = beginTime;
        String times = "";
        scorePlayer1 = score;
        String score1 = "";
        StdDraw.setFont(font);

        for(int i = 0; true; i++){

            time++;
            if(time%40==0) {//counting time

                times = Integer.toString(time/40);
            }

            score1 = Integer.toString(scorePlayer1);

            increment1 = 1;//implementing lag... incrementing other time
            if(time1!=times1) {
                increment1=2;//if the other time is not equal then increment one time by 2 until it reaches the other
            }

            times1+=increment1;
            time1++;

            ////////////
            StdDraw.picture(50,50,"Background1.png"); //first screen
            StdDraw.text(50,95, times);
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.text(5,95, score1);
            StdDraw.setPenColor(Color.GREEN);

            //StdDraw.picture(50,50,"bruh.png");
            //StdDraw.picture(50,50,"Sunia.png"); //first screen
            //StdDraw.filledSquare(50,50, 100);

            player1.draw();
            player1.checkCollision();
            player1.update(dt, gravity);


            if(player1.getY()<8){//jumping setup
                dt = 0;
                player1.setVelY(jumpPower);
                player1.setY(8);

            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {//when jumping
                dt = 1.5;
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
                    time1 += 8;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_S) && (times1==time1)){
                    player1.moveDown();
                    time1 += 8;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_1) && (time1==times1)) {
                    priority = true;
                    player1.attack();
                    time1 += 30;
                }
                if(parry && (time1==times1)){
                    time1+=10;
                }

                if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)){//escape button
                    StdDraw.clear();
                    splashScreen();
                }
            }

        StdDraw.show();
        }
    }
    public static void twoPlayer(int beginTime, int scorep1, int scorep2){
        Player player1 = new Player(20,8, 1,1.5, Color.BLUE, 1, false, true,0);
        Player player2 = new Player(80,8,1,1.5, Color.RED, 2, true, true,0);

        time1=0;
        times1=0;
        time2=0;
        times2=0;

        double dt1=0;
        double dt2=0;
        time = beginTime;
        String times = "";
        scorePlayer1 = scorep1;
        String score1 = "";
        scorePlayer2 = scorep2;
        String score2 = "";

        StdDraw.setFont(font);

        for(int i = 0; true; i++){

            time++;
            if(time%40==0) {

                times = Integer.toString(time/40);
            }

            score1 = Integer.toString(scorePlayer1);
            score2 = Integer.toString(scorePlayer2);

            increment1 = 1;
            increment2 = 1;
            if(time1!=times1) {
                increment1=2;
            }
            times1+=increment1;
            time1++;

            if(time2!=times2) {
                increment2=2;
            }
            times2+=increment2;
            time2++;

            ///////////////////////////
            StdDraw.picture(50,50,"Background1.png"); //first screen put text after this

            StdDraw.text(50,95, times);
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.text(5,95, score1);
            StdDraw.setPenColor(Color.RED);
            StdDraw.text(95,95, score2);
            StdDraw.setPenColor(Color.GREEN);
            //StdDraw.picture(50,50,"bruh.png");
            //StdDraw.picture(50,50,"Sunia.png");
            //StdDraw.picture(50,50,"Dad.png");
            //StdDraw.picture(50,50,"BrickDaddy.png");

            player1.draw();
            player2.draw();
            player1.checkCollision();
            player2.checkCollision();
            player1.update(dt1, gravity);
            player2.update(dt2, gravity);
            playerCollision(player1, player2); //player hit

            if(player1.getY()<8){
                dt1 = 0;
                player1.setVelY(jumpPower);
                player1.setY(8);

            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
                dt1 = 1.5;
            }

            if(player2.getY()<8){
                dt2 = 0;
                player2.setVelY(jumpPower);
                player2.setY(8);

            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_M)) {
                dt2 = 1.5;
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
                    time1 += 8;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_S) && (times1==time1)){
                    player1.moveDown();
                    time1 += 8;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_1) && (times1==time1)) {
                    priority = true;
                    player1.attack();
                    time1 += 30;
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
                    priority = false;
                    player2.attack();
                    time2 += 30;
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
            StdDraw.text(75, 60, "Move Right: Right Key");
            StdDraw.text(75, 50, "Move Left: Left Key");
            StdDraw.text(75, 40, "Attack: N");
            StdDraw.text(75, 30, "Jump: M");
            StdDraw.text(50, 15, "Exit: ESC");
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



