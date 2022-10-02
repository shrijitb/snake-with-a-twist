class Food {

    private static Food snakeFood = null;

    int xPos, yPos, radius;

    private Food(){
        xPos= (int)(Math.random()*249) + 25;
        yPos= (int)(Math.random()*249) + 25;
        radius=5;
    }

    public static Food getInstance(){
        if (snakeFood == null)
            snakeFood = new Food();
        return snakeFood;
    }

    public static Food removeFood(){
        snakeFood=null;
        return snakeFood;
    }
  }
