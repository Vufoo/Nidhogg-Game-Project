import java.awt.*;

public class Sword extends GameObject{
    int position;
    double playernum;
    boolean direction;

    public Sword(){
        super();
        position = 0;
        playernum = 0;
        direction = false;
    }

    public Sword(double x, double y, int position, double player, boolean direction) {
        super(x,y);
        this.position = position;
        this.playernum = player;
        this.direction = direction;
    }

    public void draw(){
        if(playernum == 20){

            if(position == 0){
                StdDraw.picture(x+10, y-5, "sword1.png");
                StdDraw.circle(x+15, y-5, 1);
            }
            if(position == 1){
                StdDraw.picture(x+10, y, "sword1.png");
                StdDraw.circle(x+15, y, 1);
            }
            if(position == 2){
                StdDraw.picture(x+10, y+5, "sword1.png");
                StdDraw.circle(x+15, y+5, 1);
            }

        }

        if(playernum == 80) {
            if(position == 0){
                StdDraw.picture(x-10, y-5, "sword2.png");
                StdDraw.circle(x-15, y-5, 1);
            }
            if(position == 1){
                StdDraw.picture(x-10, y, "sword2.png");
                StdDraw.circle(x-15, y, 1);
            }
            if(position == 2){
                StdDraw.picture(x-10, y+5, "sword2.png");
                StdDraw.circle(x-15, y+5, 1);
            }

        }

    }

    public void hitBox(){

    }

    public void moveUp(){ position += 1; y+=5; }

    public void moveDown(){ position -= 1; y-=5;}

    public void moveLeft(double velx){ x -= velx; }

    public void moveRight(double velx){
        x += velx;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){ return x; }

    public void setX(){ this.x = x; }

    public boolean getDirection(){
        return direction;
    }

    public void parry(Sword sword){ //sword collision

    }
    public void collision(){  //player collision

    }
}
