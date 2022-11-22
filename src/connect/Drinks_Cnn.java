/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import mainclass.Drinks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import connectorcle.DBUtility;

/**
 *
 * @author LOAN
 */
public class Drinks_Cnn {
    private static Drinks_Cnn instance;
    
    public Drinks_Cnn() {
    }
    
    public static Drinks_Cnn getInstance() {
        if (instance == null) {
            instance = new Drinks_Cnn();
        }
        return instance;
    }
    
    public List<Drinks> GetListDrink() {
        List<Drinks> list = new ArrayList<Drinks>();
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM drinks");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Drinks drinks = new Drinks(rs.getInt(1), rs.getString(2), rs.getInt(3));
                list.add(drinks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drinks_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int search_ID (String nameDrink){
        int id = 0;
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM drinks where name = '" + nameDrink + "'");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drinks_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public int search_Price (String nameDrink){
        int id = 0;
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM drinks where name = '" + nameDrink + "'");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                id=rs.getInt(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drinks_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public int maxID(){
        int maxid = 0;
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM drinks");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (maxid < rs.getInt(1)){
                    maxid = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drinks_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return maxid + 1;
    }
    
    public Boolean addDrinks (int id, String name, int price){
        try {
            Connection con = DBUtility.openConnection();
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("INSERT INTO drinks(id,name,price) VALUES (" + id + ", '" + name + "'," + price + ")");
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drinks_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Boolean deleteDrinks (int id ){
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("Delete from drinks where ID=?");
            pstmt.setInt(1, id);;
            int i = pstmt.executeUpdate();
            if (i>0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Account_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Boolean updateDrinks (int id, String name, int price){
         try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("update drinks set name=?, price=? where ID=?");
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                   return true;
             }
            } catch (SQLException ex) {
                Logger.getLogger(Drinks_Cnn.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
}
