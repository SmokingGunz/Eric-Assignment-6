package com.coderscampus;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Sales {

	private YearMonth date;
	private Integer sale;

	public Sales(String date, String sales) {
		this.date = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy"));
		this.sale = Integer.parseInt(sales);

	}
 
	public YearMonth getDate() {
		return date;
	}

	public void setDate(YearMonth date) {
		this.date = date;
	}

	public int getSales() {
		return sale;
	}

	public void setSales(int sales) {
		this.sale = sales;

	}

	@Override
	public String toString() {
		return "Sales [date=" + date + ", sales=" + sale + "]";
	}

}
