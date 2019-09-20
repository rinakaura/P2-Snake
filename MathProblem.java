import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MathProblem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MathProblem extends Actor
{
    private String text;
    private int num1, num2;
    
    public MathProblem()
    {
        num1 = Greenfoot.getRandomNumber(99);
        num2 = Greenfoot.getRandomNumber(99);
        text = "What is the Sum of " + num1 + " and " + num2 + " ?";
        int stringLength = (text.length() + 2) * 10;
        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.drawString(text, 1, 14);
    }
    public int getCorrectAnswer()
    {
        return num1 + num2;
    }    
}
