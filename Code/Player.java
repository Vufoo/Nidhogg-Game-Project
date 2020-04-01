import java.awt.*;

public class Player extends GameObject{
    double velx, vely, gravity;
    int playernum;
    boolean direction, hasSword, falling, jumping;
    Color color;
    Sword sword = new Sword(getX(), getY(), 1, getX(), direction);



    public Player(){
        super();
        velx = 0;
        vely = 0;
        color = Color.WHITE;
        playernum = 0;
        direction = false;
        gravity = 0.5;
    }

    public Player(double x, double y, double velx, double vely, Color color, int num, boolean direction, boolean hasSword){
        super(x,y);
        this.velx = velx;
        this.vely = vely;
        this.color = color;
        playernum = num;
        this.direction = direction;
        this.hasSword = hasSword;
        gravity = 0.5;

    }

    public void draw(){  //draws character


        if(playernum==1){
            //StdDraw.picture(x,y,"Rplayer1.png");
            StdDraw.line(x,0,x,100);
            if(hasSword){
                if(sword.getPosition()==0){

                    StdDraw.picture(x,y, "Player1Down.png");
                }
                if(sword.getPosition()==1){

                    StdDraw.picture(x,y,"Player1.png");
                }
                if(sword.getPosition()==2){

                    StdDraw.picture(x,y,"Player1Up.png");
                }
                sword.draw();

            }
        }
        if(playernum==2){
            StdDraw.line(x,0,x,100);
            //StdDraw.picture(x,y, "Rplayer2.png");
            if(hasSword){
                if(sword.getPosition()==0){

                    StdDraw.picture(x,y, "Player2Down.png");
                }
                if(sword.getPosition()==1){

                    StdDraw.picture(x,y,"Rplayer2.png");
                }
                if(sword.getPosition()==2){

                    StdDraw.picture(x,y,"Player2Up.png");
                }
                sword.draw();
            }
        }

    }

    public void attack(){ //lunge attack
        if(playernum==1) {
            x += 15;

            if (hasSword) {
                sword.moveRight(15);

            }
        }
        else{
            x -= 15;

            if (hasSword) {
                sword.moveRight(-15);

            }
        }

    }

    public void duck(){} //ducking mechanic

    public void update(double dt, double gravity){//jump mechanic

        y = y+(vely*dt);
        vely = vely+ gravity*dt;

        if(hasSword) {
            sword.setY(y);

        }


    }

    public void moveLeft(){
        x -= velx;

        if(hasSword){
            sword.moveLeft(velx);

        }
    }

    public void moveRight(){
        x+= velx;

        if(hasSword){
            sword.moveRight(velx);

        }
    }

    public void moveUp(){

        if(hasSword){
            sword.moveUp();
            if(sword.getPosition()>2 ){
                sword.setPosition(2);
            }
        }

    }
    public void moveDown(){

        if(hasSword){
            sword.moveDown();
            if(sword.getPosition()<0 ){
                sword.setPosition(0);

            }

        }
    }

    public void setVelX(double velx){
        this.velx=velx;
    }

    public double getVelx(){
        return velx;
    }

    public void setVelY(double vely){
        this.vely=vely;
    }

    public double getVelY(){
        return vely;
    }

    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x=x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y=y;
    }

    public boolean getJumping(){
        return jumping;
    }

    public void setJumping(boolean jumping){
        this.jumping = jumping;
    }

    public boolean getDirection(){
        return direction;
    }

    public int getPlayer(){
        return playernum;
    }

    public void setSword(boolean hasSword){
        this.hasSword = hasSword;
    }


}

