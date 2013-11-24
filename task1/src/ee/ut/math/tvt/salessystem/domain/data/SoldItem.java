package ee.ut.math.tvt.salessystem.domain.data;

import javax.persistence.*;

/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving history. 
 */

@Entity(name = "SOLDITEM")
public class SoldItem implements Cloneable, DisplayableItem {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "SALE_ID")
	private Order order;
	
	@Column(name = "STOCKITEM_ID")
	private Long _stockItemId;
	
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "QUANTITY")
    private Integer quantity;
    
    @Column(name = "ITEMPRICE")
    private double price;

    public SoldItem() {    	
    }
    
    public SoldItem(StockItem stockItem, int quantity) {
        this._stockItemId = stockItem.getId();
        this.name = stockItem.getName();
        this.price = stockItem.getPrice();
        this.quantity = quantity;
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
        return (double) quantity * price;
    }
    
    public Order getOrder() {
    	return this.order;
    }
    
}
