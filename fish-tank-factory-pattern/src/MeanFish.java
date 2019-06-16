
import javafx.scene.image.Image;

public class MeanFish implements FishType {
   private Image leftimage, rightimage;

   public MeanFish() {
      leftimage  = new Image("images/Lmeaniefish.gif");
      rightimage = new Image("images/Rmeaniefish.gif");
   }

   public Image leftImage() {
      return leftimage;
   }

   public Image rightImage() {
      return rightimage;
   }
}
