/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectorcle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LOAN
 */
public class DBUtility {
	
    public static Connection openConnection() throws SQLException{
    	
        Connection con = null;
        String url = "jdbc:oracle:thin:@192.168.1.3:1521:orcl";
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "HR","hr");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    public static void closeAll (Connection con,PreparedStatement pstmt, ResultSet rs ){
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
