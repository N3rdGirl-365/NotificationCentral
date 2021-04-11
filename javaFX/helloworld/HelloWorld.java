package helloworld;

 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;


public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World!");
        
        FileInputStream input = new FileInputStream("helloworld/icons/canvas.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        Button btn1 = new Button("Canvas", imageView);
        //btn.setMinWidth(100);
        btn1.setMaxWidth(200);
        btn1.setMaxHeight(50);
        
        /*btn1.setText();
        Image image
        
        Button btn2 = new Button();
        btn2.setMaxWidth(200);
        btn2.setMaxHeight(50);
        btn2.setText("button2");
        //btn2.setIcon(new ImageIcon("C:\Users\stein.000\Documents\GitHub\workspace\NotificationCentral\javaFX\helloworld\icons\canvas.png"));
        Image canvas = new Image(getClass().getResourcesAsStream("canvas.png"));
        btn2.setGraphic(new ImageView(canvas));
        */
        btn1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                btn1.setMaxHeight(200);
                btn1.setMaxWidth(200);
                btn1.setText("Okay, I get it....");
                primaryStage.setMaxWidth(200);
                
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
        root.getChildren().add(btn1);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
        //when you maximize the window, it sticks to the left of the screen
        primaryStage.setHeight(500);
        primaryStage.setWidth(100);
        primaryStage.setMaxWidth(200);
    }
}