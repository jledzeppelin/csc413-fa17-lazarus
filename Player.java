import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
  private int health;
  private int lives;
  private int tileSize;
  private int movementLimit = 40;
  
  private BufferedImage blob;
  private BufferedImage[] blobStrip;
  ImageLoader loader;
  GameHandler handler;
  
  public Player(int x, int y, ObjectID id, GameHandler handler) {
    super(x, y, id);
    this.handler = handler;
    health = 100;
    lives = 3;
    
    loader = new ImageLoader();
    blob = loader.loadImage("/" + handler.getImageString(PlayerStates.Standing));
    tileSize = blob.getWidth() / handler.getStripLength(PlayerStates.Standing);
    blobStrip = new BufferedImage[ handler.getStripLength(PlayerStates.Standing) ];
    
    for (int i = 0; i < blobStrip.length; i++) {
      blobStrip[i] = blob.getSubimage(i * tileSize, 0, tileSize, tileSize);
    }
    
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
    
    //TO DO fix this shit
    if (movementLimit >= 0) {
      x += xVelocity;
      y += yVelocity;
    } else {
      movementLimit = 40;
    }
    
    if (handler.isLeft()) {
      if (movementLimit == 40) {
        xVelocity -= 40;
      }
    } else if (!handler.isRight()) {
      xVelocity -= 0;
    }
    
    if (handler.isRight()) {
      if (movementLimit == 40) {
        xVelocity += 40;
      }
    } else if (!handler.isLeft()) {
      xVelocity += 0;
    }
  }
  
  @Override
  public void render(Graphics graphics) {
    
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