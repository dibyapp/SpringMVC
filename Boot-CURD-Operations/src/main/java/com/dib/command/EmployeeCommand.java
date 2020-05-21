package com.dib.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeCommand {
	private int empNo;
	private String ename;
	private String job;
	private float salary;
	private int deptNo;
}
