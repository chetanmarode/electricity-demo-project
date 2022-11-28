package reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MyConnection;

class GenerateReports{
	
	public ArrayList<String> name(ResultSet rs) throws SQLException {
		ArrayList<String> listconsumers = new ArrayList<String>();
		
		while(rs.next()) {
			String temp = rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getInt(5) + " " + rs.getDouble(6);
			listconsumers.add(temp);
		}
		
		return listconsumers;
	}
}

public class GenerateBill {

	public static void getBills() throws ClassNotFoundException, SQLException {
		Connection con = MyConnection.getConnection("electricity_bill");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM bill";
		
		ResultSet rs = st.executeQuery(query);

	}

}
