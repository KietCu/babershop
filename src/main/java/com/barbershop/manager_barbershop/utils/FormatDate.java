package com.barbershop.manager_barbershop.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate {
	public static String formatLocalDate(LocalDate localDate) {
		String formattedDate = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
		return formattedDate;
	}
}
