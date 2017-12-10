import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

public class SoundPlayer {
  public void playSound(String filename, float volumeAdjust) {
    float volume = 0;
    volume += volumeAdjust;
    
    try {
      Clip clip = AudioSystem.getClip();
      URL file = this.getClass().getClassLoader().getResource(filename);
      
      AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
      clip.open(inputStream);
      
      FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
      gainControl.setValue(volume);
      
      clip.start();
      
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }
  }
}