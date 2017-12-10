package LazarusGameWorld;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class EndingScreen {
  public void loadEnding(Graphics graphics, int width, int height, String message) {
    Font gameOverFont = new Font("Monotype Corsiva", Font.BOLD, 80);
      
    FontMetrics metrics = graphics.getFontMetrics(gameOverFont);
    int xPos = (width - metrics.stringWidth(message)) / 2;
    int yPos = (height - metrics.getHeight()) / 2 + metrics.getAscent();
    graphics.setFont(gameOverFont);
      
    graphics.setColor(Color.black);
    graphics.fillRect(0, 0, width, height);
    graphics.setColor(Color.white);
    graphics.drawString(message, xPos, yPos - 15);   
  }
}