package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgCircle extends JDialog {

	protected final JPanel panelCentar = new JPanel();
	protected final JPanel panelSouth = new JPanel();
	protected JTextField txtXCoordinate;
	protected JTextField txtYCoordinate;
	protected JTextField txtRadius;
	protected Color outline = Color.BLUE;
	protected Color fill = Color.white;
	protected boolean outlineColorB;
	protected boolean fillColorB;
	protected boolean ok;
	
	
	public JTextField getTxtXCoordinate() {
		return txtXCoordinate;
	}

	public void setTxtXCoordinate(JTextField txtXCoordinate) {
		this.txtXCoordinate = txtXCoordinate;
	}

	public JTextField getTxtYCoordinate() {
		return txtYCoordinate;
	}

	public void setTxtYCoordinate(JTextField txtYCoordinate) {
		this.txtYCoordinate = txtYCoordinate;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
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

	public JPanel getPanelCentar() {
		return panelCentar;
	}

	
	public boolean isOutlineColorB() {
		return outlineColorB;
	}

	public void setOutlineColorB(boolean outlineColorB) {
		this.outlineColorB = outlineColorB;
	}

	public boolean isFillColorB() {
		return fillColorB;
	}

	public void setFillColorB(boolean fillColorB) {
		this.fillColorB = fillColorB;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	/**
	*	Launch the application.
	*/
	
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	
	public DlgCircle() {
		initialize();
	}
	
	/**
	 * 
	 * Initialize of dialog.
	 */
	
	public void initialize() {
		
		//dialog
		setTitle("Dialog Circle");
		setModal(true);
		setBounds(100, 100, 320, 360);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		panelCentar.setBorder(new EmptyBorder(3, 3, 3, 3));
		panelSouth.setBorder(new EmptyBorder(3, 3, 3, 3));
		getContentPane().add(panelCentar, BorderLayout.CENTER);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		//JTextField
		txtXCoordinate = new JTextField();
		txtXCoordinate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		});
		
		txtYCoordinate = new JTextField();
		txtYCoordinate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		});
		
		txtRadius = new JTextField();
		txtRadius.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		});
		
		
		//Button
		JButton btnColor = new JButton("Color");
		btnColor.setForeground(new Color(0, 0, 0));
		btnColor.setBackground(new Color(51, 204, 255));
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Please choose a color", Color.BLACK);
				outlineColorB = true;
			}
		
		});
		
		JButton btnArea = new JButton("Area color");
		btnArea.setForeground(new Color(0, 0, 0));
		btnArea.setBackground(new Color(51, 204, 255));
		btnArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Please choose a color", Color.WHITE);
				fillColorB = true;
				
			}
		});
		
	
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setBackground(new Color(0, 204, 0));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCoordinate.getText().trim().isEmpty() 
								|| txtYCoordinate.getText().trim().isEmpty()
								|| txtRadius.getText().trim().isEmpty()) {
							ok = false;
							JOptionPane.showMessageDialog(null, "Please enter values in the field", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
						
						else {
							for(Shape shape : DrawingPanel.shapes) {
								if(shape.isSelected()) {

								shape.move(Integer.parseInt(txtXCoordinate.getText()), Integer.parseInt(txtYCoordinate.getText()));
								((Circle)shape).setRadius(Integer.parseInt(txtRadius.getText()));
						
														
								
								
								if(outlineColorB == true) {
									shape.setOutline(outline);
									outlineColorB = false;
								}
								
								if(fillColorB == true) {
									shape.setFill(fill);
									fillColorB = false;
								}
								
 							}
						}
						ok = true;
						dispose();
					}
				}
			});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			
				JButton cancleButton = new JButton("Cancle");
				cancleButton.setForeground(new Color(0, 0, 0));
				cancleButton.setBackground(new Color(255, 0, 0));
				cancleButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancleButton.setActionCommand("Cancle");
			
				
				//JLabel
				JLabel labelXCoordinate = new JLabel("Coordinate X:");
				labelXCoordinate.setPreferredSize(new Dimension(100, 40));
				
				JLabel labelYCoordinate = new JLabel("Coordinate Y:");
				labelYCoordinate.setPreferredSize(new Dimension(100, 40));
				
				JLabel labelRadius = new JLabel("Radius:");
				labelRadius.setPreferredSize(new Dimension(100,40));
				
				
				//set JTextFIeld
				txtXCoordinate.setBounds(150, 60, 75, 30);
				txtXCoordinate.setColumns(15);
				
				txtYCoordinate.setBounds(150, 60, 75, 30);
				txtYCoordinate.setColumns(15);
				
				txtRadius.setBounds(150, 60, 75, 30);
				txtRadius.setColumns(15);
				
				
				//add components in panels
				//panel center
				panelCentar.add(labelXCoordinate);
				panelCentar.add(txtXCoordinate);
				panelCentar.add(labelYCoordinate);
				panelCentar.add(txtYCoordinate);
				panelCentar.add(labelRadius);
				panelCentar.add(txtRadius);
				panelCentar.add(btnArea);
				panelCentar.add(btnColor);
				
				//panel south
				panelSouth.add(okButton);
				panelSouth.add(cancleButton);
		}

	
		


	

}
