import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.security.auth.PrivateCredentialPermission;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JFrame {
	private JTextField textField;
	private JLabel lblNewLabel;
	private JList list;
	private JScrollPane scrollPane;
	private sqliteloading sqliteloading;
	private JPanel panel_7;

	public MainPanel() throws Exception {
		sqliteloading = new sqliteloading();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(10, 10, 10, 0));
		getContentPane().add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_6.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainPanel.class.getResource("/image/FotoJet.jpg")).getImage()
				.getScaledInstance(350, 130, Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(imageIcon);
		panel_4.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel_3.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel.add(horizontalStrut);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);

		JButton btnNewButton = new JButton("搜尋");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("目標鎖定:" + textField.getText());
				try {
					ArrayList<String> ab = sqliteloading.selectName(textField.getText());
					for (int i = 0; i < ab.size(); i = i + 2) {
						System.out.println(ab.get(i));
						if ((i+1<ab.size())) {
							File file = new File(ab.get(i + 1));
						}
					}
					Object[] values = ab.toArray();
					list.setListData(values);

					revalidate();
					repaint();
					// list.setModel(new AbstractListModel() {
					// ArrayList<String> a = sqliteloading.selectName(textField.getText());

					// String[] values = (String[]) a.toArray();
					// public int getSize() {
					// return values.length;
					// }

					// public Object getElementAt(int index) {
					// return values[index];
					// }
					// });
					// scrollPane.setViewportView(list);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		panel.add(btnNewButton);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);

		lblNewLabel = new JLabel("目標鎖定");
		panel.add(lblNewLabel);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);

		JCheckBox checkBox = new JCheckBox("日式");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (checkBox.isSelected()) {
						ArrayList<String> ab = sqliteloading.selectName("日式");
						for (int i = 0; i < ab.size(); i = i + 2) {
							System.out.println(ab.get(i));
							if ((i+1<ab.size())) {
								File file = new File(ab.get(i + 1));
							}
							
						}
						Object[] values = ab.toArray();
						list.setListData(values);
					} else if (!checkBox.isSelected()) {
						Object[] emptyList = {};
						list.setListData(emptyList);
					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		panel_2.add(checkBox);

		JCheckBox chckbxNewCheckBox = new JCheckBox("西式");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (chckbxNewCheckBox.isSelected()) {
						ArrayList<String> ab = sqliteloading.selectName("西式");
						for (int i = 0; i < ab.size(); i = i + 2) {
							System.out.println(ab.get(i));
							if ((i+1<ab.size())) {
								File file = new File(ab.get(i + 1));
							}
						}
						Object[] values = ab.toArray();
						list.setListData(values);
					} else if (!chckbxNewCheckBox.isSelected()) {
						Object[] emptyList = {};
						list.setListData(emptyList);
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		panel_2.add(chckbxNewCheckBox);

		JCheckBox checkBox_1 = new JCheckBox("台式");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (checkBox_1.isSelected()) {
						ArrayList<String> ab = sqliteloading.selectName("台式");
						for (int i = 0; i < ab.size(); i = i + 2) {
							System.out.println(ab.get(i));
							if ((i+1<ab.size())) {
								File file = new File(ab.get(i + 1));
							}
						}
						Object[] values = ab.toArray();
						list.setListData(values);
					} else if (!checkBox_1.isSelected()) {
						Object[] emptyList = {};
						list.setListData(emptyList);
					}

				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		panel_2.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("下午茶");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (checkBox_2.isSelected()) {
						ArrayList<String> ab = sqliteloading.selectName("下午茶");
						for (int i = 0; i < ab.size(); i = i + 2) {
							System.out.println(ab.get(i));
							if ((i+1<ab.size())) {
								File file = new File(ab.get(i + 1));
							}
						}
						Object[] values = ab.toArray();
						list.setListData(values);
					} else if (!checkBox_2.isSelected()) {
						Object[] emptyList = {};
						list.setListData(emptyList);
					}

				} catch (Exception ex) {
					// TODO: handle exception
				}
			}

		});
		panel_2.add(checkBox_2);

		JLabel label = new JLabel("價格範圍");
		panel_2.add(label);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { " ", "$100以下", "$100-200", "$200-300", "$300以上" }));
		comboBox.setToolTipText("");

		panel_2.add(comboBox);

		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(350, 200));
		panel_5.add(scrollPane);

		list = new JList<String>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_7.removeAll();
				
				JScrollPane scrollPane_1 = new JScrollPane();
				panel_7.add(scrollPane_1);

				JTextArea textArea = new JTextArea();
				scrollPane_1.setViewportView(textArea);

				JLabel lblNewLabel_2 = new JLabel();
				panel_7.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel();
				panel_7.add(lblNewLabel_3);
				
				getContentPane().add(panel_7, BorderLayout.EAST);
				panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
				if (e.getClickCount() == 1) {
					String selectedItem = (String) list.getSelectedValue();
					int listNum = list.getSelectedIndex();
					System.out.println(listNum);
					System.out.println(selectedItem);
					try {
						ArrayList<String> listInfo = sqliteloading.selectList(selectedItem);
						String st = "";
						for (String str : listInfo ) {
							st = st+str;
						}
						textArea.setText(st);
					}catch (Exception ex) {
						// TODO: handle exception
					}
					String img = "/image/"+selectedItem+".jpg";
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainPanel.class.getResource(img)).getImage());
					lblNewLabel_2.setIcon(imageIcon);
					String map = "/image/Map_"+selectedItem+".png";
					ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(MainPanel.class.getResource(map)).getImage().getScaledInstance(729, 400, Image.SCALE_DEFAULT));
					lblNewLabel_3.setIcon(imageIcon1);
					repaint();
					pack();

				}
			}
		});

		// list.setModel(new AbstractListModel() {
		// String[] values = new String[] {};
		// public int getSize() {
		// return values.length;
		// }
		// public Object getElementAt(int index) {
		// return values[index];
		// }
		// });
		scrollPane.setViewportView(list);

		panel_7 = new JPanel();
		getContentPane().add(panel_7, BorderLayout.EAST);
		// panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));

		// JScrollPane scrollPane_1 = new JScrollPane();
		// panel_7.add(scrollPane_1);

		// JTextArea textArea = new JTextArea();
		// scrollPane_1.setViewportView(textArea);

		// JLabel lblNewLabel_2 = new JLabel("New label");
		// panel_7.add(lblNewLabel_2);

		// JLabel lblNewLabel_3 = new JLabel("New label");
		// panel_7.add(lblNewLabel_3);

		// sqliteloading.closeC();
	}

}
