package insert_into_database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOperation {
	public static void insert(Connection con) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		boolean result;
		do {
			System.out.println("Choose a table: \n1.Consumer \n2.Consumer Type \n3.City \n4.Area \n5.Exit");
			System.out.println("Enter the table choice");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				System.out.println("Enter number of consumers you want to add:");
				int n = Integer.parseInt(sc.nextLine());
				int count =1;
				do {
					System.out.println("Enter Consumer Details of consumer number: " + count);
					System.out.println(">>");
					System.out.print("Enter Consumer Id : ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Consumer Name : ");
					String consumerName = sc.nextLine();
					System.out.print("Enter Area Id : ");
					int areaId = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Consumer Type Id : ");
					int consumerTypeId = Integer.parseInt(sc.nextLine());
					result = InsertIntoConsumer.insertIntoConsumer(con, id, consumerName, areaId, consumerTypeId);
					if(result) count++;
				} while(!result || count <= n);
				break;

			case 2:
				do {
					System.out.println("Enter Consumer Type Details");
					System.out.println(">>");
					System.out.println("Enter consumer type id:");
					int id = Integer.parseInt(sc.nextLine());
					System.out.println("Enter consumer type name:");
					String type_name = sc.nextLine();
					System.out.println("Enter the rate:");
					double rate = Double.parseDouble(sc.nextLine());
					result = InsertIntoConsumerType.insertIntoConsumerType(con, id, type_name, rate);
				}while(!result);
				break;
				
			case 3:
				do {
					System.out.println("Enter City Details");
					System.out.println(">>");
					System.out.println("Enter the city id");
					int city_id=Integer.parseInt(sc.nextLine());
					System.out.println("Enter the city name");
					String city_name=sc.nextLine();
					result = InsertIntoCity.insertIntoCity(con, city_id, city_name);
				} while (!result);
				break;
				
			case 4:
				do {
					System.out.println("Enter Area Details");
					System.out.println(">>");
					System.out.print("Enter area Id : ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("Enter area_name : ");
					String area_name = sc.nextLine();
		            System.out.print("Enter city_id : ");
		            int city_id = Integer.parseInt(sc.nextLine());
					result = InsertIntoArea.insertIntoArea(con, id,area_name,city_id);
				} while(!result);
				break;

			
			case 5:
				System.out.println("Closing the Insertion Operation...");
				break;
			default:
				System.out.println("Wrong Choice. Enter Valid Choice!!!");
			}
			System.out.println("--------------------------------------------");
		} while(choice != 5);
	}
}
