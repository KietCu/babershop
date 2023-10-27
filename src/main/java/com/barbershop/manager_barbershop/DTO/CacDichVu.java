package com.barbershop.manager_barbershop.DTO;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CacDichVu {
	private Map<String, Double> dv;

	public CacDichVu() {
		this.dv = new TreeMap<>();
		this.init();
	}

	public void init() {
		this.dv.put("Cắt tóc + gội đầu", 60.000);
		this.dv.put("Cắt tóc + gội đầu + uốn", 300.000);
		this.dv.put("Cắt tóc + gội đầu + uốn + nhuộm", 800.000);
		this.dv.put("Cạo râu", 20.000);
		this.dv.put("Cạo khăn nóng", 30.000);
	}

	public double tongTienDichVu(String dichVu){
        System.out.println(dichVu);
 
        String[] cacDichVu = dichVu.split(",");
        System.out.println(Arrays.toString(cacDichVu));
        double tongTien = 0;
        for(String d: cacDichVu){
            System.out.println(this.dv.get(d.trim()));
            tongTien += this.dv.get(d.trim());
            
        }
        return tongTien;
      
    }
}
