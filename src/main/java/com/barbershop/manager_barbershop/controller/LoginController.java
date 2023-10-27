package com.barbershop.manager_barbershop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.barbershop.manager_barbershop.view.CustomerLogin;

public class LoginController implements ActionListener{
	private CustomerLogin view;
	
	public LoginController(CustomerLogin view) {
		
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Xác nhận")) {
			this.view.login();
		}
		else if(button.equals("Đăng ký")) {
			this.view.register();
		}
		else {
			this.view.backHomePage();
		}
	}

}
