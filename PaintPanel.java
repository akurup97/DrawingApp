/**
 * 
 */
package drawingapplication;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author adith
 *
 */
public class PaintPanel extends JPanel {
	
	private Shape shape;
	private Color color1 = Color.black;
	private Color color2 = Color.black;
	private Paint paint = Color.black;
	private Stroke stroke = new BasicStroke(0, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	private DrawingApplication display;
	private JPanel mousePosPanel = new JPanel();
	private JLabel mousePos = new JLabel("");
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public PaintPanel(DrawingApplication display) {
		this.display = display;
		MouseHandler mouseHandler = new MouseHandler();
		setBackground(Color.white);
		
		setLayout(new BorderLayout());
		
		mousePosPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		mousePosPanel.add(mousePos);
		
		addMouseMotionListener(mouseHandler);
		addMouseListener(mouseHandler);
		add(mousePosPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(g2d);
        }
	}
	
	public void undo(){
		try {
	        shapes.remove(shapes.size() - 1);
	        repaint();
		}
		catch(Exception e) {}
    }
    public void clear(){
        shapes.clear();
        repaint();
    }
    public void setColor1(Color c) {
        color1 = c;
    }
    public Color getColor1() {
    	return color1;
    }
    public void setGradColor(Color c) {
        color2 = c;
    }
    public Color getGradColor() {
        return color2;
    }
	
	private class MouseHandler extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent event) {

		}

		@Override
		public void mousePressed(MouseEvent event) {
            if(display.isGradient())
                paint = new GradientPaint(0, 0, getColor1(), 50, 50, getGradColor(), true);
            else
            	paint = color1;
            if(display.isDashed()) {
            	float[] dashes = {display.getDashLength()};
            	stroke = new BasicStroke(display.getLineWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashes, 0);
            }
            else
            	stroke = new BasicStroke(display.getLineWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
			if(display.getIndex() == 0) {
				shape = (new Line(event.getPoint(), paint, stroke, display.isDashed()));
				shapes.add(shape);
            }
            else if(display.getIndex() == 1) {
                shape = (new Oval(event.getPoint(), paint, stroke, display.isFilled()));
                shapes.add(shape);
            }
                    
            else if(display.getIndex() == 2) {
                shape = (new Rectangle(event.getPoint(), paint, stroke, display.isFilled()));
                shapes.add(shape);
            }                  
		}

		@Override
		public void mouseReleased(MouseEvent event) {
            shape.setEndPoint(event.getPoint());
            repaint();
		}

		@Override
		public void mouseDragged(MouseEvent event) {
			shape.setEndPoint(event.getPoint());
            repaint();
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			mousePos.setText(String.format("(%s, %s)", event.getX(), event.getY()));
		}
	}
}
