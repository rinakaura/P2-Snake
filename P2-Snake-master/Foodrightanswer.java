import greenfoot.*;
public class Foodrightanswer extends Actor
{
//Instance Variables
  int sound;
  
//Methods
  public void act()
  {
    sound = Greenfoot.getRandomNumber(500);
    if(sound == 46)
      Greenfoot.playSound("hiss1.wav");
    else if(sound == 460)
      Greenfoot.playSound("hiss2.wav");
    else if(sound == 100)
      Greenfoot.playSound("hiss3.wav");
  }
}