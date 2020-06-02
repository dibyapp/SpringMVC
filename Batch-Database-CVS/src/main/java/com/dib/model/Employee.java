package com.dib.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Employee {
	private int empNo;
	private String ename;
	private String job;
	private float salary;
	private int deptNo;
}
