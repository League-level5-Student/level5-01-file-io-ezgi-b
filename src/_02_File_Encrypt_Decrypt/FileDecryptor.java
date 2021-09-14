package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	private int key;
	public FileDecryptor() {
		key = Integer.parseInt(JOptionPane.showInputDialog("Enter the key."));
		String s = "";
		
		try {
			BufferedReader bR = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/EncryptedText"));
			String line = bR.readLine();
			while(line != null){
				s+=line;
				line = bR.readLine();
			}
			bR.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String v = "";
		System.out.println(s);
		for(String c: s.split("")) {
			char ch = c.charAt(0);
			v+=shiftBackUsingKey(ch);
		}
		JOptionPane.showMessageDialog(null,v);
		
	}
	
	
	public char shiftBackUsingKey(char c) {
		int cee = (int)c;
		if(cee >= 65 && cee<=90) {
			cee-=key;
			if(cee>90) {
				int i = cee - 90;
				cee = 64 + i;
			}else if (cee<65) {
				int i = 65 - cee;
				cee = 91 - i;
			}
		}else if(cee >= 97 && cee<=122) {
			cee-=key;
			if(cee>122) {
				int i = cee - 122;
				cee = 96 + i;
			}else if (cee<97) {
				int i = 97 - cee;
				cee = 123 - i;
			}
		}
		return (char) cee;
	}
	
	
	public static void main(String[] args) {
		FileEncryptor fE = new FileEncryptor();
		FileDecryptor fD = new FileDecryptor();
	}
}
