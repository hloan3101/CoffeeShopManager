/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectorcle.DBUtility;

/**
 *
 * @author LOAN
 */
public class Bills_Cnn {
    private static Bills_Cnn instance;

    public Bills_Cnn() {
    }

    public static Bills_Cnn getInstance() {
        if (instance == null) {
            instance = new Bills_Cnn();
        }
        return instance;
    }

    public Boolean Insert(int id, int accountId, int total_price) {
        
        try {
            Connection con = DBUtility.openConnection();
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("INSERT INTO bills(id, account_ID, total_price) VALUES (" +id + "," + accountId + "," + total_price +")");
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bills_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int GetMaxIdBills() {
        
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT MAX(ID) FROM bills");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bills_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 1;
    }
    
}
