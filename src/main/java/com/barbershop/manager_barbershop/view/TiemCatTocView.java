package com.barbershop.manager_barbershop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.barbershop.manager_barbershop.DAO.IAppointmentDAO;
import com.barbershop.manager_barbershop.DAO.IBillDao;
import com.barbershop.manager_barbershop.DAO.ICustomerDAO;
import com.barbershop.manager_barbershop.DAO.IServiceDAO;
import com.barbershop.manager_barbershop.DAO.impl.AppointmentDAO;
import com.barbershop.manager_barbershop.DAO.impl.BillDAO;
import com.barbershop.manager_barbershop.DAO.impl.CustomerDAO;
import com.barbershop.manager_barbershop.DAO.impl.ServiceDAO;
import com.barbershop.manager_barbershop.DTO.Appointment;
import com.barbershop.manager_barbershop.DTO.BillDTO;
import com.barbershop.manager_barbershop.DTO.CacDichVu;
import com.barbershop.manager_barbershop.DTO.CustomerDTO;
import com.barbershop.manager_barbershop.DTO.ServiceDTO;
import com.barbershop.manager_barbershop.controller.TiemCatTocController;
import com.barbershop.manager_barbershop.entity.AppointmentEntity;
import com.barbershop.manager_barbershop.entity.BillEntity;
import com.barbershop.manager_barbershop.entity.CustomerEntity;
import com.barbershop.manager_barbershop.entity.ServiceEntity;
import com.barbershop.manager_barbershop.session.session;
import com.barbershop.manager_barbershop.utils.FormatDate;

public class TiemCatTocView extends JFrame {

	private JPanel datLich;
	private JButton xacNhan;
	private JPanel kiemTraThongTin = new JPanel();
	private TiemCatTocController ac;
	private JTextField inputName;
	private JTextField inputSdt;
	private JComboBox<Object> ngayDat;
	private JComboBox<Object> gioDat;
	private JTextField inputNameConfirm;
	private JTextField inputSdtConfirm;
	private JPanel dichVu;
	private ArrayList<Object> listDichVuPhu;
	private ButtonGroup groupButton;
	private CustomerDTO khachSuDungDV;
	private JLabel title;
	private JPanel jpanelEdit;
	private JComboBox<Object> inputNgayDatEdit;
	private JComboBox<Object> inputGioDatEdit;
	private JComboBox<Object> ngayDatEdit;
	private JComboBox<Object> gioDatEdit;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JPanel option;
	private JMenuItem itemCustomer;
	private JMenuItem itemManager;
	private JPanel optionCustomer;
	private JTable tableLich;
	private JComboBox<Object> ngayDatLich;
	private JTable tableKhach;
	private JScrollPane scrollPaneLich;
	private JPanel jpanelSearch;
	private JButton luu;
	private JPanel updateGuess;
	private JPanel jpanelCenter;
	private JTextField textFieldMaKH;
	private JTextField textFieldHoTen;
	private JTextField textFieldSdt;
	private JTextField textFieldPhiDichVu;
	private JPanel jpanelDayTotal;
	private JTable tableTongKet;
	private JScrollPane scrollPanelTongKet;
	private JComboBox<Object> ngayTongKet;
	private JLabel tongKet;
	private JPanel formTongKet;
	private JScrollPane scrollPaneKhach;
	private JPanel jpanelTableLich;
	private JPanel header_customer;
	private IAppointmentDAO appointmentDAO = new AppointmentDAO();
	private ICustomerDAO customerDAO = new CustomerDAO();
	private JTable tableService;
	private JScrollPane scrollPaneService;
	private JPanel jpanelCenterService;
	private IServiceDAO serviceDAO = new ServiceDAO();
	private IBillDao billDao = new BillDAO();
	private JTextField inputSdtSearch;
	private JLabel lableEmpty;

	public TiemCatTocView() {
		this.init();
	}

	private void init() {
		this.setTitle("Tiệm cắt tóc");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		ac = new TiemCatTocController(this);
		JMenuBar jmenu = new JMenuBar();
		itemCustomer = new JMenuItem("Customer");
		itemManager = new JMenuItem("Manager");
		itemCustomer.addActionListener(ac);
		itemManager.addActionListener(ac);
		itemCustomer.setOpaque(true);
		itemCustomer.setBackground(Color.GRAY);
		itemCustomer.setForeground(Color.WHITE);
		jmenu.add(itemCustomer);
		jmenu.add(itemManager);
		header_customer = new JPanel();
		header_customer.setLayout(new BorderLayout(20, 20));
		JLabel labelImage = new JLabel();
		URL url = null;
		try {
			url = new URL(
					"https://cl-wpml.s3.ap-southeast-1.amazonaws.com/cam-nang-viec-lam/wp-content/uploads/2023/04/10082824/barber-hipster-vintage-poster-709x1024.jpg");
		} catch (MalformedURLException ex) {
			Logger.getLogger(TiemCatTocView.class.getName()).log(Level.SEVERE, null, ex);
		}
		ImageIcon icon = new ImageIcon(url);
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(300, 400, Image.SCALE_DEFAULT);

		option = new JPanel();
		btn1 = new JButton("Đặt lịch");
		btn2 = new JButton("Cắt tóc");
		btn3 = new JButton("Sửa lịch hẹn");
		option.setLayout(new GridLayout(1, 3));
		option.add(btn1);
		option.add(btn2);
		option.add(btn3);
		btn1.addActionListener(ac);
		btn2.addActionListener(ac);
		btn3.addActionListener(ac);

		title = new JLabel("Chào mừng tới tiệm cắt tóc Mesiuu", SwingConstants.CENTER);
		title.setFont(new Font("Times New Roman", Font.PLAIN, 22));

		labelImage.setIcon(new ImageIcon(newImage));
		labelImage.setHorizontalAlignment(SwingConstants.CENTER);
		header_customer.add(title, BorderLayout.NORTH);
		header_customer.add(labelImage, BorderLayout.CENTER);
		this.add(header_customer, BorderLayout.NORTH);
//       
		this.add(option, BorderLayout.SOUTH);
//       

		this.setJMenuBar(jmenu);

		this.setVisible(true);
	}

	public void removeCustomer() {
		if (option != null) {
			this.remove(option);
			this.repaint();
		}
	}

	public void formDatLich() {
		datLich = new JPanel();
		JLabel labelNgay = new JLabel("Ngày đặt");
		JLabel lableGio = new JLabel("Giờ đặt");
		lableEmpty = new JLabel("");
		inputName = new JTextField();
		inputSdt = new JTextField();
		ngayDat = new JComboBox<>();
		gioDat = new JComboBox<>();
		JButton btnDat = new JButton("Đặt");
		btnDat.addActionListener(ac);
		LocalTime gio;
		for (int i = 8; i <= 21; i++) {
			gio = LocalTime.of(i, 0);
			gioDat.addItem(gio);
		}

		LocalDate now = LocalDate.now();
		ngayDat.addItem(now);
		for (int i = 1; i < 7; i++) {
			ngayDat.addItem(now.plusDays(i));
		}
		
		gioDat.addActionListener(e -> {
			String ngaydat = ngayDat.getSelectedItem().toString();
			String giodat = gioDat.getSelectedItem().toString();
			showTotalOrder(ngaydat, giodat);
		});
		datLich.setLayout(new GridLayout(5, 2, 20, 20));
		datLich.add(labelNgay);
		datLich.add(ngayDat);
		datLich.add(lableGio);
		datLich.add(gioDat);
		datLich.add(lableEmpty);
		datLich.add(btnDat);

	}
	public void showTotalOrder(String ngayDat, String gioDat) {
		long result = appointmentDAO.countByNgayDatAndGioDat(ngayDat,gioDat);
		
		lableEmpty.setText("Tổng cộng các lich hẹn vào ngày: " + ngayDat + " vào: "+ gioDat +" là" + result );
		
	}
	public void formXacNhan() {
		LocalDate ngay = LocalDate.now();
		JPanel listBox = new JPanel();
		LocalTime gio = LocalTime.now();
		String ngayDat = FormatDate.formatLocalDate(ngay);
		List<Appointment> listOrder = appointmentDAO.findByCustomerIdAndNgayDat(session.customer.getId(), ngayDat);
		String gioDat = gio.toString();
		listBox.setLayout(new GridLayout(listOrder.size(), 1, 10, 20));

		for (int i = 0; i < listOrder.size(); i++) {
			Appointment lich = listOrder.get(i);
			if (lich.getGioDat().compareTo(gioDat) > 0) {
				JPanel box = new JPanel();
				box.setLayout(new BorderLayout(20, 20));
				box.setPreferredSize(new Dimension(80, 80));
				JPanel orderTime = new JPanel();
				orderTime.setLayout(new GridLayout(2, 1));
				JLabel day1 = new JLabel(lich.getNgayDat());
				JLabel time1 = new JLabel(lich.getGioDat());
				orderTime.add(day1);
				orderTime.add(time1);
				JButton conform1 = new JButton("Xác nhận");
				conform1.addActionListener(ac);
				box.setBorder(BorderFactory.createLineBorder(Color.black));
				box.add(orderTime, BorderLayout.WEST);
				box.add(conform1, BorderLayout.EAST);
				listBox.add(box);
			}

		}

		kiemTraThongTin.setPreferredSize(new Dimension(100, 100));
		kiemTraThongTin.setLayout(new BorderLayout());
		kiemTraThongTin.add(listBox, BorderLayout.CENTER);
		this.add(kiemTraThongTin, BorderLayout.NORTH);
	}

	public void xoaTitle() {
		if (header_customer != null) {
			this.remove(header_customer);
			this.repaint();
		}
	}

	public void xoaFormDat() {
		if (datLich != null) {
			this.remove(datLich);
			this.repaint();
		}
	}

	public void xoaFormCatToc() {
		if (kiemTraThongTin != null) {
			this.remove(kiemTraThongTin);
			this.repaint();
		}
		if (dichVu != null) {
			this.remove(dichVu);
			this.repaint();
		}
	}

	public void xoaFormEdit() {
		if (jpanelEdit != null) {
			this.remove(jpanelEdit);
			this.repaint();
		}
	}

	public void datLich() {
		xoaTitle();
		xoaFormCatToc();
		xoaFormEdit();
		formDatLich();
		this.add(datLich, BorderLayout.NORTH);
		this.setVisible(true);

	}

	public void confirm() {
		xoaTitle();
		xoaFormDat();
		xoaFormEdit();
		formXacNhan();

		this.setVisible(true);
	}

	public void addLichHen() {
		LocalDate ngay = (LocalDate) this.ngayDat.getSelectedItem();
		LocalTime gio = (LocalTime) this.gioDat.getSelectedItem();
		String ngayDat = FormatDate.formatLocalDate(ngay);
		String gioDat = gio.toString();
		System.out.println(session.customer);
		CustomerEntity customer = customerDAO.findById(session.customer.getId());
		AppointmentEntity lh = new AppointmentEntity(ngayDat, gioDat, false);
		lh.setCustomer(customer);
		appointmentDAO.saveEntity(lh);
		JOptionPane.showMessageDialog(this, "Bạn đã đặt lịch thành công");
		resetFormDatLich();

//		}

	}

	public void resetFormDatLich() {
		this.inputName.setText("");
		this.inputSdt.setText("");
		this.ngayDat.setSelectedIndex(0);
		this.gioDat.setSelectedIndex(0);
	}

	public void kiemTra() {

		dichVuCatToc();

	}

	public void dichVuCatToc() {

		if (kiemTraThongTin != null) {
			this.remove(kiemTraThongTin);
			this.repaint();
		}
		formCatToc();
		this.add(dichVu, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public void formCatToc() {

		dichVu = new JPanel();

		JPanel cacDichVu = new JPanel();
		List<ServiceDTO> services = serviceDAO.findAll();
//		groupButton = new ButtonGroup();
//		JRadioButton combo1 = new JRadioButton("Cắt tóc + gội đầu");
//		JRadioButton combo2 = new JRadioButton("Cắt tóc + gội đầu + uốn");
//		JRadioButton combo3 = new JRadioButton("Cắt tóc + gội đầu + uốn + nhuộm");
//		groupButton.add(combo1);
//		groupButton.add(combo2);
//		groupButton.add(combo3);
//		cacDichVu.setLayout(new GridLayout(3, 1));
//		cacDichVu.add(combo1);
//		cacDichVu.add(combo2);
//		cacDichVu.add(combo3);

		JLabel dichVuKhac = new JLabel("Chọc các dịch vụ ");
		JPanel cacDichVuKhac = new JPanel();
		listDichVuPhu = new ArrayList<>();
		cacDichVuKhac.setLayout(new GridLayout(services.size(), 1));
		services.stream().forEach(service -> {
			JCheckBox dichVuPhu2 = new JCheckBox(service.getTenDv());
			cacDichVuKhac.add(dichVuPhu2);
			listDichVuPhu.add(dichVuPhu2);
		});

		JLabel empty = new JLabel("");
		JButton btnCatToc = new JButton("Chọn");
		btnCatToc.addActionListener(ac);

		dichVu.setLayout(new GridLayout(3, 2));

//		dichVu.add(cacDichVu);
		dichVu.add(dichVuKhac);
		dichVu.add(cacDichVuKhac);
		dichVu.add(empty);
		dichVu.add(btnCatToc);

	}

	public void thanhToan() {

		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn vui lòng nhấn yes để thanh toán");
		List<ServiceEntity> services = new ArrayList<>();
		double total = 0;
		if (luaChon == JOptionPane.YES_OPTION) {

//			Enumeration<AbstractButton> selectMonChinh = groupButton.getElements();
//			while (selectMonChinh.hasMoreElements()) {
//				AbstractButton b = selectMonChinh.nextElement();
//				if (b.isSelected()) {
//
//					cacDichVu = b.getText() + ",";
//				}
//
//			}

			for (int i = 0; i < listDichVuPhu.toArray().length; i++) {
				AbstractButton b = (AbstractButton) listDichVuPhu.get(i);
				if (b.isSelected()) {
					ServiceEntity service = serviceDAO.findByTenDv(b.getText());
					services.add(service);
					total += service.getCost();

				}
			}
			LocalDate ngay = LocalDate.now();
			String today = FormatDate.formatLocalDate(ngay);
			BillEntity bill = new BillEntity(services, customerDAO.findById(session.customer.getId()), today, total);
			long id = billDao.saveEntity(bill);
//			String maKH = "KH" + (this.model.getKh().size() + 1);
//			if (this.model.kiemTraMaKH(maKH)) {
//				maKH = "KH" + (this.model.getKh().size() + 2);
//			}
//			this.khachSuDungDV.setMaKH(maKH);
//			this.khachSuDungDV.setDichVu(cacDichVu);
//			this.khachSuDungDV.setTienDichVu(phiDichVU);
//			this.model.insert(khachSuDungDV);
			if (id > 0) {
				JOptionPane.showMessageDialog(this, "Cảm ơn bạn đã sử dụng dich vụ của chúng tôi");
				this.remove(dichVu);
				this.repaint();
				this.remove(this);
				this.confirm();
			}

		}
	}

	public void editLich() {
		xoaTitle();
		xoaFormDat();
		xoaFormCatToc();
		formEditLich();
		this.add(jpanelEdit, BorderLayout.NORTH);
		this.setVisible(true);

	}

	public void formEditLich() {
		jpanelEdit = new JPanel();
		JLabel labelTen = new JLabel("Ngày sửa");
		JLabel labelSdt = new JLabel("Giờ sửa");
		JLabel labelNgay = new JLabel("Ngày đặt");
		JLabel lableGio = new JLabel("Giờ đặt");
		JLabel lableEmpty = new JLabel("");
		inputNgayDatEdit = new JComboBox<>();
		inputGioDatEdit = new JComboBox<>();
		ngayDatEdit = new JComboBox<>();
		ngayDatEdit.setPreferredSize(new Dimension(200, 20));
		gioDatEdit = new JComboBox<>();
		JButton btnEdit = new JButton("Cập nhật");
		btnEdit.addActionListener(ac);
		LocalTime gio;
		for (int i = 8; i <= 21; i++) {
			gio = LocalTime.of(i, 0);
			gioDatEdit.addItem(gio);
			inputGioDatEdit.addItem(gio);

		}
		LocalDate now = LocalDate.now();
		ngayDatEdit.addItem(now);
		inputNgayDatEdit.addItem(now);
		for (int i = 1; i < 7; i++) {
			ngayDatEdit.addItem(now.plusDays(i));
			inputNgayDatEdit.addItem(now.plusDays(i));
		}
		jpanelEdit.setLayout(new GridLayout(5, 2, 20, 20));

		jpanelEdit.add(labelNgay);
		jpanelEdit.add(ngayDatEdit);
		jpanelEdit.add(lableGio);
		jpanelEdit.add(gioDatEdit);
		jpanelEdit.add(labelTen);
		jpanelEdit.add(inputNgayDatEdit);
		jpanelEdit.add(labelSdt);
		jpanelEdit.add(inputGioDatEdit);
		jpanelEdit.add(lableEmpty);
		jpanelEdit.add(btnEdit);
	}

	public void updateLich() {
		String ngayDat = ngayDatEdit.getSelectedItem().toString();
		String gioDat = gioDatEdit.getSelectedItem().toString();
		String ngaySua = inputNgayDatEdit.getSelectedItem().toString();
		String gioSua = inputGioDatEdit.getSelectedItem().toString();
//		String hoTen = this.inputNameEdit.getText().trim();
//		int sdt = Integer.valueOf(this.inputSdtEdit.getText().trim());
		appointmentDAO.updateDayAndTime(session.customer.getId(), ngayDat, gioDat, ngaySua, gioSua);
		LocalDate ngay = (LocalDate) this.ngayDatEdit.getSelectedItem();
		LocalTime gio = (LocalTime) this.gioDatEdit.getSelectedItem();

//		Appointment lh = new Appointment(hoTen, sdt, ngay, gio);
//		this.model.update(lh);
//		JOptionPane.showMessageDialog(this, "Lịch hẹn \nTên: " + hoTen + " và  sdt: " + sdt + " đã thay đổi lịch hẹn",
//				"Thông báo", JOptionPane.INFORMATION_MESSAGE);
		this.resetForm();
	}

	public void resetForm() {

		this.ngayDatEdit.setSelectedIndex(0);
		this.gioDatEdit.setSelectedIndex(0);
	}

	public void movedPage() {
		if (session.customer.getRole().equals("ADMIN")) {
			layoutEmpty();
		} else {
			JOptionPane.showMessageDialog(this, "Truy cập bì vì từ chối ", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void layoutEmpty() {
		this.removeCustomer();
		this.xoaTitle();
		this.xoaFormCatToc();
		this.xoaFormDat();
		this.xoaFormEdit();
		itemManager.setBackground(Color.GRAY);
		itemManager.setForeground(Color.WHITE);
		itemCustomer.setOpaque(true);
		itemCustomer.setBackground(UIManager.getColor("Menu.background"));
		itemCustomer.setForeground(UIManager.getColor("Menu.foreground"));

		this.formCustomer();
		this.setVisible(true);

	}

	public void formCustomer() {
		optionCustomer = new JPanel();
		JButton quanLiDichVu = new JButton("Quản lý dịch vụ");
		quanLiDichVu.addActionListener(ac);
		JButton quanLiLich = new JButton("Quản lý lịch hẹn");
		quanLiLich.addActionListener(ac);
		JButton quanLiKhach = new JButton("Quản lý khách hàng");
		quanLiKhach.addActionListener(ac);
		JButton quanLiDoanhThu = new JButton("Quản lý doanh thu");
		quanLiDoanhThu.addActionListener(ac);
		optionCustomer.setLayout(new GridLayout(1, 4));
		optionCustomer.add(quanLiDichVu);
		optionCustomer.add(quanLiLich);
		optionCustomer.add(quanLiKhach);
		optionCustomer.add(quanLiDoanhThu);

		this.add(optionCustomer, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	public void formQuanLiLich() {

		jpanelSearch = new JPanel();
		JLabel labelSearch = new JLabel("Tìm kiếm");
		ngayDatLich = new JComboBox<>();
		LocalDate now = LocalDate.now();
		jpanelTableLich = new JPanel();
		jpanelTableLich.setLayout(new BorderLayout());

		ngayDatLich.addItem(now);
		for (int i = 1; i < 7; i++) {
			ngayDatLich.addItem(now.plusDays(i));
		}
		JButton btnLoc = new JButton("Lọc");
		btnLoc.addActionListener(ac);
		jpanelSearch.setLayout(new GridLayout(1, 3));
		jpanelSearch.add(labelSearch);
		jpanelSearch.add(ngayDatLich);
		jpanelSearch.add(btnLoc);

		tableLich = new JTable();
		tableLich.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã khách hàng", "Họ tên khách", "Số điện thoại", "Ngày đặt", "Giờ đặt" }));
		tableLich.setPreferredScrollableViewportSize(new Dimension(800, 250));
		scrollPaneLich = new JScrollPane(tableLich);
		JButton btnXoaLich = new JButton("Xóa lịch");
		JPanel box = new JPanel();
		box.add(btnXoaLich);
		btnXoaLich.addActionListener(ac);
		btnXoaLich.setPreferredSize(new Dimension(100, 20));

		jpanelTableLich.add(scrollPaneLich, BorderLayout.NORTH);
		jpanelTableLich.add(box, BorderLayout.EAST);
		this.add(jpanelSearch, BorderLayout.NORTH);
		this.add(jpanelTableLich, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void tableLich() {
		this.removeService();
		xoaTableKhach();
		xoaTongKet();
		formQuanLiLich();
		insertTableLich();
	}

	public void resetTable(JTable table) {
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		for (int i = table.getRowCount() - 1; i >= 0; i--) {
			modelTable.removeRow(i);
		}

	}

	public void insertTableLich() {
		LocalDate ngayChon = (LocalDate) this.ngayDatLich.getSelectedItem();
		DefaultTableModel modelTable = (DefaultTableModel) tableLich.getModel();
		String date = FormatDate.formatLocalDate(ngayChon);
		List<Appointment> apps = appointmentDAO.findAll(date);
		if (apps != null) {
			for (Appointment c : apps) {
				modelTable.addRow(new Object[] { c.getId() + "", c.getTenKh() + "", c.getSdt() + "",
						c.getNgayDat() + "", c.getGioDat() + "" });
			}
		}

	}

	public void locNgayDat() {
		resetTable(tableLich);
		insertTableLich();
	}

	public Long lichHenDuocChon() {
		DefaultTableModel modelTable = (DefaultTableModel) tableLich.getModel();

		int row = tableLich.getSelectedRow();
		Long id = Long.parseLong((modelTable.getValueAt(row, 0) + "").trim());

		return id;
	}

	public void xoaLichHen() {
		Long idSelected = this.lichHenDuocChon();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn vui có chắc muốn xóa lịch hẹn");

		if (luaChon == JOptionPane.YES_OPTION) {
			System.out.println("xóa");
			appointmentDAO.removeById(idSelected);
			this.resetTable(tableLich);
			this.insertTableLich();
		}

	}

	public void tableKhach() {
		this.removeService();
		xoaTableLich();
		xoaTongKet();
		removeService();
		formQuanLiKhach();
		insertDataKhach();
	}

	public void insertDataKhach() {
		DefaultTableModel modelTable = (DefaultTableModel) tableKhach.getModel();
		LocalDate ngay = LocalDate.now();
		String today = FormatDate.formatLocalDate(ngay);
		List<BillDTO> bills = billDao.findAllByCreateDate(today);
		if(bills != null) {
			bills.stream().forEach(bill -> {
				modelTable.addRow(new Object[] { bill.getCustomer().getMaKH() + "", bill.getCustomer().getTenKh() + "",
						bill.getCustomer().getSdt() + "", bill.getCreatedDate() + "", bill.getDichVu() + "", bill.getId(),
						bill.getTotal() });
			});
		}
		
	}

	public void formQuanLiKhach() {
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		JPanel formSearch = new JPanel();
		formSearch.setLayout(new GridLayout(1, 3));
		JLabel text = new JLabel("Tìm kiếm");
		inputSdtSearch = new JTextField();
		JButton btnSearch = new JButton("Tìm kiếm khách hàng");
		btnSearch.addActionListener(ac);
		formSearch.add(text);
		formSearch.add(inputSdtSearch);
		formSearch.add(btnSearch);
		tableKhach = new JTable();
		tableKhach.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Mã khách hàng",
				"Họ tên khách", "Số điện thoại", "Ngày tạo", "Dịch vụ sử dụng", "Mã hóa đơn", "Tiền dịch vụ" }));
		tableKhach.setPreferredScrollableViewportSize(new Dimension(800, 250));
		JPanel featureKhach = new JPanel();
		JButton btnUpdateKhach = new JButton("Chỉnh sửa");
		btnUpdateKhach.addActionListener(ac);

		JButton btnDeleteKhach = new JButton("Xóa");
		btnDeleteKhach.addActionListener(ac);
		featureKhach.add(btnUpdateKhach);
		featureKhach.add(btnDeleteKhach);
		jpanelCenter = new JPanel();
		jpanelCenter.setLayout(new BorderLayout());
		jpanelCenter.add(featureKhach, BorderLayout.EAST);

		scrollPaneKhach = new JScrollPane(tableKhach);
		header.add(formSearch, BorderLayout.NORTH);
		header.add(scrollPaneKhach, BorderLayout.CENTER);
		this.add(header, BorderLayout.NORTH);
		this.add(jpanelCenter, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void xoaTableLich() {
		if (jpanelTableLich != null && jpanelSearch != null) {
			this.remove(jpanelTableLich);
			this.remove(jpanelSearch);
			this.revalidate();
			this.repaint();
		}
	}

	public void updateGuess() {
		formUpdateGuess();
	}

	public void formUpdateGuess() {
		updateGuess = new JPanel();

		JLabel labelMaKH = new JLabel("Mã khách hàng");
		JLabel labelTen = new JLabel("Họ và tên ");
		JLabel labelSdt = new JLabel("Số điện thoại");
		JLabel labelPhiDichVu = new JLabel("Phí dịch vụ");
		textFieldMaKH = new JTextField();
		textFieldHoTen = new JTextField();
		textFieldSdt = new JTextField();
		textFieldPhiDichVu = new JTextField();
		inputNameConfirm = new JTextField();
		inputSdtConfirm = new JTextField();
		JLabel lableEmpty = new JLabel("");
		luu = new JButton("Lưu");
		luu.addActionListener(ac);

		CustomerDTO kh = khDuocChon();
		textFieldMaKH.setText(kh.getMaKH());
		textFieldMaKH.setEditable(false);
		textFieldHoTen.setText(kh.getTenKh());
		textFieldSdt.setText(kh.getSdt() + "");
		textFieldPhiDichVu.setText(kh.getBills().get(0).getTotal() + "");

		updateGuess.setLayout(new GridLayout(5, 2, 20, 20));
		updateGuess.add(labelMaKH);
		updateGuess.add(textFieldMaKH);
		updateGuess.add(labelTen);
		updateGuess.add(textFieldHoTen);
		updateGuess.add(labelSdt);
		updateGuess.add(textFieldSdt);
		updateGuess.add(labelPhiDichVu);
		updateGuess.add(textFieldPhiDichVu);
		updateGuess.add(lableEmpty);
		updateGuess.add(luu);
		updateGuess.setPreferredSize(new Dimension(200, 200));
		jpanelCenter.add(updateGuess, BorderLayout.CENTER);
		this.setVisible(true);

	}

	public CustomerDTO khDuocChon() {
		DefaultTableModel modelTable = (DefaultTableModel) tableKhach.getModel();

		int row = tableKhach.getSelectedRow();
		String maKh = (modelTable.getValueAt(row, 0) + "").trim();
		String tenKh = (modelTable.getValueAt(row, 1) + "").trim();
		int sdt = Integer.valueOf((modelTable.getValueAt(row, 2) + "").trim());
		double phiDichVu = Double.valueOf((modelTable.getValueAt(row, 6) + "").trim());

		Appointment lh = new Appointment(tenKh, sdt);

		BillEntity bill = new BillEntity();
		bill.setTotal(phiDichVu);
		List<BillEntity> bills = new ArrayList<>();
		bills.add(bill);

		return new CustomerDTO(maKh, tenKh, sdt, bills);
	}

	public void updateTableGuess() {
		DefaultTableModel modelTable = (DefaultTableModel) tableKhach.getModel();
		int row = tableKhach.getSelectedRow();
		Long idBill = Long.valueOf((modelTable.getValueAt(row, 5) + "").trim());
		LocalDate ngay = LocalDate.now();
		String today = FormatDate.formatLocalDate(ngay);
		String maKh = textFieldMaKH.getText();
		String tenKH = textFieldHoTen.getText();
		int sdt = Integer.valueOf(textFieldSdt.getText());
		double phiDichVu = Double.valueOf(textFieldPhiDichVu.getText());
		Appointment lh = new Appointment(tenKH, sdt);
//		CustomerDTO kh = new CustomerDTO(maKh, lh, phiDichVu);
//		System.out.println(kh);
		System.out.println(lh);
//		this.model.update(kh);
		billDao.updateBill(idBill, phiDichVu);
		this.resetTable(tableKhach);
		this.insertDataKhach();
		jpanelCenter.remove(updateGuess);
		jpanelCenter.repaint();
	}

	public void deleteGuess() {
		DefaultTableModel modelTable = (DefaultTableModel) tableKhach.getModel();
		int row = tableKhach.getSelectedRow();
		Long idBill = Long.valueOf((modelTable.getValueAt(row, 5) + "").trim());
		this.billDao.remove(idBill);
		this.resetTable(tableKhach);
		this.insertDataKhach();
	}

	public void xoaTableKhach() {
		if (jpanelCenter != null && scrollPaneKhach != null) {
			this.remove(jpanelCenter);
			this.remove(scrollPaneKhach);
			this.repaint();
		}
	}

	public void xoaTongKet() {
		if (jpanelDayTotal != null && formTongKet != null) {
			this.remove(jpanelDayTotal);
			this.remove(formTongKet);
			this.repaint();
		}
	}

	public void formTotalCost() {
		jpanelDayTotal = new JPanel();
		JLabel labelSelect = new JLabel("Ngày");
		ngayTongKet = new JComboBox<>();
		LocalDate now = LocalDate.now();
		ngayTongKet.addItem(now);
		for (int i = 1; i < 7; i++) {
			ngayTongKet.addItem(now.plusDays(-i));
		}
		JButton btnSelect = new JButton("chọn");
		btnSelect.addActionListener(ac);
		jpanelDayTotal.setLayout(new GridLayout(1, 3));
		jpanelDayTotal.add(labelSelect);
		jpanelDayTotal.add(ngayTongKet);
		jpanelDayTotal.add(btnSelect);
		formTongKet = new JPanel();
		formTongKet.setLayout(new BorderLayout());
		tableTongKet = new JTable();
		tableTongKet.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Mã khách hàng",
				"Họ tên khách", "Số điện thoại", "Ngày tạo", "Dịch vụ sử dụng", "Tiền dịch vụ" }));
		tongKet = new JLabel("Doanh thu: ", JLabel.RIGHT);
		tableTongKet.setPreferredScrollableViewportSize(new Dimension(800, 250));
		scrollPanelTongKet = new JScrollPane(tableTongKet);
		formTongKet.add(scrollPanelTongKet, BorderLayout.NORTH);
		formTongKet.add(tongKet, BorderLayout.CENTER);
		this.add(jpanelDayTotal, BorderLayout.NORTH);
		this.add(formTongKet, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void insertDataKhach(LocalDate ngay) {

		DefaultTableModel modelTable = (DefaultTableModel) tableTongKet.getModel();
		String today = ngay.toString();
		List<BillDTO> bills = billDao.findAllByCreateDate(today);
		if(bills != null) {
			bills.stream().forEach(bill -> {

				modelTable.addRow(new Object[] { bill.getCustomer().getMaKH() + "", bill.getCustomer().getTenKh() + "",
						bill.getCustomer().getSdt() + "", bill.getCreatedDate() + "", bill.getDichVu() + "",
						bill.getTotal() });
			});
			double total = 0;
			for (BillDTO bill : bills) {
				total += bill.getTotal();
			}
			tongTien(today, total);
		}
		
	}

	public void tongTien(String today, double total) {

		this.tongKet.setText("Doanh thu ngày " + today + ":    " + total);
	}

	public void totalCost() {
		this.removeService();
		System.out.println("doanh thu");
		this.xoaTableLich();
		this.xoaTableKhach();
		formTotalCost();
		insertDataKhach((LocalDate) this.ngayTongKet.getSelectedItem());

	}

	public void updateDoanhThu() {
		resetTable(tableTongKet);
		insertDataKhach((LocalDate) this.ngayTongKet.getSelectedItem());

	}

	public void movedPageCustomer() {
		this.removeService();
		this.xoaTableLich();
		this.xoaTableKhach();
		this.xoaTongKet();
		this.remove(optionCustomer);
		itemCustomer.setBackground(Color.GRAY);
		itemCustomer.setForeground(Color.WHITE);
		itemManager.setOpaque(true);
		itemManager.setBackground(UIManager.getColor("Menu.background"));
		itemManager.setForeground(UIManager.getColor("Menu.foreground"));
		this.init();
		this.setVisible(true);
	}

	public void showServicePage() {
		this.xoaTableLich();
		this.xoaTableKhach();
		this.xoaTongKet();
		formServce();
	}

	private void removeService() {
		if (jpanelCenterService != null && scrollPaneService != null) {
			this.remove(jpanelCenterService);
			this.remove(scrollPaneService);
			this.repaint();
		}
	}

	private void formServce() {
		tableService = new JTable();
		tableService.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Tên dịch vụ", "Giá" }));
		tableService.setPreferredScrollableViewportSize(new Dimension(800, 250));
		JPanel featureKhach = new JPanel();
		JButton addService = new JButton("Thêm dịch vụ");
		addService.addActionListener(ac);
		JButton btnUpdateKhach = new JButton("Chỉnh sửa dịch vụ");
		btnUpdateKhach.addActionListener(ac);

		JButton btnDeleteKhach = new JButton("Xóa dịch vụ");
		btnDeleteKhach.addActionListener(ac);
		featureKhach.add(addService);
		featureKhach.add(btnUpdateKhach);
		featureKhach.add(btnDeleteKhach);

		jpanelCenterService = new JPanel();
		jpanelCenterService.setLayout(new BorderLayout());
		jpanelCenterService.add(featureKhach, BorderLayout.EAST);

		scrollPaneService = new JScrollPane(tableService);
		insertService();
		this.add(scrollPaneService, BorderLayout.NORTH);
		this.add(jpanelCenterService, BorderLayout.CENTER);
		this.setVisible(true);

	}

	public void addService() {
		String tenDichvu = JOptionPane.showInputDialog(this, "Tên dịch vụ");
		double cost = Double.valueOf(JOptionPane.showInputDialog(this, "Giá dịch vụ"));
		if (tenDichvu.equals("")) {
			JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
			return;

		}
		ServiceEntity service = new ServiceEntity(tenDichvu, cost);
		long id = serviceDAO.saveEntity(service);
		if (id > 0) {
			JOptionPane.showMessageDialog(this, "Thêm dịch vụ");
		}

		resetTable(tableService);
		insertService();

	}

	private void insertService() {
		List<ServiceDTO> service = serviceDAO.findAll();

		DefaultTableModel modelTable = (DefaultTableModel) tableService.getModel();
		for (ServiceDTO c : service) {
			modelTable.addRow(new Object[] { c.getId() + "", c.getTenDv() + "", c.getCost() + "" });
		}
	}

	public void handleSearchCustomer() {
		resetTable(tableKhach);
		insertCustomer();

	}

	public void insertCustomer() {
		DefaultTableModel modelTable = (DefaultTableModel) tableKhach.getModel();
		List<BillDTO> bills = billDao.findByCustomerSdt(Integer.valueOf(inputSdtSearch.getText()));
		bills.stream().forEach(bill -> {
			modelTable.addRow(new Object[] { bill.getCustomer().getMaKH() + "", bill.getCustomer().getTenKh() + "",
					bill.getCustomer().getSdt() + "", bill.getCreatedDate() + "", bill.getDichVu() + "", bill.getId(),
					bill.getTotal() });
		});
	}

}
