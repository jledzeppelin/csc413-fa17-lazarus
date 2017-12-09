import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageStripLoader {
  private BufferedImage[] imageStrip;
  private BufferedImage image;
  private int tileSize;
  
  public BufferedImage[] getImageStrip(String source, int length) {
    try {
      //TO DO check is the strip is being cut up correctly
      
      image = ImageIO.read(getClass().getResource(source));
      tileSize = image.getWidth() / length;
      imageStrip = new BufferedImage[length];
      
      for (int i = 0; i < imageStrip.length; i++) {
        imageStrip[i] = image.getSubimage(i * tileSize, 0, tileSize, tileSize);
      }    
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    
    return imageStrip;
  }
}