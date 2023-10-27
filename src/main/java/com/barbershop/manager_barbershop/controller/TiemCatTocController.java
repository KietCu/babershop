package com.barbershop.manager_barbershop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.barbershop.manager_barbershop.view.TiemCatTocView;

public class TiemCatTocController implements ActionListener{
    private TiemCatTocView view;

    public TiemCatTocController(TiemCatTocView view) {
        this.view = view;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if(button.equals("Đặt lịch")){
            this.view.datLich();
        }
        else if(button.equals("Cắt tóc")){
            this.view.confirm();
        }
        else if(button.equals("Đặt")){
            this.view.addLichHen();
        }
        else if(button.equals("Xác nhận")){
            this.view.kiemTra();
        }
        else if(button.equals("Chọn")){
            this.view.thanhToan();
        }
        else if(button.equals("Sửa lịch hẹn")){
            this.view.editLich();
        }
        else if(button.equals("Cập nhật")){
            this.view.updateLich();
        }
        else if(button.equals("Manager")){
            
            this.view.movedPage();
        }
        else if(button.equals("Quản lý lịch hẹn") ){
            this.view.tableLich();
        }
        else if( button.equals("Lọc")){
            this.view.locNgayDat();
        }
        else if(button.equals("Xóa lịch")){
            this.view.xoaLichHen();
        }
        else if(button.equals("Quản lý khách hàng")){
            this.view.tableKhach();
        }
        else if(button.equals("Tìm kiếm khách hàng")) {
        	this.view.handleSearchCustomer();
        }
        else if(button.toLowerCase().equals("chỉnh sửa")){
            this.view.updateGuess();
        }
        else if(button.equals("Lưu")){
            this.view.updateTableGuess();
        }
        else if(button.equals("Xóa")){
            this.view.deleteGuess();
        }
        else if(button.equals("Quản lý doanh thu")){
            this.view.totalCost();
        }
        else if(button.equals("chọn")){
            this.view.updateDoanhThu();
        }
        else if(button.equals("Customer")){
            this.view.movedPageCustomer();
        }
        else if(button.equals("Quản lý dịch vụ")) {
        	this.view.showServicePage();
        }
        else if(button.equals("Thêm dịch vụ")) {
        	this.view.addService();
        }
    }
   
}
