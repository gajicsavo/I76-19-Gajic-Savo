package drawing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Point;
import geometry.Line;
import geometry.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;


public class DlgDrawing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JPanel contentPane;
	

	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;
	
	JToggleButton tglbtnSelect;
	JButton btnModify;
	JButton btnDelete;
	
	PnlDrawing pnlDrawing;
	
	private Color borderColor = Color.BLACK;
	private Color innerColor = Color.WHITE;	
	
	DlgPointModification pointModification = new DlgPointModification();
	DlgLineModification lineModification = new DlgLineModification();
	DlgRectangleModification rectangleModification = new DlgRectangleModification();
	DlgCircleModification circleModification = new DlgCircleModification();
	DlgDonutModification donutModification  = new DlgDonutModification();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgDrawing frame = new DlgDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DlgDrawing() {
		setTitle("I76/2019 Gajic Savo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		setContentPane(contentPane);
		

		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setBackground(new Color(250, 235, 215));
		pnlButtons.setForeground(Color.BLACK);
		pnlButtons.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		
		pnlDrawing = new PnlDrawing();
		pnlDrawing.setFrame(this);
		pnlDrawing.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pnlButtons, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlDrawing, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlButtons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnlDrawing, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
		);
		pnlButtons.setLayout(null);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		
		tglbtnPoint = new JToggleButton("Ta\u010Dka");
		tglbtnPoint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tglbtnPoint.isSelected()) {
					btnModify.setEnabled(false);
					btnDelete.setEnabled(false);
				}
			}
			
		});
		tglbtnPoint.setBounds(10, 11, 146, 23);
		pnlButtons.add(tglbtnPoint);
		buttonGroup.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Linija");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLine.isSelected()) {
					btnModify.setEnabled(false);
					btnDelete.setEnabled(false);
				}
			}
		});
		tglbtnLine.setBounds(10, 45, 146, 23);
		pnlButtons.add(tglbtnLine);
		buttonGroup.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Pravougaonik");
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tglbtnRectangle.isSelected()) {
					
					btnModify.setEnabled(false);
					btnDelete.setEnabled(false);
				}
			}
		});
		tglbtnRectangle.setBounds(10, 114, 146, 23);
		pnlButtons.add(tglbtnRectangle);
		buttonGroup.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton("Krug");
		tglbtnCircle.setBounds(10, 148, 146, 23);
		pnlButtons.add(tglbtnCircle);
		buttonGroup.add(tglbtnCircle);
		
		
		tglbtnDonut = new JToggleButton("Krofna");
		tglbtnDonut.setBounds(10, 180, 146, 25);
		pnlButtons.add(tglbtnDonut);
		buttonGroup.add(tglbtnDonut);
		
		JLabel lblBojaIvice = new JLabel("Boja ivice: ");
		lblBojaIvice.setBounds(12, 230, 112, 14);
		pnlButtons.add(lblBojaIvice);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti:");
		lblBojaUnutrasnjosti.setBounds(12, 255, 112, 14);
		pnlButtons.add(lblBojaUnutrasnjosti);
		
		JButton btnBorderColor = new JButton("");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				borderColor = JColorChooser.showDialog(null, "Izaberite boju ivice:", borderColor);
				btnBorderColor.setBackground(borderColor);
			}
		});
		btnBorderColor.setForeground(Color.BLACK);
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setBounds(135, 226, 33, 23);
		pnlButtons.add(btnBorderColor);
		
		JButton btnColorInside = new JButton("");
		btnColorInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				innerColor = JColorChooser.showDialog(null, "Izaberite boju unutrašnjosti:", innerColor);
				btnColorInside.setBackground(innerColor);
			}
		});
		btnColorInside.setForeground(Color.WHITE);
		btnColorInside.setBackground(Color.WHITE);
		btnColorInside.setBounds(135, 251, 33, 23);
		pnlButtons.add(btnColorInside);
		
		tglbtnSelect = new JToggleButton("Selektuj");
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnSelect.isSelected()) {
					btnModify.setEnabled(true);
					btnDelete.setEnabled(true);					
				}				
			}
		});
		tglbtnSelect.setBounds(12, 292, 146, 23);
		pnlButtons.add(tglbtnSelect);
		buttonGroup.add(tglbtnSelect);
		
		btnModify = new JButton("Modifikuj");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnlDrawing.getSelectedShape() instanceof Point) {
					
					Point temp = (Point) pnlDrawing.getSelectedShape();
					pointModification.getTxtX().setText("" + temp.getX());
					pointModification.getTxtY().setText("" + temp.getY());
					pointModification.getBtnBorderColor().setBackground(temp.getColor());
					
					pointModification.setVisible(true);			
					
					if(pointModification.isOk){
						temp.moveBy(pointModification.getX(), pointModification.getY());
						temp.setColor(pointModification.getBtnBorderColor().getBackground());
					}

					
				} else if(pnlDrawing.getSelectedShape() instanceof Line) {
					
					Line temp = (Line) pnlDrawing.getSelectedShape();
					lineModification.getTxtStartPointX().setText("" + temp.getStartPoint().getX());
					lineModification.getTxtStartPointY().setText("" + temp.getStartPoint().getY());
					
					lineModification.getTxtEndPointX().setText("" + temp.getEndPoint().getX());
					lineModification.getTxtEndPointY().setText("" + temp.getEndPoint().getY());
					
					lineModification.getBtnBorderColor().setBackground(temp.getColor());
					
					lineModification.setVisible(true);
					if(lineModification.isOk){
						temp.getStartPoint().moveBy(lineModification.getStartPoint().getX(), lineModification.getStartPoint().getY());
						temp.getEndPoint().moveBy(lineModification.getEndPoint().getX(), lineModification.getEndPoint().getY());
						temp.setColor(lineModification.getBtnBorderColor().getBackground());
					}
		

				} else if(pnlDrawing.getSelectedShape() instanceof Rectangle){
					
					Rectangle temp = (Rectangle) pnlDrawing.getSelectedShape();
					rectangleModification.getTxtX().setText(""+temp.getUpperLeftPoint().getX());
					rectangleModification.getTxtY().setText(""+temp.getUpperLeftPoint().getY());
					rectangleModification.getTxtHeight().setText(""+temp.getHeight());
					rectangleModification.getTxtWidth().setText(""+temp.getWidth());
					rectangleModification.getBtnBorderColor().setBackground(temp.getColor());
					rectangleModification.getBtnInnerColor().setBackground(temp.getInnerColor());
					
					rectangleModification.setVisible(true);

					if(rectangleModification.isOk){
						temp.getUpperLeftPoint().moveBy(rectangleModification.getP().getX(), rectangleModification.getP().getY());
						temp.setHeight(rectangleModification.getH());
						temp.setWidth(rectangleModification.getW());
						temp.setColor(rectangleModification.getBtnBorderColor().getBackground());
						temp.setInnerColor(rectangleModification.getBtnInnerColor().getBackground());
					}
	
					
				} else if(pnlDrawing.getSelectedShape() instanceof Donut){
					Donut temp = (Donut) pnlDrawing.getSelectedShape();
					
					donutModification.getTxtX().setText(""+temp.getCenter().getX());
					donutModification.getTxtY().setText(""+temp.getCenter().getY());
					
					donutModification.getTxtRadius().setText(""+temp.getRadius());
					donutModification.getTxtInnerRadius().setText(""+temp.getInnerRadius());
					
					donutModification.getBtnBorderColor().setBackground(temp.getColor());
					donutModification.getBtnInnerColor().setBackground(temp.getInnerColor());
					
					donutModification.setVisible(true);
					
					if(donutModification.isOk){

						try {
							temp.getCenter().moveBy(donutModification.getCenter().getX(), donutModification.getCenter().getY());
							temp.setRadius(donutModification.getR());
							temp.setInnerRadius(donutModification.getIr());
							temp.setColor(donutModification.getBtnBorderColor().getBackground());
							temp.setInnerColor(donutModification.getBtnInnerColor().getBackground());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
					
				} else if(pnlDrawing.getSelectedShape() instanceof Circle){
					
						
					
					Circle temp = (Circle) pnlDrawing.getSelectedShape();
					circleModification.getTxtX().setText(""+temp.getCenter().getX());
					circleModification.getTxtY().setText(""+temp.getCenter().getY());
					circleModification.getTxtRadius().setText(""+temp.getRadius());
					circleModification.getBtnBorderColor().setBackground(temp.getColor());
					circleModification.getBtnInnerColor().setBackground(temp.getInnerColor());

					circleModification.setVisible(true);
					
					if(circleModification.isOk){
						try {
						
							temp.getCenter().moveBy(circleModification.getCenter().getX(), circleModification.getCenter().getY());
							temp.setRadius(circleModification.getR());
							temp.setColor(circleModification.getBtnBorderColor().getBackground());
							temp.setInnerColor(circleModification.getBtnInnerColor().getBackground());
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						
						}
					}
				} 
			}
		});
		btnModify.setBounds(12, 326, 146, 23);
		pnlButtons.add(btnModify);
		buttonGroup.add(btnModify);
		btnModify.setEnabled(false);
		
		btnDelete = new JButton("Obriši");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int respons = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete selektovani oblik?", "Brisanje", JOptionPane.YES_NO_OPTION);
				if (respons == JOptionPane.YES_OPTION) {
					pnlDrawing.getListOfShapes().remove(pnlDrawing.getSelectedShape());
					
				}
			}
		});
		btnDelete.setBounds(12, 360, 146, 23);
		pnlButtons.add(btnDelete);
		buttonGroup.add(btnDelete);
		btnDelete.setEnabled(false);

		contentPane.setLayout(gl_contentPane);
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}
	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public JButton getTglbtnModify() {
		return btnModify;
	}

	public JButton getTglbtnDelete() {
		return btnDelete;
	}

	public PnlDrawing getpnlDrawing() {
		return pnlDrawing;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}
	
	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public void setTglbtnKrug(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}
	public void setTglbtnDonut(JToggleButton tglbtnDonut) {
		this.tglbtnDonut = tglbtnDonut;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(JButton btnModifikuj) {
		this.btnModify = btnModifikuj;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public void setpnlDrawing(PnlDrawing pnlDrawing) {
		this.pnlDrawing = pnlDrawing;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
}
