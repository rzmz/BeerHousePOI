package ee.ut.math.tvt.salessystem.ui.model;

import ee.ut.math.tvt.salessystem.domain.data.Order;

public class OrderTableModel extends SalesSystemTableModel <Order> {

	public OrderTableModel() {
		super(new String [] {"id", "Date and time of order", "Total sum"});
		// TODO Auto-generated constructor stub
	}

	
	private static final long serialVersionUID = 1L;

	@Override
	protected Object getColumnValue(Order order, int columnIndex) {
		switch(columnIndex){
		case(0):
			return order.getId();
		case(1):
			return order.returnDateAndTime();
		case(2):
			return order.calculateTotalSum();
		}
		throw new IllegalArgumentException("Column index out of range");
		// TODO Auto-generated method stub
	}
	
	//vajalik konsooli jaoks
	public String toString(){
		final StringBuffer buffer = new StringBuffer();
		
		for(int i = 0; i < headers.length; i++){
			buffer.append(headers[i] + "\t");
		buffer.append("\n");
		
		for(Order order : rows){
			buffer.append(order.getId() + "\t");
			buffer.append(order.returnDateAndTime() + "\t");
		}
		
		}
		return "a";
		
	}
	
	public void addOrder(Order order){
		rows.add(order);
	}

}
