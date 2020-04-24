package com.dib.services;

import java.util.Calendar;

public class WishServiceImpl implements WishService {

	@Override
	public String generateWishMessage() {

		Calendar calender=null;
		int hour=0;
		String msg=null;
		
		calender=Calendar.getInstance();
		hour=calender.get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)
			msg="Good Moring";
		else if(hour<16)
			msg="Good Afternoon";
		else if(hour<20)
			msg="Good Evening";
		else
			msg="Good Night";
		
		return msg;
		
	}

}
