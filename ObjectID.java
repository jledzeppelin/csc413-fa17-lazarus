
import java.util.ArrayList;
import java.util.Random;

public enum ObjectID {
  Player(),
  StopButton(),
  CardboardBox(),
  Mesh(),
  MetalBox(),
  Rock(),
  StoneBox(),
  Wall(),
  WoodBox();
  
  private static final ArrayList<ObjectID> fallingBlockList = new ArrayList<>();
   
  static {
    fallingBlockList.add(CardboardBox);
    fallingBlockList.add(Mesh);
    fallingBlockList.add(MetalBox);
    fallingBlockList.add(Rock);
    fallingBlockList.add(StoneBox);
    fallingBlockList.add(WoodBox);
  }
  
  private static final int size = fallingBlockList.size();
  private static final Random random = new Random();
  
  public static ObjectID randomFallingBlock() {
    return fallingBlockList.get(random.nextInt(size));
  }
  
  public static boolean isAFallingBlock(ObjectID id) {
    if (fallingBlockList.contains(id)) {
      return true;
    }
    return false;
  }
}