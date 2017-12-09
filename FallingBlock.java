
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
    //y += yVelocity * blockSpeedMap.get(id);
    y += 1;
    
    for (int i = 0; i < handler.obj.size(); i++) {
      GameObject tmpObj = handler.obj.get(i);
      
      //if (tmpObj.getID() != ObjectID.Player | ObjectID.)
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