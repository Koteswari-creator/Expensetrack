
import java.io.Serializable;

public class Transaction implements Serializable {
	
	private int id;
	private String type;
	private String category;
	private String date;
	private double amount;
	
	public Transaction(int id,String type,String category,String date,double amount){
		this.id = id;
		this.type = type;
		this.category = category;
		this.date = date;
		this.amount = amount;
		
	}
	
	public int getId(){
		return id;
	}
	public String getType(){
		return type;
	}
	public String getCategory(){
		return category;
	}
	public String getDate(){
		return date;
	}
	public double getAmount(){
		return amount;
	}
	
	public void display(){
		System.out.println(id + " | " + type + " | "  + category + " | " + date + " | " + amount);
	}

}