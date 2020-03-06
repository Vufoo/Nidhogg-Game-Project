import java.awt.event.KeyEvent;
import java.awt.*;


public class Runner {

    private final int WIDTH = 100;
    private final int HEIGHT = 100;


    public static void main(String[] args) {
        new Runner();

    }

    public Runner(){
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
        splashScreen();
    }

    public void splashScreen(){
        StdDraw.clear();

        boolean choice = true;
        int option = 0;
        while(choice){
            StdDraw.text(50,60, "1. Single Player");
            StdDraw.text(50,50, "2. Two Player");
            StdDraw.text(50,40, "3. Controls");

            if(StdDraw.isKeyPressed(KeyEvent.VK_1)){
                option = 1;
                choice = false;
            }
            if(StdDraw.isKeyPressed(KeyEvent.VK_2)){
                option = 2;
                choice = false;
            }
            if(StdDraw.isKeyPressed(KeyEvent.VK_3)){
                option = 3;
                choice = false;
            }

        }

        if(option == 1){
            singlePlayer();
        }
        if(option == 2){
            twoPlayer();
        }
        if(option == 3){
            controls();
        }


    }

    public void firstScreen(){
        boolean selected = true;
        while(selected){
            StdDraw.picture(50,50,"pixil-frame-0.png");

            if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)){
                selected = false;
            }
        }
        splashScreen();



    }

    public void nextScreen(){

    }

    public void singlePlayer(){
        firstScreen();
        Player player1 = new Player(40,0, 5,5, Color.BLUE);
        player1.draw();
        while(true){


        }
    }

    public void twoPlayer(){
        firstScreen();
        Player player1 = new Player(40,0, 5,5, Color.BLUE);
        Player player2 = new Player(60,0,5,5, Color.RED);
        while(true){

        }
    }

    public void controls(){

    }
}
