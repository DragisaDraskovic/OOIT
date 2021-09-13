package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class DlgDonut extends JDialog {

	protected final JPanel panelCentar = new JPanel();
	protected final JPanel panelSouth = new JPanel();
	protected JTextField txtXCoordinate;
	protected JTextField txtYCoordinate;
	protected JTextField txtInnerRadius;
	protected JTextField txtRadius;
	protected Color outlineColor = Color.BLUE;
	protected Color fillColor = Color.GRAY;
	protected boolean outlineColorB;
	protected boolean fillColorB;
	protected boolean ok;
	
	
	
	public JPanel getPanelSouth() {
		return panelSouth;
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
	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}
	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}
	public JTextField getTxtRadius() {
		return txtRadius;
	}
	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}
	public Color getOutlineColor() {
		return outlineColor;
	}
	public void setOutline(Color outlineColor) {
		this.outlineColor = outlineColor;
	}
	public Color getFillColor() {
		return fillColor;
	}
	public void setFill(Color fillColor) {
		this.fillColor = fillColor;
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
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public JPanel getPanelCentar() {
		return panelCentar;
	}
	
	
	/**
	 *  Launch the application/
	 */
	
	public static void main(String[] args) {
	try {
		DlgDonut dialog = new DlgDonut();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}	
	/**
	 * Create the dialog.
	 */
	
	public DlgDonut() {
		initialize();
	}
	
	/**
	 * Initialize of dialog.
	 */
	public	void initialize() {
		//Dialog
		setTitle("Dialog Donut");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 320, 362);
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
		
		txtInnerRadius = new JTextField();
		txtInnerRadius.addKeyListener(new KeyAdapter() {
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
				
		
		//JButton
		JButton btnColor = new JButton("Color");
		btnColor.setForeground(new Color(0, 0, 0));
		btnColor.setBackground(new Color(51, 204, 255));
		btnColor.setBounds(100, 40, 80, 80);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outlineColor = JColorChooser.showDialog(null, "Chooser a color", Color.BLACK);
				outlineColorB = true;
			}
		});
		
		JButton btnFill = new JButton("Area Color");
		btnFill.setForeground(new Color(0, 0, 0));
		btnFill.setBackground(new Color(51, 204, 255));
		btnFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillColor = JColorChooser.showDialog(null, "Chooser a color", Color.BLACK);
				fillColorB = true;
			}
		});
		
		JButton okButton = new JButton("OK");
		okButton.setForeground(new Color(0, 0, 0));
		okButton.setBackground(new Color (0, 204, 0));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTxtXCoordinate().getText().trim().isEmpty() 
						|| getTxtYCoordinate().getText().trim().isEmpty() 
						|| getTxtInnerRadius().getText().trim().isEmpty() 
						|| getTxtRadius().getText().trim().isEmpty()) {
					ok = false;
					JOptionPane.showMessageDialog(null,"Please enter values in the field" ,"Error", JOptionPane.ERROR_MESSAGE);					
					return;
				} else {
					if(Integer.parseInt(txtRadius.getText()) > Integer.parseInt(txtInnerRadius.getText())) {
						for (Shape shape : DrawingPanel.shapes) {
							if(shape.isSelected()) {
							shape.move(Integer.parseInt(txtXCoordinate.getText()), Integer.parseInt(txtYCoordinate.getText()));
							((Donut)shape).setRadius(Integer.parseInt(txtRadius.getText()));
							((Donut)shape).setInnerRadius(Integer.parseInt(txtInnerRadius.getText()));
							if(isOutlineColorB() == true) {
								shape.setOutline(outlineColor);
								setOutlineColorB(false);
							}
							
							if(isFillColorB() == true) {
								shape.setFill(fillColor);
								setFillColorB(false);
							}
							
						}
					}
					
					ok= true;
					dispose();
				} else {
					ok = false;
					JOptionPane.showMessageDialog(null, "The inner radius must be smaller then the radius!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		});
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		
		JButton cancelButton = new JButton("Cancle");
		cancelButton.setForeground(new Color(0, 0, 0));
		cancelButton.setBackground(new Color(255, 0, 0));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		
		//JLabel
		JLabel labelXCoordinate = new JLabel("Coordinate X:");
		labelXCoordinate.setPreferredSize(new Dimension(100, 40));
		
		JLabel labelYCoordinate = new JLabel("Coordinate Y:");
		labelYCoordinate.setPreferredSize(new Dimension(100, 40));
		
		JLabel labelInnerRadius = new JLabel("InnerRadius:");
		labelInnerRadius.setPreferredSize(new Dimension (100, 40));
		
		JLabel labelRadius = new JLabel("Radius:");
		labelRadius.setPreferredSize(new Dimension(100, 40));
		
		
		//set JTextField
		txtXCoordinate.setBounds(100, 40, 100, 40);
		txtXCoordinate.setColumns(10);
	
		
		txtYCoordinate.setBounds(100, 40, 100, 40);
		txtYCoordinate.setColumns(10);
		
		txtRadius.setBounds(100, 40, 100, 40);
		txtRadius.setColumns(10);
		
		txtInnerRadius.setBounds(100, 40, 100, 40);
		txtInnerRadius.setColumns(10);
		
		//Add components in panels
		//Panel centar
		panelCentar.add(labelXCoordinate);
		panelCentar.add(txtXCoordinate);
		panelCentar.add(labelYCoordinate);
		panelCentar.add(txtYCoordinate);
		panelCentar.add(labelRadius);
		panelCentar.add(txtRadius);
		panelCentar.add(labelInnerRadius);
		panelCentar.add(txtInnerRadius);
		panelCentar.add(btnFill);
		panelCentar.add(btnColor);
		//panel south
		panelSouth.add(okButton);
		panelSouth.add(cancelButton);
		
		
		
	}

	
	
	
}