package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgLineModification extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnBorderColor;
	private JTextField txtStartPointX;
	private  JTextField txtStartPointY;
	private  JTextField txtEndPointX;
	private  JTextField txtEndPointY;
	Point startPoint, endPoint;
	public boolean isOk = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLineModification dialog = new DlgLineModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLineModification() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X koorfinata početne tačke:");
		lblNewLabel.setBounds(12, 23, 212, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Y koordinata početne tačke:");
		lblNewLabel_1.setBounds(12, 60, 212, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("X koordinata krajnje tačke:");
		lblNewLabel_2.setBounds(12, 102, 212, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Y koordinata krajnje tačke:");
		lblNewLabel_3.setBounds(12, 138, 196, 15);
		contentPanel.add(lblNewLabel_3);
		
		txtStartPointX = new JTextField();
		txtStartPointX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtStartPointX.setBounds(274, 21, 114, 19);
		contentPanel.add(txtStartPointX);
		txtStartPointX.setColumns(10);
		
		txtStartPointY = new JTextField();
		txtStartPointY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtStartPointY.setBounds(274, 58, 114, 19);
		contentPanel.add(txtStartPointY);
		txtStartPointY.setColumns(10);
		
		txtEndPointX = new JTextField();
		txtEndPointX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtEndPointX.setBounds(274, 100, 114, 19);
		contentPanel.add(txtEndPointX);
		txtEndPointX.setColumns(10);
		
		txtEndPointY = new JTextField();
		txtEndPointY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && c != KeyEvent.VK_SPACE){
					e.consume();
				}
			}
		});
		txtEndPointY.setBounds(274, 136, 114, 19);
		contentPanel.add(txtEndPointY);
		txtEndPointY.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Boja ivice:");
		lblNewLabel_4.setBounds(12, 175, 103, 15);
		contentPanel.add(lblNewLabel_4);
		
		btnBorderColor = new JButton("");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color borderColor = Color.BLACK;
				borderColor = JColorChooser.showDialog(null, "Izaberite boju ivice:", borderColor);
				btnBorderColor.setBackground(borderColor);
			}
		});
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setBounds(274, 165, 117, 25);
		contentPanel.add(btnBorderColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							
							startPoint = new Point(Integer.parseInt(txtStartPointX.getText()),Integer.parseInt(txtStartPointY.getText()));
							endPoint = new Point(Integer.parseInt(txtEndPointX.getText()), Integer.parseInt(txtEndPointY.getText()));

							isOk = true;
							
							setVisible(false);
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null,"Niste uneli tražene podatke!", "Grežka", JOptionPane.ERROR_MESSAGE);

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

	public JTextField getTxtStartPointX() {
		return txtStartPointX;
	}

	public void setTxtStartPointX(JTextField txtStartPointX) {
		this.txtStartPointX = txtStartPointX;
	}

	public JTextField getTxtStartPointY() {
		return txtStartPointY;
	}

	public void setTxtStartPointY(JTextField txtStartPointY) {
		this.txtStartPointY = txtStartPointY;
	}

	public JTextField getTxtEndPointX() {
		return txtEndPointX;
	}

	public void setTxtEndPointX(JTextField txtEndPointX) {
		this.txtEndPointX = txtEndPointX;
	}

	public JTextField getTxtEndPointY() {
		return txtEndPointY;
	}

	public void setTxtEndPointY(JTextField txtEndPointY) {
		this.txtEndPointY = txtEndPointY;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}
	
}
