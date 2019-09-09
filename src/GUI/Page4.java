/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.page1;
import javafx.scene.image.Image;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import Project.*;


/**
 *
 * @author DELL
 */
public class Page4 extends Application{

    OrderingProcesses processes[];
    Button Reset ;
    int sumBurstTime = 0;
    
    Text avgWT ;Text avgTA_T ;Text avgResponse ;Text avgBurstTime ;
    TextField tavgWT ;TextField tavgTA_T ;TextField tavgResponse;TextField tavgBurstTime;
    TextField tWT ;TextField tTA_T ;TextField tResponse ;TextField tBurstTime ; 
    
    
    // Constructor
    public Page4(OrderingProcesses processes[]){
        this.processes = processes;
        this.Reset = new Button("Reset :) ");
        
        Reset.setStyle("-fx-font:20 Tahoma; -fx-base:white");
        
        this.avgResponse = new Text("Avg Response Time : ");
        
        avgResponse.setFill(javafx.scene.paint.Color.WHITE);
        avgResponse.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        this.avgTA_T = new Text("Avg Turnaround Time : ");
        
        avgTA_T.setFill(javafx.scene.paint.Color.WHITE);
        avgTA_T.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        this.avgWT = new Text("Avg Waiting Time : ");
        
        avgWT.setFill(javafx.scene.paint.Color.WHITE);
        avgWT.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        this.avgBurstTime = new Text("Avg Burst Time : ");
        
        avgBurstTime.setFill(javafx.scene.paint.Color.WHITE);
        avgBurstTime.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        
        this.tResponse = new TextField();
        this.tTA_T = new TextField();
        this.tWT = new TextField();
        this.tavgResponse = new TextField();
        this.tavgTA_T = new TextField();
        this.tavgWT = new TextField();
        this.tavgBurstTime = new TextField();
        this.tBurstTime = new TextField();
    }
    
    public void initalizeComponents(GridPane pane){
        int i ,j,k;
        int arrWTandRT[] =  new AllProcess().WaitingTimeForEachProc(processes);
        int arrTA_T[] =  new AllProcess().TurnaroundTimeForEachProc(processes);
        Text no = new Text("Process");
        
        no.setFill(javafx.scene.paint.Color.WHITE);
        no.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        pane.add(no, 5, 0);
        Text proc[] = new Text[15];
        for (i = 0; i < processes.length; i++) {
            proc[i] = new Text(processes[i].getNameOfProcess());
            
            proc[i].setFill(javafx.scene.paint.Color.WHITE);
            proc[i].setFont(Font.font("Arial", FontWeight.BOLD, 20));
            pane.add(proc[i], 6, i + 2);
        }
        Text summ =new Text("Summation");
        summ.setFill(javafx.scene.paint.Color.WHITE);
        summ.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        pane.add(summ, 5, i+2);
        
        
        Text BT = new Text("Burst Time");
        
        BT.setFill(javafx.scene.paint.Color.WHITE);
        BT.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        pane.add(BT, 15, 0);
        TextField bt[] = new TextField[15];
        for ( j = 0; j < processes.length; j++) {
            bt[j] = new TextField(""+processes[j].getBurstTime());
            sumBurstTime += processes[j].getBurstTime();
            bt[j].setEditable(false);
            pane.add(bt[j], 15, j + 2);
        }
        tBurstTime.setText(""+sumBurstTime);
        pane.add(tBurstTime,15,j+2);
        
        Text WT = new Text("Waiting Time");
        
       WT.setFill(javafx.scene.paint.Color.WHITE);
        WT.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 
        
        pane.add(WT, 20, 0);
        TextField wt[] = new TextField[15];
        for ( j = 0; j < processes.length; j++) {
            wt[j] = new TextField(""+arrWTandRT[j]);
            wt[j].setEditable(false);
            pane.add(wt[j], 20, j + 2);
        }
        pane.add(tWT,20,j+2);

        Text RT = new Text("Response Time");
        
        RT.setFill(javafx.scene.paint.Color.WHITE);
        RT.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        pane.add(RT, 30, 0);
        TextField rt[] = new TextField[15];
        for ( k = 0; k < processes.length; k++) {
            rt[k] = new TextField(""+arrWTandRT[k]);
            rt[k].setEditable(false);
            pane.add(rt[k], 30, k + 2);
        }
        pane.add(tResponse,30,k+2);
        
        
        Text TA = new Text("Turnaround Time");
        
        TA.setFill(javafx.scene.paint.Color.WHITE);
        TA.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        pane.add(TA, 35, 0);
        TextField ta[] = new TextField[15];
        for ( k = 0; k < processes.length; k++) {
            ta[k] = new TextField(""+arrTA_T[k]);
            ta[k].setEditable(false);
            pane.add(ta[k], 35, k + 2);
        }
        pane.add(tTA_T,35,k+2);
        
    }
    
    public void setPanels(GridPane pane){
        
        pane.add(avgWT,40,2);
        pane.add(tavgWT,45,2);
        pane.add(avgTA_T,40,3);
        pane.add(tavgTA_T,45,3);
        pane.add(avgResponse,40,4);
        pane.add(tavgResponse,45,4);
        pane.add(avgBurstTime,40,5);
        pane.add(tavgBurstTime,45,5);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        GridPane pane = new GridPane();
        initalizeComponents(pane);
        //*************
        pane.setHgap(2);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
        // put Components in pane *********
        setPanels(pane);
        //****************   :)   *********
        
        
        

        
        
        
        Image image=new Image("file:cpu.jpg");
        
        BackgroundImage backgroundimage = new BackgroundImage(image,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundPosition.DEFAULT,  
                                              BackgroundSize.DEFAULT); 
            Background background = new Background(backgroundimage); 
                        pane.setBackground(background);

                
        
        tWT.setText(""+ new AllProcess().SumWaitingTime(processes));
        tTA_T.setText(""+ new AllProcess().SumTurnaroundTime(processes));
        tResponse.setText(""+ new AllProcess().SumWaitingTime(processes));
        
        tavgWT.setText(""+ (Double.parseDouble(tWT.getText())/processes.length));
        tavgTA_T.setText(""+ (Double.parseDouble(tTA_T.getText())/processes.length));
        tavgResponse.setText(""+ (Double.parseDouble(tResponse.getText())/processes.length));
        tavgBurstTime.setText(""+ sumBurstTime/(double)processes.length);
        
        tWT.setEditable(false);
        tTA_T.setEditable(false);
        tResponse.setEditable(false);
        tavgWT.setEditable(false);
        tavgTA_T.setEditable(false);
        tavgResponse.setEditable(false);
        tBurstTime.setEditable(false);
        tavgBurstTime.setEditable(false);
        
        
        
        
        
        
        pane.add(Reset,30,processes.length+5);
        
        final Scene scene = new Scene(pane, 1300, 500);
        primaryStage.setScene(scene);
        final Scene scenesc = new Scene(scroll, 1300, 500);
        primaryStage.setScene(scenesc);
        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true);
        scroll.setContent(pane);
        primaryStage.setTitle("Taking Info");
     //   primaryStage.setResizable(false);

        primaryStage.show();
        
        // To Reset Program
        this.Reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    primaryStage.close();
                    Stage s = new Stage();
                    new page1().start(s);
                }
                catch(Exception exc){
                    exc.printStackTrace();
                }
            }

        });
        
    }
    
}
