import java.awt.*;
import java.awt.Canvas;
import java.awt.image.*;

public class LazarusGame extends Canvas implements Runnable {
  public static int WIDTH = 845;
  public static int HEIGHT = 701;
  
  private boolean isRunning = false;
  private Thread thread;
  private GameHandler handler;
  private EndingScreen ending;
  private NewFallingObject fallingObject;
  
  private BufferedImage level;
  private BufferedImage background;
  private BufferedImage lives;
  
  private int playerLives;
  //private int resetPosX;
  //private int resetPosY;
  boolean gameOver = false;
  String message;
          
  public LazarusGame() {
    new GameWindow(WIDTH, HEIGHT, "Lazarus", this);
    start();
    handler = new GameHandler();
    this.addKeyListener(new KeyInput(handler));
    fallingObject = new NewFallingObject(handler);
    
    ImageLoader loader = new ImageLoader();
    level = loader.loadImage("/LazarusSimpleMap.png");
    background = loader.loadImage("/Background.png");
    lives = loader.loadImage("/heart.png");
    
    loadLevel(level);
  }
  
  private void start() {
    isRunning = true;
    thread = new Thread(this);
    thread.start();
  }
  
  private void stop() {
    isRunning = false;
    
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public void tick() {
    for (int i = 0; i < handler.obj.size(); i++) {
      if (handler.obj.get(i).getID() == ObjectID.Player) {
        playerLives = handler.obj.get(i).lives;
        
        if (playerLives == 0) {
          gameOver = true;
          message = "GAME OVER";
        }
      }
    }
    
    handler.tick();
    fallingObject.createNewFallingObject();
  }
  
  public void render() {
    BufferStrategy buffStrat = this.getBufferStrategy();
    
    if (buffStrat == null) {
      this.createBufferStrategy(3);
      return;
    }  
    Graphics graphics = buffStrat.getDrawGraphics();
    
    //***************** Start of drawing section
    
    //background
    graphics.drawImage(background, 0, 0, WIDTH, HEIGHT, null); 
    
    //lives 
    for (int i = 0; i < playerLives; i++){
      graphics.drawImage(lives, 10 + 35 * i, 10, 40, 40, null);
    }
    
    //next block
    graphics.setColor(Color.lightGray);
    graphics.fillRect(2, 120, 42*3, 42*3);
    graphics.setColor(Color.black);
    graphics.drawRect(2, 120, 42*3, 42*3);
    
    handler.render(graphics);
    
    /*
    if (handler.resetLevel()) {
      for (int i = 0; i < handler.obj.size(); i++) {
        if (ObjectID.isAFallingBlock(handler.obj.get(i).getID())) {
          handler.removeObject(handler.obj.get(i));
        } else if (handler.obj.get(i).getID() == ObjectID.Player) {
          handler.obj.get(i).setX(resetPosX);
          handler.obj.get(i).setY(resetPosY);
        }
      }
      
    }
    */
    
    if (gameOver) {
      ending.loadEnding(graphics, WIDTH, HEIGHT, message);
    }  
    //***************** End of drawing section
    
    graphics.dispose();
    buffStrat.show();
  }
  
  public void loadLevel(BufferedImage image) {
    int width = image.getWidth();
    int height = image.getHeight();
    
    for (int xAxis = 0; xAxis < width; xAxis++) {
      for (int yAxis = 0; yAxis < height; yAxis++) {
        int pixel = image.getRGB(xAxis, yAxis);
        
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        
        if (red == 255) {
          handler.addObject(new Wall(xAxis * 42, yAxis * 42, ObjectID.Wall));
        }
        if (green == 255) {
          handler.addObject(new Player(xAxis * 42, yAxis * 42, ObjectID.Player, handler));
          //resetPosX = xAxis * 42;
          //resetPosY = yAxis * 42;
        }
        if (blue == 255) {
          handler.addObject(new StopButton(xAxis * 42, yAxis * 42, ObjectID.StopButton));
        }
      }
    }
  }
  
  //game loop here
  public void run() {
    this.requestFocus();
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    
    while (isRunning) {
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      
      while (delta >= 1) {
        tick();
        delta--;
      }
      
      render();
      frames++;
      
      if (System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        frames = 0;
      }
    }
    stop();
  }
  
  public static void main(String args[]) {
    new LazarusGame();
  }
  
}
