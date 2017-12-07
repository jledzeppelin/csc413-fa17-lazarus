import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class GameHandler {
  ArrayList<GameObject> obj = new ArrayList<GameObject>();
  //private static final HashMap<PlayerStates, BufferedImage[]> images = new HashMap();
  //private static final HashMap<PlayerStates, Integer> stripLength = new HashMap();
  private ImageStripLoader imgStripLoader = new ImageStripLoader();
  private BufferedImage[] tmp;
  
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
  
  /*
  static {
    //creating BufferedImage[] for all the actions/movements
    ImageStripLoader imgStripLoader = new ImageStripLoader();
    BufferedImage[] tmp;
    
    tmp = imgStripLoader.getImageStrip("/Lazarus_stand.png", 1);
    images.put(PlayerStates.Standing, tmp);
    tmp = imgStripLoader.getImageStrip("/Lazarus_afraid_strip10.png", 10);
    images.put(PlayerStates.Scared, tmp);
    tmp = imgStripLoader.getImageStrip("/Lazarus_squished_strip11.png", 11);
    images.put(PlayerStates.Squished, tmp);
    tmp = imgStripLoader.getImageStrip("/Lazarus_left_strip7.png", 7);
    images.put(PlayerStates.MoveLeft, tmp);
    tmp = imgStripLoader.getImageStrip("/Lazarus_right_strip7.png", 7);
    images.put(PlayerStates.MoveRight, tmp);
    tmp = imgStripLoader.getImageStrip("/Lazarus_jump_left_strip7.png", 7);
    images.put(PlayerStates.JumpLeft, tmp);
    tmp = imgStripLoader.getImageStrip("/Lazarus_jump_right_strip7.png", 7);
    images.put(PlayerStates.JumpRight, tmp);
    
    images.put(PlayerStates.Scared, imgStripLoader.getImageStrip("/Lazarus_afraid_strip10.png", 10));
    images.put(PlayerStates.Squished, imgStripLoader.getImageStrip("/Lazarus_squished_strip11.png", 11));
    images.put(PlayerStates.MoveLeft, imgStripLoader.getImageStrip("/Lazarus_left_strip7.png", 7));
    images.put(PlayerStates.MoveRight, imgStripLoader.getImageStrip("/Lazarus_right_strip7.png", 7));
    images.put(PlayerStates.JumpLeft, imgStripLoader.getImageStrip("/Lazarus_jump_left_strip7.png", 7));
    images.put(PlayerStates.JumpRight, imgStripLoader.getImageStrip("/Lazarus_jump_right_strip7.png", 7));
    
    
    //probably dont need
    stripLength.put(PlayerStates.Standing, 1);
    stripLength.put(PlayerStates.Scared, 10);
    stripLength.put(PlayerStates.Squished, 11);
    stripLength.put(PlayerStates.MoveLeft, 7);
    stripLength.put(PlayerStates.MoveRight, 7);
    stripLength.put(PlayerStates.JumpLeft, 7);
    stripLength.put(PlayerStates.JumpRight, 7);
  }
  */
}