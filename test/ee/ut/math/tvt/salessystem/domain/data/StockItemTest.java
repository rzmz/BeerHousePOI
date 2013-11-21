package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StockItemTest {

	StockItem item = new StockItem(85l, "testItem", "test", 9, 23);
	

	@Test
	public void testClone() {
		assertEquals(item.clone(), item);
	}
	
	@Test
	public void testGetColumn() {
		assertEquals(item.getColumn(3), 23);
	}
}
