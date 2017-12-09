public class NewFallingObject {
  private GameHandler handler;
  
  public NewFallingObject(GameHandler handler) {
    this.handler = handler;
  }
  
  void createNewFallingObject() {
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
      randomID = ObjectID.randomFallingBlock();
      
      handler.addObject(new FallingBlock(x, 0, randomID, handler));
    }
    
  }
}