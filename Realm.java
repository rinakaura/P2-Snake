
import greenfoot.*;
public class Realm extends World
{
//Instance Variables
  public SnakeHead eli;
  public Food[] foods;
  public Score score;
  public MathProblem mathProblem;
  
//Constructors
  public Realm()
  {    
    super(52, 54, 9);
    eli = new SnakeHead();
    addObject(eli, 26, 26);
    mathProblem = new MathProblem();
    addObject(mathProblem, 33, 52);
    foods = new Food[4];
    for (int i=0; i < 4; i++)
    {
        foods[i] = new Food();
        addObject(foods[i], 0, 0);
    }
    placeFoods();
    score = new Score();
    addObject(score, 5, 52);
    Greenfoot.setSpeed(30);
  }
  
  public void placeFoods()
  {
      mathProblem.refresh();
      int[] answers = new int[4];
      // initialize all to random numbers
      for (int i=0; i < 4; i++)
      {
          answers[i] = Greenfoot.getRandomNumber(200);
      }
      // choose location for correct answer
      int location = Greenfoot.getRandomNumber(4);
      // set the correct answer in the random location in answers array
      answers[location] = mathProblem.getCorrectAnswer();
      for (int i=0; i < 4; i++)
      {
          foods[i].setLocation(Greenfoot.getRandomNumber(50)+1,Greenfoot.getRandomNumber(50)+1);
          foods[i].setNum(answers[i]);
      }
  }
    
  
//Methods
  public void gameOver()
  {
    Greenfoot.stop();
    Greenfoot.playSound("end1.wav");
    setBackground("gameover2.jpg");
  }
  public void started()
  {
    Greenfoot.playSound("start1.wav");
  }
 }
