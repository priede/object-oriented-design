
import javafx.scene.image.Image;

public class Octopus implements FishType {
   private Image leftimage, rightimage;

   public Octopus() {
      leftimage  = new Image("images/Loctopus.gif");
      rightimage = new Image("images/Roctopus.gif");
   }

   public Image leftImage() {
      return leftimage;
   }

   public Image rightImage() {
      return rightimage;
   }
}

