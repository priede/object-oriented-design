import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HW10Program extends Application {
        public void start(Stage stage) {
           ScoreService service = new ScoreService();
           Client c1 = new SportClient("chess", service);
           Client c2 = new SportClient("golf", service);
           Client c3 = new TeamClient("bc", service);
           stage.setScene(new Scene(service.getRoot()));
           stage.setTitle("Score Service");
           stage.show();
}
        public static void main(String[] args) {
           Application.launch(args);
} }