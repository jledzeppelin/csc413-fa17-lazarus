package GameObjects;

import Images.ImageLoader;
import ObjectEnumerations.ObjectID;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class StopButton extends GameObject {
  BufferedImage block;
  
  public StopButton(int x, int y, ObjectID id) {
    super(x, y, id);
    
    ImageLoader loader = new ImageLoader();
    block = loader.loadImage("/Button.png");
  }
  
  @Override
  public void tick() {
    
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