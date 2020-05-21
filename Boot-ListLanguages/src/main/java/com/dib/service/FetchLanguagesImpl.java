package com.dib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service("langService")
public class FetchLanguagesImpl implements FetchLanguages {

	@Override
	public List<String> fetchAllLanguages() {
		Locale locales[]=null;
		List<String> langList=null;
		
		locales=Locale.getAvailableLocales();
		langList=new ArrayList<String>();
		
		for(Locale l : locales)
		{
			langList.add(l.getDisplayLanguage());
		}
		
		return langList;
	}

}
