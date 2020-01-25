
package friends.cafe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author abdal
 */
public class FriendsCafe {
    static ArrayList<Item> items = new ArrayList<Item>();
    static ArrayList<Order> orders = new ArrayList<Order>();
    static Manager manager = new Manager("admin", "admin");

    
    public static void Read() throws IOException
    {
        try {
            BufferedReader BR = new BufferedReader(new FileReader("stock.txt"));
            
            while(BR.ready())
            {
                String Line = BR.readLine();
                String[] item = Line.split("<>");
                Item i = new Item(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), item[4], item[5]);
                items.add(i);
            }
            
            BR.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found");
        }
    }
    
}
