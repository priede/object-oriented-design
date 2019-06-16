
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Aquarium extends Application {
   public static double INIT_TANK_HT = 300;
   public static double INIT_TANK_WD = 600;
   
   private FishFactory[] fishyfac =
       { AngelFactory.INSTANCE,
         MeanFactory.INSTANCE,
         OctoFactory.INSTANCE,
         YellowFactory.INSTANCE };
   
   public void start(Stage stage) {
      Pane p = new Pane();
      p.setBackground(new Background(
            new BackgroundFill(Color.DARKTURQUOISE, null, null)));
      FishTank tank = new FishTank(p);
      MenuBar bar = createMenuBar(tank);
      p.getChildren().add(bar);
     
      Scene scene = new Scene(p, INIT_TANK_WD, INIT_TANK_HT);
      stage.setScene(scene);
      stage.setTitle("Fish Tank");
      stage.show();
      
      AnimationTimer timer = new FishAnimation(tank, p);
      timer.start();
   }

   private MenuBar createMenuBar(FishTank tank) {   
      Menu animation = new Menu("Animation");
      MenuItem start = new MenuItem("start");
      start.setOnAction(e->tank.startAnimation());
      MenuItem stop = new MenuItem("stop");
      stop.setOnAction(e->tank.stopAnimation());
      animation.getItems().addAll(start, stop);

      Menu newfish = new Menu("New Fish");
      MenuItem angel = new MenuItem("angelfish");
      angel.setOnAction(e->tank.addFish(fishyfac[0]));
      MenuItem meanie = new MenuItem("mean fish");
      meanie.setOnAction(e->tank.addFish(fishyfac[1]));
      MenuItem octopus = new MenuItem("octopus");
      octopus.setOnAction(e->tank.addFish(fishyfac[2]));
      
      MenuItem yellowfish = new MenuItem("yellow fish");
      yellowfish.setOnAction(e->tank.addFish(fishyfac[3]));
      
      newfish.getItems().addAll(angel, meanie, octopus, yellowfish);

      MenuBar bar = new MenuBar();
      bar.getMenus().addAll(animation, newfish);
      return bar;
   }
   
   public static void main(String[] args) {
      Application.launch(args);
   }
}
