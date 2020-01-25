/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friends.cafe;


import static friends.cafe.FriendsCafe.Read;
import static friends.cafe.FriendsCafe.items;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author abdal
 */
public class MakeOrderController {

    ArrayList<Item> currentTable ;
    
    public String[][] getTable(ArrayList<Item> list){
        int n = list.size();
        String[][] s = new String[n][3];
        for(int i=0; i<n; i++)
            {
                s[i][0] = Integer.toString(list.get(i).getID());
                s[i][1] = list.get(i).getName();
                s[i][2] = Double.toString(list.get(i).getPrice());
            }
        
        return s;
    }
    
    public String[][] filterTable(String s){
        switch(s){
            case "Hot Drinks":
                ArrayList<Item> HotDrinksList = new ArrayList<Item>();
                for(Item i:items)
                {
                    if(i.getType().equals("hot_drink"))
                    {
                        HotDrinksList.add(i);
                    }
                } 
                currentTable = HotDrinksList;
                return getTable(HotDrinksList);
            case "Cold Drinks":
                ArrayList<Item> ColdDrinksList = new ArrayList<Item>();
                for(Item i:items)
                {
                    if(i.getType().equals("cold_drink"))
                    {
                        ColdDrinksList.add(i);
                    }
                } 
                currentTable = ColdDrinksList;
                return getTable(ColdDrinksList);
            case "Smoothies":
                ArrayList<Item> SmoothiesList = new ArrayList<Item>();
                for(Item i:items)
                {
                    if(i.getType().equals("smoothie"))
                    {
                        SmoothiesList.add(i);
                    }
                } 
                currentTable = SmoothiesList;
                return getTable(SmoothiesList);
            case "Desserts":
                ArrayList<Item> DessertsList = new ArrayList<Item>();
                for(Item i:items)
                {
                    if(i.getType().equals("dessert"))
                    {
                        DessertsList.add(i);
                    }
                } 
                currentTable = DessertsList;
                return getTable(DessertsList);    
    }
        currentTable = items;
        return getTable(items);  //All Drinks
}
    
    public String[][] searchTable(String s){
        ArrayList<Item> searchlist = new ArrayList<Item>();
        for(Item item:currentTable)
            if(item.getName().toLowerCase().contains(s.toLowerCase()))
                searchlist.add(item);
        return getTable(searchlist);
    }
    
    public Item getItemById(String ID){
        for(Item i:items)
            if(i.getID()==Integer.parseInt(ID))
                return i;
        return null;
    }
    
}
