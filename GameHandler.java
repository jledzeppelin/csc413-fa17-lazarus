import java.util.ArrayList;
import java.awt.Graphics;
import java.util.HashMap;

public class GameHandler {
  ArrayList<GameObject> obj = new ArrayList<GameObject>();
  static HashMap<ObjectID, String> blockImageMap = new HashMap<>();
  
  private boolean moveRight = false;
  private boolean moveLeft = false;
  
  public void tick() { 
    for (int i = 0; i < obj.size(); i++) {
      GameObject tmpObj = obj.get(i);
      tmpObj.tick();
    }
  }
  
  public void render(Graphics graphics) {
    for (int i = 0; i < obj.size(); i++) {
      GameObject tmpObj = obj.get(i);
      tmpObj.render(graphics);
    }
  }

  public void addObject(GameObject tmpObj) {
    obj.add(tmpObj);
  }
  
  public void removeObject(GameObject tmpObj) {
    obj.remove(tmpObj);
  }
  
  public boolean isRight() {
    return moveRight;
  }
  public boolean isLeft() {
    return moveLeft;
  }
  public void setRight(boolean right) {
    this.moveRight = right;
  }
  public void setLeft(boolean left) {
    this.moveLeft = left;
  }
  
  static {
    blockImageMap.put(ObjectID.CardboardBox, "/CardBox.png");
    blockImageMap.put(ObjectID.Rock, "/Rock.png");
    blockImageMap.put(ObjectID.Mesh, "/Mesh.png");
    blockImageMap.put(ObjectID.MetalBox, "/MetalBox.png");
    blockImageMap.put(ObjectID.StoneBox, "/StoneBox.png");
    blockImageMap.put(ObjectID.WoodBox, "/WoodBox.png");
  }
}