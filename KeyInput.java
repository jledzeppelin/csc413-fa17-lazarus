import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
  GameHandler handler;
  
  public KeyInput(GameHandler handler) {
    this.handler = handler;
  }
  
  public void keyPressed(KeyEvent event) {
    int key = event.getKeyCode();
    
    for (int i = 0; i < handler.obj.size(); i++) {
      GameObject tmpObj = handler.obj.get(i);
      
      if (tmpObj.getID() == ObjectID.Player) {
        if (key == KeyEvent.VK_A) handler.setLeft(true);
        if (key == KeyEvent.VK_D) handler.setRight(true);
      }
    }
  }
  
  public void keyReleased(KeyEvent event) {
    int key = event.getKeyCode();
    
    for (int i = 0; i < handler.obj.size(); i++) {
      GameObject tmpObj = handler.obj.get(i);

      if (tmpObj.getID() == ObjectID.Player) {
        if (key == KeyEvent.VK_A) handler.setLeft(false);
        if (key == KeyEvent.VK_D) handler.setRight(false);
      }
    }
  }
}