import java.awt.*;

public class Player extends GameObject{
    private int score;
    private double velx, vely, gravity, playernum;
    private boolean direction, hasSword;
    private Color color;
    private Sword sword;
    private Hitbox hitboxP = new Hitbox(getX(), getY(), 2, 7);

    public Player(){
        super();
        velx = 0;
        vely = 0;
        color = Color.WHITE;
        playernum = 0;
        direction = false;
        this.hasSword = false;
        score = 0;
        gravity = 0.5;
    }
    public Player(double x, double y, double velx, double vely, Color color, int playernum, boolean direction, boolean hasSword, int score){
        super(x,y);
        this.velx = velx;
        this.vely = vely;
        this.color = color;
        this.playernum = playernum;
        this.direction = direction;
        this.hasSword = hasSword;
        this.score = score;
        gravity = 0.5;
        setSword();

    }

    public void setSword() {
        if(getX()==20) {
            sword = new Sword(getX()+10, getY(), 1, getX(), direction);

        }
        if(getX()==80) {
            sword = new Sword(getX()-10, getY(), 1, getX(), direction);

        }

    }

    public void draw(){  //draws character
        //hitboxP.draw();
        if(playernum==1){
            //StdDraw.line(x,0,x,100);
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
            else{
                StdDraw.picture(x,y,"Player1.png");
            }
        }
        if(playernum==2){
            //StdDraw.line(x,0,x,100);
            if(hasSword){
                if(sword.getPosition()==0){

                    StdDraw.picture(x,y, "Player2Down.png");
                }
                if(sword.getPosition()==1){

                    StdDraw.picture(x,y,"Player2.png");
                }
                if(sword.getPosition()==2){

                    StdDraw.picture(x,y,"Player2Up.png");
                }
                sword.draw();
            }
            else{
                StdDraw.picture(x,y, "Player2.png");
            }
        }
    }
    public void attack(){ //lunge attack
        if(playernum==1) {
            if (hasSword) {
                sword.moveRight(8);
                x += 8;
                hitboxP.moveRight(8);
            }
            else{
                x+=0;
            }

        }
        if(playernum == 2){
            if (hasSword) {
                sword.moveLeft(8);
                x -= 8;
                hitboxP.moveLeft(8);
            }
            else{
                x -= 0;
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
        hitboxP.setY(y);
    }

    public void moveLeft(){
        x -= velx;
        if(hasSword){
            sword.moveLeft(velx);
        }
        hitboxP.moveLeft(velx);
    }
    public void moveRight(){
        x+= velx;
        if(hasSword){
            sword.moveRight(velx);

        }
        hitboxP.moveRight(velx);
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
    public void checkCollision(){
        if(playernum == 1 && x < 5){
            x = 5;
            if(hasSword){
                sword.setX(15);
                sword.getHitBoxS().setX(15);
            }
            hitboxP.setX(5);
        }
        if(playernum == 2 && x > 95){
            x=95;
            if(hasSword){
                sword.setX(85);
                sword.getHitBoxS().setX(85);
            }
            hitboxP.setX(95);
        }
    }

    public int getScore(){
        return score;
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

    public double getY(){ return y; }

    public void setY(double y){
        this.y=y;
    }

    public boolean getDirection(){
        return direction;
    }

    public double getPlayerNum(){
        return playernum;
    }

    public Sword getSword(){
        return sword;
    }

    public void setSword(boolean hasSword){
        this.hasSword = hasSword;
    }

    public Hitbox getHitboxP(){
        return hitboxP;
    }


    public void parry(){

    }

}



