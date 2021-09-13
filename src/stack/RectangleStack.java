package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import geometry.Point;
import geometry.Rectangle;

public class RectangleStack extends JFrame{

	
	protected JFrame frame; 
	protected JPanel centarPanel = new JPanel();
	protected JPanel southPanel = new JPanel();
	protected JScrollPane scroll = new JScrollPane();
	protected DefaultListModel<Rectangle> defaultList = new DefaultListModel<Rectangle>();
	protected JList list = new JList();
	protected boolean ok;
	
	
	
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getCentarPanel() {
		return centarPanel;
	}

	public void setCentarPanel(JPanel centarPanel) {
		this.centarPanel = centarPanel;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public DefaultListModel<Rectangle> getDefaultList() {
		return defaultList;
	}

	public void setDefaultList(DefaultListModel<Rectangle> defaultList) {
		this.defaultList = defaultList;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RectangleStack frameM = new RectangleStack();
					frameM.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the dialog.
	 */
	
	public RectangleStack() {
		initialize();
	}
	
	/**
	 * Initialize of dialog.
	 */
	
	public void initialize() {
		
		//Frame
		frame = new JFrame();
		frame.setTitle("IM122/2015 Dragisa Draskovic");
		frame.setSize(600, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(centarPanel, BorderLayout.CENTER);
		frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		//ScrollPane
		scroll.setViewportView(list);
		scroll.setPreferredSize(new Dimension(550, 350));
		
		//List
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(defaultList);
		
		//Button
		JButton buttonAdd = new JButton("Add");
		buttonAdd.setForeground(new Color(0, 0, 0));
		buttonAdd.setBackground(new Color(0, 204, 0));
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogStack dialog = new DialogStack();
				dialog.setVisible(true);
				
				if(dialog.ok) {
					
					int x = Integer.parseInt(dialog.getTxtXCoordinate().getText());
					int y = Integer.parseInt(dialog.getTxtYCoordinate().getText());
					int width = Integer.parseInt(dialog.getTxtWidth().getText());
					int height = Integer.parseInt(dialog.getTxtHeight().getText());
					
					Point point = new Point(x, y);
					
					Rectangle rectangle = new Rectangle(point, width, height);
					
					defaultList.insertElementAt(rectangle, 0);
				}
			}
		});
		
		JButton buttonDelete = new JButton("Delete");
		buttonDelete.setForeground(new Color(0, 0, 0));
		buttonDelete.setBackground(new Color(255, 0, 0));
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DialogStack dialog = new DialogStack();
				Rectangle delete = defaultList.elementAt(0);
				
				dialog.getTxtXCoordinate().setText(Integer.toString(delete.getUpperLeft().getX()));
				dialog.getTxtYCoordinate().setText(Integer.toString(delete.getUpperLeft().getY()));
				dialog.getTxtWidth().setText(Integer.toString(delete.getWidth()));
				dialog.getTxtHeight().setText(Integer.toString(delete.getHeight()));
				
				dialog.txtXCoordinate.setEditable(false);
				dialog.txtYCoordinate.setEditable(false);
				dialog.txtWidth.setEditable(false);
				dialog.txtHeight.setEditable(false);
				
				dialog.setVisible(true);
				
				if (dialog.ok) {
					defaultList.removeElementAt(0);
				}
				
				
			}
		});
		
		//add components in panels
		
		//Centar panel
		centarPanel.add(scroll);
		
		//South panel
		southPanel.add(buttonAdd);
		southPanel.add(buttonDelete);
	}
}
