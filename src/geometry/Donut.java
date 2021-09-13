package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {		
	private int innerRadius;
	

	private int getInnerRadius() {
		return innerRadius;
	}

	protected void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public Donut() {
		
	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);									
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		super(center, radius);
		this.innerRadius = innerRadius;
		this.selected = selected;
		
	}
	public double area() {
		return super.area() - Math.PI * innerRadius * innerRadius;  
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		super.draw(g);
		g.drawOval(center.getX() - innerRadius, center.getY() - innerRadius, innerRadius * 2 , innerRadius * 2);
		if (selected) {
			g.setColor(Color.RED);
			g.drawRect(this.getCenter().getX() - innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + innerRadius -3, this.getCenter().getY() -3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3,  this.getCenter().getY() - innerRadius -3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + innerRadius - 3, 6, 6);
		
		}
	}																			
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(x, y) >= innerRadius;
	}
	
	public boolean contains (Point p) {
		return this.contains(p.getX(), p.getY());
		
	}
	
	public String toString() {
		return super.toString() + ", inner radius is:" + innerRadius;
	}
	
	public void DialogEdit() {
		DlgDonut dialog = new DlgDonut();
		for(Shape shape : DrawingPanel.shapes) {
			if(shape.isSelected()) {
				String[] string = shape.toString().split(" ");
				
				Donut donut = (Donut) shape;
				
				dialog.getTxtXCoordinate().setText(String.valueOf(donut.center.getX()));
				dialog.getTxtYCoordinate().setText( String.valueOf(donut.center.getY()));
				dialog.getTxtRadius().setText(String.valueOf(donut.radius));
				dialog.getTxtInnerRadius().setText(String.valueOf(donut.innerRadius));
			}
		}
		dialog.setVisible(true);
	}
	
	public void AreaPainter(Graphics g) {
		super.AreaPainter(g);
		g.setColor(getFill());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2, this.getInnerRadius() * 2);
	}
}
