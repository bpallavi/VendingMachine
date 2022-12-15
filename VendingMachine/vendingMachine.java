package MyStuff.vendingMachine.VendingMachine;

import MyStuff.vendingMachine.Inventory.Product;
import MyStuff.vendingMachine.Inventory.inventory;
import MyStuff.vendingMachine.States.CoinInsertedState;
import MyStuff.vendingMachine.States.DispenseState;
import MyStuff.vendingMachine.States.NoCoinInsertedState;
import MyStuff.vendingMachine.States.State;

public class vendingMachine {
    
    public double amount;
    public NoCoinInsertedState noCoinInsertedState;
    public CoinInsertedState coinInsertedState;
    public String pressButtonState;
    public DispenseState dispenseState;
    public State state;
    inventory inventory;
    Product product;
    private static final Integer aisles = 2;

    public vendingMachine() {
        noCoinInsertedState = new NoCoinInsertedState(this);
        coinInsertedState = new CoinInsertedState(this);
        dispenseState = new DispenseState(this);
        amount = 0.0;
        state = noCoinInsertedState;
        inventory = new inventory(aisles);
    }



    public NoCoinInsertedState getNoCoinInsertedState() {
        return noCoinInsertedState;
    }

    public void setNoCoinInsertedState(NoCoinInsertedState noCoinInsertedState) {
        this.noCoinInsertedState = noCoinInsertedState;
    }

   
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public inventory getInventory() {
        return inventory;
    }

    public void setInventory(inventory inventory) {
        this.inventory = inventory;
    }

    public CoinInsertedState getCoinInsertedState() {
        return coinInsertedState;
    }

    public void setCoinInsertedState(CoinInsertedState coinInsertedState) {
        this.coinInsertedState = coinInsertedState;
    }

    public String getPressButtonState() {
        return pressButtonState;
    }

    public void setPressButtonState(String pressButtonState) {
        this.pressButtonState = pressButtonState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean hasSufficientAmount(Product p) {
        if (amount >= p.getPrice())
            return true;
        else
            return false;
    }
    
    
    public void insertCoin(double amount) {
        this.state.insertCoin(amount);
        System.out.println("Inserted coin "+amount);
    }

   
    public void selectproduct(int aisle) {
        this.state.selectproduct(aisle);
        this.state.dispense(aisle);
        System.out.println("Product seleceted");
        
    }
    
    public void addProduct(Product machine) throws Exception {
        this.getInventory().addProduct(machine);
    }
}
