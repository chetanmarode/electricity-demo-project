package insert_into_database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import database.MyConnection;

public class InsertIntoCity {
	public static boolean insertIntoCity(int id, String city_name) throws ClassNotFoundException, SQLException {
		Connection con = MyConnection.getConnection("electricity_bill");
		CallableStatement cst = con.prepareCall("{call insert_into_city(?, ?)}");
		
		cst.setInt(1, id);
		cst.setString(2, city_name);
		
		boolean result = cst.execute();
		
		return result;
	}
}
