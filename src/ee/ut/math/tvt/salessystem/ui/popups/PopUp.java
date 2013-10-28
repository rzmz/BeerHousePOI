package ee.ut.math.tvt.salessystem.ui.popups;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class PopUp {
	
	private SalesSystemModel model;
	private Order order;
	
	public PopUp(SalesSystemModel model, int row){
		this.model = model;
		this.order = model.getOrderTableModel().getTableRows().get(row);
		
	}
	
	
	public List <SoldItem> getSoldItems(){
		return this.order.getSoldItems();
	}
	
	public PurchaseInfoTableModel createModel() {
		PurchaseInfoTableModel forThisOrder = new PurchaseInfoTableModel();
		forThisOrder.populateWithData(getSoldItems());
		return forThisOrder;
	}
	
	public void draw(){
		JFrame popup = new JFrame();
		popup.setSize(400, 200);
		popup.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		JTable table = new JTable(createModel());
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

        panel.setBorder(BorderFactory.createTitledBorder("List of sold items"));
        popup.add(panel);
        popup.setVisible(true);
		
	}
	
	
}