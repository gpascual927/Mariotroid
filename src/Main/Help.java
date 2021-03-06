package Main;

/*
 * Try to figure out what to do in case of multi directional collision.  Keep in mind, when
 * speedY is less than 0 physics will automatically reduce to -10, -20 and so on.  I think
 * the key is determining where collided object is in relation to the hero.
 */

public class Help {
  /*
  
  Use these to adjust the hero's position:
    h.x = c.getRight() + h.width/2 + 1;
    h.x = c.getLeft() - h.width/2 - 1;
    h.y = c.getTop() + h.height/2 + 1;
    h.y = c.getBottom() - h.height/2 - 1;
  */
  
  
  public static void fallingRightAndDown(Hero h, Collidable c) {
    if(Math.abs(c.getRight() - h.getLeft()) <= Math.abs(c.getTop() - h.getBottom())) {
      h.x = c.getLeft() - h.width/2 - 1;
      h.speedX = 0;
    } else {
      h.y = c.getTop() + h.height/2 + 1;
      h.speedY = 0;
    }
  }
  
  public static void fallingLeftAndDown(Hero h, Collidable c) {
    if(Math.abs(c.getRight() - h.getLeft()) <= Math.abs(c.getTop() - h.getBottom())) {
      h.x = c.getRight() + h.width/2 + 1;
      h.speedX = 0;
    } else {
      h.y = c.getTop() + h.height/2 + 1;
      h.speedY = 0;
    }
  }
  
  public static void flyingUpAndToTheLeft(Hero h, Collidable c) {
    if(Math.abs(c.getRight() - h.getLeft()) <= Math.abs(c.getBottom() - h.getTop())) {
      h.x = c.getRight() + h.width/2 + 1;
      h.speedX = 0;
    } else {
      h.y = c.getBottom() - h.height/2 - 1;
      h.speedY = 0;
    }
  }
  
  public static void flyingUpAndToTheRight(Hero h, Collidable c) {
    if(Math.abs(c.getRight() - h.getLeft()) <= Math.abs(c.getBottom() - h.getTop())) {
      h.x = c.getLeft() - h.width/2 - 1;
      h.speedX = 0;
    } else {
      h.y = c.getBottom() - h.height/2 - 1;
      h.speedY = 0;
    }
  }
}
