package com.barbershop.manager_barbershop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.barbershop.manager_barbershop.view.ManagerLogin;

public class ManagerController implements ActionListener{
	private ManagerLogin view;
	
	public ManagerController(ManagerLogin view) {
		
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Xác nhận")) {
			this.view.login();
		}
		else {
			this.view.backHomePage();
		}
		
	}

}
