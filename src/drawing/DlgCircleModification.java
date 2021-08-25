package drawing;

import geometry.Circle;
import geometry.Point;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgCircleModification extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private JButton btnBorderColor;
	private JButton btnInnerColor;
	Circle newCircle;
	Point center;
	int r;
	public boolean isOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircleModification dialog = new DlgCircleModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircleModification() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X koordinata:");
		lblNewLabel.setBounds(12, 24, 117, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Y koordinata:");
		lblNewLabel_1.setBounds(12, 51, 117, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Poluprečnik:");
		lblNewLabel_2.setBounds(12, 98, 143, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Boja ivice:");
		lblNewLabel_3.setBounds(12, 143, 117, 15);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Boja unutrašnjosti:");
		lblNewLabel_4.setBounds(12, 169, 169, 15);
		contentPanel.add(lblNewLabel_4);
		
		txtX = new JTextField();
		txtX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9' ) && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtX.setBounds(266, 22, 114, 19);
		contentPanel.add(txtX);
		txtX.setColumns(10);
		
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
		txtY.setBounds(266, 49, 114, 19);
		contentPanel.add(txtY);
		txtY.setColumns(10);
		
		txtRadius = new JTextField();
		txtRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtRadius.setBounds(266, 96, 114, 19);
		contentPanel.add(txtRadius);
		txtRadius.setColumns(10);
		
		btnBorderColor = new JButton("");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color borderColor = Color.BLACK;
				borderColor = JColorChooser.showDialog(null, "Izaberite boju ivice:", borderColor);
				btnBorderColor.setBackground(borderColor);
				
			}
		});
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setBounds(266, 133, 117, 25);
		contentPanel.add(btnBorderColor);
		
		btnInnerColor = new JButton("");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color innerColor = Color.WHITE;
				innerColor = JColorChooser.showDialog(null, "Izaberite boju unutrašnjosti", innerColor);
				btnInnerColor.setBackground(innerColor);
			}
		});
		btnInnerColor.setBackground(Color.WHITE);
		btnInnerColor.setBounds(266, 164, 117, 25);
		contentPanel.add(btnInnerColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							
							//Point center, int radius, boolean selected, Color color, Color innerColor
							center = new Point(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()));
							r = Integer.parseInt(txtRadius.getText());
							isOk = true;
							setVisible(false);
							
						} catch (NumberFormatException e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Niste uneli tra�ene podatke!", "Gre�ka", JOptionPane.ERROR_MESSAGE);
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

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}



	public Point getCenter() {
		return center;
	}

	public Circle getNewCircle() {
		return newCircle;
	}

	public void setNewCircle(Circle newCircle) {
		this.newCircle = newCircle;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
}
