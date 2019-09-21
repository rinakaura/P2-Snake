import greenfoot.*;
public class SnakeHead extends Actor
{
//Instance Variables
  SnakeTail next;
  int x;
  int y;
  int rotation;
  int sound;
  
//Methods
  public void act() 
  {
    if(getIntersectingObjects(SnakeTail.class).size() > 0)
    {
      ((Realm)(getWorld())).gameOver();
      return;
    }
    else if (getX() == 51 || getY() == 51 || getX() == 0 || getY() == 0)
    {
      ((Realm)(getWorld())).gameOver();
      return;
    }
    
    x = getX();
    y = getY();
    rotation = getRotation();
    processKeys();
    if(getRotation() == 0)
      setLocation(getX(), getY()-1);
    else if(getRotation() == 90)
      setLocation(getX()+1, getY());
    else if(getRotation() == 180)
      setLocation(getX(), getY()+1);
    else if(getRotation() == 270)
      setLocation(getX()-1, getY());
      
    if(intersects((((Realm)(getWorld())).foodRight)))
    {
      (((Realm)(getWorld())).foodRight).setLocation(Greenfoot.getRandomNumber(50)+1,Greenfoot.getRandomNumber(50)+1);
      (((Realm)(getWorld())).foodWrong1).setLocation(Greenfoot.getRandomNumber(50)+1,Greenfoot.getRandomNumber(50)+1);
      (((Realm)(getWorld())).foodWrong2).setLocation(Greenfoot.getRandomNumber(50)+1,Greenfoot.getRandomNumber(50)+1);
      addTail();
      ((Realm)(getWorld())).score.addPoint();
      sound = Greenfoot.getRandomNumber(4);
      if(sound == 0)
        Greenfoot.playSound("chew1.wav");
      else if(sound == 1)
        Greenfoot.playSound("chew2.wav");
      else if(sound == 2)
        Greenfoot.playSound("chew3.wav");
      else if(sound == 3)
        Greenfoot.playSound("chew4.wav");
    }
    if(next != null)
      next.move(x,y,rotation);
      
    if(intersects((((Realm)(getWorld())).foodWrong1)))
    {
      ((Realm)(getWorld())).gameOver();
      return;
    }
    
    if(intersects((((Realm)(getWorld())).foodWrong2)))
    {
      ((Realm)(getWorld())).gameOver();
      return;
    }
  }   
  public void addTail()
  {
    if(next == null)
    {
      next = new SnakeTail();
      if(getRotation() == 0)
        getWorld().addObject(next, getX(), getY()+1);
      if(getRotation() == 90)
        getWorld().addObject(next, getX()-1, getY());
      if(getRotation() == 180)
        getWorld().addObject(next, getX(), getY()-1);
      if(getRotation() == 270)
        getWorld().addObject(next, getX()+1, getY());
    }
    else if (next != null)
    {
      next.addTail();
      next.next.addTail();
      next.next.next.addTail();}
  }
  private void processKeys() 
  {
    if(Greenfoot.isKeyDown("down") && this.getRotation() != 180 && this.getRotation() != 0)
      this.setRotation(180);
    else if(Greenfoot.isKeyDown("up") && this.getRotation() != 0 && this.getRotation() != 180)
      this.setRotation(0);
    else if(Greenfoot.isKeyDown("left") && this.getRotation() != 270 && this.getRotation() != 90)
      this.setRotation(270);
    else if(Greenfoot.isKeyDown("right") && this.getRotation() != 90 && this.getRotation() != 270)
      this.setRotation(90);
    else{}
  }
}