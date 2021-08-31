package _01_File_Recorder;

import java.io.FileWriter;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("What message do you want to write to the file?");
		try {
			FileWriter fw = new FileWriter("src/_01_File_recorder/FileRecorderText", true);
			fw.write(message + "\n");
			fw.close();
		}catch(Exception e) {
			
		}
	}
	
	
	
}
