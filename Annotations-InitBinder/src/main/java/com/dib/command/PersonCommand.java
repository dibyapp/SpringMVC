package com.dib.command;

import java.util.Date;

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
	private String gender="male";
	private String hobies[]= {"meditation"};
	private String courses[]={"java","oracle"};
	private String qualification="B.Tech";
	private Date dob;
	private Date doj;
	
	
}
