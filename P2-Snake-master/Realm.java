import greenfoot.*;
public class Realm extends World
{
//Instance Variables
  public SnakeHead eli;
  public Foodrightanswer foodRight;
  public Foodwronganswer foodWrong1;
  public Foodwronganswer foodWrong2;
  public Score score;
  
//Constructors
  public Realm()
  {    
    super(52, 54, 9);
    eli = new SnakeHead();
    addObject(eli, 26, 26);
    foodRight = new Foodrightanswer();
    foodWrong1 = new Foodwronganswer();
    foodWrong2= new Foodwronganswer();
    addObject(foodRight, Greenfoot.getRandomNumber(40)+1, Greenfoot.getRandomNumber(40)+5);
    addObject(foodWrong1, Greenfoot.getRandomNumber(40)+1, Greenfoot.getRandomNumber(40)+5);
    addObject(foodWrong2, Greenfoot.getRandomNumber(40)+1, Greenfoot.getRandomNumber(40)+5);
    score = new Score();
    addObject(score, 5, 52);
    Greenfoot.setSpeed(30);
  }
  
//Methods
  public void gameOver()
  {
    Greenfoot.stop();
    Greenfoot.playSound("end1.wav");
    setBackground("gameover.png");
  }
  public void started()
  {
    Greenfoot.playSound("start1.wav");
  }
}