package MyStuff.vendingMachine;

import MyStuff.vendingMachine.Inventory.Product;
import MyStuff.vendingMachine.VendingMachine.vendingMachine;

public class DriverCode {

    public static void main(String args[]) throws Exception {
        vendingMachine machine = new vendingMachine();
        Product plum = new Product("kitkat", 1, 5.0);
    
        for (int i = 0; i < 3; i++)
            machine.addProduct(plum); 
        Product cake = new Product("Britania", 2, 10.0);
        for (int i = 0; i < 3; i++)
            machine.addProduct(cake);

        machine.insertCoin(5.0);
        machine.selectproduct(1);
        machine.insertCoin(10.0);
        machine.selectproduct(2);
    }
    
}
