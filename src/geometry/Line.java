package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;		
	private Point endPoint;		
	
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {  					
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {			
		this(startPoint, endPoint);												
		this.selected = selected;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	
	public double length() { 								
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public boolean equals(Object obj) {						
		if(obj instanceof Line) {							
			Line l = (Line) obj;							
			return startPoint.equals(l.startPoint) && endPoint.equals(l.endPoint);		
		} 
			return false;				
	}
	
	public String toString() {
		return this.getStartPoint() + "->" + this.getEndPoint()  +" is selected =" + super.isSelected();
	}
	
	public void draw (Graphics g) {	
		g.setColor(getOutline());
		g.drawLine(this.getStartPoint().getX(), 	
				   this.getStartPoint().getY(), 
				   this.getEndPoint().getX(), 
				   this.getEndPoint().getY());
		if(isSelected() == true) {								
			g.setColor(Color.RED);
			g.drawRect(this.getStartPoint().getX() - 3, this.getStartPoint().getY() -3, 6, 6); 		
			g.drawRect(this.getEndPoint().getX() - 3, this.getEndPoint().getY() -3, 6, 6);
		}		
	}
	
	public Point middle() {
		int middleX = (this.getStartPoint().getX() + this.getEndPoint().getX()) / 2;
		int middleY = (this.getEndPoint().getX() + this.getEndPoint().getY()) / 2;
		Point middle = new Point(middleX, middleY);
		return middle;
	}
	
	public boolean contains(int x, int y) {			
		return (startPoint.distance(x, y) + endPoint.distance(x, y) - length()) <=5; 
	}
	
	public void move(int nX, int nY) {
		
	}
	
	public int compareTo(Object o) {				 
		return 0;
	}

	public void DialogEdit() {
		DlgLine dialog = new DlgLine();
		for(Shape shape : DrawingPanel.shapes) {
			if(shape.isSelected()) {
				String[]string = shape.toString().split(" ");
				
				Line line = (Line) shape;
				dialog.getTxtStartXCoordinate().setText(String.valueOf(line.getStartPoint().getX()));
				dialog.getTxtStartYCoordinate().setText(String.valueOf(line.getStartPoint().getY()));
				dialog.getTxtEndXCoordinate().setText(String.valueOf(line.getEndPoint().getX()));
				dialog.getTxtEndYCoordinate().setText(String.valueOf(line.getEndPoint().getX()));
			}
		}
		dialog.setVisible(true);
	}
	
	public void AreaPainter(Graphics g) {
	}




}
