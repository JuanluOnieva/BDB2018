package org.uma.BDB2018.Driver;
import java.sql.*;

import org.mariadb.jdbc.Driver;

public class MySQLConnection extends DummySqlConnection{
	
	
	public MySQLConnection() throws SQLException{
		//create connection for a server installed in localhost, with a user "root"
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chebi?user=root&password=BDB2018");
        time = 0;
        rowsNumber = 0;
	}	

	public void executeQuery(String s){

		// create a Statement
		try (Statement stmt = connection.createStatement()){	
			//execute query
			time = 0;
			rowsNumber = 0;
			long timeBefore = System.currentTimeMillis();
			try (ResultSet rs = stmt.executeQuery(s)){ 
				time = System.currentTimeMillis() - timeBefore;
				rs.last();
				rowsNumber = rs.getRow();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getTime() {
		return ""+time;
	}

	@Override
	public String getRows() {
		return ""+rowsNumber;
	}
	
}
