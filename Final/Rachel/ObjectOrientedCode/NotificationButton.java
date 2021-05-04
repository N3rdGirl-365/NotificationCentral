import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class NotificationButton extends Button implements EventHandler<ActionEvent> {
   private static ReadInCSV readInCSV = new ReadInCSV();
   private static String[][] notifications = readInCSV.getNotification(); //get notifications from prev class 
   private int countNotification = 0;
   private static int counter = 0;
   private Image icon;
   private boolean toggle = false;
   private String platformName;
   
   
       
    
   public NotificationButton(String platformName, String fileName){
      super(platformName);
      this.icon = new Image(fileName);
      this.platformName = platformName;//update instance variable
      ImageView imgView = new ImageView(this.icon);
      imgView.setFitWidth(18);
      imgView.setFitHeight(18);
      this.setGraphic(imgView);
      this.setOnAction(this);
      this.smallDimensions(this);
      System.out.println("Hello");
      System.out.println("" + notifications[0][0]);
      
   }//end conctructor
    
   //EventHandler<ActionEvent> clickButton = new EventHandler<ActionEvent>(){
   public void handle(ActionEvent event){
      try{
         if (toggle == false){
            System.out.println(platformName + " You clicked the button" + "   " + toggle);
            largeDimensions(this);
            this.setWrapText(true);
            this.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
            toggle = true;
            countNotification = countNotification+1;   
         }//end if
         else{
            System.out.println(platformName + " You clicked the button again." + "   " + toggle);
            smallDimensions(this);
            this.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
            toggle = false;
          }//end else
      }//end try
      catch(Exception e){
         System.out.println("No new notifications at this time");
         smallDimensions(this);
         this.setText("No new notifications at this time");                            
      }//end catch           
   }//end method
   //};//end event action
    
   //resizing methods
    private void smallDimensions(Button btn){
       btn.setMinWidth(200);
       btn.setMaxWidth(200);
       btn.setMinHeight(50);
    }//end smallDimensions
    private void largeDimensions(Button btn){
       btn.setMinWidth(200);
       btn.setMaxWidth(200);
       btn.setMinHeight(200);
    }//end smallDimensions
 
    //delay method
    private void delay(int time){
       try{
          Thread.sleep(time);
       }//end try
       catch(Exception e){
          Thread.currentThread().interrupt();
       }//end catch
    }//end delay method
    

    
    

}//end Notification class