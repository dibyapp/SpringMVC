package com.dib.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientCommand {

	public PatientCommand() {
		System.out.println("PatientCommand.PatientCommand()");
	}
	private String patName;
	private int age;
	private String location;
	private String hospital;
	private String vflag="no";
	
	
}
