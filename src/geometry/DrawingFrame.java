package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class DrawingFrame extends JFrame {

	protected JPanel contentPane;
	protected DrawingPanel panel = new DrawingPanel();
	protected JPanel panelNorth = new JPanel();
	static Color outline = Color.black;
	static Color fill = Color.white;
	
;
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run(){
		try {
			DrawingFrame frame = new DrawingFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   });		
}
	
	/**
	 
	 * Create the frame.
	 */
	
	public DrawingFrame() {
		initialize();
	}
	
	/**
	 * Initialize of frame.
	 */
	
	public void initialize() {
	setTitle("IM 122-2015 Draskovic Dragisa");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(800, 600); 
	setResizable(false);
	contentPane = new JPanel();					
	contentPane.setBorder(new EmptyBorder(8, 3, 8, 3));
	contentPane.setLayout(new BorderLayout(5, 5));
	setContentPane(contentPane);
	panel.setBackground(Color.white);
	panel.setBorder(null);
	contentPane.add(this.panel, BorderLayout.CENTER);
	panelNorth.setBackground(SystemColor.menu);
	contentPane.add(panelNorth, BorderLayout.NORTH);
	
	
	//Button
	JButton btnPoint = new JButton("Point");   			
	btnPoint.setForeground(new Color(0, 0, 0)); 					 
	btnPoint.setBackground(new Color(51, 204, 255)); 				
	btnPoint.addActionListener(new ActionListener() { 				
		public void actionPerformed(ActionEvent e) { 				
			DrawingPanel.o = 1;
			for (Shape shape : DrawingPanel.shapes) {						
				shape.setSelected(false);
			}
		}
	});
	
	JButton btnLine = new JButton("Line");			
	btnLine.setForeground(new Color(0,0,0));
	btnLine.setBackground(new Color(51,204,255));
	btnLine.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DrawingPanel.o = 2;
			for(Shape shape : DrawingPanel.shapes) {
				shape.setSelected(false);
			}
		}
		
	} );
	
	JButton btnRectangle = new JButton("Rectangle");
	btnRectangle.setForeground(new Color(0, 0, 0));
	btnRectangle.setBackground(new Color(51, 204, 255));
	btnRectangle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DrawingPanel.o = 3;
			for (Shape shape : DrawingPanel.shapes) {
				shape.setSelected(false);
			}
		}
	});
	
	JButton btnCircle = new JButton("Circle");
	btnCircle.setForeground(new Color(0, 0, 0));
	btnCircle.setBackground(new Color(51, 204, 255));
	btnCircle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DrawingPanel.o = 4;
			for (Shape shape : DrawingPanel.shapes) {
				shape.setSelected(false);
			}
		}
	});
	
	
	JButton btnDonut = new JButton("Donut");
	btnDonut.setForeground(new Color(0, 0, 0));
	btnDonut.setBackground(new Color(51, 204, 255));
	btnDonut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DrawingPanel.o = 5;
			for(Shape shape : DrawingPanel.shapes) {
				shape.setSelected(false);
			}
		}
	});
	
	JButton btnSelect = new JButton("Select");
	btnSelect.setForeground(new Color(0, 0, 0));
	btnSelect.setBackground(new Color(0, 204, 0));
	btnSelect.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DrawingPanel.o = 6;
			for(Shape shape : DrawingPanel.shapes) {
				shape.setSelected(false);
			}
		}
	});	
	
	
	JButton btnModify = new JButton("Modify");					
	btnModify.setForeground(new Color(0, 0, 0));
	btnModify.setBackground(new Color(0, 204, 0));
	btnModify.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			if(DrawingPanel.shapes.isEmpty()) {					
				JOptionPane.showMessageDialog(null, "No modify!","Error", JOptionPane.ERROR_MESSAGE); 			
			return;
			}
			for (Shape shape : DrawingPanel.shapes) {	
				if (shape.isSelected()) {						
					shape.DialogEdit();								
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Please select an object!","Error", JOptionPane.INFORMATION_MESSAGE);		
		}
	});
	
	
	 JButton btnColor = new JButton("Color");					
	btnColor.setForeground(new Color(0, 0, 0));
	btnColor.setBackground(new Color (255, 255, 0));
	btnColor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {				
			outline = JColorChooser.showDialog(null, "Please chose a color", Color.BLACK); 
			
		}
	} ); 
	
	JButton btnArea = new JButton("Area Color");		
	btnArea.setForeground(new Color(0, 0, 0));
	btnArea.setBackground(new Color(255, 255, 0));
	btnArea.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {		
			fill = JColorChooser.showDialog(null, "Please choose a color", Color.BLACK); 	
		}
	});
	
	JButton btnDelete = new JButton("Delete");							
	btnDelete.setForeground(new Color(0, 0, 0));
	btnDelete.setBackground(new Color(255, 0, 0));
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(DrawingPanel.shapes.isEmpty()) {						
				JOptionPane.showMessageDialog(null, "Nothing to delete!","Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (Shape shape : DrawingPanel.shapes) {		
				if (shape.isSelected()) {		
					int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the object?", "Waring", JOptionPane.YES_NO_OPTION); 
					if(answer==0) {					
						DrawingPanel.shapes.remove(shape); 		
					}
					return;
				}
				
			}
			
			JOptionPane.showMessageDialog(null, "Please select an object!"); 		
		}																			
	});
	

	
	
	//set Button
	btnPoint.setBounds(150, 60, 200, 30);
	btnLine.setBounds(150, 60, 200, 30);
	btnCircle.setBounds(150,  60, 200,  30);
	btnDonut.setBounds(150, 60, 200, 30);
	btnRectangle.setBounds(150, 60, 200, 30);
	btnColor.setBounds(150, 60, 200, 30);
	btnSelect.setBounds(150, 60, 200, 30);
	btnModify.setBounds(150, 60, 200, 30);
	btnArea.setBounds(150, 60, 200, 30);
	btnDelete.setBounds(150, 60, 200, 30);
	
	//Add components in panels
	//add in north panel
	
	panelNorth.add(btnPoint);
	panelNorth.add(btnLine);
	panelNorth.add(btnCircle);
	panelNorth.add(btnDonut);
	panelNorth.add(btnRectangle);
	panelNorth.add(btnColor);
	panelNorth.add(btnArea);
	panelNorth.add(btnSelect);
	panelNorth.add(btnModify);
	panelNorth.add(btnDelete);
	
	}
	
}




