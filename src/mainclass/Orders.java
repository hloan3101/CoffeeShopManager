/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

/**
 *
 * @author LOAN
 */
public class Orders {
    private int id;
    private int drinksId;
    private int billsId;
    private int count;

    public Orders() {
    }

    public Orders(int id, int drinksId, int billsId, int count) {
        this.id = id;
        this.drinksId = drinksId;
        this.billsId = billsId;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrinksId() {
        return drinksId;
    }

    public void setDrinksId(int drinksId) {
        this.drinksId = drinksId;
    }

    public int getBillsId() {
        return billsId;
    }

    public void setBillsId(int billsId) {
        this.billsId = billsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
