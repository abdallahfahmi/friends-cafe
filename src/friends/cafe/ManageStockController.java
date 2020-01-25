/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friends.cafe;

import static friends.cafe.FriendsCafe.items;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author abdal
 */
public class ManageStockController {
    
    DBConnection connect = new DBConnection();
    
    
    public String[][] getStockTable(){
        return getTable(FriendsCafe.items);
    }
    
    
    public String[][] getSearchTable(String s){
        ArrayList<Item> searchlist = new ArrayList<Item>();
        for(Item item:items)
            if(item.getName().toLowerCase().contains(s.toLowerCase()))
                searchlist.add(item);
        return getTable(searchlist);
    }
    
    
    private String[][] getTable(ArrayList<Item> items)
    {
        String[][] s = new String[items.size()][6];
        for(int i=0; i<items.size(); i++)
            {
                s[i][0] = Integer.toString(items.get(i).getID());
                s[i][1] = items.get(i).getName();
                s[i][2] = Double.toString(items.get(i).getPrice());
                s[i][3] = Integer.toString(items.get(i).getQuantity());
                s[i][4] = items.get(i).getExpireDate();
                s[i][5] = items.get(i).getType();
            }
        
        return s;
    }
    
    
    
    public boolean isDuplicated(int id){
        for(Item i:items)
        {
            if(i.getID()==id)
                return true;
        }
        return false;
    }
    
    public void addItem(int id, String name, double price, int quantity, String expire_date, String type)
    {
        Item i = new Item(id, name, price, quantity, expire_date, type);
        connect.addEntry(i);
    }
    
    public void updateItem(int id, String field, String value){
        connect.updateEntry(id, field, value);
    }
    
    public void deleteItem(int id){
        connect.deleteEntry(id);
    }
    
    public String viewOrders(){
        String s="";
        for(Order order:FriendsCafe.orders)
        {
            s += order.date+"\n";
            s += order.toString();
            s += (float)order.amount+"\n";
            s += "---------------------------------------\n";
        }
        return s;
    }
    
    public String statistics() throws ParseException{
        Date current_date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current_date);
        cal.add(Calendar.DATE, -30);
        Date month_before = cal.getTime();
        ArrayList<OrderItem> items_sold_that_month = new ArrayList<>();
        double month_income=0;
        for(Order order:FriendsCafe.orders)
        {
            SimpleDateFormat spf=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
            Date order_date = spf.parse(order.getDate());
            if(order_date.after(month_before))
            {
                month_income += order.getAmount();
                for(OrderItem orderitem:order.getItems_in_order())
                {
                    int found =0;
                    for(OrderItem solditem:items_sold_that_month)
                    {
                        if(orderitem.item.getID() == solditem.item.getID())
                        {
                            solditem.numberofunits += orderitem.numberofunits;
                            found++;
                            break;
                        }
                    }
                    if(found==0)
                        items_sold_that_month.add(new OrderItem(orderitem.item, orderitem.numberofunits));
                }
            }
        }
        
        String most_sold_item=null, least_sold_item=null;
        int total_items_sold=0, most_sold_units=0, least_sold_units=100000;
        for(OrderItem item:items_sold_that_month)
        {
            total_items_sold += item.numberofunits;
            if(item.numberofunits>most_sold_units)
            {
                most_sold_units = item.numberofunits;
                most_sold_item = item.item.getName();
            }
            
            if(item.numberofunits<least_sold_units)
            {
                least_sold_units = item.numberofunits;
                least_sold_item = item.item.getName();
            }
        }
        
        String s = "Last Month Statistics\n\n\n"
                +"Total items sold = "+total_items_sold+"\n\n"
                + "Net Income = "+month_income+"\n\n"
                + "The most sold item is "+most_sold_item+" ( "+most_sold_units+" units sold )"+"\n\n"
                + "The least sold item is "+least_sold_item+" ( "+least_sold_units+" units sold )";
        return s;
    }
}
