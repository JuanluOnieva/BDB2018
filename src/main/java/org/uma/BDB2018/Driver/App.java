package org.uma.BDB2018.Driver;

import java.io.IOException;
import java.sql.*;


public class App {

    public static void main( String[] args ) throws SQLException, IOException {
        //create connection for a server installed in localhost, with a user "root" with no password
    	GenericSqlConnection con = new PostgreSqlConnection();
    	con.connect("chebi_basic");
    	con.executeQuery("SELECT compound_id FROM names where name like 'water'");
    	System.out.println(con.getRows());
    	System.out.println("Execution time: " + con.getTime() + "ms");
    }
}
