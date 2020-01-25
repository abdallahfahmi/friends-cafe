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
public class OrderItem {
    
    Item item;
    int numberofunits;

    public OrderItem(Item item) {
        this.item = item;
        numberofunits=1;
    }

    public OrderItem(Item item, int numberofunits) {
        this.item = item;
        this.numberofunits = numberofunits;
    }
    
    

    
    
    
}
