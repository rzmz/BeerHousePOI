package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class OrderTableModelTest {
	
	StockItem stockItem1 = new StockItem((long)47, "TestProduct1", "RandomDisc1", 3.5);
	StockItem stockItem2 = new StockItem((long)48, "TestProduct2", "RandomDisc2", 5.5);
	StockItem stockItem3 = new StockItem((long)49, "TestProduct3", "RandomDisc3", 2.5);
	
	SoldItem soldItem1 = new SoldItem(stockItem1, 2);
	SoldItem soldItem2 = new SoldItem(stockItem2, 1);
	SoldItem soldItem3 = new SoldItem(stockItem3, 3);
	
	SoldItem[] soldProducts = {soldItem1, soldItem2, soldItem3};
	SoldItem[] soldProducts2 = {soldItem1, soldItem2};
	
	Order order1;
	Order order2;
	
	OrderTableModel otm;
	
	@Before
	public void setUp(){
		otm = new OrderTableModel();
		order1 = new Order((long)21, Arrays.asList(soldProducts));
		order2 = new Order((long)22, Arrays.asList(soldProducts2));
		
	}
	@Test (expected = IllegalArgumentException.class)
	public void testColumnValueIfIndexOutOfRange(){
		assertEquals(otm.getColumnValue(order1, 3), order1.calculateTotalSum());
	}
	
	@Test
	public void testNumberOfRowsWhenAddingANewOne(){
		int initialNrOfRows = otm.getRowCount();
		otm.addOrder(order1);
		otm.addOrder(order2);
		assertEquals(otm.getRowCount(), 2);
		
	}

}
