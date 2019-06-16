
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class FishAnimation extends AnimationTimer {
   private FishTank tank;
   private Pane contents;
   
   public FishAnimation(FishTank tank, Pane p) {
      this.tank = tank;
      contents = p;
   }
   
   public void handle(long now) {
      double h = contents.getLayoutBounds().getHeight();
      double w = contents.getLayoutBounds().getWidth();
      tank.move(h,w);
   }
}
