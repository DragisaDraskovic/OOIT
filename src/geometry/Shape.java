package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable, Movable{		

	   protected boolean selected;
	   protected Color outline = Color.black;
	   protected Color fill = Color.white;
	   
	   
		public Shape() {
			
		}
		
		public Shape(boolean selected) {
			super();
			this.selected = selected;
		}
		
		public boolean isSelected() {
			return selected;
		}
		
		public Color getOutline() {
			return outline;
		}

		public void setOutline(Color outline) {
			this.outline = outline;
		}

		public Color getFill() {
			return fill;
		}

		public void setFill(Color fill) {
			this.fill = fill;
		}

		public void setSelected(boolean selected) {
			this.selected = selected;
		}
			
		public abstract boolean contains (int x, int y);
		
		public abstract void draw(Graphics g); 
		
		public abstract void DialogEdit();

		public abstract void AreaPainter(Graphics g);
	

		
}
