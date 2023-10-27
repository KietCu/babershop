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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.barbershop.manager_barbershop.DAO.ICustomerDAO;
import com.barbershop.manager_barbershop.DAO.impl.CustomerDAO;
import com.barbershop.manager_barbershop.controller.RegisterController;
import com.barbershop.manager_barbershop.entity.CustomerEntity;

public class CustomerRegister extends JFrame {

	private Color mainColor;
	private JTextField accTxt;
	private JTextField passWrTxt;
	private JTextField phoneTxt;
	private JTextField nameTxt;
	private ICustomerDAO customerDAO = new CustomerDAO();
	public void init() {
		this.setTitle("Manager Login");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 1));

		mainColor = new Color(57, 183, 255);

		Font f = new Font("sans-serif", Font.BOLD, 42);
		JLabel title = new JLabel("Khách hàng", JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(f);
		Font f2 = new Font("sans-serif", Font.BOLD, 26);
		JLabel signin = new JLabel("Đăng kí", JLabel.CENTER);
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
		JButton name = new JButton("Họ và tên");
		JButton phone = new JButton("Số điện thoại");
		passWrTxt = new JPasswordField();
		
		nameTxt = new JTextField();
		phoneTxt = new JTextField();
		passWr.setPreferredSize(new Dimension(100, 40));
		passWrTxt.setPreferredSize(new Dimension(250, 40));
		JPanel row3 = new JPanel();
		JPanel row4 = new JPanel();
		name.setPreferredSize(new Dimension(100, 40));
		nameTxt.setPreferredSize(new Dimension(250, 40));
		phone.setPreferredSize(new Dimension(100, 40));
		phoneTxt.setPreferredSize(new Dimension(250, 40));
		acc.setEnabled(false);
		passWr.setEnabled(false);
		name.setEnabled(false);
		phone.setEnabled(false);
		row3.setLayout(new FlowLayout());
		row4.setLayout(new FlowLayout());
		row2.add(passWr);
		row2.add(passWrTxt);
		row3.add(name);
		row3.add(nameTxt);
		row4.add(phone);
		row4.add(phoneTxt);

		form.add(row1);
		form.add(row2);
		form.add(row3);
		form.add(row4);
		row1.setBackground(mainColor);
		row2.setBackground(mainColor);
		row3.setBackground(mainColor);
		row4.setBackground(mainColor);
		form.setBackground(mainColor);
		ActionListener action = new RegisterController(this);
		JPanel btnGroup = new JPanel();
		JButton btnReturn = new JButton("Trở lại");
		JButton spaceBtn1 = new JButton("");
		JButton btnSignup = new JButton("Đăng nhập");
		JButton spaceBtn2 = new JButton("");
		JButton btnConfirm = new JButton("Đăng ký");
		btnConfirm.addActionListener(action);
		btnSignup.addActionListener(action);
		spaceBtn1.setEnabled(false);
		spaceBtn1.setBorderPainted(false);
		spaceBtn1.setBackground(null);
		spaceBtn1.setPreferredSize(new Dimension(100, 40));
		spaceBtn2.setEnabled(false);
		spaceBtn2.setBorderPainted(false);
		spaceBtn2.setBackground(null);
		spaceBtn2.setPreferredSize(new Dimension(100, 40));

		btnReturn.setOpaque(true);
		btnReturn.setBorderPainted(false);
		btnReturn.setBackground(Color.RED);
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setPreferredSize(new Dimension(120, 40));

		btnSignup.setOpaque(true);
		btnSignup.setBorderPainted(false);
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setBackground(Color.GRAY);
		btnSignup.setPreferredSize(new Dimension(120, 40));

		btnConfirm.setOpaque(true);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(Color.GREEN);
		btnConfirm.setPreferredSize(new Dimension(120, 40));
		btnGroup.add(btnReturn);
		btnGroup.add(spaceBtn1);
		btnGroup.add(btnSignup);
		btnGroup.add(spaceBtn2);
		btnGroup.add(btnConfirm);
		btnGroup.setBackground(mainColor);

		this.add(title);
		this.add(signin);
		this.add(form);
		this.add(btnGroup);
		getContentPane().setBackground(mainColor);
		this.setVisible(true);
	}

	public CustomerRegister() {
		this.init();
	}

	public void register() {
		
		String userName = accTxt.getText();
		String password = passWrTxt.getText();
		String tenKh = nameTxt.getText();
		int sdt = Integer.valueOf(phoneTxt.getText());
		String maKh = "KH" + (customerDAO.count() + 1);
		CustomerEntity customer = customerDAO.findByUserName(userName);
		if(customer != null) {
			JOptionPane.showMessageDialog(this, "Tên người dùng đã tồn tại");
			return;
		}
		 customer= new CustomerEntity(userName, password, tenKh, sdt, maKh, "USER");
		Long id =  customerDAO.saveEntity(customer);
		if(id > 0) {
			JOptionPane.showMessageDialog(this, "Đăng kí thành công");
		}
		this.dispose();
		new CustomerLogin();
		
	}

	public void formLogin() {
		this.dispose();
		new CustomerLogin();
		
	}

	public void backHomePage() {
		this.dispose();
		new HomePage();
		
	}
}
