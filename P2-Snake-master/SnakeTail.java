import greenfoot.*;
public class SnakeTail extends Actor
{
//Instance Variables
  SnakeTail next;
  int nx;
  int ny;
  int nrotation;
  
//Methods
  public void move(int x, int y, int rotation)
  {
    nx = getX();
    ny = getY();
    nrotation = getRotation();
    setLocation(x,y);
    setRotation(rotation);
    if(next != null)
      next.move(nx,ny,nrotation);
  }
  public void addTail()
  {
    if(next == null)
    {
      next = new SnakeTail();
      if(getRotation() == 0)
        getWorld().addObject(next, getX(), getY()+1);
      else if(getRotation() == 90)
        getWorld().addObject(next, getX()-1, getY());
      else if(getRotation() == 180)
        getWorld().addObject(next, getX(), getY()-1);
      else if(getRotation() == 270)
        getWorld().addObject(next, getX()+1, getY());
    }
    else
    {
      next.addTail();
    }
  }
}