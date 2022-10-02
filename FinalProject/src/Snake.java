import java.util.ArrayList;

public class Snake{

    ArrayList<Dot> snakeStorage = new ArrayList<>();
    int Length;

    public Snake(int x, int y, int l) {
        Length = l;
        for (int i = 0; i <= Length - 1; i++) {
            Dot snakePosition = new Dot(x, y + i, 'w');
            snakeStorage.add(snakePosition);
        }
    }

    public ArrayList getSnakeStorage() {
        return snakeStorage;
    }

    public void move() {
        char lastDotDirection = ((Dot) snakeStorage.get(0)).getVelocity();
        for (int i = 0; i <= snakeStorage.size() - 1; i++) {
            Dot tempDot = snakeStorage.get(i);

            if (tempDot.getVelocity() == 'w') {
                tempDot.moveUp();
            }
            if (tempDot.getVelocity() == 'a') {
                tempDot.moveLeft();
            }
            if (tempDot.getVelocity() == 's') {
                tempDot.moveDown();
            }
            if (tempDot.getVelocity() == 'd') {
                tempDot.moveRight();
            }
            if (lastDotDirection != tempDot.getVelocity()) {
                char tempLastDotDirection = tempDot.getVelocity() ;
                tempDot.setVelocity(lastDotDirection);
                lastDotDirection = tempLastDotDirection;
            }
        }
    }

    public void moveLeft() {
        Dot tempDot = snakeStorage.get(0);
        if(tempDot.getVelocity()!='d'){
        tempDot.setVelocity('a');
        this.move();}
    }

    public void moveUp() {
        Dot tempDot = snakeStorage.get(0);
        if(tempDot.getVelocity()!='s'){
        tempDot.setVelocity('w');
        this.move();}
    }

    public void moveDown() {
        Dot tempDot = snakeStorage.get(0);
        if(tempDot.getVelocity()!='w'){
        tempDot.setVelocity('s');
        this.move();}
    }

    public void moveRight() {
        Dot tempDot = snakeStorage.get(0);
        if(tempDot.getVelocity()!='a'){
        tempDot.setVelocity('d');
        this.move();}
    }

    public void eat(){
        Dot newTail = new Dot();
        Dot snakeTail= snakeStorage.get(Length-1);
        if(snakeTail.getVelocity()=='w'){
           newTail.setxCoordinate(snakeTail.getxCoordinate());
           newTail.setyCoordinate(snakeTail.getyCoordinate()+1);
           newTail.setVelocity(snakeTail.getVelocity());
        }
        if(snakeTail.getVelocity()=='a'){
            newTail.setxCoordinate(snakeTail.getxCoordinate()+1);
            newTail.setyCoordinate(snakeTail.getyCoordinate());
            newTail.setVelocity(snakeTail.getVelocity());
        }
        if(snakeTail.getVelocity()=='s'){
            newTail.setxCoordinate(snakeTail.getxCoordinate());
            newTail.setyCoordinate(snakeTail.getyCoordinate()-1);
            newTail.setVelocity(snakeTail.getVelocity());
        }
        if(snakeTail.getVelocity()=='d'){
            newTail.setxCoordinate(snakeTail.getxCoordinate()-1);
            newTail.setyCoordinate(snakeTail.getyCoordinate());
            newTail.setVelocity(snakeTail.getVelocity());
        }
        Length=Length+1;
        snakeStorage.add(newTail);
    }
}