import java.io.*;  
import java.util.*;
import java.util.Scanner;  
public class ReadingInCSVFile{  
   public static void main(String[] args) throws Exception {  
      //parsing a CSV file into Scanner class constructor  
      Scanner sc = new Scanner(new File("C:/Users/Owner/Documents/GitHub/Programs/attemptAgainAgain/NotificationCentral/CSV test.csv"));  
      sc.useDelimiter(",");   //sets the delimiter pattern
      String[][] listOfNotifications = new String[20][3];
      String[] notification = new String[3]; 
      int cnt = 0;
      int listNum = 1;
      int listOfListsNum = 0;
        
      while (sc.hasNext()){  //returns a boolean value  
         String line = sc.next();
         line = line.replaceAll("[\\n\\t\\r]", "");//remove newline characters etc
         System.out.print(line + " " + cnt + " ");  //find and returns the next complete token from this scanner  
         
                  
         
         if(cnt >= 3){ //outside of header, now we're sorting the values
            System.out.println("line!" + line + " " + listNum + " " + cnt);
            
            if ((cnt%3 ==0) && (cnt !=3)){ //multiple of 3, means you've filled out the notification array, time to save and reset
               System.out.println("Notifications filled!");
               System.out.println(notification[0]);
               System.out.println(notification[1]);
               System.out.println(notification[2]);
               
               listOfNotifications[listOfListsNum] = notification;
               
               listOfListsNum = listOfListsNum + 1;
               listNum = 1;
               
            }//end if

            if(listNum <=3){
                
                notification[listNum-1]=line;             
                listNum = listNum+1;
             }//endif
         }//end if 
         System.out.println("*********\n");
         System.out.println(listOfNotifications[0][0]);
         System.out.println(listOfNotifications[0][1]);
         System.out.println(listOfNotifications[0][2]);
         System.out.println(listOfNotifications[1][0]);
         System.out.println(listOfNotifications[1][1]);
         System.out.println(listOfNotifications[1][2]); 
         System.out.println("*********\n");
         
         cnt = cnt + 1;
      }//end while     
   sc.close();  //closes the scanner  
      
      
      
   }//end main  
}//end class  