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
public class Rectangle extends Shape2D {

	public Rectangle(Point startPoint, Paint paint, Stroke stroke, boolean filled) {
		super(startPoint, paint, stroke, filled);
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setPaint(getPaint());
		g2d.setStroke(getStroke());
		if(isFilled())
			g2d.fillRect(getTopX(), getTopY(), getWidth(), getHeight());
		else
			g2d.drawRect(getTopX(), getTopY(), getWidth(), getHeight());
	}
}
