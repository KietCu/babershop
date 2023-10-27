package com.barbershop.manager_barbershop.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.barbershop.manager_barbershop.DAO.ICustomerDAO;
import com.barbershop.manager_barbershop.DAO.impl.CustomerDAO;
import com.barbershop.manager_barbershop.DTO.CustomerDTO;
import com.barbershop.manager_barbershop.controller.ManagerController;
import com.barbershop.manager_barbershop.entity.CustomerEntity;
import com.barbershop.manager_barbershop.session.session;

public class ManagerLogin extends JFrame {

	private Color mainColor;
	private JTextField passWrTxt;
	private JTextField accTxt;
	private ICustomerDAO customerDao = new CustomerDAO();

	public void init() {
		this.setTitle("Manager Login");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 1));
		ActionListener action = new ManagerController(this);
		mainColor = new Color(255, 189, 89);

		Font f = new Font("sans-serif", Font.BOLD, 42);
		JLabel title = new JLabel("Quản lý", JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(f);
		Font f2 = new Font("sans-serif", Font.BOLD, 26);
		JLabel signin = new JLabel("Đăng nhập", JLabel.CENTER);
		signin.setForeground(Color.WHITE);
		signin.setFont(f2);

		JPanel form = new JPanel();
		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
		JPanel row1 = new JPanel();
		row1.setLayout(new FlowLayout());
		JButton acc = new JButton("Tài khoản");
		accTxt = new JTextField();
		acc.setPreferredSize(new Dimension(100, 40));
		accTxt.setPreferredSize(new Dimension(250, 40));
		row1.add(acc);
		row1.add(accTxt);
		JPanel row2 = new JPanel();
		row2.setLayout(new FlowLayout());
		JButton passWr = new JButton("Mật khẩu");
		passWrTxt = new JTextField();
		passWr.setPreferredSize(new Dimension(100, 40));
		passWrTxt.setPreferredSize(new Dimension(250, 40));
		acc.setEnabled(false);
		passWr.setEnabled(false);
		row2.add(passWr);
		row2.add(passWrTxt);
		form.add(row1);
		form.add(row2);
		row1.setBackground(mainColor);
		row2.setBackground(mainColor);
		form.setBackground(mainColor);

		JPanel btnGroup = new JPanel();
		JButton btnReturn = new JButton("Trở lại");
		JButton spaceBtn = new JButton("");
		JButton btnConfirm = new JButton("Xác nhận");
		btnReturn.addActionListener(action);
		btnConfirm.addActionListener(action);
		spaceBtn.setEnabled(false);
		spaceBtn.setBorderPainted(false);
		spaceBtn.setBackground(null);
		btnReturn.setPreferredSize(new Dimension(120, 40));
		spaceBtn.setPreferredSize(new Dimension(100, 40));
		btnConfirm.setPreferredSize(new Dimension(120, 40));
		btnReturn.setOpaque(true);
		btnReturn.setBorderPainted(false);
		btnReturn.setBackground(Color.RED);
		btnReturn.setForeground(Color.WHITE);
		btnConfirm.setOpaque(true);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(Color.GREEN);
		btnGroup.add(btnReturn);
		btnGroup.add(spaceBtn);
		btnGroup.add(btnConfirm);
		btnGroup.setBackground(mainColor);

		this.add(title);
		this.add(signin);
		this.add(form);
		this.add(btnGroup);
		getContentPane().setBackground(mainColor);
		this.setVisible(true);
	}

	public ManagerLogin() {
		this.init();
	}

	public void login() {
		String userName = accTxt.getText();
		String password = passWrTxt.getText();
		CustomerEntity customer = customerDao.findByUserName(userName);
		if (customer != null) {
			if (!customer.getPassword().equals(password)) {
				JOptionPane.showMessageDialog(this, "Sai mật khẩu");
				return;
			}
			if (customer.getRole().equals("ADMIN")) {
				session.customer = new CustomerDTO(customer.getId(), null, null, 0, null, customer.getRole());
			} else {
				session.customer = new CustomerDTO(customer.getId(), customer.getMaKH(), customer.getTenKh(),
						customer.getSdt(), customer.getBills(), customer.getRole());
			}

			System.out.println(session.customer);
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công ");
			this.dispose();
			new TiemCatTocView();
		} else {
			JOptionPane.showMessageDialog(this, "Người dùng không tồn tại");
		}

	}

	public void backHomePage() {
		this.dispose();
		new HomePage();

	}
}
