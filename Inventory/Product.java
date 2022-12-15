package MyStuff.vendingMachine.Inventory;

public class Product {
    Integer id;
    String name;
    double price;
    
    public Product(String name, int id, double amount) {
        this.name = name;
        this.id = id;
        this.price = amount;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
