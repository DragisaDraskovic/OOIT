package geometry;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;



public class DlgRectangle extends JDialog {

	protected Color outline = Color.BLACK;
	protected Color fill = Color.white;
	protected boolean ok;
	protected JTextField txtXCoordinate;
	protected JTextField txtYCoordinate;
	protected JTextField txtWidth;
	protected JTextField txtHeight;
	protected final JPanel panelCentar = new JPanel();
	protected final JPanel panelSouth = new JPanel();
	protected boolean outlineColorB;
	protected boolean fillColorB;
	
	/**
	* Launch the application.
	*/

	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
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

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		ok = ok;
	}

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

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public boolean isOutlineColorB() {
		return outlineColorB;
	}

	public void setOutlineCoolrB(boolean outlineCol0rB) {
		this.outlineColorB = outlineColorB;
	}

	public boolean isFillColorB() {
		return fillColorB;
	}

	public void setFillColorB(boolean fillColorB) {
		this.fillColorB = fillColorB;
	}
	
	public JPanel getPanelCentar() {
		return panelCentar;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	/**
	 * Create the dialog.
	 */
	
	public DlgRectangle() {
		initialize();
	}
	
	/**
	 *  Initialize of dialog.
	 */
	
	public void initialize() {	
		//dialog
		setTitle("Dialog Rectangle");
		setModal(true);									
		setResizable(false);
		setBounds(100, 100, 306, 355);				
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
		txtYCoordinate.addKeyListener(new KeyAdapter( ) {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		});
		
		txtWidth = new JTextField();
		txtWidth.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
					e.consume();
				}
			}
		}); 
		
		txtHeight = new JTextField();
		txtHeight.addKeyListener(new KeyAdapter() {
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
				outline = JColorChooser.showDialog(null, "Please Choose a color",Color.BLACK);
				outlineColorB = true;
			}
		});
		
		JButton btnArea = new JButton ("Area Color");
		btnArea.setForeground(new Color(0, 0, 0));
		btnArea.setBackground(new Color(51, 204, 255));
		btnArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Please choose a color", Color.WHITE);
				fillColorB = true;
			}
		});
		
		
		JButton buttonOK = new JButton("OK");
		buttonOK.setForeground(new Color(0, 0, 0));
		buttonOK.setBackground(new Color(51, 204, 255));
		buttonOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtXCoordinate.getText().trim().isEmpty() 
							|| txtYCoordinate.getText().trim().isEmpty() 
							|| txtHeight.getText().trim().isEmpty() 
							|| txtWidth.getText().trim().isEmpty()) {
						ok = false;
						JOptionPane.showMessageDialog(null, "Please enter values in the field","Error", JOptionPane.ERROR_MESSAGE);
						return;
						}
							
						else {
								
							for(Shape shape : DrawingPanel.shapes) {
								if(shape.isSelected()) {
									shape.move(Integer.parseInt(txtXCoordinate.getText()), Integer.parseInt(txtYCoordinate.getText()));
									((Rectangle)shape).setHeight(Integer.parseInt(txtHeight.getText()));
									((Rectangle)shape).setWidth(Integer.parseInt(txtWidth.getText()));
									
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
								
				}
					ok = true;
					dispose();
				}
			});
					
			buttonOK.setActionCommand("OK");	
			getRootPane().setDefaultButton(buttonOK);
			
			
			JButton buttonCancle = new JButton("Cancle");
			buttonCancle.setForeground(new Color(0, 0, 0));
			buttonCancle.setBackground(new Color(255, 0, 0));
			buttonCancle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}				
			});
			buttonCancle.setActionCommand("Cancle");
			
			
			//JLabel
			JLabel labelXCoordinate = new JLabel("X Coordinate:");
			labelXCoordinate.setPreferredSize(new Dimension(100, 40));
			
			JLabel labelYCoordinate = new JLabel("Y Coordinate:");
			labelYCoordinate.setPreferredSize(new Dimension(100, 40));
			
			JLabel labelHeight = new JLabel("Height:");
			labelHeight.setPreferredSize(new Dimension(100, 40));
			
			JLabel labelWidth = new JLabel("Width:");
			labelWidth.setPreferredSize(new Dimension(100, 40));
			
			
			//set JTextField
			txtXCoordinate.setBounds(150, 60, 75, 30);
			txtXCoordinate.setColumns(10);
			
			txtYCoordinate.setBounds(150, 60, 75, 30);
			txtYCoordinate.setColumns(10);
			
			txtHeight.setBounds(150, 60, 75, 30);
			txtHeight.setColumns(10);
			
			txtWidth.setBounds(150, 60, 75, 30);
			txtWidth.setColumns(10);
			
			//Add components in panels
			//centar panel
			panelCentar.add(labelXCoordinate);
			panelCentar.add(txtXCoordinate);
			panelCentar.add(labelYCoordinate);
			panelCentar.add(txtYCoordinate);
			panelCentar.add(labelHeight);
			panelCentar.add(txtHeight);
			panelCentar.add(labelWidth);
			panelCentar.add(txtWidth);
			panelCentar.add(btnArea);
			panelCentar.add(btnColor);
			//south panel
			panelSouth.add(buttonOK);
			panelSouth.add(buttonCancle);
			
			
			}



	
}




	




