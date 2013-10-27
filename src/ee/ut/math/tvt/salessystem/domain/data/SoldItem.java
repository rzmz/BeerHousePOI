package ee.ut.math.tvt.salessystem.domain.data;



/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving history. 
 */
public class SoldItem implements Cloneable, DisplayableItem {

    private Long id;
    private StockItem stockItem;
    
    private String name;
    private Integer quantity;
    private double price;
    private double sum;
    
    public SoldItem(StockItem stockItem, int quantity) {
        this.stockItem = stockItem;
        this.id = stockItem.getId();
        this.name = stockItem.getName();
        this.price = stockItem.getPrice();
        this.quantity = quantity;
        this.sum = (double)quantity * price;
        
    }
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getSum() {
        return sum;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }
    
}
