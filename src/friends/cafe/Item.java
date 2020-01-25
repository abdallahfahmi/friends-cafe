/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friends.cafe;

/**
 *
 * @author abdal
 */
public class Item {
    
    int ID;
    String Name;
    double Price;
    int Quantity;
    String ExpireDate;
    String Type;

    public Item() {
    }

    public Item(int ID, String Name, double Price, int Quantity, String ExpireDate, String Type) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.ExpireDate = ExpireDate;
        this.Type = Type;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setExpireDate(String ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
    

    public int getID() {
        return ID;
    }
    
    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getExpireDate() {
        return ExpireDate;
    }
    
    public String getType(){
        return Type;
    }
}
