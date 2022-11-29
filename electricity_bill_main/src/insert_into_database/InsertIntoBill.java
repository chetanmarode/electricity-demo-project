package insert_into_database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.MyConnection;

public class InsertIntoBill {

	public static boolean insertIntoBill(Connection con, int id, int consumer_id, String year, String month, int units_consumed) throws ClassNotFoundException, SQLException {
		
		Statement st = con.createStatement();
		String query = "SELECT rate FROM consumer_type ct JOIN consumer c"
				+ " ON c.consumer_type_id = ct.id AND c.id = " +consumer_id;
		ResultSet rs = st.executeQuery(query);
		rs.next();
		Double rate1 = rs.getDouble(1);
		Double amount = rate1 * units_consumed;
//		System.out.println(rs.getDouble(1));
		CallableStatement cst = con.prepareCall("{call insert_into_bill(?, ?, ?, ?, ?, ?)}");
		cst.setInt(1, id);
		cst.setInt(2, consumer_id);
		cst.setString(3, year);
		cst.setString(4, month);
		cst.setInt(5, units_consumed);
		cst.setDouble(6, amount);
	
		boolean result;
		
		try {
			cst.execute();
			result = true;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			result = false;
		}
		
		return result;
	}

}
