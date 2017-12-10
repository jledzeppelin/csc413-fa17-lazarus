package ObjectHandler;

import GameObjects.GameObject;
import ObjectEnumerations.ObjectID;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.HashMap;

public class GameHandler {
  public ArrayList<GameObject> obj = new ArrayList<GameObject>();
  static HashMap<ObjectID, String> blockImageMap = new HashMap<>();
  
  private boolean moveRight = false;
  private boolean moveLeft = false;
  private boolean victory = false;
  private boolean resetLevel = false;
  
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
  
  public boolean victory() {
    return victory;
  }
  public void setVictory(boolean v) {
    victory = v;
  }
  public boolean resetLevel() {
    return resetLevel;
  }
  public void setResetLevel(boolean reset) {
    resetLevel = reset;
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
  public String getImageSource(ObjectID id) {
    return blockImageMap.get(id);
  }
  
  static {
    blockImageMap.put(ObjectID.CardboardBox, "res/CardBox.png");
    blockImageMap.put(ObjectID.Rock, "res/Rock.png");
    blockImageMap.put(ObjectID.Mesh, "res/Mesh.png");
    blockImageMap.put(ObjectID.MetalBox, "res/MetalBox.png");
    blockImageMap.put(ObjectID.StoneBox, "res/StoneBox.png");
    blockImageMap.put(ObjectID.WoodBox, "res/WoodBox.png");
  }
}