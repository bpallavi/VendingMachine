package MyStuff.vendingMachine.States;

import MyStuff.vendingMachine.Inventory.Product;
import MyStuff.vendingMachine.Inventory.inventory;
import MyStuff.vendingMachine.VendingMachine.vendingMachine;

public class CoinInsertedState implements State {

    vendingMachine machine;

    public CoinInsertedState(vendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(double amount) {
        this.machine.setAmount(machine.getAmount() + amount);
        
    }

    @Override
    public void selectproduct(int aisle) {
        inventory inv = machine.getInventory();
        Product product = inv.getProductAt(aisle);
        if (!inv.isSufficentProduct(product.getId())) {
            throw new IllegalStateException("No sufficient product");
        }
        
        if(!machine.hasSufficientAmount(product))
        throw new IllegalStateException("No sufficient balance");

        machine.setState(machine.getDispenseState());
    }

    @Override
    public void dispense(int aisle) {
        throw new IllegalStateException("Product not dispensed");
        
    }
    
}
