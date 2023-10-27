package com.barbershop.manager_barbershop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.barbershop.manager_barbershop.view.CustomerRegister;

public class RegisterController implements ActionListener{
	private CustomerRegister view;
	
	public RegisterController(CustomerRegister view) {
		
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Đăng ký")) {
			this.view.register();
		}
		else if(button.equals("Đăng nhập")) {
			this.view.formLogin();
		}
		else {
			this.view.backHomePage();
		}
			
		
	}
	
}
