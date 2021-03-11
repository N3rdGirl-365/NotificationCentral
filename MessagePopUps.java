import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;

public class MessagePopUps {

  public static void main(String[] a) {
    JFrame parent = new JFrame();
    Scanner scnr = new Scanner(System.in);  // Create a Scanner object
    
    //bank of notifications
    String[] message = {"New deals here!", "Document update required", "Don't forget about", "New assignment posted"};
    String[] mediaPlatform = {"Outlook", "Canvas", "Outlook", "Canvas"};

    String userInput = "y"; // initialize

    while(!userInput.equals("n")){
       //pick random notification
       int len = message.length;
       Random r = new Random();
       int i =  r.nextInt((len - 0));
       System.out.println(i);
   
       //notification pop up
       JOptionPane.showMessageDialog(parent, mediaPlatform[i]+": "+message[i]);
       System.out.print("Keep going? (y/n) ");
       userInput = scnr.nextLine();  // Read user input
    }//end while
    
    System.out.println("\nNo more notifications");
  }//end main
}//end class