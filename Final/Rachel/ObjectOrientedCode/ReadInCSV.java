//package helloworld;
 
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

 
 
public class ReadInCSV {
 private static String currentFileName = "";
 private int countNotification = 0;
 private static int counter = 0;
 private static String[][] notifications = new String[20][3];
 private static Stack<String> stackNotifications = new Stack<String>();
 public static final String APP_ID_Canvas = "Canvas";

 
 public static void main(String[] args) throws Exception{
     try{
     csvFileRead("CSV test.csv");
     getNotificationForButton("Canvas");
     System.out.println("************************************************************************");
     stackNotifications.add(notifications[0][0] + "!!");
     stackNotifications.add(notifications[1][0] + "!!");
     stackNotifications.add(notifications[2][0] + "!!");
     stackNotifications.add(notifications[3][0] + "!!");
     stackNotifications.add(notifications[4][0] + "!!");
     stackNotifications.add(notifications[5][0] + "!!");
     stackNotifications.add(notifications[6][0] + "!!");
     }//end try
     catch (Exception e){
        System.out.println("Error main: " + e); 
     }//
 }//end main
 

 
 
 //csv reading method
    private static void csvFileRead(String fileName){
       try{
          currentFileName = fileName;
          Scanner sc = new Scanner(new File(fileName));  
          sc.useDelimiter(",");   //sets the delimiter pattern
          String nextSource;
          String nextMessage;
          String nextTimeStamp;
          int cnt = 0;
          counter = 0;
        
          while (sc.hasNext()){  //returns a boolean value  
             nextSource = sc.next().replaceAll("[\\n\\t\\r]", "");//remove newline characters etc
             nextMessage = sc.next().replaceAll("[\\n\\t\\r]", "");//remove newline characters etc
             nextTimeStamp = sc.next().replaceAll("[\\n\\t\\r]", "");//remove newline characters etc
         
             notifications[cnt][0] = nextSource;
             notifications[cnt][1] = nextMessage;
             notifications[cnt][2] = nextTimeStamp;
         
             cnt = cnt + 1;
          }//end while     
          sc.close();  //closes the scanner  
      
          for(int i =0; i< notifications.length; i++){
             if (notifications[i][0] != null){
                //System.out.println("Notification ");
                counter = counter +1;
                System.out.println(notifications[i][0] + ": " + notifications[i][1] + " -- recieved at " + notifications[i][2]);
                
             }//end if
          }//end for
          System.out.println("COUNTER: " + counter);
          
      }//end try
      catch (Exception e){
         System.out.println("Error csvFileRead: " + e);
      }//end ctach
    }//end csvFileRead

    public static String[][] getNotification(String fileName){
       try{
       csvFileRead(fileName);
       return notifications;
       }//ed try
       catch(Exception e){
       System.out.println("Error getNotification: " + e);
       String[][] emptyArray = {{"null","null"}};
       return emptyArray;
       }//
    }//end getNotificatio method
 
    public static List<Integer> getNotificationForButton(String param){
      try{
      String[][] notifications = getNotification(currentFileName);
      List<Integer> listExample = new ArrayList<>();
      for(int i = 0; i < counter; i++){
         String buttonName = notifications[i][0];
         System.out.println(buttonName);
         System.out.println("PARAMTER  " + param);
         if (buttonName.equals(param)){
             listExample.add(i);
         }//end if
      }//end for
      System.out.println(listExample);
      
      //for(int i = 0; i < listExample.size(); i++){
         //int index = listExample.get(i);
         //System.out.println("First: " + notifications[index][0] + ", Second: " + notifications[index][1] + "."); 
      //}//end for
      return listExample;
      }//ed try
      catch(Exception e){
         System.out.println("Error getNotificationForButton: " + e);
         List<Integer> emptyList = new ArrayList<>();
         emptyList.add(-1);
         return emptyList;
      }//end catch
    }//end getNotificationForButton
 
}//end multipleButtonsOOP class
 
