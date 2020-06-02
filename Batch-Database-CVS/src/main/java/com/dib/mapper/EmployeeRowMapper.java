package com.dib.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dib.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = null;
		employee = new Employee();
		employee.setEmpNo(rs.getInt("eno"));
		employee.setEname(rs.getString("ename"));
		employee.setJob(rs.getString("job"));
		employee.setSalary(rs.getFloat("salary"));
		employee.setDeptNo(rs.getInt("deptno"));
		
		return employee;
	}

}
