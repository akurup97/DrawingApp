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
public class Oval extends Shape2D {

	public Oval(Point startPoint, Paint paint, Stroke stroke, boolean filled) {
		super(startPoint, paint, stroke, filled);
	}
	public void draw(Graphics2D g2d) {
		g2d.setPaint(getPaint());
		g2d.setStroke(getStroke());
		if(isFilled())
			g2d.fillOval(getTopX(), getTopY(), getWidth(), getHeight());
		else
			g2d.drawOval(getTopX(), getTopY(), getWidth(), getHeight());
	}
}
