package com.dib.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageGeneratorController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
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
		
		
		return new ModelAndView("result", "resMg", msg);
	}

}
