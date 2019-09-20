/**
 * 
 */
package drawingapplication;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * @author adith
 *
 */
public class DrawingApplication extends JFrame {

	private final JButton undo = new JButton("Undo"), clear = new JButton("Clear"), color1_bt = new JButton("1st Color..."), color2_bt = new JButton("2nd Color...");
	private final JCheckBox filled = new JCheckBox("Filled"), gradient = new JCheckBox("Use Gradient"), dashed = new JCheckBox("Dashed");
	private final JLabel shapeLabel = new JLabel("Shape:"), lineWidthLabel = new JLabel("Line Width:"), dashLengthLabel = new JLabel("Dash Length:"), mousePos = new JLabel("");
	private final JTextField lineWidth = new JTextField(2), dashLength = new JTextField(2);
	private final String[] shapes = {"Line", "Oval", "Rectangle"};
	private final JComboBox<String> shapeSelection = new JComboBox<String>(shapes);
	private final JPanel optionPanel = new JPanel(), topPanel = new JPanel(), bottomPanel = new JPanel();
	private final PaintPanel drawPanel = new PaintPanel(this);
	
	public DrawingApplication(String title, int length, int width) {
		
		super(title);
		ButtonHandler buttonHandler = new ButtonHandler();
		
		setSize(length, width);
		setLayout(new BorderLayout());
		
		optionPanel.setLayout(new GridLayout(2, 1));
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new FlowLayout());
		
		undo.addActionListener(buttonHandler);
		clear.addActionListener(buttonHandler);
		color1_bt.addActionListener(buttonHandler);
		color2_bt.addActionListener(buttonHandler);
		
		topPanel.add(undo);
		topPanel.add(clear);
		topPanel.add(shapeLabel);
		topPanel.add(shapeSelection);
		topPanel.add(filled);
		
		bottomPanel.add(gradient);
		bottomPanel.add(color1_bt);
		bottomPanel.add(color2_bt);
		bottomPanel.add(lineWidthLabel);
		bottomPanel.add(lineWidth);
		bottomPanel.add(dashLengthLabel);
		bottomPanel.add(dashLength);
		bottomPanel.add(dashed);
		
		optionPanel.add(topPanel, BorderLayout.NORTH);
		optionPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		add(optionPanel, BorderLayout.NORTH);
		add(drawPanel, BorderLayout.CENTER);
		add(mousePos, BorderLayout.SOUTH);
	}
	
	public int getIndex() {
		return shapeSelection.getSelectedIndex();
	}
	
	public int getLineWidth() {
		try {
			return Integer.parseInt(lineWidth.getText());
		}
		catch (Exception e) {
			return 1;
		}
	}
	public int getDashLength() {
		try {
			return Integer.parseInt(dashLength.getText());
		}
		catch (Exception e) {
			return 1;
		}
	}
	
	public boolean isFilled() {
		return filled.isSelected();
	}
	public boolean isGradient() {
		return gradient.isSelected();
	}
	public boolean isDashed() {
		return dashed.isSelected();
	}
	
	public class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == undo) {
				drawPanel.undo();
			}
                            
			if(event.getSource() == clear) {
				drawPanel.clear();
            }
				
			if(event.getSource() == color1_bt) {
				drawPanel.setColor1(JColorChooser.showDialog(DrawingApplication.this, "Choose a Color", drawPanel.getColor1()));
			}
			
			if(event.getSource() == color2_bt) {
                drawPanel.setGradColor(JColorChooser.showDialog(DrawingApplication.this, "Choose a Color", drawPanel.getGradColor()));
            }
		}
	}
        
        public static void main(String[] args) {
		DrawingApplication display = new DrawingApplication("Java 2D Drawings", 650, 500);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setVisible(true);
	}
}
