package _02_File_Encrypt_Decrypt;

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
	private int key;
	public FileEncryptor(int key) {
		this.key = key;
	}
	
	public char shiftUsingKey(char c) {
		if(c >= 65 && c<=90) {
			c+=key;
			if(c>90) {
				int i = c - 90;
				c = 64 + i;
			}
		}else if(c >= 97 && c<=122) {
			c+=key;
			if(c>122) {
				int i = c - 122;
				c = 96 + i;
			}
		}
		return c;
	}
}
