package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgLine extends JDialog{
	
	protected final JPanel panelCentar = new JPanel();
	protected final JPanel panelSouth = new JPanel();
	protected JTextField txtStartXCoordinate;
	protected JTextField txtStartYCoordinate;
	protected JTextField txtEndXCoordinate;
	protected JTextField txtEndYCoordinate;
	protected Color outline =  Color.BLACK;
	protected boolean outlineColorB;
	protected boolean ok;
	
	
	
public JTextField getTxtStartXCoordinate() {
		return txtStartXCoordinate;
	}


	public void setTxtStartXCoordinate(JTextField txtStartXCoordinate) {
		this.txtStartXCoordinate = txtStartXCoordinate;
	}


	public JTextField getTxtStartYCoordinate() {
		return txtStartYCoordinate;
	}


	public void setTxtStartYCoordinate(JTextField txtStartYCoordinate) {
		this.txtStartYCoordinate = txtStartYCoordinate;
	}


	public JTextField getTxtEndXCoordinate() {
		return txtEndXCoordinate;
	}


	public void setTxtEndXCoordinate(JTextField txtEndXCoordinate) {
		this.txtEndXCoordinate = txtEndXCoordinate;
	}


	public JTextField getTxtEndYCoordinate() {
		return txtEndYCoordinate;
	}


	public void setTxtEndYCoordinate(JTextField txtEndYCoordinate) {
		this.txtEndYCoordinate = txtEndYCoordinate;
	}


	public Color getOutline() {
		return outline;
	}


	public void setOutline(Color outline) {
		this.outline = outline;
	}


	public boolean isOutlineColorB() {
		return outlineColorB;
	}


	public void setOutlineColorB(boolean outlineColorB) {
		this.outlineColorB = outlineColorB;
	}


	public boolean isOk() {
		return ok;
	}


	public void setOk(boolean ok) {
		this.ok = ok;
	}


	public JPanel getPanelCentar() {
		return panelCentar;
	}


	public JPanel getPanelSouth() {
		return panelSouth;
	}


/**
 *  Launch the application.
 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Create the dialog.
	 */
	
	public DlgLine() {
		initialize();
	}
	
	
	/**
	 *	 Initialize of dialog.
	 */
	
	public void initialize() {
		//dialog
		setTitle("Dialog Line");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 320, 380);
		getContentPane().setLayout(new BorderLayout());
		panelCentar.setBorder(new EmptyBorder(3, 3, 3, 3));
		panelCentar.setBorder(new EmptyBorder(3, 3, 3, 3));
		getContentPane().add(panelCentar, BorderLayout.CENTER);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);	
		
		
		//JTextField
		txtStartXCoordinate = new JTextField();
		txtStartXCoordinate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		});
		
		txtStartYCoordinate = new JTextField();
		txtStartYCoordinate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		});
		
		txtEndXCoordinate = new JTextField();
		txtEndXCoordinate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		});
		
		txtEndYCoordinate = new JTextField();
		txtEndYCoordinate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		});
		
		//JButton 
		JButton btnColor = new JButton("Color");
		btnColor.setForeground(new Color(0, 0, 0));
		btnColor.setBackground(new Color(51, 204, 255));
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Please choose a color", Color.BLACK);
				outlineColorB = true;
			}
		});
			
		JButton okButton = new JButton("OK");
		okButton.setForeground(new Color(0, 0, 0));
		okButton.setBackground(new Color(0, 204, 0));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtStartXCoordinate.getText().trim().isEmpty() 
						|| txtStartYCoordinate.getText().trim().isEmpty() 
						|| txtEndXCoordinate.getText().trim().isEmpty() 
						|| txtEndYCoordinate.getText().trim().isEmpty()) {
					ok = false;
					JOptionPane.showMessageDialog(null, "Please enter values in the field", "Error", JOptionPane.ERROR_MESSAGE);
					return;
			
			} else {
					for(Shape shape : DrawingPanel.shapes) {
						if(shape.isSelected()) {
							((Line)shape).setStartPoint(new Point (Integer.parseInt(txtStartXCoordinate.getText()), Integer.parseInt(txtStartYCoordinate.getText())));
							((Line)shape).setEndPoint(new Point (Integer.parseInt(txtEndXCoordinate.getText()), Integer.parseInt(txtEndYCoordinate.getText())));
							if(outlineColorB == true) {
								shape.setOutline(outline);
								outlineColorB = false;
							}
						}
					}
				}
				ok = true;
				dispose();
				
			}
		});
		
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
					
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(new Color(0, 0, 0));
		cancelButton.setBackground(new Color(255, 0, 0));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		
		//JLabel
		JLabel labelStartXCoordinate = new JLabel("StartX:");
		labelStartXCoordinate.setPreferredSize(new Dimension(100, 40));
		
		JLabel labelStartYCoordinate = new JLabel("StartY:");
		labelStartYCoordinate.setPreferredSize(new Dimension(100, 40));
		
		JLabel labelEndXCoordinate = new JLabel("EndX:");
		labelEndXCoordinate.setPreferredSize(new Dimension(100, 40));
		
		JLabel labelEndYCoordinate = new JLabel("EndY:");
		labelEndYCoordinate.setPreferredSize(new Dimension(100, 40));
		
		
		//set JTextField
		txtStartXCoordinate.setBounds(150, 60, 75, 30);
		txtStartXCoordinate.setColumns(15);
		
		txtStartYCoordinate.setBounds(150, 60, 75, 30);
		txtStartYCoordinate.setColumns(15);
		
		txtEndXCoordinate.setBounds(150, 60, 75, 30);
		txtEndXCoordinate.setColumns(15);
		
		txtEndYCoordinate.setBounds(150, 60, 75, 30);
		txtEndYCoordinate.setColumns(15);
		
		//Add components in panels
		//panel centar
		panelCentar.add(labelStartXCoordinate);
		panelCentar.add(txtStartXCoordinate);
		panelCentar.add(labelStartYCoordinate);
		panelCentar.add(txtStartYCoordinate);
		panelCentar.add(labelEndXCoordinate);
		panelCentar.add(txtEndXCoordinate);
		panelCentar.add(labelEndYCoordinate);
		panelCentar.add(txtEndYCoordinate);
		panelCentar.add(btnColor);
		//panel south
		panelSouth.add(okButton);
		panelSouth.add(cancelButton);
		
	}
	

	
	

}
