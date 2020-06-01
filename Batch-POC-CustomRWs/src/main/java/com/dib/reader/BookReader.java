package com.dib.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import lombok.Setter;

@Setter
public class BookReader implements ItemReader<String> {

	private List<String>  books;
	private int count = 0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		System.out.println("BookReader.read()");
		
		if(count!=5) 
			return books.get(count++);
		
		return null;
	}

}
