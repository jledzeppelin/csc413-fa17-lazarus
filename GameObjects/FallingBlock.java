package GameObjects;

import Images.ImageLoader;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import ObjectEnumerations.ObjectID;
import ObjectHandler.GameHandler;


public class FallingBlock extends NextBlock {
  private BufferedImage block;
  GameHandler handler;
  
  public FallingBlock(int x, int y, ObjectID id, GameHandler handler) {
    super(x, y, id);
    this.handler = handler;
    
    ImageLoader loader = new ImageLoader();
    block = loader.loadImage(this.handler.getImageSource(id));
    isFalling = true;
  }
  
  @Override
  public void tick() {
    //need to implement collision differently if i want different speeds
    //y += yVelocity * blockSpeedMap.get(id);
    y += yVelocity;
    
    if (isFalling) {
      yVelocity = 2;
    
      for (int i = 0; i < handler.obj.size(); i++) {
        GameObject tmpObj = handler.obj.get(i);
      
        //better way to check instersects
        if (tmpObj.getID() == ObjectID.Player) {   
          if (getBounds().intersects(tmpObj.getBounds()) && this.isFalling) {
            handler.removeObject(this);
            handler.setResetLevel(true);
            tmpObj.lives--;
          }
        
        } else if (tmpObj.getID() == ObjectID.Wall || tmpObj.getID() == ObjectID.StopButton) {
          if (getBounds().intersects(tmpObj.getBounds())) {
            yVelocity = 0;
            isFalling = false;
          }
        
        } else {
          if (tmpObj != this && getBounds().intersects(tmpObj.getBounds())) {
            if (blockWeightMap.get(this.id) > blockWeightMap.get(tmpObj.getID())) {
              handler.removeObject(tmpObj);
              soundPlayer.playSound("/res/Crush.wav");
            } else {
              yVelocity = 0;
              isFalling = false;
              i = handler.obj.size();
            }
          }
        }
      }
    }
    
  }
  
  @Override
  public void render(Graphics graphics) {
    graphics.drawImage(block, x, y, width, height, null);
  }
  
  @Override
  public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
  }
}