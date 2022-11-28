package insert_into_database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import database.MyConnection;

public class InsertIntoBill {

	public static boolean insertIntoBill(int id, int consumer_id, String year, String month, int units_consumed) throws ClassNotFoundException, SQLException {
		Connection con = MyConnection.getConnection("electricity");
		CallableStatement cst = con.prepareCall("{call insert_into_bill(?, ?, ?, ?, ?, ?)}");
		
		cst.setInt(1, id);
		cst.setInt(2, consumer_id);
		cst.setString(3, year);
		cst.setString(4, month);
		cst.setInt(5, units_consumed);
		
		cst.registerOutParameter(6, java.sql.Types.DECIMAL);
		Double amount = cst.getDouble(6);
		
		
		boolean result = cst.execute();
		
		return result;
	}

}
