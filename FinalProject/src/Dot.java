public class Dot{
    int xCoordinate;
    int yCoordinate;
    char velocity;

    public Dot(int x, int y, char v){
        xCoordinate=x;
        yCoordinate=y;
        velocity=v;
    }
    public Dot(){}

    public void moveUp(){
        yCoordinate=yCoordinate-1;
        this.setyCoordinate(yCoordinate);

    }
    public void moveLeft(){
        xCoordinate=xCoordinate-1;
        this.setxCoordinate(xCoordinate);

    }
    public void moveRight(){
        xCoordinate=xCoordinate+1;

    }
    public void moveDown(){
        yCoordinate=yCoordinate+1;

    }
    public int getxCoordinate(){
        return xCoordinate;
    }
    public int getyCoordinate(){
        return yCoordinate;
    }
    public char getVelocity(){
        return velocity;
    }
    public void setxCoordinate(int a){
        this.xCoordinate=a;
    }
    public void setyCoordinate(int a){
        this.yCoordinate=a;
    }

    public void setVelocity(char velocity) {
        this.velocity = velocity;
    }
}
