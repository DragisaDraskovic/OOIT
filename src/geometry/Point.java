package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	protected int x;						
	protected int y;					
	
	
	public void setX(int x) {    
		this.x = x;
	}
	
	public int getX() {			
		return this.x;		
	}
	
	public void setY(int y) {	
		this.y = y;				
	}
	
	public int getY() {			
		return this.y;
	}
	
	public Point() {					
		
	}
	
	
	
	public Point (int x, int y) {		
		this.x = x;							
		this.y = y;
	}
	
  public Point(int x, int y, boolean selected) {  
	  this.x = x;
	  this.y = y;								
	  this.selected = selected;
  }
	

	
	public double distance(int x, int y) {
		int dx = this.x - x; 						
		int dy = this.y - y;						
		double d = Math.sqrt(dx * dx + dy * dy );	
		return d;									
	}
	
	public boolean equals(Object obj) {		
		if(obj instanceof Point) {					
			Point p = (Point) obj;					
			if (p.x == x && p.y == y)		
				return true;						
			else
				return false;					
		} else
			return false;							
	}
	
	public String toString() {							
		return "(" + this.x + "," + this.y + super.isSelected() + ")";		
	}
	
	public void draw (Graphics g) {				
		g.setColor(getOutline());
		g.drawLine(this.getX() - 3, this.getY(), this.getX() +	3, this.getY());
		g.drawLine(this.getX(), this.getY() - 3, this.getX(), this.getY() + 3);
		if(isSelected() == true) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getX() - 3, this.getY() - 3, 6, 6);
		}	
		
	}														
	
	public boolean contains(int x, int y) {									
		return this.distance(x,y) <= 5; 					
	}														
	
	public void move(int nX, int nY) {
		this.x = nX;
		this.y = nY;
	}
	
	
	public int compareTo(Object arg0) {
		return 0;
	}

	public void DialogEdit() {
		DlgPoint dialog	= new DlgPoint();
		for (Shape shape : DrawingPanel.shapes) {
			if(shape.isSelected()) {
		
				
				String [] string = shape.toString().split(" ");	
				
				Point point = (Point) shape;
				dialog.getTxtXCoordinate().setText(String.valueOf(point.getX()));
				dialog.getTxtYCoordinate().setText(String.valueOf(point.getY()));
			}
		
		}
		dialog.setVisible(true);
	}
	
	public void AreaPainter(Graphics g) {
		
	}




	
}


