
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Managetransactions {
	Scanner sc = new Scanner(System.in);
	ArrayList<Transaction> transactions = new ArrayList<>();
	int idCounter = 1;
	
	public void addIncome(){
		String category = " ";
		System.out.println("choose income category");
			System.out.println("1.salary");
			System.out.println("2.Business");
			System.out.println("3.Investment");
			System.out.println("Enter choice");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice){
			case 1:
				category = "salary";
				break;
			case 2 :
				category = "Business";
				break;
			case 3 :
				category = "investment";
				break;
			default :
				category = "other income";
			}
		
		System.out.println("Enter amount");
		double amount = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Enter date(YYYY-MM):");
		String date = sc.nextLine();
		sc.nextLine();
		
		Transaction t = new Transaction(idCounter++,"Income",category,date,amount);
		transactions.add(t);
		System.out.println("Income added successfully");
	}
	
	public void addExpense(){
		    String category = " ";
			System.out.println("Choose expense category");
			System.out.println("1.Food");
			System.out.println("2.Rent");
			System.out.println("3.Travel");
			System.out.println("4.Shopping");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
			case 1:
				category = "Food";
				break;
			case 2:
				category = "Rent";
				break;
			case 3:
				category = "Travel";
				break;
			case 4:
				category = "Shopping";
				break;
			default :
				category = "other expenses";
			}
			System.out.println("Enter amount");
			double amount = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Enter date(YYYY-MM):");
			String date = sc.nextLine();
			sc.nextLine();
			
			Transaction t = new Transaction(idCounter++,"Expense",category,date,amount);
			transactions.add(t);
			System.out.println("Expense added successfully");
			
			
		}
	
	public void viewTransactions(){
		if(transactions.isEmpty()){
			System.out.println("No Transactions");
			return;
		}else{
			System.out.println("ALL TRANSACTIONS:");
			for(Transaction t : transactions){
				t.display();
			}
		}
	}
	
	
	public void monthlySummary(){
		System.out.println("show all monthly summary (YYYY-MM):");
		String month = sc.nextLine();
		double  income = 0,expense = 0;
		for(Transaction t : transactions){
			if(t.getDate().equals(month)){
				if(t.getType().equals("Income")){
					income = income + t.getAmount();
				}else{
					expense = expense + t.getAmount();
				}
				
			}
		}
		System.out.println("Monthly summary for:" +month);
		System.out.println("Total income:" +income);
		System.out.println("Total expense:" +expense);
		System.out.println("Total Balance:" + (income - expense));
		
		
	}
	
	 public void saveToFile(){
		 try{
			 ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("transactions.dat"));
			 out.writeObject(transactions);
			 out.close();
			 System.out.println("Data saved successfully");
			 
		 }catch(IOException e){
			 System.out.println("Error saving data: " +e.getMessage());
		 }
	 }
	 
	 public void loadFile(){
		 try{
			 ObjectInputStream in = new ObjectInputStream(new FileInputStream("transactions.dat"));
			 transactions = (ArrayList<Transaction>) in.readObject();
			 in.close();
			 System.out.println("data loaded successfully");
			 idCounter = transactions.size() + 1;
			 
		 }catch(IOException | ClassNotFoundException e){
			 System.out.println("No existing data found.starting fresh");
		 }
	 }
			
	
}
	

