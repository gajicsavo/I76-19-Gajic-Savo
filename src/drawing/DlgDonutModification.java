package drawing;

import geometry.Donut;
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

public class DlgDonutModification extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	private JButton btnBorderColor;
	private JButton btnInnerColor;
	Point center;
	private Donut newDonut;
	int r, ir;
	public boolean isOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonutModification dialog = new DlgDonutModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonutModification() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Koordinata X:");
		lblNewLabel.setBounds(12, 16, 113, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Koordinata Y:");
		lblNewLabel_1.setBounds(12, 45, 130, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Radius:");
		lblNewLabel_2.setBounds(13, 82, 70, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Unutrašnji radius:");
		lblNewLabel_3.setBounds(12, 109, 144, 15);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Boja ivice:");
		lblNewLabel_4.setBounds(12, 150, 130, 15);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti:");
		lblBojaUnutrasnjosti.setBounds(12, 181, 201, 15);
		contentPanel.add(lblBojaUnutrasnjosti);
		
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
		txtX.setBounds(282, 14, 114, 19);
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
		txtY.setBounds(282, 43, 114, 19);
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
		txtRadius.setBounds(282, 80, 114, 19);
		contentPanel.add(txtRadius);
		txtRadius.setColumns(10);
		
		txtInnerRadius = new JTextField();
		txtInnerRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtInnerRadius.setBounds(282, 107, 114, 19);
		contentPanel.add(txtInnerRadius);
		txtInnerRadius.setColumns(10);
		
		btnBorderColor = new JButton("");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color borderColor = Color.BLACK;
				borderColor = JColorChooser.showDialog(null, "Izaberite boju ivice", borderColor);
				btnBorderColor.setBackground(borderColor);
			}
		});
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setBounds(279, 145, 117, 25);
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
		btnInnerColor.setBounds(279, 176, 117, 25);
		contentPanel.add(btnInnerColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							center = new Point(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()));
							
							r = Integer.parseInt(txtRadius.getText());
							ir = Integer.parseInt(txtInnerRadius.getText());
				
							isOk = true;
							setVisible(false);
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Niste uneli tražene podatke!", "Greška", JOptionPane.ERROR_MESSAGE);
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

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}


	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public Donut getNewDonut() {
		return newDonut;
	}

	public void setNewDonut(Donut newDonut) {
		this.newDonut = newDonut;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getIr() {
		return ir;
	}

	public void setIr(int ir) {
		this.ir = ir;
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
	
}
