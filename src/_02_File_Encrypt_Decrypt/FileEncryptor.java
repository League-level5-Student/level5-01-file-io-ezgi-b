package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	private String message;
	private int key;
	
	
	public FileEncryptor() {
		
		message = JOptionPane.showInputDialog("Enter a message.");
		key = Integer.parseInt(JOptionPane.showInputDialog("Enter a key."));
		String s = "";
		for(String c: message.split("")) {
			char ch = c.charAt(0);
			s+=shiftUsingKey(ch);
		}
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/EncryptedText", true);
			fw.write(s);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public char shiftUsingKey(char c) {
		int cee = (int)c;
		if(cee >= 65 && cee<=90) {
			cee+=key;
			if(cee>90) {
				int i = cee - 90;
				cee = 64 + i;
			}
		}else if(cee >= 97 && cee<=122) {
			cee+=key;
			if(cee>122) {
				int i = cee - 122;
				cee = 96 + i;
			}
		}
		return (char) cee;
	}
	
	
	public static void main(String[] args) {
		FileEncryptor fE = new FileEncryptor();
	}
}
