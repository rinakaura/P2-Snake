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
      
    if(next != null)
      next.move(x,y,rotation);
    
    Food[] foods = ((Realm)getWorld()).foods;
    for (int i=0; i < foods.length; i++)
    {
        if (intersects(foods[i])) 
        {
            if (foods[i].getNum() == ((Realm)getWorld()).mathProblem.getCorrectAnswer())
            {
                ((Realm)getWorld()).placeFoods();
                addTail();
                ((Realm)(getWorld())).score.addPoint();
            } else {
                ((Realm)(getWorld())).gameOver();
                return;
            }
        }
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