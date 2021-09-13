package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private int width; 
	private int height;
	private Point upperLeft;					

	public Rectangle ( ) {
		
	}
	
	public Rectangle (Point upperLeft, int width, int height) {  
		this.upperLeft = upperLeft;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle (Point upperLeft, int width, int height, boolean selected) {		
		this(upperLeft, width, height);
		this.selected = selected;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	
	public Point getCenter() {									
		return new Point(upperLeft.getX() + width/2, upperLeft.getY() + height/2);    
	}	   																		   
																				   
	public int area () {					
		return width * height;
	}
	
	public int volume () {					
		return 2 * height + 2 * width;
	}
	
	public String toString () {
		return "Upper left point:" + upperLeft + ",width:" + width + ", height:" + height;
	}
	
	
	public boolean equals (Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle r = (Rectangle) obj;
			return upperLeft.equals(r.upperLeft) && width == r.width && height == r.height; 
		}
		return false;
	}
	
	public void draw(Graphics g) {						
		g.setColor(getOutline());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height); 
		if (selected) {										
			g.setColor(Color.RED);
			g.drawRect(getUpperLeft().getX() - 3, getUpperLeft().getY() - 3, 6, 6);		 
			g.drawRect(getUpperLeft().getX() + width - 3, getUpperLeft().getY() - 3, 6, 6);	
			g.drawRect(getUpperLeft().getX() - 3, getUpperLeft().getY() + height -3, 6, 6);	
			g.drawRect(getUpperLeft().getX() + width -3, getUpperLeft().getY() + height - 3, 6, 6); 
		}
	}
	
	public boolean contains (int x, int y) {				
		return(upperLeft.getX() < x && x < upperLeft.getX() + width && upperLeft.getY() < y && y < upperLeft.getY() + height);
	}
	
	public boolean contains (Point p) {
		return this.contains(p.getX(),p.getY());
	}
	
	
	
	
	public int compareTo (Object o) {
		if(o instanceof Rectangle) {
			return (int)(this.area() - ((Rectangle)o).area());
		}
		return 0;
		
	}
	
	public void DialogEdit() {
		DlgRectangle dlgRectangle = new DlgRectangle();
		for(Shape shape : DrawingPanel.shapes) {
			if(shape.isSelected()) {
				String[] string = shape.toString().split(" ");
				
				Rectangle rectangle =(Rectangle) shape;
				dlgRectangle.getTxtXCoordinate().setText(String.valueOf(rectangle.upperLeft.getX()));
				dlgRectangle.getTxtYCoordinate().setText(String.valueOf(rectangle.upperLeft.getY()));
				dlgRectangle.getTxtWidth().setText(String.valueOf(rectangle.getWidth()));
				dlgRectangle.getTxtHeight().setText(String.valueOf(rectangle.getHeight()));
			}
		}
		dlgRectangle.setVisible(true);
	}
	
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.getWidth(), this.getHeight());
	}

	public void move(int nX, int nY) {
		upperLeft.move(nX, nY);
		
	}
	
}