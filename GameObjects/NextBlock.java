package GameObjects;

import ObjectEnumerations.ObjectID;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;

public abstract class NextBlock extends GameObject {
  protected static HashMap<ObjectID, Integer> blockWeightMap = new HashMap<>();
  protected static HashMap<ObjectID, Integer> blockSpeedMap = new HashMap<>();
  
  public NextBlock(int x, int y, ObjectID id) {
    super(x, y, id);
  }
  
  public abstract void tick();
  public abstract void render(Graphics graphics);
  public abstract Rectangle getBounds();
  
  static {
    blockWeightMap.put(ObjectID.CardboardBox, 1);
    blockWeightMap.put(ObjectID.Rock, 3);
    blockWeightMap.put(ObjectID.Mesh, 0); 
    blockWeightMap.put(ObjectID.MetalBox, 4);
    blockWeightMap.put(ObjectID.StoneBox, 5);
    blockWeightMap.put(ObjectID.WoodBox, 2);
    
    blockSpeedMap.put(ObjectID.CardboardBox, 5);
    blockSpeedMap.put(ObjectID.Rock, 7);
    blockSpeedMap.put(ObjectID.Mesh, 5);
    blockSpeedMap.put(ObjectID.MetalBox, 8);
    blockSpeedMap.put(ObjectID.StoneBox, 9);
    blockSpeedMap.put(ObjectID.WoodBox, 6);
  }
}