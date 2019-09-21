import greenfoot.*;
public class Food extends Actor
{
//Instance Variables
  int sound;
  private int num;
  
  public Food()
  {
        String text = "" + num;
        int stringLength = (text.length() + 2) * 10;
        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.drawString(text, 1, 14);
  }
  
  public void setNum(int num)
  {
      this.num = num;
      String text = "" + num;
      GreenfootImage image = getImage();
      image.clear();
      image.drawString(text, 1, 14);
  }
  
  public int getNum()
  {
      return num;
  }
    
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