package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	StockItem stockItem1 = new StockItem((long)47, "TestProduct1", "RandomDisc1", 3.5);
	StockItem stockItem2 = new StockItem((long)48, "TestProduct2", "RandomDisc2", 5.5);
	StockItem stockItem3 = new StockItem((long)49, "TestProduct3", "RandomDisc3", 2.5);
	
	SoldItem soldItem1 = new SoldItem(stockItem1, 2);
	SoldItem soldItem2 = new SoldItem(stockItem2, 1);
	SoldItem soldItem3 = new SoldItem(stockItem3, 3);
	
	SoldItem[] soldProducts = {soldItem1, soldItem2, soldItem3};
	SoldItem[] soldProductsEmpty = {};
	
	Order order1; 
	Order order2;
	
	@Before
	public void setUp(){
		order1 = new Order((long)21, Arrays.asList(soldProducts));
		order2 = new Order((long)22, Arrays.asList(soldProductsEmpty));
	}
	
	@Test
	public void testOrderTimeCorrectness(){
		try {
			assertEquals(new SimpleDateFormat("dd.MM.yyyy, 'kl' HH:mm:ss").parse(order1.returnDateAndTime()).getTime(), new Date().getTime(),10000);
		} catch (ParseException e) {
			fail("Could not parse date");
		}
	}
	
	@Test
	public void testOrderSumCorrectness(){
		assertEquals(order1.calculateTotalSum(), soldItem1.getSum() + soldItem2.getSum() + soldItem3.getSum(), 0.0001);
	}
	
	@Test
	public void testSumWithZeroProducts(){
		assertEquals(order2.calculateTotalSum(), 0, 0.0001);
	}
	
	@Test
	public void testDateFormat(){
		String date = order1.returnDateAndTime();
		System.out.println(date.substring(2, 3));
		assertTrue(date.substring(2, 3).equals(".") && date.substring(5,6).equals(".") && date.substring(12, 14).equals("kl") && date.substring(17, 18).equals(":"));
	}
}
