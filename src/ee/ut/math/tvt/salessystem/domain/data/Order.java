package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Order implements Cloneable, DisplayableItem {
	
	static long currentId = 0;
	
	private Long id;
	private List<SoldItem> soldItems ;
	private Date dateAndTime;
	
	public Order(Long id, List<SoldItem> soldItems){
		this.id = id;
		this.dateAndTime = new GregorianCalendar().getTime();
		this.soldItems = soldItems;
	}
	
	
	public List<SoldItem> getSoldItems() {
		return soldItems;
	}


	public void setSoldItems(List<SoldItem> soldItems) {
		this.soldItems = soldItems;
	}


	public Date getDateAndTime() {
		return dateAndTime;
	}


	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public double calculateTotalSum(){
		double sum = 0;
		
		for(SoldItem item: soldItems){
			sum = sum + item.getSum();
		}
		return sum;
	}
	
	// todo: should return something else when connected to a database
	public static long getNextId() {
		return ++currentId;
	}
	
	public String returnDateAndTime(){
		SimpleDateFormat a = new SimpleDateFormat("dd.MM.yyyy, 'kl' HH:mm:ss"); 
		return a.format(getDateAndTime());	
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}