import java.awt.*;

public class Player {
    double x, y, velx, vely;
    int playernum;
    boolean direction;
    Color color;

    public Player(){
        this.x=0;
        this.y=0;
        velx = 0;
        vely = 0;
        color = Color.WHITE;
        playernum = 0;
        direction = false;
    }

    public Player(double x, double y, double velx, double vely, Color color, int num, boolean direction){
        this.x=x;
        this.y=y;
        this.velx = velx;
        this.vely = vely;
        this.color = color;
        playernum = num;
        this.direction = direction;
    }

    public void draw(){  //draws character

        if(playernum==1){
            StdDraw.picture(x,y,"Player1.png");
        }
        if(playernum==2){
            StdDraw.picture(x,y, "Player2.png");
        }

    }
    public void duck(){} //ducking mechanic

    public void jump(){} //jump mechanic

    public void attack(){} //lunge attack

    public void moveLeft(){
        x -= velx;
        draw();
    }

    public void moveRight(){
        x+= velx;
        draw();

    }

    public void setVelX(double velx){
        this.velx=velx;
    }

    public double getVelx(){
        return velx;
    }
    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x = x;
    }







}



