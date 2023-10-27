package com.barbershop.manager_barbershop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.barbershop.manager_barbershop.DAO.ICustomerDAO;
import com.barbershop.manager_barbershop.DAO.impl.CustomerDAO;
import com.barbershop.manager_barbershop.controller.HomePageController;
import com.barbershop.manager_barbershop.entity.CustomerEntity;

public class HomePage extends JFrame{

    public static Color blue;
    public static Color yellow;
    private ICustomerDAO customerDAO = new CustomerDAO();
    public void init() {
        this.setTitle("Tiệm cắt tóc");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JLabel labelImage = new JLabel();
        ImageIcon icon = new ImageIcon("./src/main/java/com/barbershop/manager_barbershop/view/background.jpeg");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        labelImage.setIcon(new ImageIcon(newImage));
        labelImage.setHorizontalAlignment(SwingConstants.CENTER);
        ActionListener action = new HomePageController(this);
        JPanel pnBor = new JPanel();
        pnBor.setLayout(new GridLayout(2, 1));
        Font f = new Font("sans-serif", Font.BOLD, 16);
        JLabel welcome = new JLabel("Bạn là: ", JLabel.CENTER);
        welcome.setFont(f);
        JPanel btnContainer = new JPanel();
        JButton btnCustomer = new JButton("Khách hàng");
        btnCustomer.addActionListener(action);
        JButton spaceBtn = new JButton("");
        spaceBtn.setEnabled(false);
        JButton btnManager = new JButton("Quản lý");
        btnManager.addActionListener(action);
        spaceBtn.setBackground(null);
        spaceBtn.setBorderPainted(false);
        
        blue = new Color(55, 182, 255);
        yellow = new Color(255, 189, 89);
        btnCustomer.setBackground(blue);
        btnManager.setBackground(yellow);
        
        btnCustomer.setPreferredSize(new Dimension(150, 40));
        spaceBtn.setPreferredSize(new Dimension(250, 40));
        btnManager.setPreferredSize(new Dimension(150, 40));
        
        btnCustomer.setOpaque(true);
        btnManager.setOpaque(true);
        btnCustomer.setBorderPainted(false);
        btnManager.setBorderPainted(false);
        
        btnContainer.add(btnCustomer);
        btnContainer.add(spaceBtn);
        btnContainer.add(btnManager);
        
        pnBor.add(welcome);
        pnBor.add(btnContainer);
        
        this.add(labelImage, BorderLayout.CENTER);
        this.add(pnBor, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    public void createAdmin() {
    	CustomerEntity admin = customerDAO.findByUserName("admin");
    	if(admin == null) {
    		admin = new CustomerEntity("admin", "babershop", null, null, null, "ADMIN");
    		customerDAO.saveEntity(admin);
    	}
    	
    }
    public HomePage() {
        this.init();
        this.createAdmin();
    }
    
}
