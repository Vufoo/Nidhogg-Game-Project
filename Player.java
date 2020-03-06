import java.awt.*;

public class Player {
    double x, y, velx, vely;
    Color color;

    public Player(){
        this.x=0;
        this.y=0;
        velx = 0;
        vely = 0;
    }

    public Player(double x, double y, double velx, double vely, Color color){
        this.x=x;
        this.y=y;
        this.velx = velx;
        this.vely = vely;
        this.color = color;
    }

    public void draw(){
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x,y,5,5);

    }
    public void duck(){

    }

    public void update(){
        StdDraw.clear();
        x+=velx;
        draw();
    }

    public void setVelX(double velx){
        this.velx=velx;
    }


    public void jump(){}

    public void attack(){}



}
