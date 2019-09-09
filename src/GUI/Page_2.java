/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import Project.*;
/**
 *
 * @author dell
 */
public class Page_2 extends Application {


    OrderingProcesses op[] ;
    

    AllProcess ap = new AllProcess();

    public Page_2(int NoProc) {
        op = new OrderingProcesses[NoProc];
    }
    
    @Override
    public void start(Stage primaryStage) {


        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

        for(int i=0;i<op.length;i++)
            op[i] = new OrderingProcesses();
        
        
        Button btn = new Button("Continue");
        btn.setStyle("-fx-font:20 Tahoma; -fx-base:white");

        
        
        root.setHalignment(btn, HPos.CENTER); 
        root.setValignment(btn, VPos.CENTER); 
        Text no = new Text("Process");
        root.add(no, 5, 0);
        Text proc[] = new Text[op.length];
        no.setFill(javafx.scene.paint.Color.WHITE);
        no.setFont(Font.font ( 30));
        
        for (int i = 0; i < op.length; i++) {
            proc[i] = new Text("p" + (i + 1));
            root.add(proc[i], 5, i + 2);
            proc[i].setFill(javafx.scene.paint.Color.WHITE);
            proc[i].setFont(Font.font ( 30));

        }

        
        Text BT = new Text("Burst Time");
        root.add(BT, 20, 0);
        TextField bt[] = new TextField[op.length];
        BT.setFill(javafx.scene.paint.Color.WHITE);
        BT.setFont(Font.font ( 30));


        
        
        for (int j = 0; j < op.length; j++) {
            bt[j] = new TextField();
            root.add(bt[j], 20, j + 2);
        }

        Text Pr = new Text("Priority");
        root.add(Pr, 35, 0);
        TextField pri[] = new TextField[op.length];
        Pr.setFill(javafx.scene.paint.Color.WHITE);
        Pr.setFont(Font.font ( 30));

        
        int k=0;
        for ( ; k < op.length; k++) {
            pri[k] = new TextField();
            root.add(pri[k], 35, k + 2);
        }
        root.add(btn, 25, k+2);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                boolean act = true;
                Validation v = new Validation();
                
                for(int i=0;i<op.length;i++){
                    if (!bt[i].getText().isEmpty() && !pri[i].getText().isEmpty() && v.checkNO(bt[i].getText()) && v.checkNO(pri[i].getText())){
                        op[i].setBurstTime(Integer.parseInt(bt[i].getText()));
                        op[i].setPriority(Integer.parseInt(pri[i].getText()));
                        op[i].setNameOfProcess("P"+(i+1));
                    }
                    else{
                        act = false;
                        break;
                    }
                }
                if(act){
                    Arrays.sort(op);
                    primaryStage.close();
                    Stage s = new Stage();
                    new Result(op).start(s);
                }
                else
                    showAlert(Alert.AlertType.ERROR, root.getScene().getWindow(), " Error_Message", "Please, Enter Right Data :) \nTry Again ..");

            }
        });
                       


        
        final Scene scene = new Scene(root, 1300, 500);
        final Scene scenesc = new Scene(scroll, 1300, 500);
       scroll.setFitToWidth(true);
       scroll.setFitToHeight(true);

             Image image=new Image("file:cpu.jpg");
        
            BackgroundImage backgroundimage = new BackgroundImage(image,  
                                             BackgroundRepeat.REPEAT,  
                                             BackgroundRepeat.REPEAT,  
                                             BackgroundPosition.DEFAULT,  
                                              BackgroundSize.DEFAULT); 
            Background background = new Background(backgroundimage); 
                        root.setBackground(background);
        scroll.setContent(root);
        //primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setScene(scenesc);

        primaryStage.setTitle("Taking Info");
        primaryStage.show();


    }

    /**
     * @param args the command line arguments
     */

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
