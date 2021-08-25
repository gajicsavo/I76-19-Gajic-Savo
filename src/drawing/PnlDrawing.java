package drawing;

import geometry.Donut;
import geometry.Circle;
import geometry.Line;
import geometry.Shape;
import geometry.Rectangle;
import geometry.Point;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;


public class PnlDrawing extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	DlgDrawing frame;
	private ArrayList<Shape> listOfShapes= new ArrayList<Shape>();
	private ArrayList<Shape> listOfSelShapes = new ArrayList<Shape>();
	private boolean click;
	Point startPoint;
	private Shape selectedShape;	
	
	
	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			if(frame.getTglbtnPoint().isSelected()) {
				
				int x = e.getX();
				int y = e.getY();
				
				Point p = new Point(x,y,false, frame.getBorderColor());
				listOfShapes.add(p);	
				
			} else if(frame.getTglbtnLine().isSelected()) {
				
				if(click == false) {
					
					startPoint = new Point(e.getX(), e.getY());
					click = true;
					
				}else {
					Point endPoint = new Point(e.getX(), e.getY());
					Line l = new Line(startPoint, endPoint, false, frame.getBorderColor());
					
					listOfShapes.add(l);
					click = false;
				}
				
			} else if(frame.getTglbtnRectangle().isSelected()) {
				
				Point upperLeftPoint = new Point(e.getX(), e.getY());
				DlgRectangle dialog = new DlgRectangle();
				
				dialog.setVisible(true);
				
				Rectangle r = new Rectangle(upperLeftPoint, dialog.getH(), dialog.getW(), false, frame.getBorderColor(), frame.getInnerColor());
				listOfShapes.add(r);
				
			} else if(frame.getTglbtnCircle().isSelected()) {
				
				Point center = new  Point(e.getX(), e.getY());
				
				DlgCircle dialog = new DlgCircle();
				
				dialog.setVisible(true);
				
				Circle c = new Circle(center, dialog.getRadius(), false, frame.getBorderColor(), frame.getInnerColor());
				listOfShapes.add(c);
				
			} else if(frame.getTglbtnDonut().isSelected()) {
				
				Point center = new Point(e.getX(), e.getY());
				DlgDonut dialog = new DlgDonut();
				
				dialog.setVisible(true);
				
				Donut d = new Donut(center, dialog.getRadius(), dialog.getInnerRadius(), false, frame.getBorderColor(), frame.getInnerColor());
				listOfShapes.add(d);
				
			} else if(frame.tglbtnSelect.isSelected()) {
				int x = e.getX();
				int y = e.getY();
				
				for (Shape shape: listOfShapes) {
					if(shape.contains(x,y)) {
						selectedShape = shape;
						listOfSelShapes.add(selectedShape);
						selectedShape = lastShape(x,y);
					} else {
						shape.setSelected(false);
						listOfSelShapes.clear();
					}
				}
			}
				
			}
		});

	}
	
	public Shape lastShape(int x, int y) {
		Shape lastShape = null;
		for(Shape o: listOfSelShapes) {
			o.setSelected(false);
			lastShape = o;
		}
		
		lastShape.setSelected(true);		
		return lastShape;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = listOfShapes.iterator();
		while(it.hasNext()) {
			((Shape) it.next()).draw(g);
		}
		repaint();
	}

	public DlgDrawing getFrame() {
		return frame;
	}

	public void setFrame(DlgDrawing frame) {
		this.frame = frame;
	}

	public ArrayList<Shape> getListOfShapes() {
		return listOfShapes;
	}

	public void setListOfShapes(ArrayList<Shape> listOfShapes) {
		this.listOfShapes = listOfShapes;
	}

	public ArrayList<Shape> getListOfSelShapes() {
		return listOfSelShapes;
	}

	public void setListOfSelShapes(ArrayList<Shape> listOfSelShapes) {
		this.listOfSelShapes = listOfSelShapes;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

}
