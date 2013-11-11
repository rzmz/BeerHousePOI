package ee.ut.math.tvt.salessystem.domain.data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "ORDER")
public class Order implements Cloneable, DisplayableItem {

	static long currentId = 0;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@OneToMany(mappedBy = "order")
	private List<SoldItem> soldItems;
	
	@Column(name = "SALE_TIME")
	private Timestamp saleTime;

	public Order() {		
	}
	
	public Order(Long id, List<SoldItem> soldItems) {
		this.id = id;
		this.saleTime = (Timestamp) new GregorianCalendar().getTime();
		this.soldItems = soldItems;
	}

	public List<SoldItem> getSoldItems() {
		return soldItems;
	}

	public void setSoldItems(List<SoldItem> soldItems) {
		this.soldItems = soldItems;
	}

	public Timestamp getDateAndTime() {
		return saleTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.saleTime = dateAndTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double calculateTotalSum() {
		double sum = 0;

		for (SoldItem item : soldItems) {
			sum = sum + item.getSum();
		}
		return sum;
	}

	// todo: should return something else when connected to a database
	public static long getNextId() {
		return ++currentId;
	}

	public String returnDateAndTime() {
		SimpleDateFormat a = new SimpleDateFormat("dd.MM.yyyy, 'kl' HH:mm:ss");
		return a.format(getDateAndTime());
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return null;
	}

}