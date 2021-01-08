package service;

import connect.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Partner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dao Van Do
 */
public class PartnerService {
    
    private Connection connection;
    
    public List<Partner> getAllPartner() {
        List<Partner> partners = new ArrayList<>();
        try {
            DBConnect dbContext = new DBConnect();
            connection = DBConnect.getConnection();
            String sql = "SELECT T1.id, T1.name, T1.code, T1.mail, T1.stk, T2.status\n"
                    + "FROM demo.Partner AS T1\n"
                    + "JOIN demo.Bill AS T2\n"
                    + "ON T1.id = T2.idPartner";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                Partner partner = new Partner();
                partner.setId(rs.getString("id"));
                partner.setName(rs.getString("name"));
                partner.setMail(rs.getString("mail"));
                partner.setCode(rs.getString("code"));
                partner.setStatus(rs.getString("status"));
                partner.setStk(rs.getString("stk"));
                partners.add(partner);
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
        return partners;
    }
    
    public List<Partner> getPartnerByName(String name) {
        List<Partner> partners = new ArrayList<>();
        try {
            DBConnect dbContext = new DBConnect();
            connection = DBConnect.getConnection();
            String sql = "SELECT T1.id, T1.name, T1.code, T1.mail, T1.stk, T2.status\n"
                    + "FROM demo.Partner AS T1\n"
                    + "JOIN demo.Bill AS T2\n"
                    + "ON T1.id = T2.idPartner where T1.name like '%" + name + "%' ";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                Partner partner = new Partner();
                partner.setId(rs.getString("id"));
                partner.setName(rs.getString("name"));
                partner.setMail(rs.getString("mail"));
                partner.setCode(rs.getString("code"));
                partner.setStatus(rs.getString("status"));
                partners.add(partner);
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
        return partners;
    }
}
