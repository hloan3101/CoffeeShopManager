/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import mainclass.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectorcle.DBUtility;

/**
 *
 * @author LOAN
 */
public class Orders_Cnn {
    private static Orders_Cnn instance;

    public Orders_Cnn() {
    }
    
    public static Orders_Cnn getInstance(){
        if (instance == null){
            instance = new Orders_Cnn();
        }
        return instance;
    }
    
    public List<Orders> ListOrder(int id){
        List<Orders> list = new ArrayList<Orders>();
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM orders WHERE ID = ?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Orders orders = new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(orders);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Orders_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public int maxID(){
        int maxid = 0;
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM orders");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (maxid < rs.getInt(1)){
                    maxid = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drinks_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return maxid;
    }
    
    public Boolean Insert(int drinkId, int invoiceId, int count) {
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO orders(ID, drinks_ID,  bills_ID, count) VALUES (?,?,?,?)");
            pstmt.setInt(1, maxID()+1);
            pstmt.setInt(2, drinkId);
            pstmt.setInt(3, invoiceId);
            pstmt.setInt(4, count);
            
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Orders_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
