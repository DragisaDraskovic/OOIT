package stack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DialogStack extends JDialog {

	protected final JPanel centarPanel = new JPanel();
	protected final JPanel southPanel = new JPanel();
	protected boolean ok;
	protected JTextField txtXCoordinate;
	protected JTextField txtYCoordinate;
	protected JTextField txtWidth;
	protected JTextField txtHeight;
	
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
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

	public JPanel getCentarPanel() {
		return centarPanel;
	}
	public JPanel getSouthPanel() {
		return southPanel;
	}
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			DialogStack dialog = new DialogStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	
	public DialogStack() {
		initialize();
	}
	
	/**
	 * Initialize of dialog.
	 */
	
	public void initialize() {
		//dialog
		setTitle("Sort rectangle");
		setModal(true);
		setBounds(150, 150, 400, 400);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(centarPanel, BorderLayout.CENTER);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		centarPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		southPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		
		//TextField
		this.txtXCoordinate = new JTextField();
		txtXCoordinate.setColumns(15);
		txtXCoordinate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		
		this.txtYCoordinate = new JTextField();
		txtYCoordinate.setColumns(15);
		txtYCoordinate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		
		this.txtWidth = new JTextField();
		txtWidth.setColumns(15);
		txtWidth.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		
		this.txtHeight = new JTextField();
		txtHeight.setColumns(15);
		txtHeight.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char i = e.getKeyChar();
				if(!((i <= '9') && (i >= '0')) || (i == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		
		//Button
		
		JButton okButton = new JButton("Ok");
		okButton.setForeground(new Color(0, 0 ,0));
		okButton.setBackground(new Color(0, 204, 0));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtXCoordinate.getText().trim().isEmpty()
					|| txtYCoordinate.getText().trim().isEmpty()
					|| txtWidth.getText().trim().isEmpty()
					|| txtHeight.getText().trim().isEmpty()) {
					ok = false;
					JOptionPane.showMessageDialog(null,"Please enter values in the field", "Errom", JOptionPane.ERROR_MESSAGE);
				return;
								
				} else {
					ok = true;
					setVisible(false);
				}
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
		
		
		//Labele
		
		JLabel labelTxtXCoordinate = new JLabel("Upper left point X:");
		labelTxtXCoordinate.setPreferredSize(new Dimension(100, 40));
		
		JLabel labelTxtYCoordinate = new JLabel("Upper left point Y:");
		labelTxtYCoordinate.setPreferredSize(new Dimension(100, 40));
		
		JLabel labelTxtWidth = new JLabel("Width:");
		labelTxtWidth.setPreferredSize(new Dimension(100, 40));
		
		JLabel labelTxtHeight = new JLabel("Height:");
		labelTxtHeight.setPreferredSize(new Dimension(100, 40));
		
		
		//add component in panels
		
		//Centar panel
		
		centarPanel.add(labelTxtXCoordinate);
		centarPanel.add(txtXCoordinate);
		centarPanel.add(labelTxtYCoordinate);
		centarPanel.add(txtYCoordinate);
		centarPanel.add(labelTxtWidth);
		centarPanel.add(txtWidth);
		centarPanel.add(labelTxtHeight);
		centarPanel.add(txtHeight);
		
		//South panel
		
		southPanel.add(okButton);
		southPanel.add(cancelButton);
	}
	
	
	
}
