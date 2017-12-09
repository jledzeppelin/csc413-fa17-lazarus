

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Player extends GameObject {
  
  private HashMap<PlayerStates, BufferedImage[]> images;
  private ImageStripLoader imgStripLoader;
  
  private int movesLeft; 
  private BufferedImage[] blobStrip;
  GameHandler handler;
  private boolean win = false;
  private boolean moving = false;
  
  public Player(int x, int y, ObjectID id, GameHandler handler) {
    super(x, y, id);
    this.handler = handler;
    lives = 3;
    
    images = new HashMap<>();
    imgStripLoader = new ImageStripLoader();
    fillImageMap();
    
    movesLeft = 0;
    blobStrip = images.get(PlayerStates.Standing);
  }
  
  @Override
  public void tick() { 
    /*
    if (health <= 0) {
      if (lives > 0) {
        lives--;
        if (lives != 0) {
          health = 100;
        }
      } else {
        handler.removeObject(this);
      }
    }
    */
    
    if (movesLeft > 0) {
      x += xVelocity;
      y += yVelocity;
      
      collision();
      movesLeft--;
    } else {
      //reset to standing image
      moving = false;
      blobStrip = images.get(PlayerStates.Standing);
      
      movesLeft = 0;
      
      if (handler.isLeft()) {
        //moves by 6 for 7 times to equal the width of a block
        xVelocity = -6;
        movesLeft = 7;
        moving = true;
        blobStrip = images.get(PlayerStates.MoveLeft);
        
      } else if (!handler.isRight()) {
        xVelocity = 0;
        yVelocity = 0;
      }
    
      if (handler.isRight()) {
        xVelocity = 6;
        movesLeft = 7;
        moving = true;
        blobStrip = images.get(PlayerStates.MoveRight);
      } else if (!handler.isLeft()) {
        xVelocity = 0;
        yVelocity = 0;
      }
    }
  }
  
  @Override
  public void render(Graphics graphics) {
    int tmpIndex;
    
    if (movesLeft == 0) {
      tmpIndex = blobStrip.length - 1;
    } else {
      tmpIndex = blobStrip.length - movesLeft;
    }
    if(moving == true){
    graphics.drawImage(blobStrip[tmpIndex], x , y - 42 , blobStrip[tmpIndex].getWidth(), blobStrip[tmpIndex].getHeight(), null);
    }else{
      graphics.drawImage(blobStrip[tmpIndex], x , y , blobStrip[tmpIndex].getWidth(), blobStrip[tmpIndex].getHeight(), null);
    }
    //graphics.drawImage(blobStrip[tmpIndex], x, y, width, height, null);
  }
  
  @Override
  public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
  }
 
  private void collision() {
    boolean intersect = false;
    
    for (int i = 0; i < handler.obj.size(); i++) {
      GameObject tmpObj = handler.obj.get(i);
      
      
      
      //TO DO add jump to block if possible
      
      if (tmpObj.getID() != ObjectID.Player ){
        if (getBounds().intersects(tmpObj.getBounds())) {
          //x += -xVelocity;
         // y += -yVelocity;
          
          
          y -= 42; 
          for (int j = 0; j < handler.obj.size(); j++) {
            GameObject tmpObj2 = handler.obj.get(j);
            if (tmpObj2.getID() != ObjectID.Player ){
              if(getBounds().intersects(tmpObj2.getBounds()))
                intersect = true;   
              }  
            }
          if (intersect == true){
            y += 42;
            x += -xVelocity;
          }else {
            y -= 0;
            x += xVelocity;
            }
        }
      } 
    }
    y += 42;
    for (int i = 0; i < handler.obj.size(); i++) {
      GameObject tmpObj = handler.obj.get(i);
      if (tmpObj.getID() != ObjectID.Player){
        if (getBounds().intersects(tmpObj.getBounds())) {
          y -= 42;
        
        }
      }
    }
  }
  
  public void fillImageMap() {
    images.put(PlayerStates.Standing, imgStripLoader.getImageStrip("/Lazarus_stand.png", 1));
    images.put(PlayerStates.Scared, imgStripLoader.getImageStrip("/Lazarus_afraid_strip10.png", 10));
    images.put(PlayerStates.Squished, imgStripLoader.getImageStrip("/Lazarus_squished_strip11.png", 11));
    images.put(PlayerStates.MoveLeft, imgStripLoader.getImageStrip("/Lazarus_left_strip7.png", 7));
    images.put(PlayerStates.MoveRight, imgStripLoader.getImageStrip("/Lazarus_right_strip7.png", 7));
    images.put(PlayerStates.JumpLeft, imgStripLoader.getImageStrip("/Lazarus_jump_left_strip7.png", 7));
    images.put(PlayerStates.JumpRight, imgStripLoader.getImageStrip("/Lazarus_jump_right_strip7.png", 7));
  }
}