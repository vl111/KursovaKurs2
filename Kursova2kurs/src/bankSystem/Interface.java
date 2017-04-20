package bankSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Actions;
import entity.Account;
import enums.TypeAccount;

@SuppressWarnings("serial")
public class Interface extends JFrame {

	@SuppressWarnings("unchecked")
	Interface() throws IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(300, 300);
		setSize(890, 500);
		setVisible(true);
		setResizable(true);
		setTitle("KursovaAccounts");

		JPanel container = new JPanel(new FlowLayout());
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		add(container);
		container.add(p);
		container.add(p1);
		container.add(p2);

		p.setPreferredSize(new Dimension(430, 100));
		p1.setPreferredSize(new Dimension(430, 100));
		p2.setPreferredSize(new Dimension(860, 800));

		Border bor = BorderFactory.createEtchedBorder();
		p.setBorder(bor);
		p1.setBorder(bor);
		p2.setBorder(bor);

		p.setLayout(new FlowLayout());
		p1.setLayout(new FlowLayout());
		p2.setLayout(new BorderLayout());

		JLabel jl1 = new JLabel();
		JLabel jl2 = new JLabel();
		JLabel jl3 = new JLabel();
		jl1.setText(
				"                       ID                           BALANCE                              TYPE                         ");
		jl2.setText("      ID:");
		jl3.setText("      SUM:");
		p.add(jl1);

		JTextField tf1 = new JTextField(10);
		JTextField tf2 = new JTextField(10);
		JTextField id = new JTextField(10);
		JTextField sum = new JTextField(10);
		@SuppressWarnings("rawtypes")
		JComboBox cb3 = new JComboBox(new String[] { "", "PAYMENT", "DEPOSIT", "UNIVERSAL" });
		p.add(tf1);
		p.add(tf2);
		p.add(cb3);
		p1.add(jl2);
		p1.add(id);
		p1.add(jl3);
		p1.add(sum);
		cb3.setPreferredSize(new Dimension(140, 20));

		JButton add = new JButton();
		p.add(add);
		add.setText("ADD");

		JButton delete = new JButton();
		p1.add(delete);
		delete.setText("Delete");

		JButton replenishment = new JButton();
		p1.add(replenishment);
		replenishment.setText("Replenish(sum)");

		JButton payment = new JButton();
		p1.add(payment);
		payment.setText("Pay(sum)");

		JButton acquisitionMonthly = new JButton();
		p1.add(acquisitionMonthly);
		acquisitionMonthly.setText("Acquisition");

		JLabel matList = new JLabel();
		p2.add(matList, BorderLayout.PAGE_START);

		List<Account> accounts = FileWR.read();
		matList.setText(refresh(accounts));

		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (idCheck(accounts, Long.parseLong(tf1.getText()))) {
						throw new IdAlreadyExistsExeption();
					}
					accounts.add(new Account(Long.parseLong(tf1.getText()), Double.parseDouble(tf2.getText()),
							TypeAccount.valueOf(cb3.getSelectedItem().toString()),
							FileWR.chooseType(TypeAccount.valueOf(cb3.getSelectedItem().toString()))) {
					});

					tf1.setText("");
					tf2.setText("");
					cb3.setSelectedItem("");
					tf1.grabFocus();

					matList.setText(refresh(accounts));
					try {
						FileWR.write(accounts);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Неправильний формат. Поле 1 - ціле число, 2 - дробове.");
				} catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(null, "Неправильний формат. Тип рахунку не обрано.");
				} catch (IdAlreadyExistsExeption e3) {
					JOptionPane.showMessageDialog(null, "Рахунок з таким id вже існує.");
				}

			}
		});

		delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (!idCheck(accounts, Long.parseLong(id.getText()))) {
						throw new NoIdExeption();
					}
					delete(accounts, Long.parseLong(id.getText()));// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					matList.setText(refresh(accounts));
					try {
						FileWR.write(accounts);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					id.setText("");
					sum.setText("");
					id.grabFocus();
					
				} catch (NoIdExeption e1) {
					JOptionPane.showMessageDialog(null, "Рахунок з таким id не існує.");
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Неправильний формат id. id - ціле число.");
				}
			}
		});

		replenishment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!idCheck(accounts, Long.parseLong(id.getText()))) {
						throw new NoIdExeption();
					}
					accounts.get(getById(accounts, Long.parseLong(id.getText()))).setBalance(
							Actions.replenishment(accounts.get(getById(accounts, Long.parseLong(id.getText()))),
									Double.parseDouble(sum.getText())));
					matList.setText(refresh(accounts));
					try {
						FileWR.write(accounts);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (NoIdExeption e1) {
					JOptionPane.showMessageDialog(null, "Рахунок з таким id не існує.");
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,
							"Неправильний формат id чи суми. id - ціле число, sum - дробове.");
				}
			}
		});

		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!idCheck(accounts, Long.parseLong(id.getText()))) {
						throw new NoIdExeption();
					}
					accounts.get(getById(accounts, Long.parseLong(id.getText())))
							.setBalance(Actions.payment(accounts.get(getById(accounts, Long.parseLong(id.getText()))),
									Double.parseDouble(sum.getText())));
					matList.setText(refresh(accounts));
					try {
						FileWR.write(accounts);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (NoIdExeption e1) {
					JOptionPane.showMessageDialog(null, "Рахунок з таким id не існує.");
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,
							"Неправильний формат id чи суми. id - ціле число, sum - дробове.");
				}
			}
		});

		acquisitionMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!idCheck(accounts, Long.parseLong(id.getText()))) {
						throw new NoIdExeption();
					}
					accounts.get(getById(accounts, Long.parseLong(id.getText()))).setBalance(
							Actions.acquisitionMonthly(accounts.get(getById(accounts, Long.parseLong(id.getText())))));
					matList.setText(refresh(accounts));
					try {
						FileWR.write(accounts);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (NoIdExeption e1) {
					JOptionPane.showMessageDialog(null, "Рахунок з таким id не існує.");
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Неправильний формат id. id - ціле число.");
				}
			}
		});
	}

	private String refresh(List<Account> list) {
		String text = "";

		for (int i = 0; i < list.size(); i++) {
			text += list.get(i).getId() + "\\" + list.get(i).getBalance() + "\\" + list.get(i).getTypeAccount()
					+ "<br>";
		}

		text = "<html><font face='verdana' size = 5>" + text + "</html>";
		return text;
	}

	private boolean idCheck(List<Account> list, long x) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == x)
				return true;
		}
		return false;
	}

	@SuppressWarnings("null")
	private int getById(List<Account> list, long id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id)
				return i;
		}
		return (Integer) null;
	}

	private List<Account> delete(List<Account> list, long x) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == x) {
				list.remove(i);
				return list;
			}
		}
		return list;
	}
}
