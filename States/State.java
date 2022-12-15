package MyStuff.vendingMachine.States;

//3 diff states 
/*
 * Nocoin inserted -> coin inserted ->dispenseState ->nocoininserted state
 */
public interface State {
    public void insertCoin(double amount);
    public void selectproduct(int aisle);
    public void dispense(int aisle);
}
