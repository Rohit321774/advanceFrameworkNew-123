package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random=new Random();
		int randomNumber=random.nextInt(1000);
		return randomNumber;
	}

	public String getSystemDate() {
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String Date=sim.format(date);
		return Date;
	}
	
	public String getRequireDate(int days) {
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String Date=sim.format(date);
		       Calendar  cal=sim.getCalendar();
		                  cal.add(Calendar.DAY_OF_MONTH,days);
		                      String Data=sim.format(cal.getTime());
	 return Data;
	}
}
