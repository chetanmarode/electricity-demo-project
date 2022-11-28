package main_package;

import java.util.Scanner;

import insert_into_database.InsertOperation;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		
		do {
			System.out.println("Select an Operation: ");
			System.out.println("1.Insertion");
			System.out.println("0.Exit");
			System.out.println("Enter choice...");
			choice = sc.nextInt();
			switch(choice) {
			case 1: 
				InsertOperation.insert();
				break;
			case 0:
				System.out.println("Exiting the Operation....");
				break;
			}
		}while(choice != 0);
	}
}
