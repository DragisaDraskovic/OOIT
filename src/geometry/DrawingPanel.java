package geometry;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import geometry.Circle;
import geometry.Donut;
import geometry.DrawingFrame;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;


public class DrawingPanel extends JPanel implements MouseListener {
	
	
	protected static ArrayList<Shape> shapes = new ArrayList<Shape>();	
	private Point startPoint = null;		
	static int o = 0;			 
	int mx;			
	int my;		

	
	public DrawingPanel() {
		addMouseListener(this);
	}
		
	public void paint(Graphics g) {
		super.paint(g);
	
		for(Shape shape : shapes) {
		shape.AreaPainter(g);
		shape.draw(g);
		}
 		repaint();
	}
	
	
	
	public void mouseClicked(MouseEvent e) {		
		mx = e.getX();	
		my = e.getY();
		
		if (o == 1) {
			Point point = new Point(mx, my, false);
			point.setOutline(DrawingFrame.outline);
			shapes.add(point);
			
		} else if (o == 2) {
			if(startPoint == null) {
				startPoint = new Point (mx, my, false);
			} else {
				Point endPoint = new Point(mx, my);
				Line line = new Line(startPoint, endPoint, false);
				line.setOutline(DrawingFrame.outline);
				shapes.add(line);
				startPoint = null;
			}
			
		}	else if (o == 3) {
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.getTxtXCoordinate().setText(String.valueOf(mx));
			dlgRectangle.getTxtXCoordinate().setEditable(false);
			dlgRectangle.getTxtYCoordinate().setText(String.valueOf(my));
			dlgRectangle.getTxtYCoordinate().setEditable(false);
			dlgRectangle.setVisible(true);
			if(dlgRectangle.ok == true) {
				Rectangle r = new Rectangle(new Point(mx, my), Integer.parseInt(dlgRectangle.getTxtWidth().getText()),
						Integer.parseInt(dlgRectangle.getTxtHeight().getText()), false);
				r.setOutline(DrawingFrame.outline);
				r.setFill(DrawingFrame.fill);
				
				if(dlgRectangle.isOutlineColorB()) {
					r.setOutline(dlgRectangle.getOutline());
				}
				
				if(dlgRectangle.isFillColorB()) {
					r.setFill(dlgRectangle.getFill());
				}
				shapes.add(r);
			}
		} else if (o == 4) {
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.getTxtXCoordinate().setText(String.valueOf(mx));
			dlgCircle.getTxtYCoordinate().setText(String.valueOf(my));
			dlgCircle.getTxtXCoordinate().setEditable(false);
			dlgCircle.getTxtYCoordinate().setEditable(false);
			dlgCircle.setVisible(true);
			if(dlgCircle.ok == true) {
				Circle c = new Circle(new Point(mx, my), Integer.parseInt(dlgCircle.getTxtRadius().getText()), false);
				c.setOutline(DrawingFrame.outline);
				c.setFill(DrawingFrame.fill);
				
				if(dlgCircle.isOutlineColorB()) {
					c.setOutline(dlgCircle.getOutline());
				}
				
				if(dlgCircle.isFillColorB()) {
					c.setFill(dlgCircle.getFill());
				}
				
				shapes.add(c);
			}
		} else if (o == 5) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.getTxtXCoordinate().setText(String.valueOf(mx));
			dlgDonut.getTxtYCoordinate().setText(String.valueOf(my));
			dlgDonut.getTxtXCoordinate().setEditable(false);
			dlgDonut.getTxtYCoordinate().setEditable(false);
			dlgDonut.setVisible(true);
			if(dlgDonut.ok == true) {
				Donut d = new Donut(new Point(mx, my),
						Integer.parseInt(dlgDonut.getTxtRadius().getText()),
						Integer.parseInt(dlgDonut.getTxtInnerRadius().getText()),false);
				d.setOutline(DrawingFrame.outline);
				d.setFill(DrawingFrame.fill);
				
				if(dlgDonut.isOutlineColorB()) {
					d.setOutline(dlgDonut.getOutlineColor());
				}
				
				if(dlgDonut.isFillColorB()) {
					d.setFill(dlgDonut.getFillColor());
				}
				
				shapes.add(d);
			}
		} else if (o == 6) {
			boolean match = false;
			Collections.reverse(shapes);				//okrecemo listu kako bi poslednji selektovali
			for(Shape shape : shapes) {
				shape.setSelected(false);
				if(match == false) {
					if(shape.contains(mx, my)) {
						shape.setSelected(true);
						match = true;
					}
				}
			}
			Collections.reverse(shapes);				//vracamo listu na prethodno stanje
		
		}
			
			
} 

	
	
	@Override
	public void mousePressed(MouseEvent e) {}
		// TODO Auto-generated method stub
		
	@Override
	public void mouseReleased(MouseEvent e) {}
		// TODO Auto-generated method stub
		

	@Override
	public void mouseEntered(MouseEvent e) {}
		// TODO Auto-generated method stub
		

	@Override
	public void mouseExited(MouseEvent e) {}
		// TODO Auto-generated method stub




	


	

}