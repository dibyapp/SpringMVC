package com.dib.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguagesHandler implements Handler {

	@Override
	public String handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Locale locales[]=null;
		List<String> langList=null;
		
		locales=Locale.getAvailableLocales();
		langList=new ArrayList();
		
		for(Locale l:locales) {
			langList.add(l.getDisplayLanguage());
		}
		req.setAttribute("result", langList);
		
		return "disp_lang";
	}

}
