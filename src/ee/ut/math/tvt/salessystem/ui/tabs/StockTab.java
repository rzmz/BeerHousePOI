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

import org.apache.log4j.Logger;
import org.hibernate.Session;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.OutOfStockException;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

public class StockTab {

	private static final Logger log = Logger.getLogger(StockTab.class);

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
		nameField = new JTextField();
		descField = new JTextField();
		priceField = new JTextField();
		quantityField = new JTextField();

		// == Add components to the panel

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

				StockItem item = new StockItem();
				Boolean isError = true;

				try {
					item.setName(nameField.getText());
					item.setDescription(descField.getText());
					item.setPrice((double) Math.round(Double
							.parseDouble(priceField.getText()) * 10) / 10);
					item.setQuantity(Integer.parseInt(quantityField.getText()));
					isError = false;
				} catch (NumberFormatException | OutOfStockException ex) {
					JOptionPane.showMessageDialog(null,
							"Please insert valid data", "Error",
							JOptionPane.WARNING_MESSAGE);
				}

				if (!isError) {
					try {
						Session session = HibernateUtil.currentSession();
						session.beginTransaction();
						session.persist(item);
						session.getTransaction().commit();
						model.getWarehouseTableModel().addItem(item);
					} catch (Throwable t) {
						log.error("Could not save item to the database");
						t.printStackTrace();
						JOptionPane.showMessageDialog(null,
								"Database transaction failed", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
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
