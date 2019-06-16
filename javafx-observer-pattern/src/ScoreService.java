import java.awt.List;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreService {
	
	private ArrayList<Client> observers = new ArrayList<Client>();
	private boolean changed = false;
	
	private String sportname = null; 
	private String hometeam = null; 
	private String awayteam = null; 
	private String homescore = null;
	private String awayscore = null; 

	public void addClient(Client c) {
		observers.add(c); 
	}
	
	public void removeClient(Client c) {
		observers.remove(c); 
	}
	
	public void notifyObservers() {
        if (changed)
           for (Client obs : observers)
        	   		obs.newScore(sportname, hometeam, awayteam, homescore, awayscore);
        changed = false;
     }
	
	public void setChanged() {
        changed = true;
	}
	
	public Parent getRoot() {
		  VBox p3 = new VBox(8);
	      p3.setAlignment(Pos.CENTER); 
	      p3.setPadding(new Insets(10));
	      p3.setBackground(
	            new Background(
	                  new BackgroundFill(Color.LIGHTGREY, 
	                        new CornerRadii(20), new Insets(0))));
	      
	      Label type = new Label("Home Team");
	      Label teamname = new Label("Name");
	      TextField textField1 = new TextField ();
	      HBox hb = new HBox();
	      hb.getChildren().addAll(teamname, textField1);
	      hb.setSpacing(10);
	   
	      Label score = new Label("Score");
	      TextField textField2 = new TextField ();
	      HBox hb2 = new HBox();
	      hb2.getChildren().addAll(score, textField2);
	      hb2.setSpacing(10);

	      p3.getChildren().addAll(type, hb, hb2);

	      
	      ////////////////////////////////////////////////
	      
	      
		  VBox p4 = new VBox(8);
		  p4.setAlignment(Pos.CENTER); 
		  p4.setPadding(new Insets(10));
		  p4.setBackground(
	            new Background(
	                  new BackgroundFill(Color.LIGHTGREY, 
	                        new CornerRadii(20), new Insets(0))));
	      
	      Label type2 = new Label("Away Team");
	      Label teamname2 = new Label("Name");
	      TextField textField1_2 = new TextField ();
	      HBox hb3 = new HBox();
	      hb3.getChildren().addAll(teamname2, textField1_2);
	      hb3.setSpacing(10);
	   
	      Label score2 = new Label("Score");
	      TextField textField2_2 = new TextField ();
	      HBox hb4 = new HBox();
	      hb4.getChildren().addAll(score2, textField2_2);
	      hb4.setSpacing(10);

	      p4.getChildren().addAll(type2, hb3, hb4);
	      
	      
	      //////////////////////////////////////////////
	      
	      
	      VBox p5 = new VBox(8);
	      p5.setAlignment(Pos.CENTER); 
	      p5.setPadding(new Insets(10));
	      p5.setBackground(
	            new Background(
	                  new BackgroundFill(Color.LIGHTGREY, 
	                        new CornerRadii(20), new Insets(0))));
	      
	      Label sport = new Label("Sport");
	      TextField textField3 = new TextField ();
	      HBox hb5 = new HBox();
	      hb5.getChildren().addAll(sport, textField3);
	      hb5.setSpacing(10);
	      
	      p5.getChildren().addAll(sport, hb5);
	      
	      
	      ////////////////////////////////////////////
	      
	      
	      HBox p2 = new HBox(8);
	      p2.setAlignment(Pos.CENTER);
	      p2.setPadding(new Insets(10));
	      Button btn  = new Button("SUBMIT");
	      btn.setDisable(true);
	      p2.getChildren().addAll(p3, p4, p5, btn);

	      VBox p1 = new VBox(8);
	      p1.setAlignment(Pos.CENTER);
	      p1.setPadding(new Insets(10));
	      p1.getChildren().addAll(p2);
	      
	      p1.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> {

	    	  	 sportname = textField3.getText(); 
	    	  	 hometeam = textField1.getText(); 
	    	  	 awayteam = textField1_2.getText(); 
	    	  	 homescore = textField2.getText(); 
	    	  	 awayscore = textField2_2.getText(); 

	    	  	 setChanged();
	    	  	 notifyObservers(); 
	      });

//	      ObservableValue<String> obsval = chbx.valueProperty();
	      ChangeListener<String> listener = 
	            (obj, oldval, newval) -> btn.setDisable(newval==null);
//	      obsval.addListener(listener);
	      
	      /* alternatively,
	            chbx.valueProperty().addListener(
	                      (obj, oldval, newval) -> btn.setDisable(newval==null));
	     */
	      
	      btn.setOnAction(event -> {
//	         String foreign = ckbx1.isSelected() ? "Foreign " : "";
//	         String preferred = ckbx2.isSelected() ? "Preferred " : "";
//	         String acct = chbx.getValue();
//	         title.setText(foreign + preferred + " Account Created");
	      });
	      
	      return p1; 
	}
	
}

class ColorLabelHandler implements EventHandler<Event> {
	   private Label lbl;
	   private Color color;

	   public ColorLabelHandler(Label lbl, Color color) {
	      this.lbl = lbl;
	      this.color = color;
	   }

	   public void handle(Event e) {
	      lbl.setTextFill(color);
	   }
	}
