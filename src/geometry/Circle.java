package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	protected Point center;
	protected int radius;

	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
		
	}
	
  public Circle(Point center, int radius, boolean selected) {		
		this(center,radius);
		this.selected = selected;
	} 

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius)	{												
			this.radius = radius;									
}														 
		
	
	
	public String toString() {
		return "The center of the circle is at coordinates" + center + ", the radius of the circle is at" + radius + "selection is" + super.isSelected();
	}
		
	public double area() {							
		return radius * radius * Math.PI;			
	}
	
	public double volume() {						
		return 2  *radius * Math.PI;
	}
	
	public boolean equals (Object obj) {
		if(obj instanceof Circle) {
			Circle O =(Circle) obj;
			return center.equals(O.center) && radius == O.radius;
			
		}
		return false;
	}
	
	
	public void draw(Graphics g) {	
		g.setColor(getOutline());
		g.drawOval(center.getX() - radius, center.getY() - radius, radius*2, radius*2);
					
		
		if(selected) {							
			g.setColor(Color.RED);				
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - this.getRadius() -3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.getRadius() -3 , this.getCenter().getY() - 3, 6, 6);
			
		}
	}
	
	public boolean contains (int x, int y) {				
		return this.getCenter().distance(x, y) <= this.getRadius();
	}
		
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			return (int)(this.area() - ((Circle)o).area());
		} 
		return 0;
	}

	public void DialogEdit() {
		DlgCircle dialog = new DlgCircle();
		for(Shape shape : DrawingPanel.shapes) {
			if(shape.isSelected()) {
				String[] string = shape.toString().split(" ");
				
				Circle circle = (Circle) shape;
				
				
				dialog.getTxtXCoordinate().setText(String.valueOf(circle.getCenter().getX()));
				dialog.getTxtYCoordinate().setText(String.valueOf(circle.getCenter().getY()));
				dialog.getTxtRadius().setText(String.valueOf(circle.getRadius()));
				
			}
			dialog.setVisible(true);
		}
		
	}
	
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillOval(this.getCenter().getX() - this.getRadius(), 
				this.getCenter().getY() - this.getRadius(),
				this.getRadius() * 2, this.getRadius() * 2);
	}

	public void move(int nX,int nY) {
		center.move(nX, nY);
	}


	



		
}
