package GameObjects;

import ObjectEnumerations.ObjectID;
import ObjectEnumerations.PlayerStates;
import Sound.SoundPlayer;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;

public abstract class GameObject {
  protected int width = 42;
  protected int height = 42;
  protected int x, y;
  protected int xVelocity = 0;
  protected int yVelocity = 0;
  protected int lives;
  protected ObjectID id;
  protected boolean isFalling = false;
  protected SoundPlayer soundPlayer = new SoundPlayer();
  
  protected static HashMap<PlayerStates, String> playerStateSound = new HashMap<>();
  protected static HashMap<ObjectID, String> gameObjectSound = new HashMap<>();
  
  public GameObject(int x, int y, ObjectID id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }
  
  public abstract void tick();
  public abstract void render(Graphics graphics);
  public abstract Rectangle getBounds();
  
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public int getWidth() {
    return width;
  }
  public int getHeigh() {
    return height;
  }
  public void setX(int x) {
    this.x = x;
  }
  public void setY(int y) {
    this.y = y;
  }
  public void setWidth(int w) {
    this.width = w;
  }
  public void setHeight(int h) {
    this.height = h;
  }
  public ObjectID getID() {
    return id;
  }
  public void setID(ObjectID id) {
    this.id = id;
  }
  public boolean isFalling() {
    return isFalling;
  }
  public void setFalling(boolean fall) {
    this.isFalling = fall;
  }
  public void setLives(int lives) {
    this.lives = lives;
  }
  public int getLives() {
    return lives;
  }
  
  static {
    playerStateSound.put(PlayerStates.JumpLeft, "Move.wav");
    playerStateSound.put(PlayerStates.JumpRight, "Move.wav");
    playerStateSound.put(PlayerStates.MoveLeft, "Move.wav");
    playerStateSound.put(PlayerStates.MoveRight, "Move.wav");
    playerStateSound.put(PlayerStates.Squished, "Move.wav");
    
    gameObjectSound.put(ObjectID.StopButton, "Button.wav");
  }
}