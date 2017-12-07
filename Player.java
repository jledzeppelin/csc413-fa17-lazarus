import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
  private int health;
  private int lives;
  private int movesLeft;
  
  private BufferedImage[] blobStrip;
  private BufferedImage test;
  GameHandler handler;
  
  public Player(int x, int y, ObjectID id, GameHandler handler) {
    super(x, y, id);
    this.handler = handler;
    health = 100;
    lives = 3;
    
    ImageLoader loader = new ImageLoader();
    test = loader.loadImage("/Lazarus_stand.png");
    movesLeft = 0;
    //blobStrip = handler.getImageString(PlayerStates.Standing);
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
      
      movesLeft--;
    } else {
      if (handler.isLeft()) {
        //moves by 6 for 7 times to equal the width of a block
        xVelocity = -6;
        movesLeft = 7;
        //blobStrip = handler.getImageString(PlayerStates.MoveLeft);
      }
    
      if (handler.isRight()) {
        xVelocity = 6;
        movesLeft = 7;
        //blobStrip = handler.getImageString(PlayerStates.MoveRight);
      }
    }

  }
  
  @Override
  public void render(Graphics graphics) {
    //int tmpIndex = blobStrip.length - movesLeft;
    
    //graphics.drawImage(blobStrip[tmpIndex], x, y, null);
    graphics.drawImage(test, x, y, width, height, null);
  }
  
  @Override
  public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
  }
 
  /*
  private void collision() {
    for (int i = 0; i < handler.obj.size(); i++) {
      GameObject tmpObj = handler.obj.get(i);
      
      if (tmpObj.getID() == ObjectID.IndestructibleBlock || tmpObj.getID() == ObjectID.DestructibleBlock || 
              tmpObj.getID() == ObjectID.Player1){
        if (getBounds().intersects(tmpObj.getBounds())) {
          x += xSpeed * -1;
          y += ySpeed * -1;
        }
      }
    }
  }
  */
}