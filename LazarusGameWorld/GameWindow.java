package LazarusGameWorld;

import java.awt.Dimension;
import javax.swing.JFrame;


public class GameWindow {
  public GameWindow(int width, int height, String title, LazarusGame game) {
    JFrame frame = new JFrame(title);
    
    Dimension dim = new Dimension(width, height); 
    frame.setPreferredSize(dim);
    frame.setMaximumSize(dim);
    frame.setMinimumSize(dim);
    
    frame.add(game);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}