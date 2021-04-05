package helloworld;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;
 
public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        //btn.setMinWidth(100);
        btn.setMaxWidth(200);
        btn.setMaxHeight(50);
        
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                btn.setMaxHeight(200);
                btn.setMaxWidth(200);
                btn.setText("Okay, I get it....");
                
                try {
			         //System.out.println("Opening notepad");
                  String fileNameType = "null";   
                  String fileName = "ReadingInCSVFile_v2.java";
         			fileNameType = fileName; 
                  File myFile = new File(fileName);
                  String fileNameAbsolute = myFile.getAbsolutePath();
                  System.out.println(fileNameAbsolute);
                  fileNameAbsolute = fileNameAbsolute.substring(0,fileNameAbsolute.length()-fileName.length()-1) + "\\HelloWorld\\" + fileName;
                  System.out.println(fileNameAbsolute);
                  
                  File file = new File(fileNameAbsolute);
                  if (file.exists()){
                     System.out.println("DONE!");
                  }//end if
                  File file2 = new File("error.jpg");
                  
                  
                  
                  //Runtime runTime = Runtime.getRuntime();
         			//Process process = runTime.exec(fileNameAbsolute);
         			//try {
         				//Thread.sleep(5000);
         			//} 
                  //catch (InterruptedException e) {
         				//e.printStackTrace();
         			//}
         			//System.out.println("Closing notepad");
         			//process.destroy();
         		} 
               catch (Exception e) {
         			e.printStackTrace();
         		}                
               //BufferedReader b = new BufferedReader(myReader);  
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}