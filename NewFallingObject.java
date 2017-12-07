
import java.util.concurrent.ThreadLocalRandom;



public class NewFallingObject {
  private GameHandler handler;
  
  NewFallingObject(GameHandler handler){
    this.handler = handler;
  }
  
  void newObject() {
    boolean check = false;
    
    
    //check if any object is falling
    for( int i = 0; i < handler.obj.size(); i++){
      if(handler.obj.get(i).checkFalling()){
        check = true;
      }
    }
    
    
    if (check == false){
      // random number from 1 to 4
      int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
      if(randomNum == 1){
        handler.addObject(new cardBoardBox());
      } else if (randomNum == 2){
        handler.addObject(new woodBox());
      }else if (randomNum == 3){
        handler.addObject(new metalBox());
      } else {
        handler.addObject(new stoneBox());
      }
    }
    
  
  }
}
