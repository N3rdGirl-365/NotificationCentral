package test;

import java.io.IOException;
import java.io.*;

public class RuntimeExecTest1 {

	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Opening notepad");
         String filePath = "C:\\Users\\Owner\\Documents\\GitHub\\Programs\\attemptAgainAgain\\NotificationCentral\\javaFX\\sample.txt";
         File file = new File(filePath);
         if(file.exists()){
            System.out.println("HELLO!!!!!");
         }//end if
			Runtime runTime = Runtime.getRuntime();
			Process process = runTime.exec("notepad");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Closing notepad");
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}