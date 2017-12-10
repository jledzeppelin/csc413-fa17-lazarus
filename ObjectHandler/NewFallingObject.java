package ObjectHandler;

import GameObjects.FallingBlock;
import GameObjects.GameObject;
import ObjectEnumerations.ObjectID;

public class NewFallingObject {
  private GameHandler handler;
  private ObjectID nextInQueue;
  
  public NewFallingObject(GameHandler handler) {
    this.handler = handler;
  }
  
  public void createNewFallingObject(ObjectID nextBlock) {
    boolean create = true;
    boolean playerCreated = false;
    GameObject tmpGameObject;
    ObjectID randomID;
    int x = 0;
    
    for (int i = 0; i < handler.obj.size(); i++) {
      tmpGameObject = handler.obj.get(i);
      
      if (tmpGameObject.getID() == ObjectID.Player) {
        x = tmpGameObject.getX();
        playerCreated = true;
      } else if (tmpGameObject.isFalling()) {
        create = false;
      }
    }
    
    
    if (create && playerCreated) {
      handler.addObject(new FallingBlock(x, 0, nextBlock, handler));
      nextInQueue = randomID = ObjectID.randomFallingBlock();
    }
    
  }
  
  public ObjectID getNextInQueue() {
    return nextInQueue;
  }
}