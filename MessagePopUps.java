import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;  
import java.util.*;
public class MessagePopUps {

  public static void main(String[] a) throws Exception{    
    //bank of notifications
      
      //parsing a CSV file into Scanner class constructor  
      try{
         Scanner sc = new Scanner(new File("C:/Users/Owner/Documents/GitHub/Programs/attemptAgainAgain/NotificationCentral/CSV test.csv"));  
         sc.useDelimiter(",");   //sets the delimiter pattern
         String[][] notifications = new String[20][3];     
         String nextSource;
         String nextMessage;
         String nextTimeStamp;
         
         int numNotifications = 0;
         int cnt = 0;
           
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
               //System.out.println(notifications[i][0] + ": " + notifications[i][1] + " -- recieved at " + notifications[i][2]);
               numNotifications = numNotifications + 1; 
            }//end if
         }//end for
   
   
       JFrame parent = new JFrame();
       Scanner scnr = new Scanner(System.in);  // Create a Scanner object
   
           
       String[] message = {"New deals here!", "Document update required", "Don't forget about", "New assignment posted"};
       String[] mediaPlatform = {"Outlook", "Canvas", "Outlook", "Canvas"};
   
       String userInput = "y"; // initialize
   
       while(!userInput.equals("n")){
          //pick random notification
          int len = numNotifications;
          Random r = new Random();
          int i =  r.nextInt((len - 0));
          System.out.println(i);
      
          //notification pop up
          String message35;
          if(notifications[i][1].length() >35){
             message35 = notifications[i][1].substring(0, 35);
          }//end if
          else{
             message35 = notifications[i][1];
          }//end else
          
          JOptionPane.showMessageDialog(parent, notifications[i][0] + ": " + message35 + "  recieved at " + notifications[i][2]);
          System.out.print("Keep going? (y/n) ");
          userInput = scnr.nextLine();  // Read user input
       }//end while
  
       System.out.println("\nNo more notifications");
    }//end try
    
    catch (Exception e){
			System.err.println("Output error: " + e);
	 }//end catch
        
  }//end main
}//end class