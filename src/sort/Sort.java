package sort;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Sort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private DefaultListModel<String> dlm2 = new DefaultListModel<String>();
	JList<String> list = new JList<String>();
	JList<String> list_1 = new JList<String>();

	SortFunction s1 = new SortFunction();
	Rectangle[] list1 = new Rectangle[10];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort frame = new Sort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sort() {
		setTitle("Savo Gajic I76/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		setContentPane(contentPane);

		JButton btnAdd = new JButton("Generiši");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SortFunction.generateRectangle(list1);
				
				dlm.removeAllElements();
				dlm2.removeAllElements();
				
				for (Rectangle r : list1)
					dlm.addElement(r.toString() + ", area= " + r.area());

			}
		});

		JButton btnSort = new JButton("Sortiraj");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Generišite pravougaonike!");
				} else {

					Arrays.sort(list1, s1.getComp());

					for (Rectangle r : list1)
						dlm2.addElement(r.toString() + ", area= " +r.area());
				}
			}
		});

		JLabel lblUnsorted = new JLabel("Ne sortirani");
		lblUnsorted.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblSorted = new JLabel("Sortirani");
		lblSorted.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUnsorted))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSort)
								.addComponent(btnAdd))
							.addGap(43))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSorted)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnsorted)
								.addComponent(lblSorted))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
								.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(btnAdd)
							.addGap(18)
							.addComponent(btnSort)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		list.setModel(dlm);
		list_1.setModel(dlm2);
	}
}
