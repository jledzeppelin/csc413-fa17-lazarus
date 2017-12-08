import java.util.ArrayList;
import java.awt.Graphics;

public class GameHandler {
  ArrayList<GameObject> obj = new ArrayList<GameObject>();
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
  
  //public BufferedImage[] getImageString(PlayerStates state) {
  //  return images.get(state);
  //}
  
  //public int getStripLength(PlayerStates state) {
  //  return stripLength.get(state);
  //}
  
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
}