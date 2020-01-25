/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friends.cafe;

import static friends.cafe.FriendsCafe.items;
import static friends.cafe.FriendsCafe.orders;
import java.sql.*;

/**
 *
 * @author abdal
 */
public class DBConnection {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cafe", "root", "");
            st = con.createStatement();
        }catch(Exception e)
        {
            System.out.print("Database connection error..");
        }
        
    }
    
    public void readData(){
        readItems();
        readOrders();
    }
    
    public void readItems(){
        try{
            String query = "SELECT * FROM Items";
            rs = st.executeQuery(query);
            items.clear();
            while(rs.next())
            {
                int id = rs.getInt("Item_ID");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                int quantity = rs.getInt("Quantity");
                String expire_date = rs.getString("Expire_date");
                String type = rs.getString("Item_type");
                Item item = new Item(id, name, price, quantity, expire_date, type);
                items.add(item);
            
            }
        }catch(Exception e)
        {
            System.out.print("Database connection error..");
        }
        
    }
    
    public void readOrders(){
        try{
            String query = "SELECT DISTINCT Order_ID FROM Items_Orders";
            rs = st.executeQuery(query);
            orders.clear();
            while(rs.next()){
                String query2 = "SELECT * FROM Items as I INNER JOIN Items_Orders as IO ON I.Item_ID = IO.Item_ID INNER JOIN Orders as O ON O.Order_ID = IO.Order_ID WHERE O.Order_ID = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query2);
                preparedStatement.setInt(1, rs.getInt("Order_ID"));
                ResultSet rs2 = preparedStatement.executeQuery();
                rs2.next();
                Order order = new Order();
                order.setOrder_id(rs2.getInt("Order_ID"));
                //order.setDate(new Date(rs2.getDate("Order_date").getTime()));
                order.setDate(rs2.getString("Order_date"));
                order.setAmount(rs2.getDouble("Order_amount"));
                do{
                    Item item = new Item();
                    item.setID(rs2.getInt("Item_ID"));
                    item.setName(rs2.getString("Name"));
                    item.setPrice(rs2.getDouble("Price"));
                    item.setQuantity(rs2.getInt("Quantity"));
                    item.setExpireDate(rs2.getString("Expire_date"));
                    item.setType(rs2.getString("Item_type"));
                    order.addItem(new OrderItem(item, rs2.getInt("Num_of_Items")));
                }while(rs2.next());
                FriendsCafe.orders.add(order);
            }
        }catch(Exception e){
            System.out.print("Database connection error..");
        }
    }
    
    public void saveOrder(Order order){
        try{
            String query = "INSERT INTO Orders(Order_date, Order_amount)"+" values (?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, order.getDate());
            preparedStatement.setDouble(2, order.getAmount());
            preparedStatement.executeUpdate();
            query = "SELECT MAX(Order_ID) FROM Orders";
            rs = st.executeQuery(query);
            if(rs.next())
            {
                for(OrderItem item:order.getItems_in_order())
                {
                    query = "INSERT INTO Items_Orders(Order_ID, Item_ID, Num_of_Items)"+" values (?,?,?)";
                    preparedStatement = con.prepareStatement(query);
                    preparedStatement.setInt(1, rs.getInt(1));
                    preparedStatement.setInt(2, item.item.getID());
                    preparedStatement.setInt(3,item.numberofunits);
                    preparedStatement.executeUpdate();
                }
            }
            readOrders();
        }catch(Exception e){
            System.out.print("Database connection error..");
        }
    }
    
    public void addEntry(Item item){
        try{
            String query = "INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type)"+" values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(item.getID()));
            preparedStatement.setString(2, item.getName());
            preparedStatement.setString(3, Double.toString(item.getPrice()));
            preparedStatement.setString(4, Integer.toString(item.getQuantity()));
            preparedStatement.setString(5, item.getExpireDate());
            preparedStatement.setString(6, item.getType());
            preparedStatement.executeUpdate();
            readItems();
        }catch(Exception e){
            System.out.print("Database connection error..");
        }
    }
    
    public void updateEntry(int id, String field, String value){
        try{
            String query = "";
            switch(field)
            {
                case "NAME": query = "UPDATE Items SET Name=? WHERE Item_ID=?";
                        break;
                case "PRICE": query = "UPDATE Items SET Price=? WHERE Item_ID=?";
                        break;
                case "QUANTITY": query = "UPDATE Items SET Quantity=? WHERE Item_ID=?";
                        break;
                case "EXPIRE DATE": query = "UPDATE Items SET Expire_date=? WHERE Item_ID=?";
                        break;
                case "TYPE": query = "UPDATE Items SET Item_type=? WHERE Item_ID=?";
                        break;
            }
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, Integer.toString(id));
            preparedStatement.executeUpdate();
            readItems();
        }catch(Exception e){
            System.out.print("Database connection error..");
        }
        
    }
    
    public void deleteEntry(int id){
        try{
            String query = "DELETE FROM Items WHERE Item_ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(id));
            preparedStatement.executeUpdate();
            readItems();
        }catch(Exception e){
            System.out.print("Database connection error..");
        }
        
    }
    
    
}
