package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.OrderTableModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab extends JPanel {
    
    // TODO - implement!

    public HistoryTab() {
    	
    	super(new GridLayout(1,0));
    		
    	
    	//table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //table.setFillsViewportHeight(true);
        
        //JScrollPane scrollPane = new JScrollPane(table);
        //add(scrollPane);
    } 
    
    public Component draw() {
    	
    	List<Order> orders = new ArrayList<Order>();
    	
    	StockItem a = new StockItem((long)12, "coca-cola", "karastusjook", 1.5, 200);
    	SoldItem a1 = new SoldItem(a, 2);
    	StockItem b = new StockItem((long)13, "creme-brule", "magustoidud", 3.5, 20);
    	SoldItem b1 = new SoldItem(b, 2);
    	
    	
    	StockItem c = new StockItem((long)14, "kohv", "kuumad joogid", 1.7, 130);
    	SoldItem c1 = new SoldItem(c, 2);
    	StockItem d = new StockItem((long)15, "premium", "olled", 2.5, 70);
    	SoldItem d1 = new SoldItem(d, 1);
    	
    	List<SoldItem> soldItems1 = new ArrayList<SoldItem>();
    	soldItems1.add(a1);
    	soldItems1.add(b1);
    	
    	List<SoldItem> soldItems2 = new ArrayList<SoldItem>();
    	soldItems2.add(c1);
    	soldItems2.add(d1);
    	
    	Order order1 = new Order((long)123, soldItems1);
    	Order order2 = new Order((long)124, soldItems2);
    	
    	orders.add(order1);
    	orders.add(order2);
    	
    	OrderTableModel otm = new OrderTableModel();
    	otm.addOrder(order1);
    	otm.addOrder(order2);
    	
        JPanel panel = new JPanel();
        
        String [] ColumnNames = {"Order", "Date and time of order", "Total sum of order"};
    	
    	Object [][] data = {{"Order1", order1.returnDateAndTime(), order1.calculateTotalSum()}, {"Order2", order2.returnDateAndTime(), order2.calculateTotalSum()}, };
    	
    	JTable table = new JTable(otm);
        
    	panel.add(table);
        // TODO - Sales history tabel
        return panel;
    }
}