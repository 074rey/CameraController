package mavenproject1;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class App extends Application {
    
private Map<String, Image> imageMap;
private ImageView imv;
private ComboBox<String> cbo;
private Rectangle rectangle = new Rectangle(60, 20, Color.WHITE);

    public void start(Stage stage) {
        //border
 BorderPane pane = new BorderPane(); 
//top 
HBox top = new HBox();
 Text t1=new Text("Panasonic");
 t1.setFont(Font.font("Helvetica",FontWeight.BLACK,FontPosture.REGULAR,13));
top.getChildren().add(t1); 
top.setStyle("-fx-border-color: gray;"); 
top.setPadding(new Insets(15.5, 260.5, 25.5, 260.5));
//right 
HBox right = new HBox(); 
Text tt=new Text("| | |");
tt.setFont(Font.font("Helvetica",FontWeight.BLACK,FontPosture.REGULAR,30));
right.getChildren().add(tt);
right.setStyle("-fx-border-color: white;");
right.setPadding(new Insets(370.5, 40.5, 60.5, 21.5));
//bottom 
HBox bottom = new HBox();

bottom.setStyle("-fx-border-color: gray;"); 
bottom.setPadding(new Insets(9.5, 230.5, 20.5, 245.5));
//left
HBox left = new HBox();
//left.getChildren().add(new Text("Left")); 
left.setStyle("-fx-border-color: white;");
left.setPadding(new Insets(380.5, 80.5, 60.5, 11.5));
//center 
HBox center = new HBox(); 

center.setStyle("-fx-border-color: white;");
//Place nodes in the pane 
pane.setTop(top);
pane.setRight(right);

pane.setLeft(left); 
pane.setCenter(center);
   String[] doors = {"Door1", "Door2", "Door3"};
//
//        // Initialize the image map
        imageMap = new HashMap<>();
        imageMap.put("Door1", new Image("file:C:///Users/rey7s/OneDrive/الصور/lab4i.jpg"));
        imageMap.put("Door2", new Image("file:C:///Users\\rey7s\\OneDrive\\الصور\\641f253050c84481641e73a6305cd7e5.jpg"));
        imageMap.put("Door3", new Image("file:C:///Users/rey7s/OneDrive/الصور/6fe3afeaeaa01e03e3a4d12a093ac1f1.jpg"));

      cbo = new ComboBox<>();
        cbo.setEditable(true);
        cbo.setPrefWidth(70);
        cbo.setValue("Door1");
        cbo.getItems().addAll(doors);
        cbo.setVisibleRowCount(3);

        imv = new ImageView();
        imv.setFitWidth(400);
        imv.setFitHeight(430);
        imv.setPreserveRatio(true);
        imv.setX(75);
        imv.setY(59);
        //
        imv.setImage(imageMap.get("Door1"));
        cbo.valueProperty().addListener((observable, oldValue, newValue) -> switchImage());

        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setCenter(cbo);

       
      
        pane.getChildren().add(imv);
         FlowPane pane2 = new FlowPane();
        pane2.setPadding(new Insets(60, 100, 70, 75));
Circle cc=new Circle(40);
        ToggleButton button = new ToggleButton("ON");
        button.setOnAction(event -> {
            switchImage();          
            cc.setFill(Color.GREEN);
            });
         Text i=new Text("its off");
         ToggleButton button2 = new ToggleButton("OFF");
        button2.setOnAction(event -> {
            ni();
             cc.setFill(Color.RED);
             
                });
        
        ToggleGroup gt2=new ToggleGroup();
        button2.setToggleGroup(gt2);
        button.setToggleGroup(gt2); 
    
         pane2.setPadding(new Insets(400, 90, 400, 90));
        pane2.setHgap(30);
        pane2.setVgap(30); 
        pane2.getChildren().addAll(paneForComboBox);
        pane2.getChildren().addAll(button,button2);
        
   
        Button enlargeButton = new Button(" > ");
        Button shrinkButton = new Button(" < ");

        enlargeButton.setOnAction(new EnlargeHandler());
        shrinkButton.setOnAction(new ShrinkHandler());

        HBox hbox = new HBox(10);
        hbox.setLayoutX(80.0);
        hbox.setLayoutY(340.0);
        hbox.getChildren().addAll(enlargeButton, shrinkButton, rectangle);
        Image i2 =new Image("file:C:///Users\\rey7s\\OneDrive\\الصور\\المستندات\\mic2222.png");
        ImageView imv2=new ImageView(i2);
        imv2.setFitHeight(30);
        imv2.setFitWidth(30);
        imv2.setLayoutX(290);
         imv2.setLayoutY(334);
        imv2.setPreserveRatio(true);
        cc.setCenterX(200);
        cc.setCenterY(200);
        
        bottom.getChildren().add(cc);
    pane.setBottom(bottom);
    Group g=new Group(pane,pane2,hbox,imv2);
    Scene scene = new Scene(g,570, 630);  
   stage.setTitle("Surveillance Camera controller_Reema Ali");   
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
 
    private void switchImage() {
   String s= cbo.getValue();
   Image si=imageMap.get(s);
 
   if (si!=null){
       imv.setImage(si);
   }
    }
       
      private void ni(){
          imv.setImage(null);
          cbo.getSelectionModel().clearSelection();
      }
      
      
    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if(rectangle.getWidth() < 110 && rectangle.getHeight() > 5){
            rectangle.setWidth(rectangle.getWidth()+5 );
            rectangle.setHeight(rectangle.getHeight() );
        }
        }
    }

    class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (rectangle.getWidth() > 10 && rectangle.getHeight() > 5) {
                rectangle.setWidth(rectangle.getWidth() -5);
                rectangle.setHeight(rectangle.getHeight() );
            }
        }
    }

    }
