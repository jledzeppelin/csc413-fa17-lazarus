import java.util.ArrayList;
import java.awt.Graphics;
import java.util.HashMap;

public class GameHandler {
  ArrayList<GameObject> obj = new ArrayList<GameObject>();
  private static final HashMap<PlayerStates, String> images = new HashMap();
  private static final HashMap<PlayerStates, Integer> stripLength = new HashMap();
  
  private boolean moveRight = false;
  private boolean moveLeft = false;
  
  public void tick() { 
    for (int i = 0; i < obj.size(); i++) {
      GameObject tmpObj = obj.get(i);
      tmpObj.tick();
    }
  }
  
  public void renderPlayer(Graphics graphics) {
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
  
  public String getImageString(PlayerStates state) {
    return images.get(state);
  }
  
  public int getStripLength(PlayerStates state) {
    return stripLength.get(state);
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
    images.put(PlayerStates.Standing, "Lazarus_stand.png");
    images.put(PlayerStates.Scared, "Lazarus_afraid_strip10.png");
    images.put(PlayerStates.Squished, "Lazarus_squished_strip11.png");
    images.put(PlayerStates.MoveLeft, "Lazarus_left_strip7.png");
    images.put(PlayerStates.MoveRight, "Lazarus_right_strip7.png");
    images.put(PlayerStates.JumpLeft, "Lazarus_jump_left_strip7.png");
    images.put(PlayerStates.JumpRight, "Lazarus_jump_left_strip7.png");
    
    stripLength.put(PlayerStates.Standing, 1);
    stripLength.put(PlayerStates.Scared, 10);
    stripLength.put(PlayerStates.Squished, 11);
    stripLength.put(PlayerStates.MoveLeft, 7);
    stripLength.put(PlayerStates.MoveRight, 7);
    stripLength.put(PlayerStates.JumpLeft, 7);
    stripLength.put(PlayerStates.JumpRight, 7);
  }
}