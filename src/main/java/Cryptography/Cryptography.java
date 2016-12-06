import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cryptography
{
	private JOptionPane joptPane = new JOptionPane();
	private Scanner scanner = new Scanner(System.in);
	private int num1,num2,num3,num4;

	//constructor
	public Cryptography(int number1,int number2,int number3,int number4)
	{
		num1 = number1;
		num2 = number2;
		num3 = number3;
		num4 = number4;
	}

	/*
	setters and getters
	*/

	public void setNum1(int n1)
	{
		num1 = n1;
	}

	public int getNum1()
	{
		return num1;
	}

	public void setNum2(int n2)
	{
		num2 = n2;
	}

	public int getNum2()
	{
		return num2;
	}

	public void setNum3(int n3)
	{
		num3 = n3;
	}

	public int getNum3()
	{
		return num3;
	}

	public void setNum4(int n4)
	{
		num4 = n4;
	}

	public int getNum4()
	{
		return num4;
	}

	public int encrypter()
	{
		int rem1 = (getNum1()+7)%10;
		int rem2 = (getNum2()+7)%10;
		int rem3 = (getNum3()+7)%10;
		int rem4 = (getNum4()+7)%10;

		int result = (rem3*1000)+(rem4*100)+(rem1*10)+(rem2);
		return result;
	}

	public void displayEncryptedMsg()
	{
		joptPane.showMessageDialog(null,"Encrypted Message: " + encrypter());
		joptPane.showMessageDialog(null,"Decrypted Message: " + decrypter());

	}

	public int decrypter()
	{
		int enc = encrypter();
		int mDecrypt[] = {getNum1(),getNum2(),getNum3(),getNum4()};
		int n1 = mDecrypt[0];
		int n2 = mDecrypt[1];
		int n3 = mDecrypt[2];
		int n4= mDecrypt[3];

		int decrypt = (n1*1000)+(n2*100)+(n3*10)+n4;
		return decrypt;
	}

//end
}
