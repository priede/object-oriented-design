
import java.util.*;
import javafx.scene.layout.Pane;

public class FishTank {
   List<Fish> fishes = new ArrayList<>();
   Pane p;
   boolean suspended = false;
   
   private FishType ft;         

   public FishTank(Pane p) {
      this.p = p;
   }
   
   public void addFish(FishFactory facfishy) {
	   Fish f = null;
//	   if (fishtype == 0)
//		   ft = new AngelFish(); 
//	   else if (fishtype == 1)
//		   ft = new MeanFish();
//	   else if (fishtype == 2)
//		   ft = new Octopus();
//	   else if (fishtype == 3)
//		   ft = new YellowFish();
	   
	   FishType ft = facfishy.create(); 
	   FishBehavior fb = facfishy.newBehave();
	   f = new Fish(ft, fb);
	   fishes.add(f);
	   p.getChildren().add(f.getView());
   }

   public void startAnimation() {
      suspended = false;
   }

   public void stopAnimation() {
      suspended = true;
   }

   public void move(double height, double width) {
      if (!suspended) {
         for (Fish f : fishes) 
            f.move(height, width);
      }
   }
}
