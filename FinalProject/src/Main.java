
import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {
    int life;
    int ease;
    int gameScore;
    int headotX;
    int headotY;
    int width=300;
    int height=300;
    int snakeIncrementer;
    Snake snake;
    char lastKeyPressed = ' ';
    Food food;
    ArrayList<Dot> pointStore;
    boolean gameOver;
    public void settings(){
    size(width,height+35);
    }

    public void setup(){
        snake=new Snake(150,150,40);
        gameOver=false;
        gameScore=0;
        life=1;
    }

    public void draw(){
        lastKeyPressed = ' ';
        if(gameOver){
          //  life = life-1;
            text("Game Over!!!", 100,330);

        } else {
            lastKeyPressed = key;
            pointStore = snake.getSnakeStorage();
            background(255);
            strokeWeight(3);

            food = Food.getInstance();
            switch (gameScore) {
                case 0:
                    ease = 10;
                    break;
                case 10:
                    ease = 9;
                    break;
                case 20:
                    ease = 8;
                    break;
                case 30:
                    ease = 7;
                    break;
                case 40:
                    ease = 6;
                    break;
                case 50:
                    ease = 5;
                    break;
                case 60:
                    ease = 4;
                    break;
                case 70:
                    ease = 3;
                    break;
                case 80:
                    ease = 2;
                    break;
                default:
                    ease = 1;
            }
            food.radius = 5 * ease;
            snakeIncrementer = 5 * (11 - ease);
            ellipse(food.xPos, food.yPos, food.radius, food.radius);
            line(0, 300, 300, 300);
            textSize(15);
            text("Score : " + gameScore, 10, 330);
            fill(0, 102, 153);


            for (int i = 0; i <= pointStore.size() - 1; i++) {
                Dot tempDot = pointStore.get(i);
                int xPos = tempDot.getxCoordinate();
                int yPos = tempDot.getyCoordinate();
                point(xPos, yPos);

            }

            if (lastKeyPressed != ' ') {
                if ('w' == lastKeyPressed) {
                    snake.moveUp();

                    lastKeyPressed = 'w';
                }
                if ('a' == lastKeyPressed) {
                    snake.moveLeft();
                    lastKeyPressed = 'a';
                }
                if ('s' == lastKeyPressed) {
                    snake.moveDown();
                    lastKeyPressed = 's';
                }
                if ('d' == lastKeyPressed) {
                    snake.moveRight();
                    lastKeyPressed = 'd';
                }
            }
            lastKeyPressed = ' ';

            delay(1);

            snake.move();
            isSnakeEating(snakeIncrementer);
            boundsDetect();
            snakeDetect();
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void delay(int s){

        long delay = s * 10*ease ;
        try{
            Thread.sleep(delay);

        }catch (Exception e){}
    }
    public void isSnakeEating( int a){

        Dot headDot= pointStore.get(0);
        headotX=headDot.getxCoordinate();
        headotY=headDot.getyCoordinate();
        int vicinity = food.radius / 2;

        if((headotX>=(food.xPos-vicinity)) && (headotX<=(food.xPos+vicinity))){

            if((headotY>=(food.yPos-vicinity)) && (headotY<=(food.yPos+vicinity))){

                for(int i=0;i<=a;i++) {
                    snake.eat();
                }
                gameScore += 10;
                food = food.removeFood();
            }
        }
    }

    public void boundsDetect(){
        if(headotX>width || headotX<0 || headotY>height || headotY<0){

            gameOver=true;
        }
    }
    public void snakeDetect(){
        for(int i=1; i<=pointStore.size()-1; i++){
            Dot compDot = pointStore.get(i);
            int compDot_X = compDot.getxCoordinate();
            int compDot_Y = compDot.getyCoordinate();

            if(compDot_X == headotX && compDot_Y == headotY){

               gameOver=true;
            }
        }
    }
}
