package stack;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

public class Stack extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList<String> list = new JList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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

	public Stack() {
		setTitle("Savo Gajic I76/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		setContentPane(contentPane);

		JButton btnAdd = new JButton("Umetni");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgStack dlgS = new DlgStack();
				dlgS.setVisible(true);

				if (dlgS.isOk) {

					Rectangle r = new Rectangle(
							new Point(Integer.parseInt(dlgS.getTxtX().getText()),
									Integer.parseInt(dlgS.getTxtY().getText())),
							
							Integer.parseInt(dlgS.getTxtHeight().getText()),
							Integer.parseInt(dlgS.getTxtWidth().getText()));

					dlm.add(0, r.toString());
					
				}
			}
		});

		JButton btnNewButton = new JButton("Izbriši");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DlgStack dlgS = new DlgStack();
				
				if(!list.isSelectionEmpty()) {
					
					
					String[] split = list.getSelectedValue().toString().split(" ");
					
					dlgS.getTxtX().setText(split[2].replaceAll("\\D+", ""));

					dlgS.getTxtY().setText(split[3].replaceAll("\\D+", ""));

					dlgS.getTxtWidth().setText(split[4].replaceAll("\\D+", ""));

					dlgS.getTxtHeight().setText(split[5].replaceAll("\\D+", ""));

					dlgS.setVisible(true);
					
						if(dlgS.isOk) {
							
						dlm.removeElement(list.getSelectedValue());
						
						}
				}else {
					JOptionPane.showMessageDialog(null, "Niste selektovali nijedan Pravougaonik!");
				}
				/*if (dlm.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Lista je prazna!");
					
				} else {
				
					String[] split = dlm.getElementAt(0).toString().split(" ");

					dlgS.getTxtX().setText(split[2].replaceAll("\\D+", ""));

					dlgS.getTxtY().setText(split[3].replaceAll("\\D+", ""));

					dlgS.getTxtWidth().setText(split[4].replaceAll("\\D+", ""));

					dlgS.getTxtHeight().setText(split[5].replaceAll("\\D+", ""));

					dlgS.setVisible(true);

					if (dlgS.isOk) {

						dlm.remove(0);

					}
				}*/
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAdd)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(37)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addGap(100))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdd)
							.addGap(18)
							.addComponent(btnNewButton)))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		list.setModel(dlm);
	}
}
