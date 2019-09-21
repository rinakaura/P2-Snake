
import greenfoot.*;
public class Realm extends World
{
//Instance Variables
  public SnakeHead eli;
  public Food food;
  public Score score;
  public MathProblem mathProblem;
  
//Constructors
  public Realm()
  {    
    super(52, 54, 9);
    eli = new SnakeHead();
    addObject(eli, 26, 26);
    food = new Food();
    addObject(food, Greenfoot.getRandomNumber(50)+1, Greenfoot.getRandomNumber(50)+1);
    score = new Score();
    addObject(score, 5, 52);
    mathProblem = new MathProblem();
    addObject(mathProblem, 33, 52);
    Greenfoot.setSpeed(40);
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
=======
import greenfoot.*;
public class Realm extends World
{
//Instance Variables
  public SnakeHead eli;
  public Food food;
  public Score score;
  
//Constructors
  public Realm()
  {    
    super(52, 54, 9);
    eli = new SnakeHead();
    addObject(eli, 26, 26);
    food = new Food();
    addObject(food, Greenfoot.getRandomNumber(50)+1, Greenfoot.getRandomNumber(50)+1);
    score = new Score();
    addObject(score, 5, 52);
    Greenfoot.setSpeed(40);
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