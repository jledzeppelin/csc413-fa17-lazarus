
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class CardboardBox extends NextBlock {
  private BufferedImage block;
  private int fallingVel = 5;
  GameHandler handler;
  
  public CardboardBox(int x, int y, int weight, int fallingSpeed, ObjectID id, GameHandler handler) {
    super(x, y, weight, fallingSpeed, id);
    this.handler = handler;
    
    ImageLoader loader = new ImageLoader();
    block = loader.loadImage("/CardBox.png");
    isFalling = true;
  }
  
  @Override
  public void tick() {
    y += yVelocity * fallingSpeed;
    
    if (isFalling) {
      yVelocity += fallingVel;
    } else {
      yVelocity += 0;
    }
    
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