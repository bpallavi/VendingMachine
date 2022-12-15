package MyStuff.vendingMachine.States;

import MyStuff.vendingMachine.VendingMachine.vendingMachine;

public class NoCoinInsertedState implements State {

    vendingMachine machine;

    public NoCoinInsertedState(vendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(double amount) {
        machine.setAmount(amount);
        machine.setState(machine.getCoinInsertedState());
        
    }

    @Override
    public void selectproduct(int aisle) {
        throw new IllegalStateException("No coin is inserted");
        
    }

    @Override
    public void dispense(int aisle) {
        throw new IllegalStateException("No coin is inserted to dispense product");
        
    }
    
}
