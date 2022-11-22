/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import mainclass.Menues;

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
public class Menues_Cnn {
    private static Menues_Cnn instance;

    public Menues_Cnn() {
    }

    public static Menues_Cnn getInstance() {
        if (instance == null) {
            instance = new Menues_Cnn();
        }
        return instance;
    }

    public static void setInstance(Menues_Cnn instance) {
        Menues_Cnn.instance = instance;
    }

    public List<Menues> GetListMenu(int id) {
        List<Menues> list = new ArrayList<Menues>();
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement pstmt = con.prepareStatement("select  d.id, d.name, ord.count, d.price from drinks d" +
                        " join orders ord on ord.drinks_id=d.id where ord.id = " + id);
                ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Menues menu = new Menues(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),rs.getInt(3) *  rs.getInt(4));
                list.add(menu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menues_Cnn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
