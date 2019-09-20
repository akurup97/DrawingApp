/**
 * 
 */
package drawingapplication;

import java.awt.*;

/**
 * @author adith
 *
 */
public abstract class Shape {
	
	private Point startPoint;
	private Point endPoint;
	private Paint paint;
	private Stroke stroke;
	
	public Shape(Point startPoint, Paint paint, Stroke stroke) {
		this.startPoint = startPoint;
		this.endPoint = startPoint;
		this.paint = paint;
		this.stroke = stroke;
	}
	public void setStartPoint(Point start) {
		startPoint = start;
	}
	public void setEndPoint(Point end) {
		endPoint = end;
	}
	public void setPaint(Paint p) {
		paint = p;
	}
	public void setStroke(Stroke s) {
		stroke = s;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public Paint getPaint() {
		return paint;
	}
	public Stroke getStroke() {
		return stroke;
	}
	
	public abstract void draw(Graphics2D g2d);
}
