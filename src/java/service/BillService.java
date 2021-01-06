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
import model.BillModel;
import model.Partner;

/**
 *
 * @author Dao Van Do
 */
public class BillService {

    private Connection connection;

    public List<BillModel> getAllBills(int idPartner) {
        List<BillModel> bills = new ArrayList<>();
        int type = 0;
        try {
            DBConnect dbContext = new DBConnect();
            connection = DBConnect.getConnection();
            String sql = "select * from demo.Bill where idPartner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idPartner);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                BillModel bill = new BillModel();
                bill.setId(rs.getInt("id"));
                bill.setCode(rs.getString("code"));
                bill.setMoney(rs.getString("money"));
                bill.setMonth(rs.getString("month"));
                bill.setIdPartner(rs.getInt("IdPartner"));
                bill.setStatus(rs.getString("status"));
                bills.add(bill);
            }

        } catch (Exception e) {
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                }
            }
        }
        return bills;
    }
}
