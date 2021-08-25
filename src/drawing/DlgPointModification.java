package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgPointModification extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JButton btnBorderColor;
	int x,y;
	public boolean isOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPointModification dialog = new DlgPointModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPointModification() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Pozicija X koordinate:");
			lblNewLabel.setBounds(12, 26, 169, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Pozicija Y koordinate:");
			lblNewLabel_1.setBounds(13, 69, 168, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtX = new JTextField();
			txtX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
						e.consume();
					}
				}
			});
			txtX.setBounds(266, 22, 114, 19);
			contentPanel.add(txtX);
			txtX.setColumns(10);
		}
		{
			txtY = new JTextField();
			txtY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
						e.consume();
					}
				}
			});
			txtY.setBounds(266, 67, 114, 19);
			contentPanel.add(txtY);
			txtY.setColumns(10);
		}
		
		JLabel lblBojaIvice = new JLabel("Boja ivice:");
		lblBojaIvice.setBounds(12, 136, 100, 15);
		contentPanel.add(lblBojaIvice);
		
		btnBorderColor = new JButton("");
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color borderColor = Color.BLACK;
				borderColor = JColorChooser.showDialog(null, "Izaberite boju ivice", borderColor);
				btnBorderColor.setBackground(borderColor);
			}
		});
		btnBorderColor.setBounds(266, 126, 117, 25);
		contentPanel.add(btnBorderColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						
							x = Integer.parseInt(txtX.getText());
							y = Integer.parseInt(txtY.getText());
							isOk = true;
							setVisible(false);
							
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null,"Niste uneli tražene podatke!", "Greška", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Odustani");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}
	
}
