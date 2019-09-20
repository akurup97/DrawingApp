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
public abstract class Shape2D extends Shape {

	private boolean filled;
	private boolean gradient;
	public Shape2D(Point startPoint, Paint paint, Stroke stroke, boolean filled) {
		super(startPoint, paint, stroke);
		this.filled = filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public int getTopX() {
		return Math.min((int)getStartPoint().getX(), (int)getEndPoint().getX());
	}
	
	public int getTopY() {
		return Math.min((int)getStartPoint().getY(), (int)getEndPoint().getY());
	}
	
	public int getWidth() {
		return Math.abs((int)getStartPoint().getX() - (int)getEndPoint().getX());
	}
	
	public int getHeight() {
		return Math.abs((int)getStartPoint().getY() - (int)getEndPoint().getY());
	}
}
