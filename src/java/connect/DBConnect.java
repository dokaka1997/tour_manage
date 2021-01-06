/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.*;

/**
 *
 * @author Dao Van Do
 */
public class DBConnect {

    private static final String hostName = "localhost";
    private static final String dbName = "demo";
    private static final String userName = "sa";
    private static final String password = "12345678";
    private static final String connectionURL = "jdbc:mysql://localhost:4306/demo?autoReconnect=true&useSSL=false";

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
