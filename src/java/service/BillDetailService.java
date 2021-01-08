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
import model.BillDetailModel;
import model.BillModel;

/**
 *
 * @author Dao Van Do
 */
public class BillDetailService {
    
    private Connection connection;
    
    public List<BillDetailModel> getBillDetail(int idPartner) {
        List<BillDetailModel> bills = new ArrayList<>();
        int type = 0;
        try {
            DBConnect dbContext = new DBConnect();
            connection = DBConnect.getConnection();
            String sql = "SELECT T1.id, T1.name, T1.code, T1.startDate, T1.amount, T1.money, T1.idBill, T1.idPartner, T2.stk\n"
                    + "FROM demo.Partner AS T2\n"
                    + "JOIN demo.BillDetail AS T1\n"
                    + "ON T2.id = T1.idPartner\n"
                    + "where T1.idPartner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idPartner);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                BillDetailModel bdm = new BillDetailModel();
                bdm.setId(rs.getInt("id"));
                bdm.setName(rs.getString("name"));
                bdm.setBill(rs.getInt("idBill"));
                bdm.setCode(rs.getString("code"));
                bdm.setMoney(rs.getInt("money"));
                bdm.setDate(rs.getString("startDate"));
                bdm.setIdPartner(rs.getInt("IdPartner"));
                bdm.setAmount(rs.getInt("amount"));
                bdm.setStk(rs.getString("stk"));
                bills.add(bdm);
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
