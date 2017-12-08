import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;

public abstract class NextBlock extends GameObject {
  protected static HashMap<ObjectID, Integer> blockWeightMap = new HashMap<>();
  protected static HashMap<ObjectID, Integer> blockSpeedMap = new HashMap<>();
  protected boolean isFalling = false;
  
  public NextBlock(int x, int y, int weight, int fallingSpeed, ObjectID id) {
    super(x, y, id);
    this.weight = weight;
    this.fallingSpeed = fallingSpeed;
  }
  
  public abstract void tick();
  public abstract void render(Graphics graphics);
  public abstract Rectangle getBounds();
  
  public boolean isFalling() {
    return isFalling;
  }
  public void setFall(boolean fall) {
    isFalling = fall;
  }
  
  static {
    blockWeightMap.put(ObjectID.CardboardBox, 1);
    blockWeightMap.put(ObjectID.Rock, 3);
    blockWeightMap.put(ObjectID.Mesh, 0); 
    blockWeightMap.put(ObjectID.MetalBox, 4);
    blockWeightMap.put(ObjectID.StoneBox, 5);
    blockWeightMap.put(ObjectID.WoodBox, 2);
    
    blockWeightMap.put(ObjectID.CardboardBox, 5);
    blockWeightMap.put(ObjectID.Rock, 7);
    blockWeightMap.put(ObjectID.Mesh, 5);
    blockWeightMap.put(ObjectID.MetalBox, 8);
    blockWeightMap.put(ObjectID.StoneBox, 9);
    blockWeightMap.put(ObjectID.WoodBox, 6);
  }
}