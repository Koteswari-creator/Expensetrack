
import java.util.Scanner;
public class Expensetracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Managetransactions m = new Managetransactions();
		Scanner sc = new Scanner(System.in);
		
		m.loadFile();
		int choice;
		
		do{
			System.out.println("Expense Tracker");
			System.out.println("1.Add income");
			System.out.println("2.Add Expense");
			System.out.println("3.view Transactions");
			System.out.println("4.view monthlySummary");
			System.out.println("5.save and Exit");
			System.out.println("Enter your Choice:");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
			case 1:
				m.addIncome();
				break;
			case 2:
				m.addExpense();
				break;
			case 3:
				m.viewTransactions();
				break;
			case 4:
				m.monthlySummary();
				break;
			case 5:
				m.saveToFile();
				System.out.println("EXIT");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			
		}while(choice != 5);

	}

}
