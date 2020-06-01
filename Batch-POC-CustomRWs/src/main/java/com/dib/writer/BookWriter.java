package com.dib.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class BookWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		
		System.out.println("BookWriter.write()");
		System.out.println(items);
	}
 
}
