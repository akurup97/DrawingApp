/**
 * 
 */
package drawingapplication;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

/**
 * @author adith
 *
 */
public class Line extends Shape {
	
	private boolean dashed;
	public Line(Point startPoint, Paint paint, Stroke stroke, boolean dashed) {
		super(startPoint, paint, stroke);
		this.dashed = dashed;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setStroke(getStroke());
		g2d.setPaint(getPaint());
		g2d.drawLine((int)getStartPoint().getX(), (int)getStartPoint().getY(), (int)getEndPoint().getX(), (int)getEndPoint().getY());
	}

}
