package com.dib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.dib.bo.EmployeeBO;

@Repository("/empDAO")
public class EmployeeDAOImpl implements EmployeeDAO
{
	private static final String QUERY="SELECT ENO,ENAME,JOB,SALARY,DEPTNO FROM EMP";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<EmployeeBO> getAllEmployees() 
	{
		List<EmployeeBO> listBO=null;
		listBO=jt.query(QUERY, new ResultSetExtractor<List<EmployeeBO>>() {

			@Override
			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeBO> listBO = null;
				EmployeeBO bo = null;
				listBO=new ArrayList<EmployeeBO>();
				while(rs.next())
				{
					bo=new EmployeeBO();
					bo.setEmpNo(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSalary(rs.getFloat(4));
					bo.setDeptNo(rs.getInt(5));
					listBO.add(bo);
				}
				
				return listBO;
			}
			
		});
		return listBO;
	}
}
