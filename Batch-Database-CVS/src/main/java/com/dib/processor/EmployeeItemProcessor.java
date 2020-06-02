package com.dib.processor;

import org.springframework.batch.item.ItemProcessor;

import com.dib.model.Employee;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getSalary()>10000)
			return item;
		else
			return null;
	}

}
