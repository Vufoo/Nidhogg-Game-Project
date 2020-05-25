public class Sword extends GameObject{
    int position, player;
    double playernum;
    boolean direction;
    Hitbox hitboxS= new Hitbox(getX(), getY(), 5.7,1.5);


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
            player = 1;

            if(position == 0){
                setY(y-5);
                hitboxS.setY(y);
                StdDraw.picture(x, y, "sword1.png");
                //StdDraw.rectangle(x+12, y-5, 4,1);


            }
            if(position == 1){
                StdDraw.picture(x, y, "sword1.png");
                //StdDraw.rectangle(x+12, y, 4,1);

            }
            if(position == 2){
                setY(y+5);
                hitboxS.setY(y);
                StdDraw.picture(x, y, "sword1.png");
                //StdDraw.rectangle(x+12, y+5, 4,1);

            }
        }
        if(playernum == 80) {

            player = 2;
            if(position == 0){
                setY(y-5);
                hitboxS.setY(y);
                StdDraw.picture(x, y, "sword2.png");
                //StdDraw.rectangle(x-12, y-5, 4,1);
            }
            if(position == 1){
                StdDraw.picture(x, y, "sword2.png");
                //StdDraw.rectangle(x-12, y, 4,1);
            }
            if(position == 2){
                setY(y+5);
                hitboxS.setY(y);
                StdDraw.picture(x, y, "sword2.png");
                //StdDraw.rectangle(x-12, y+5, 4,1);
            }

        }
        hitboxS.draw();

    }

    public void moveUp(){ position += 1; y+=5; hitboxS.moveUp();}

    public void moveDown(){ position -= 1; y-=5; hitboxS.moveDown();}

    public void moveLeft(double velx){ x -= velx; hitboxS.moveLeft(velx);}

    public void moveRight(double velx){ x += velx; hitboxS.moveRight(velx);}

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){ this.y = y; hitboxS.setY(y);}

    public double getX(){ return x; }

    public void setX(double x){ this.x = x; }

    public boolean getDirection(){
        return direction;
    }

    public Hitbox getHitBoxS(){
        return hitboxS;
    }
}
