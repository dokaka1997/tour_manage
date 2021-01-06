/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Partner;

/**
 *
 * @author Dao Van Do
 */
public class PaymentService {

    private Connection connection;

    public void updateStatusBill(int id) {
        int type = 0;
        try {
            DBConnect dbContext = new DBConnect();
            connection = DBConnect.getConnection();
            String sql = "UPDATE demo.Bill\n"
                    + "SET status ='Da Thanh Toan'\n"
                    + "WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
}
