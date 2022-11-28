package main_package;

import java.sql.SQLException;
import java.util.Scanner;

import insert_into_database.InsertIntoBill;
import insert_into_database.InsertIntoConsumer;
import insert_into_database.InsertOperation;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		
		do {
			
			// Taking the choice from the user
			System.out.println("Select an Operation: ");
			System.out.println("1.Insertion into table");
			System.out.println("2.Register a Consumer");
			System.out.println("3. Calculate Bill Amount for a customer");
			System.out.println("0.Exit");
			System.out.println("Enter choice...");
			choice = sc.nextInt();
			switch(choice) {
			case 1: 
				
				// Inserting Data into table
				InsertOperation.insert();
				break;
			case 2:
				
				// Registering one Consumer
				System.out.println("Enter Consumer Details: ");
				System.out.print("Enter Consumer Id : ");
				int id = Integer.parseInt(sc.nextLine());
				System.out.print("Enter Consumer Id : ");
				String consumerName = sc.nextLine();
				System.out.print("Enter Area Id : ");
				int areaId = Integer.parseInt(sc.nextLine());
				System.out.print("Enter Consumer Type Id : ");
				int consumerTypeId = Integer.parseInt(sc.nextLine());
				InsertIntoConsumer.insertIntoConsumer(id, consumerName, areaId, consumerTypeId);
				System.out.println("Consumer Registered Successfully!!!");
				break;
			case 3:
				boolean result;
				// Calculate Bill for a particular consumer
				do {
					System.out.println("Enter the consumer Details for Calculating Bill Amount:");
					System.out.println(">>");
					System.out.println("Enter the consumer id:");
					int cid = Integer.parseInt(sc.nextLine());
					System.out.println("Enter the area id:");
					int aid = Integer.parseInt(sc.nextLine());
					System.out.println("Enter the year");
					String year = sc.nextLine();
					System.out.println("Enter the month");
					String month = sc.nextLine();
					System.out.println("Enter the units consumed");
					int units = Integer.parseInt(sc.nextLine());
					while(units < 0) {
						System.out.println("The units are negative.. Please enter units > 0");
						units = Integer.parseInt(sc.nextLine());
					}
					result = InsertIntoBill.insertIntoBill(cid, aid, year, month, units);
				} while(!result);
			case 0:
				System.out.println("Exiting the Operation....");
				break;
			}
			
			System.out.println("**************************************");
		}while(choice != 0);
	}
}
