package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SoldItemTest {
	
	StockItem item = new StockItem((long)99, "Test thing", "For testing and stuff..", 10.8, 41);
	SoldItem item3 = new SoldItem(item, 25);
	SoldItem item4 = new SoldItem(item, 0);
	
	@Test
	public void testGetSum(){
		assertEquals(item3.getSum(), 270, 0.0001);
	}
	
	@Test
	public void testGetSumWithZeroQuanity(){
		assertEquals(item4.getSum(), 0, 0.0001);
	}
	
}
