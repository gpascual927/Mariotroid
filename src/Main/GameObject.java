package Main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jeezy
 */
public class GameObject extends Collidable {
  private static final double SPRINT = 20;
  private static final int SPRINT_MULTIPLIER = 4;
  private double MAX_SPEED_X = PhysicsEngine.TERMINAL_SPRINT;
  private double MAX_SPEED_Y = PhysicsEngine.TERMINAL_VELOCITY;
  protected String name = "Default";
  protected double speedX; // movement increment x
  protected double speedY; // movement increment y
  private boolean isSprinting;
  
  public GameObject(int texId, double x, double y, double w, double h) {
    super(texId, x, y, w, h);
    speedX = 0.0;
    speedY = 0.0;
    isSprinting = false;
  }
  
  public double getSpeedX() { return speedX; }
  public double getSpeedY() { return speedY; }
  public void setSpeedX(double spdX) { speedX = spdX; }
  public void setSpeedY(double spdY) { speedY = spdY; }
  public void setSpeed(double spdX, double spdY) { speedX = spdX; speedY = spdY; }
  
  /**
   * Moves object if no collisions detected with nearObjects.  Returns direction of collions if one
   * is found, otherwise returns DIRECTION.NONE;
   * @param nearObjects
   * @return 
   */
  public Map<Integer, Collidable> move(Map<Integer, Collidable> nearObjects) {
    Map<Integer, Collidable> collisions = new HashMap<>();
    x += speedX;
    y += speedY;
    
    if(speedX != 0) setFlipY(speedX < 0); // this reverses the sprite with direction changes
    
    for(Collidable near : nearObjects.values()) {
      if(collidesWith(near.getBoundary()))
        collisions.put(near.getTextureId(), near);
    }

    return collisions;
  }
  public void increaseSpeed(double deltaX, double deltaY) {
    speedX += deltaX;
    speedY += deltaY;
    if(Math.abs(speedX) > MAX_SPEED_X)
      speedX = (speedX < 0) ? -MAX_SPEED_X : MAX_SPEED_X;
    if(Math.abs(speedY) > MAX_SPEED_Y)
      speedY = (speedY < 0) ? -MAX_SPEED_Y : MAX_SPEED_Y;
  }
  
  public void resetAll() {
    this.resetPosition();
    this.setSpeed(0, 0);
  }
  
  public String getName() { return name; }
  public void setName(String to) { name = to; }
  
  /**
   * Toggles between maximum running speeds.
   */
  public void toggleSprint() {
    if(!isSprinting) {
      MAX_SPEED_X *= SPRINT_MULTIPLIER;
      isSprinting = true;
    } else {
      MAX_SPEED_X /= SPRINT_MULTIPLIER;
      isSprinting = false;
    }
  }
  
  public void setSprinting(boolean to) { isSprinting = to; }
  public boolean isSprinting() { return isSprinting; }
}
