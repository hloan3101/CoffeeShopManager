/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import java.sql.Timestamp;

/**
 *
 * @author LOAN
 */
public class Bills {
    private int id;
    private int accountId;
    private int totalPrice;
    private Timestamp billDate;

    public Bills() {
    }

    public Bills(int id, int accountId, int totalPrice, Timestamp billDate) {
        this.id = id;
        this.accountId = accountId;
        this.totalPrice = totalPrice;
        this.billDate = billDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getBillDate() {
        return billDate;
    }

    public void setBillDate(Timestamp billDate) {
        this.billDate = billDate;
    }
    
}
