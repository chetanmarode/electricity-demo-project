package main_package;

import java.sql.SQLException;
import java.util.Scanner;

import insert_into_database.InsertIntoConsumer;
import insert_into_database.InsertOperation;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		
		do {
			System.out.println("Select an Operation: ");
			System.out.println("1.Insertion into table");
			System.out.println("Register a Consumer");
			System.out.println("0.Exit");
			System.out.println("Enter choice...");
			choice = sc.nextInt();
			switch(choice) {
			case 1: 
				InsertOperation.insert();
				break;
			case 2:
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
			case 0:
				System.out.println("Exiting the Operation....");
				break;
			}
		}while(choice != 0);
	}
}
