import java.util.Scanner;
import javax.swing.JOptionPane;

public class CryptographyTest
{
	public static void main(String[] args)
	{
		JOptionPane joptPane = new JOptionPane();
		Scanner scanner = new Scanner(System.in);

		//prompt user for the message to send

		/*
		System.out.println("Message to send");
		int msg1 = scanner.nextInt();
		*/

		System.out.println("Digit 1");
		int msg1 = scanner.nextInt();

		System.out.println("Digit 2");
		int msg2 = scanner.nextInt();

		System.out.println("Digit 3");
		int msg3 = scanner.nextInt();

		System.out.println("Digit 4");
		int msg4 = scanner.nextInt();

		//instantiate the Cryptography class
		Cryptography crypt = new Cryptography(msg1,msg2,msg3,msg4);
		crypt.encrypter();
		crypt.displayEncryptedMsg();
		crypt.decrypter();
	}
}