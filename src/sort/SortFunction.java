package sort;

import java.util.Comparator;
import java.util.Random;

import geometry.Point;
import geometry.Rectangle;
import sort.RectangleComparator;

public class SortFunction {

	private Rectangle[] list;
	private RectangleComparator comp;

	public SortFunction() {
	}

	public SortFunction(Rectangle[] list, RectangleComparator comp) {
		this.list = list;
		this.comp = comp;
	}

	public static void print(Rectangle[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println("area = " + list[i].getWidth() * list[i].getHeight());
		}
	}

	public static Rectangle[] generateRectangle(Rectangle[] list) {

		Random r = new Random();

		for (int i = 0; i < list.length; i++) {

			list[i] = new Rectangle(new Point(r.nextInt(9) + 1, r.nextInt(9) + 1), r.nextInt(9) + 1, r.nextInt(9) + 1);
		}

		return list;
	}

	public Rectangle[] getList() {
		return list;
	}

	public void setList(Rectangle[] list) {
		this.list = list;
	}

	public RectangleComparator getComp() {
		return comp;
	}

	public void setComp(RectangleComparator comp) {
		this.comp = comp;
	}
	
}

// inner class implements Comparator for Rectangle class
class RectangleComparator implements Comparator<Object> {

	@Override
	public int compare(Object firstObject, Object secondObject) {
		// order based on area, ascending
		Rectangle r1 = (Rectangle) firstObject;
		double area1 = r1.area();
		Rectangle r2 = (Rectangle) secondObject;
		double area2 = r2.area();

		if (area1 < area2) {
			return -1;
		}
		if (area1 > area2) {
			return 1;
		} else // areas are equal
		// test for equality must be the same as in overridden
		// equals() method - all 4 instance var's are equal
		{
			double x1 = r1.getUpperLeftPoint().getX();
			double y1 = r1.getUpperLeftPoint().getY();
			double x2 = r2.getUpperLeftPoint().getX();
			double y2 = r2.getUpperLeftPoint().getY();

			if (x1 == x2 && y1 == y2 && r1.getWidth() == r2.getWidth() && r1.getHeight() == r2.getHeight()) {
				return 0;
			} else // equal areas but not X, Y, width, and height
			// order on distance of upper-left corner from 0,0
			{
				if (Math.sqrt(x1 * x1 + y1 * y1) < Math.sqrt(x2 * x2 + y2 * y2)) {
					return -1;
				} else {
					return 1;
				}
			}
		}

	}

}