package MyStuff.vendingMachine.States;

import java.util.Map;

import MyStuff.vendingMachine.Inventory.Product;
import MyStuff.vendingMachine.Inventory.inventory;
import MyStuff.vendingMachine.VendingMachine.vendingMachine;

public class DispenseState implements State {
    
    vendingMachine machine;
    
    public DispenseState(vendingMachine inv) {
        this.machine = inv;
    }

    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("Product getting dispensd");
        
    }

    @Override
    public void selectproduct(int aisle) {
        throw new IllegalStateException("Product getting dispensd");
        
    }

    @Override
    public void dispense(int aisle) {
        inventory inv = machine.getInventory();
        Product p = inv.getProductAt(aisle);

        inv.deductCount(aisle);
        double money = machine.getAmount() - p.getPrice();
        machine.setAmount(0);
        System.out.println("Please collect the change and selected product is" + p.getName());
        machine.setState(machine.getNoCoinInsertedState());
        
    }
    
}
