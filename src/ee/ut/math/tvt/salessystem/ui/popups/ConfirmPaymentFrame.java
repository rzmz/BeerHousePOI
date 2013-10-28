package ee.ut.math.tvt.salessystem.ui.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// todo: needs refactoring
public class ConfirmPaymentFrame extends JFrame {
	
	private static final long serialVersionUID = 11234222L;
	private JButton _confirmButton;
	private JButton _cancelButton;
	
	public ConfirmPaymentFrame(double totalSum) {
				
		super("Payment Confirmation");

		setAlwaysOnTop(true);
		
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
		JLabel paymentAmountLabel = new JLabel("Amount paid:");
		final JTextField paymentAmountTextField = new JTextField(20);

		paymentAmountTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("paid:" + ((JTextField)e.getSource()).getText());
			}
			
		});
		
		paymentAmountPanel.add(paymentAmountLabel);
		paymentAmountPanel.add(paymentAmountTextField);
		
		getContentPane().add(paymentAmountPanel);
		
		JPanel buttonsPanel = new JPanel();

		_confirmButton = new JButton("Confirm");
				
		_cancelButton = new JButton("Cancel");

		buttonsPanel.add(_confirmButton);
		buttonsPanel.add(_cancelButton);

		getContentPane().add(buttonsPanel);

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
