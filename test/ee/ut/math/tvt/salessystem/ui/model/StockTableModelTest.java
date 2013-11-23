package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.OutOfStockException;








import org.junit.Before;
import org.junit.Test;

public class StockTableModelTest {
	private StockTableModel warehouseTableModel;
	
	
	StockItem item = new StockItem((long)99, "Test thing", "For testing and stuff..", 10.8, 41);
	StockItem item2 = new StockItem((long)10, "Test thing2", "For testing and stuff..2", 17.9, 2);
	SoldItem item3 = new SoldItem(item, 3);
	
	@Before
	public void setUp(){
		warehouseTableModel = new StockTableModel();
	}
	
	@Test
	public void testValidateNameUniqueness(){
		warehouseTableModel.addItem(item);
		warehouseTableModel.addItem(new StockItem((long)89, "Test thing", "For testing", 10.8, 250));
		assertEquals(warehouseTableModel.getItemByName("Test thing").getQuantity(), 291);
	}
	@Test (expected = OutOfStockException.class)
	public void testHasEnoughInStock() throws OutOfStockException{
		warehouseTableModel.addItem(item2);
		warehouseTableModel.getItemById(item2.getId()).setQuantity(-1);
		
	}
	@Test
	public void testGetItemByIdWhenItemExists(){
		warehouseTableModel.addItem(item);
		assertEquals(warehouseTableModel.getItemById(99), item);
	}
	@Test (expected = NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException(){
		assertEquals(warehouseTableModel.getItemById(10), item2);
		
	}
	

}
