package com.dib.command;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientCommand {

	public PatientCommand()
	{
		System.out.println("PatientCommand.PatientCommand()");
	}
	
	@NotEmpty(message="patient name is required(d)")
	private String patName;
	
	@NotNull(message="patient age is required(d)")
	@Range(min=1,max=100,message="patient age must be  through 100(d)")
	private int age;
	
	@NotEmpty(message="patient location is required(d)")
	private String location;
	
	@NotEmpty(message="patient hospital is required(d)")
	@Length(min=3, max=12, message="patient hospital name must have min 3 and max of 2 chars")
	private String hospital;
	private String vflag="no";
	
	
}
