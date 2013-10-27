package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class StockTab {

	private JTextField barCodeField;
	private JTextField quantityField;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField descField;

	private JButton addItem;

	private SalesSystemModel model;

	public StockTab(SalesSystemModel model) {
		this.model = model;
	}

	// warehouse stock tab - consists of a menu and a table
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

	// warehouse menu
	private GridBagConstraints getDialogPaneConstraints() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 0.2;
        gc.weighty = 0d;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.NONE;

        return gc;
    }
	
	private Component drawStockMenuPane() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		
		// Create the panel
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6, 2));
        panel2.setBorder(BorderFactory.createTitledBorder("Add product"));
        
        // Initialize the textfields
		barCodeField = new JTextField();
		nameField = new JTextField();
		descField = new JTextField();
		priceField = new JTextField();
		quantityField = new JTextField();
		
		// == Add components to the panel

        // - bar code
        panel2.add(new JLabel("Bar code:            "));
        panel2.add(barCodeField);
        
        // - name
        panel2.add(new JLabel("Name: "));
        panel2.add(nameField);
        
        // - description
        panel2.add(new JLabel("Description: "));
        panel2.add(descField);
        
        // - price
        panel2.add(new JLabel("Price: "));
        panel2.add(priceField);
        
        // - amount
        panel2.add(new JLabel("Amount: "));
        panel2.add(quantityField);
        
		addItem = new JButton("Add");
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				model.getWarehouseTableModel().addItem(
						new StockItem(Long.parseLong(barCodeField.getText()),
								nameField.getText(), descField.getText(),
								(Double.parseDouble(priceField.getText())),
								Integer.parseInt(quantityField.getText())));
				} catch (Exception q) {
					JOptionPane.showMessageDialog(null, "Please insert valid data", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		panel2.add(addItem);
		panel.add(panel2, getDialogPaneConstraints());
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return panel;
	}

	// table of the wareshouse stock
	private Component drawStockMainPane() {
		JPanel panel = new JPanel();

		JTable table = new JTable(model.getWarehouseTableModel());

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

		panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
		return panel;
	}

}
