import javax.swing.JOptionPane;
import java.util.Scanner;
public class InvoiceTest
{
	public static void main(String[] args)
	{
		//create objects of class Scanner and JOptionPane
		Scanner scanner = new Scanner(System.in);
		JOptionPane joptPane = new JOptionPane();

		//variables to be used in tis class
		String userQty,userDesc;
		double totalPrice;
		int userNo;

		joptPane.showMessageDialog(null,"Welcome to LuHardware Store \n You need it, we've got it!");

		//prompt the user for what they intend to purchase
		userDesc = joptPane.showInputDialog(null,"How may we help you today, what do you need?");

		//quantity needed
		userQty = joptPane.showInputDialog(null,"How many of those do you need?");
		int qty = Integer.parseInt(userQty);

		//set the price
		totalPrice = 500.50 * qty;
		String message = String.format("%d of %s will cost you %.2f",qty,userDesc,totalPrice);
		joptPane.showMessageDialog(null,message);

		//create an object of the class Invoice
		Invoice storeInvoice = new Invoice("one",userDesc,qty,totalPrice);
		storeInvoice.setDescription(userDesc);
		storeInvoice.setPrice(totalPrice);
		storeInvoice.setQuantity(qty);

		storeInvoice.getInvoiceAmount();
	}
}