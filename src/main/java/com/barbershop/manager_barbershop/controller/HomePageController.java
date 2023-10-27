package com.barbershop.manager_barbershop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.barbershop.manager_barbershop.view.CustomerLogin;
import com.barbershop.manager_barbershop.view.HomePage;
import com.barbershop.manager_barbershop.view.ManagerLogin;

public class HomePageController implements ActionListener{
	private HomePage view;
	
	public HomePageController(HomePage view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Khách hàng")) {
			this.view.dispose();
			new CustomerLogin();
		}
		else {
			this.view.dispose();
			new ManagerLogin();
		}
		
	}

}
