import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class NextBlock extends GameObject {
  protected int fallingXPosition;
  protected int weight;
  
  public NextBlock(int x, int y, int xPos, int weight, int fallingSpeed, ObjectID id) {
    super(x, y, id);
    this.fallingXPosition = xPos;
    this.weight = weight;
    this.yVelocity = fallingSpeed;
  }
  
  public abstract void tick();
  public abstract void render(Graphics graphics);
  public abstract Rectangle getBounds();
  
  public int getXPosition() {
    return fallingXPosition;
  }
  public int getWeight() {
    return weight;
  }
  public void setXPosition(int x) {
    fallingXPosition = x;
  }
  public void setWeight(int w) {
    weight = w;
  }
}