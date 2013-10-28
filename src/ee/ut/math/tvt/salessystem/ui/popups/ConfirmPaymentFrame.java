package ee.ut.math.tvt.salessystem.ui.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// todo: needs refactoring
public class ConfirmPaymentFrame extends JFrame {
	
	private static final long serialVersionUID = 11234222L;
	private JButton _confirmButton;
	private JButton _cancelButton;
	private double _totalSum = 0.0;
	private double _changeSum = 0.0;
	
	final JFrame _frame = this; 
	
	public ConfirmPaymentFrame(double totalSum) {
				
		super("Payment Confirmation");

		_totalSum = totalSum;
				
		setLocationRelativeTo(null);
		setSize(400, 200);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JPanel sumPanel = new JPanel();
		JLabel label = new JLabel("Total sum:");

		JLabel totalSumLabel = new JLabel(Double.toString(totalSum));

		sumPanel.add(label);
		sumPanel.add(totalSumLabel);
		getContentPane().add(sumPanel);

		JPanel paymentAmountPanel = new JPanel();
		paymentAmountPanel.add(new JLabel("Amount paid:"));

		final JTextField paymentAmountTextField = new JTextField(10);
		
		paymentAmountPanel.add(paymentAmountTextField);
		
		getContentPane().add(paymentAmountPanel);
		
		JPanel changeAmountPanel = new JPanel();
		changeAmountPanel.add(new JLabel("Change amount:"));
		final JLabel changeAmountLabel = new JLabel("(press <enter> to calculate change)");
		changeAmountPanel.add(changeAmountLabel);
		
		getContentPane().add(changeAmountPanel);
		
		JPanel buttonsPanel = new JPanel();

		_confirmButton = new JButton("Confirm");				
		_cancelButton = new JButton("Cancel");

		buttonsPanel.add(_confirmButton);
		buttonsPanel.add(_cancelButton);

		getContentPane().add(buttonsPanel);

		paymentAmountTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double amountPaid = Double.parseDouble(paymentAmountTextField.getText());
					if(amountPaid < _totalSum) {
						JOptionPane.showMessageDialog(_frame, "Insufficient amount paid!");
					} else {
						_changeSum = amountPaid - _totalSum;
						changeAmountLabel.setText(Double.toString(_changeSum));
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(_frame, "Please enter valid number");
				}
			}
			
		});

		pack();
		setVisible(true);
	}
	
	public JButton getConfirmButton() {
		return _confirmButton;
	}
	
	public JButton getCancelButton() {
		return _cancelButton;
	}
}
