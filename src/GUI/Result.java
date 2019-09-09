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
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Project.*;
/**
 *
 * @author DELL
 */
public class Result extends Application {

    int sumBurstTime = 0;
    Text BurstTime[];
    TextField chart[];
    Text labelChart[];

    Button nextPage4;

    OrderingProcesses processes[];

    // Constructor
    public Result(OrderingProcesses processes[]) {
        this.processes = processes;
    }

    public void initalizeComponents(GridPane pane) {

        this.BurstTime = new Text[processes.length];
        this.chart = new TextField[processes.length];

        this.labelChart = new Text[processes.length + 1];

        for (int i = 0; i < processes.length; i++) {
            BurstTime[i] = new Text("" + processes[i].getBurstTime());
            sumBurstTime += processes[i].getBurstTime();
        }

        int arr[] = new AllProcess().WaitingTimeForEachProc(processes);
        for (int i = 0; i < processes.length; i++) {
            chart[i] = (new TextField(processes[i].getNameOfProcess()));//hy7t el process Name hna
            //chart[i].setFill(javafx.scene.paint.Color.WHITE);
            chart[i].setFont(Font.font("Arial", FontWeight.BOLD, 20));
            chart[i].setMaxSize(150, 10);

            chart[i].setStyle("-fx-background-color: #4e8eed;");

            chart[i].setEditable(false);
            labelChart[i] = (new Text("" + arr[i]));//Calc Waiting
            labelChart[i].setFill(javafx.scene.paint.Color.WHITE);
            labelChart[i].setFont(Font.font("Arial", FontWeight.BOLD, 20));
            pane.add(chart[i], i + 1, 0);
            pane.add(labelChart[i], i + 1, 1);
        }

        this.nextPage4 = new Button("Continue :)");
        pane.add(nextPage4, processes.length/2+1, 5);

        labelChart[processes.length] = (new Text("" + sumBurstTime));
        pane.add(labelChart[processes.length], processes.length + 1, 1);
        labelChart[processes.length].setFill(javafx.scene.paint.Color.WHITE);
        labelChart[processes.length].setFont(Font.font("Arial", FontWeight.BOLD, 20));

        nextPage4.setStyle("-fx-font:20 Tahoma; -fx-base:white");
        
        

    }

    @Override
    public void start(Stage primaryStage) {
        //FlowPane fp = new FlowPane();

        GridPane pane = new GridPane();
        pane.setHgap(2);
        pane.setVgap(5);
        initalizeComponents(pane);

        //*************
        System.out.println(Arrays.toString(processes));

        pane.setAlignment(Pos.CENTER);

        /*fp.getChildren().addAll(chart);
        fp.getChildren().addAll(labelChart);*/
        Image image = new Image("file:cpu.jpg");
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);
        pane.setBackground(background);

        // To Reset Program
        this.nextPage4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    primaryStage.close();
                    Stage s = new Stage();
                    new Page4(processes).start(s);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });

        Scene scene = new Scene(pane, 1300, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Result");
      //  primaryStage.setResizable(false);
        primaryStage.show();

    }

}
