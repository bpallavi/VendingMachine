package MyStuff.vendingMachine.Inventory;

import java.util.*;

public class inventory {
    Map<Integer, Product> aisleToProductMap;
    Map<Integer, Integer> productCountMap;
    Queue<Integer> availableAisles;

    public inventory(int aisle) {
        availableAisles = new LinkedList<>();
        for (int i = 1; i <= aisle; i++) {
            availableAisles.add(i);
        }

        aisleToProductMap = new HashMap<>();
        productCountMap = new HashMap<>();
    }

    public void addProduct(Product product) throws Exception {
        int id = product.getId();
        int productCount = productCountMap.getOrDefault(id,0);
        if (productCount == 0) {
            if (availableAisles.isEmpty())
                throw new Exception("No space");

            aisleToProductMap.put(availableAisles.poll(), product);
        }
        
        productCountMap.put(id, productCount + 1);
    }

    public Map<Integer, Product> getAisleToProductMap() {
        return aisleToProductMap;
    }
    public void setAisleToProductMap(Map<Integer, Product> aisleToProductMap) {
        this.aisleToProductMap = aisleToProductMap;
    }
    public Map<Integer, Integer> getProductCountMap() {
        return productCountMap;
    }
    public void setProductCountMap(Map<Integer, Integer> productCountMap) {
        this.productCountMap = productCountMap;
    }
    public Queue<Integer> getAisles() {
        return availableAisles;
    }

    public void setAisles(Queue<Integer> aisles) {
        this.availableAisles = aisles;
    }
    
    public Product getProductAt(int aisle) {
        return aisleToProductMap.get(aisle);
    }

    public boolean isSufficentProduct(int id) {
        return productCountMap.get(id) > 0;
    }

    public void deductCount(int aisle) {
        Product p = getProductAt(aisle);
        int count = productCountMap.get(p.getId());
        int updatedCount = count - 1;
        if (updatedCount == 0) {
            productCountMap.remove(p.getId());
            aisleToProductMap.remove(aisle);
            availableAisles.add(aisle);
        } else {
            productCountMap.put(p.getId(), updatedCount);
        }
        
    }


}
