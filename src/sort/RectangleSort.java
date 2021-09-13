package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import geometry.Point;
import geometry.Rectangle;
import stack.DialogStack;

public class RectangleSort extends JFrame {
	
	protected JFrame frame;
	protected JPanel panelCentar = new JPanel();
	protected JPanel panelSouth = new JPanel();
	protected JScrollPane scroll = new JScrollPane();
	protected JList jList = new JList();
	protected DefaultListModel<Rectangle> defaultList = new DefaultListModel<>();

	
	
	
	
	public JScrollPane getScroll() {
		return scroll;
	}


	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}


	public JPanel getPanelCentar() {
		return panelCentar;
	}


	public void setPanelCentar(JPanel panelCentar) {
		this.panelCentar = panelCentar;
	}


	public JPanel getPanelSouth() {
		return panelSouth;
	}


	public void setPanelSouth(JPanel panelSouth) {
		this.panelSouth = panelSouth;
	}

	
	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JList getjList() {
		return jList;
	}


	public void setjList(JList jList) {
		this.jList = jList;
	}


	public DefaultListModel<Rectangle> getDefaultList() {
		return defaultList;
	}


	public void setDefaultList(DefaultListModel<Rectangle> defaultList) {
		this.defaultList = defaultList;
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable () {
			public void run() {
				try {
					RectangleSort frameM = new RectangleSort();
					frameM.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application. 
	 */

	public RectangleSort() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	
	public void initialize() {
		
		//Frame
		frame = new JFrame();	
		frame.setTitle("IM122/2015 Dragisa Draskovic");
		frame.setVisible(true);
		frame.setBounds(150, 150, 600, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panelCentar, BorderLayout.CENTER);
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		//Scrollpane
		scroll.setViewportView(jList);
		scroll.setPreferredSize(new Dimension(550, 350));
		
		//list
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setModel(defaultList);
		
		//Button
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setBackground(new Color(0, 204, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort dialog = new DlgSort();
				dialog.setVisible(true);
				
				if(dialog.ok) {				
					
										
					int UpperLeftPointX = Integer.parseInt(dialog.getTxtXCoordinate().getText());
					int UpperLeftPointY = Integer.parseInt(dialog.getTxtYCoordinate().getText());
					int width = Integer.parseInt(dialog.getTxtWidth().getText());
					int height = Integer.parseInt(dialog.getTxtHeight().getText());
					
					Point point = new Point(UpperLeftPointX, UpperLeftPointY);
					Rectangle rectangleSort = new Rectangle(point, width, height);
					
								
					defaultList.insertElementAt(rectangleSort, 0);						
				}									
			}
			
		});
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBackground(new Color(0, 0, 0));
		btnSort.setBackground(new Color(51, 204, 255));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Rectangle> list = new ArrayList<Rectangle>();
				
				for (int i = 0; i < defaultList.size(); i++) {
					list.add((Rectangle)defaultList.get(i));
				}
				Collections.sort(list, new Comparator<Rectangle>() {
					public int compare (Rectangle sort1, Rectangle sort2) {
						return Integer.compare(sort1.area(), sort2.area());
					}
				});
				
				defaultList.removeAllElements();
				
				for(int i = 0; i <list.size(); i++) {
					defaultList.addElement(list.get(i));
				}
			}
			
		});
		
		
		
			
		//Add components in panels
		
		//Centar panel
		panelCentar.add(scroll);
		
		//South panel
		panelSouth.add(btnAdd);
		panelSouth.add(btnSort);
		}
		
		
		
	
	}


