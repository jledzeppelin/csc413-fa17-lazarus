import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class NextBlock extends GameObject {
  protected int weight;
  protected int fallingSpeed;
  protected boolean isFalling = false;
  
  public NextBlock(int x, int y, int weight, int fallingSpeed, ObjectID id) {
    super(x, y, id);
    this.weight = weight;
    this.fallingSpeed = fallingSpeed;
  }
  
  public abstract void tick();
  public abstract void render(Graphics graphics);
  public abstract Rectangle getBounds();
  
  public int getWeight() {
    return weight;
  }
  public void setWeight(int w) {
    weight = w;
  }
  public boolean isFalling() {
    return isFalling;
  }
  public void setFall(boolean fall) {
    isFalling = fall;
  }
}