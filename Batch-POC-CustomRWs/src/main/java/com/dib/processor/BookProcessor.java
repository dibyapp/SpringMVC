package com.dib.processor;

import org.springframework.batch.item.ItemProcessor;

public class BookProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		
		System.out.println("BookProcessor.process()");
		
		if (item.equalsIgnoreCase("Complete Reference Java"))
			return item+" by DIB";
		else if (item.equalsIgnoreCase("Head First"))
			return item+" by Ayesha";
		else if (item.equalsIgnoreCase("Think Java"))
			return item+" by Hijabi";
		else if (item.equalsIgnoreCase("Core Java"))
			return item+" by AJ";
		else if (item.equalsIgnoreCase("OCJP Java"))
			return item+" by Urmi";
		
		return null;
	}

}
