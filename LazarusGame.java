import java.awt.*;
import java.awt.Canvas;
import java.awt.image.*;

public class LazarusGame extends Canvas implements Runnable {
  public static int WIDTH = 806; //weird dimensions, stick to 20 blocks wide for this to work
  public static int HEIGHT = 829;
  
  private boolean isRunning = false;
  private Thread thread;
  private GameHandler handler;
  
  private BufferedImage level;
  private BufferedImage background;
  private BufferedImage lives; //could put into own class
  private BufferedImage floor;
  
  boolean gameOver = false;
  String message;
          
  public LazarusGame() {
    new GameWindow(WIDTH, HEIGHT, "Lazarus", this);
    start();
    handler = new GameHandler();
    this.addKeyListener(new KeyInput(handler));
    
    ImageLoader loader = new ImageLoader();
    level = loader.loadImage("/LazarusSimpleMap.png");
    background = loader.loadImage("/Background.png");
    
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
    handler.tick();
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
    
    handler.render(graphics);
    
    //health and lives
    /*
    graphics.setColor(Color.gray);
    graphics.fillRect(0, 500, 100, 20);
    graphics.setColor(Color.green);
    graphics.fillRect(0, 500, player1Health, 20);
    graphics.setColor(Color.black);
    graphics.drawRect(0, 500, 100, 20);
    
    for (int i = 0; i < player1Lives; i++){
      graphics.drawImage(lives, 120 + 30 * i, 491, 34, 34, null);
    }
    */
    
    /*
    if (gameOver) {
      Font gameOverFont = new Font("Monotype Corsiva", Font.BOLD, 80);
      
      FontMetrics metrics = graphics.getFontMetrics(gameOverFont);
      int xPos = (WIDTH - metrics.stringWidth(message)) / 2;
      int yPos = (HEIGHT - metrics.getHeight()) / 2 + metrics.getAscent();
      graphics.setFont(gameOverFont);
      
      graphics.setColor(Color.black);
      graphics.fillRect(0, 0, WIDTH, HEIGHT);
      graphics.setColor(Color.white);
      graphics.drawString(message, xPos, yPos - 15);
    }
    */
    
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
          handler.addObject(new Wall(xAxis * 40, yAxis * 40, ObjectID.Wall));
        }
        if (green == 255) {
          handler.addObject(new Player(xAxis * 40, yAxis * 40, ObjectID.Player, handler));
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
