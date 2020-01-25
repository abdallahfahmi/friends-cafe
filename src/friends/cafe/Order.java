/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friends.cafe;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author abdal
 */
public class Order {
    
    int order_id;
    ArrayList<OrderItem> items_in_order = new ArrayList<OrderItem>();
    String date;
    double amount;
    DBConnection connect = new DBConnection();
    
    public void addItem(OrderItem newitem){
        for(OrderItem orderitem:items_in_order)
            if(orderitem.item.equals(newitem.item))
            {
                orderitem.numberofunits++;
                return;
            }
        items_in_order.add(newitem);
    }
    
    public void deleteItem(OrderItem newitem){
        for(OrderItem orderitem:items_in_order)
            if(orderitem.item.equals(newitem.item))
                if(orderitem.numberofunits==1)
                {
                    items_in_order.remove(orderitem);
                    return;
                }
                else
                {
                    orderitem.numberofunits--;
                    return;
                }
    }
    
    public double calculatePrice(){
        
        double sum=0;
        for(OrderItem item:items_in_order)
        {
            sum += item.item.getPrice()*item.numberofunits;
        }
        
        return sum;
        
    }
    
    public double calcPriceWithService(){
        return calculatePrice()*1.12;
    }

    @Override
    public String toString() {
        String s="";
        for(OrderItem item:items_in_order)
            s += item.item.getName()+"   x"+item.numberofunits+"\n";
        return s;
    }
    
    public void submitOrder(){
        for(OrderItem orderitem:items_in_order)
        {
            for(Item item:FriendsCafe.items)
            {
                if(item.equals(orderitem.item))
                {
                    for(int i=orderitem.numberofunits; i>0; i--)
                        item.setQuantity(item.getQuantity()-1);
                    break;
                }
            }
        }
        for(OrderItem orderitem:items_in_order){
            Item item = orderitem.item;
            connect.updateEntry(item.getID(), "QUANTITY", Integer.toString(item.getQuantity()));
        }
        date = new Date().toString();
        amount = calcPriceWithService();
        connect.saveOrder(this);
    }
    
    public OrderItem hasItem(Item item){
        for(OrderItem orderitem:items_in_order)
            if(orderitem.item.equals(item))
                return orderitem;
        return null;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public ArrayList<OrderItem> getItems_in_order() {
        return items_in_order;
    }

    public void setItems_in_order(ArrayList<OrderItem> order) {
        this.items_in_order = order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
    
}
