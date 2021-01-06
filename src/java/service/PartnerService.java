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
        int type = 0;
        try {
            DBConnect dbContext = new DBConnect();
            connection = DBConnect.getConnection();
            String sql = "select * from demo.Partner";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Partner partner = new Partner();
                partner.setId(rs.getString("id"));
                partner.setName(rs.getString("name"));
                partner.setMail(rs.getString("mail"));
                partner.setCode(rs.getString("code"));
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
