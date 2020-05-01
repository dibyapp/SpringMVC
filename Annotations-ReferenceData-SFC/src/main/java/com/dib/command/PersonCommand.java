package com.dib.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonCommand {

	public PersonCommand() {
		System.out.println("PersonCommand.PersonCommand()");
	}
	private String name;
	private int age;
	private String gender;
	private String hobies[];
	private String courses[];
	private String qualification;
	
	
}
