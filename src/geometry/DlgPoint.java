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

public class DlgPoint extends JDialog {

	protected final JPanel panelCentar = new JPanel();
	protected final JPanel panelSouth = new JPanel();
	protected JTextField txtXCoordinate;
	protected JTextField txtYCoordinate;
	protected Color outline = Color.BLACK;
	protected boolean outlineColorB;
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
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Create the dialog.
	 */
	
	public DlgPoint() {
		initialize();
	}
	
	/**
	 *  Initialize of dialog.
	 */

	
	public void initialize() {
		//dialog
		setTitle("Dialog Point");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 320, 250);
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
		
		JButton btnColor = new JButton("Color");
		btnColor.setForeground(new Color(0, 0, 0));
		btnColor.setBackground(new Color(51, 204, 255));
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Please chose a color", Color.BLACK);
				outlineColorB = true;
			}
		});
		
		//JButton
		JButton okButton = new JButton("OK");
		okButton.setForeground(new Color(0, 0, 0));
		okButton.setBackground(new Color(0, 204, 0));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtXCoordinate.getText().trim().isEmpty() 
				|| txtYCoordinate.getText().trim().isEmpty()) {
					ok = false;
					JOptionPane.showMessageDialog(null, "Please enter values in the field","Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					for(Shape shape : DrawingPanel.shapes) {
						if(shape.isSelected()) {
							((Point)shape).setX(Integer.parseInt(txtXCoordinate.getText()));
							((Point)shape).setY(Integer.parseInt(txtYCoordinate.getText()));
							shape.setOutline(outline);
							outlineColorB = false;
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
		JLabel xCoordinate = new JLabel("X Coordinate:");
		xCoordinate.setPreferredSize(new Dimension(100, 40));
		
		JLabel yCoordinate = new JLabel("Y Coordinate:");
		yCoordinate.setPreferredSize(new Dimension(100, 40));
		
		//set JTextField
		txtXCoordinate.setBounds(150, 60, 75, 30);
		txtXCoordinate.setColumns(15);
		
		txtYCoordinate.setBounds(150,  60, 75, 30);
		txtYCoordinate.setColumns(15);
		
		//Add components in panels
		//centar panel
		panelCentar.add(xCoordinate);
		panelCentar.add(txtXCoordinate);
		panelCentar.add(yCoordinate);
		panelCentar.add(txtYCoordinate);
		panelCentar.add(btnColor);
		//south panel
		panelSouth.add(okButton);
		panelSouth.add(cancelButton);
	}
}
