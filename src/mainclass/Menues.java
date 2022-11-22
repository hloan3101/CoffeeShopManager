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
public class Menues {
    private int idDrink;
    private String drinkName;
    private int count;
    private int price;
    private int totalPrice;

    public Menues() {
    }

    public Menues(int idDrink, String drinkName, int count, int price, int totalPrice) {
        this.idDrink = idDrink;
        this.drinkName = drinkName;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    public int getIdDrink() {
        return idDrink;
    }
    
    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
