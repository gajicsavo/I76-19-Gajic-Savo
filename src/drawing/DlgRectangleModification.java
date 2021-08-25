package drawing;

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

public class DlgRectangleModification extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JButton btnBorderColor;
	private JButton btnInnerColor;
	Point p;
	int h,w;
	public boolean isOk = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleModification dialog = new DlgRectangleModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangleModification() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tacka gore levo koordinaka X:");
		lblNewLabel.setBounds(12, 12, 240, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tacka gore levo koordinaka Y:");
		lblNewLabel_1.setBounds(12, 41, 225, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sirina");
		lblNewLabel_2.setBounds(12, 83, 70, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Visina");
		lblNewLabel_3.setBounds(12, 110, 70, 15);
		contentPanel.add(lblNewLabel_3);
		
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
		txtX.setBounds(278, 10, 114, 19);
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
		txtY.setBounds(278, 39, 114, 19);
		contentPanel.add(txtY);
		txtY.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtWidth.setBounds(278, 79, 114, 19);
		contentPanel.add(txtWidth);
		txtWidth.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtHeight.setBounds(278, 108, 114, 19);
		contentPanel.add(txtHeight);
		txtHeight.setColumns(10);
		
		JLabel lblBojaIvice = new JLabel("Boja ivice:");
		lblBojaIvice.setBounds(12, 161, 94, 15);
		contentPanel.add(lblBojaIvice);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti:");
		lblBojaUnutrasnjosti.setBounds(12, 188, 166, 15);
		contentPanel.add(lblBojaUnutrasnjosti);
		
		btnBorderColor = new JButton("");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color borderColor = Color.BLACK;
				borderColor = JColorChooser.showDialog(null, "Izaberite boju ivice", borderColor);
				btnBorderColor.setBackground(borderColor);
			}
		});
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setBounds(275, 151, 117, 25);
		contentPanel.add(btnBorderColor);
		
		btnInnerColor = new JButton("");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color innerColor = Color.WHITE;
				innerColor = JColorChooser.showDialog(null, "Izaberite boju ivice", innerColor);
				btnInnerColor.setBackground(innerColor);
			}
		});
		btnInnerColor.setBackground(Color.WHITE);
		btnInnerColor.setBounds(275, 183, 117, 25);
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
							//Rectangle(Point upperLeftPoint, int height, int width)
							
							p = new Point(Integer.parseInt(txtX.getText()),Integer.parseInt(txtY.getText()));
							//newRectangle = new Rectangle(p,Integer.parseInt(txtHeight.getText()),Integer.parseInt(txtWidth.getText()));
							h = Integer.parseInt(txtHeight.getText());
							w = Integer.parseInt(txtWidth.getText());
							
							isOk = true;
							setVisible(false);
							
						} catch (NumberFormatException e2) {
							// TODO: handle exception
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
					public void actionPerformed(ActionEvent arg0) {
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

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
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

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
	
}
