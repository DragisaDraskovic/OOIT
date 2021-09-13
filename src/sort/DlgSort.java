package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class DlgSort extends JDialog {

	protected final JPanel panelCentar = new JPanel();
	protected final JPanel panelSouth = new JPanel();
	protected JTextField txtXCoordinate;
	protected JTextField txtYCoordinate;
	protected JTextField txtWidth;
	protected JTextField txtHeight;
	boolean ok;
	
	
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
	
	

	/*
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			DlgSort dialog = new DlgSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Create the dialog.
	 */
	
	public DlgSort() {
		initialize();
	}
	
	
	/**
	 * Initialize of dialog.
	 */
	
	public void initialize() {
		setModal(true);
		setTitle("Add rectangle");
		setBounds(150, 150, 400, 400);
		setResizable(false);
		getContentPane().setLayout(new	BorderLayout());
		getContentPane().add(panelCentar, BorderLayout.CENTER);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);;
		panelCentar.setBorder(new EmptyBorder(3, 3, 3, 3));
		panelSouth.setBorder(new EmptyBorder(3, 3, 3, 3));
		
	this.txtXCoordinate = new JTextField();
	txtXCoordinate.setColumns(15);
	txtXCoordinate.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char i = e.getKeyChar();
			if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
				e.consume();
			}
		}
	});
	
	this.txtYCoordinate = new JTextField();
	txtYCoordinate.setColumns(15);
	txtYCoordinate.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char i = e.getKeyChar();
			if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
				e.consume();
			}
		}
	});
	
	this.txtWidth = new JTextField();
	txtWidth.setColumns(15);
	txtWidth.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char i = e.getKeyChar();
			if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
				e.consume();
			}
		}
	});
	
	this.txtHeight = new JTextField();
	txtHeight.setColumns(15);
	txtHeight.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char i = e.getKeyChar();
			if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE  )) {
				e.consume();
			}
		}
	});
	
	JLabel labelTxtXCoordinate = new JLabel("Upper left point X:");
	labelTxtXCoordinate.setPreferredSize(new Dimension(100, 40));
	
	JLabel labelTxtYCoordinate = new JLabel("Upper left point Y:");
	labelTxtYCoordinate.setPreferredSize(new Dimension(100, 40));
	
	JLabel labelTxtWidth = new JLabel("Width:");
	labelTxtWidth.setPreferredSize(new Dimension(100, 40));
	
	JLabel labelTxtHeight = new JLabel("Height");
	labelTxtHeight.setPreferredSize(new Dimension (100, 40));
	
	JButton okButton = new JButton("Ok");
	okButton.setForeground(new Color(0, 0, 0));
	okButton.setBackground(new Color(0, 204, 0));
	okButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(txtXCoordinate.getText().trim().isEmpty() 
				|| txtYCoordinate.getText().trim().isEmpty()
				|| txtWidth.getText().trim().isEmpty()
				|| txtHeight.getText().trim().isEmpty()) {
				ok = false;
				JOptionPane.showMessageDialog(null, "Please enter values in the field", "Error", JOptionPane.ERROR_MESSAGE);
			return;
			
			
			} else {
				ok = true;
				setVisible(false);
			}
		}
	});
	okButton.setActionCommand("Ok");
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

	panelCentar.add(labelTxtXCoordinate);	
	panelCentar.add(txtXCoordinate);
	panelCentar.add(labelTxtYCoordinate);
	panelCentar.add(txtYCoordinate);
	panelCentar.add(labelTxtWidth);
	panelCentar.add(txtWidth);
	panelCentar.add(labelTxtHeight);
	panelCentar.add(txtHeight);
	
	panelSouth.add(okButton);
	panelSouth.add(cancelButton);
	
	
	
	}
	
	
	
}
