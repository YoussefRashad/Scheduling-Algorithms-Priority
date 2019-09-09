/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Window;
import Project.*;

/**
 *
 * @author DELL
 */
public class page1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(0, 10, 0, 10));

        
        Text t = new Text("Enter :: Number Of Processes  .. ");
        root.add(t,40,15);
        t.setFill(javafx.scene.paint.Color.WHITE);
        t.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        TextField f = new TextField();
        root.add(f,40,20);
        
  
        Button btn = new Button();
        btn.setText("Next");
        btn.setStyle("-fx-font:20 Tahoma; -fx-base:white");
        root.add(btn, 40, 25);
        root.setHalignment(btn, HPos.CENTER); 
        root.setValignment(btn, VPos.CENTER); 
  
      
        
       
        Image image=new Image("file:cpu.jpg");
        
        BackgroundImage backgroundimage = new BackgroundImage(image,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundPosition.DEFAULT,  
                                              BackgroundSize.DEFAULT); 
            Background background = new Background(backgroundimage); 
                        root.setBackground(background);



        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Validation v = new Validation();
                if (!f.getText().isEmpty()&&v.checkNO(f.getText())){
                        Stage s = new Stage();
                        new Page_2(Integer.parseInt(f.getText())).start(s);
                        primaryStage.close();
                        f.setText("");
                }
                else
                    showAlert(Alert.AlertType.ERROR, root.getScene().getWindow(), " Error_Message", "Please, Enter Right No of Process :) \nTry Again ..");
            }
        });
        Scene scene = new Scene(root, 1300, 500);
        primaryStage.setTitle("Hello Processes :)");
        primaryStage.setScene(scene);
    //    primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
}
