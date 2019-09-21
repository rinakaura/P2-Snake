import greenfoot.*;

import java.awt.Graphics;

public class Score extends Actor
{
//Instance Variables
  private int score = 0;
  private String text;
  private int stringLength;
  
//Constructors
  public Score()
  {
    text = "Score: ";
    stringLength = (text.length() + 2) * 10;
    setImage(new GreenfootImage(stringLength, 16));
    GreenfootImage image = getImage();
    updateImage();
  }
  
//Methods
  public void addPoint()
  {
    score += 1;
    updateImage();
    if(score == 5)
      Greenfoot.setSpeed(41);
    if(score == 10)
      Greenfoot.setSpeed(42);
    if(score == 20)
      Greenfoot.setSpeed(43);
    if(score == 30)
      Greenfoot.setSpeed(44);
    if(score == 45)
      Greenfoot.setSpeed(45);
    if(score == 55)
      Greenfoot.setSpeed(46);
    if(score == 70)
      Greenfoot.setSpeed(47);
    if(score == 80)
      Greenfoot.setSpeed(48);
    if(score == 100)
      Greenfoot.setSpeed(49);
    if(score == 120)
      Greenfoot.setSpeed(50);
  }
  private void updateImage()
  {
    GreenfootImage image = getImage();
    image.clear();
    image.drawString(text + score, 10, 14);
  }
}