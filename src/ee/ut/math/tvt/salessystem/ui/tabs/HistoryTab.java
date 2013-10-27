package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.OrderTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.popups.PopUp;
/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab extends JPanel  {
    
 
	private SalesSystemModel model;
	
	public HistoryTab(SalesSystemModel model){
		this.model = model; 
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
		model.getOrderTableModel().addOrder(order1);
		model.getOrderTableModel().addOrder(order2);
		
	}
	
    public HistoryTab() {
    	
    	super(new GridLayout(1,0));
    		
   
    } 
    
    public Component draw() {
    	
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        panel.setLayout(gb);
        
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.NORTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.weightx = 1.0d;
        gc.weighty = 0d;
        
        panel.add(drawStockMenuPane(), gc);
        gc.weighty = 1.0;
        gc.fill = GridBagConstraints.BOTH;
        panel.add(drawStockMainPane(), gc);
       
        return panel;
    }
    
    private Component drawStockMenuPane() {
        JPanel panel = new JPanel();

        GridBagConstraints gc = new GridBagConstraints();
        GridBagLayout gb = new GridBagLayout();

        panel.setLayout(gb);

        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = 0;

       
        gc.gridwidth = GridBagConstraints.RELATIVE;
        gc.weightx = 1.0;
       

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return panel;
      }
    
    private Component drawStockMainPane() {
        JPanel panel = new JPanel();

        
		JTable table = new JTable(model.getOrderTableModel());
		
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      PopUp popup = new PopUp(model,row);
			      popup.draw();
			    }
			  }
		});
			  
        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);

        GridBagConstraints gc = new GridBagConstraints();
        GridBagLayout gb = new GridBagLayout();
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;

        panel.setLayout(gb);
        panel.add(scrollPane, gc);

        panel.setBorder(BorderFactory.createTitledBorder("History of orders"));
        return panel;
        
      }
    
}