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
	private static final String QUERYGETONE="SELECT ENO,ENAME,JOB,SALARY,DEPTNO FROM EMP WHERE ENO=?";
	private static final String UPDATE="UPDATE EMP SET ENAME=?,JOB=?,SALARY=?,DEPTNO=? WHERE ENO=?";
	private static final String DELETE="DELETE FROM EMP WHERE ENO=?";
	private static final String INSERT="INSERT INTO EMP VALUES(?,?,?,?,?)";

	
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

	@Override
	public EmployeeBO getEmp(int eno) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(QUERYGETONE, (rs,rownum)->{
			EmployeeBO bo1=null;
			bo1=new EmployeeBO();
			bo1.setEmpNo(rs.getInt(1));
			bo1.setEname(rs.getString(2));
			bo1.setJob(rs.getString(3));
			bo1.setSalary(rs.getFloat(4));
			bo1.setDeptNo(rs.getInt(5));
			return bo1;
		},eno);
		return bo;
	}

	@Override
	public int updateEmpByNo(EmployeeBO bo) {
		int count=0;
		count=jt.update(UPDATE, bo.getEname(),bo.getJob(),bo.getSalary(),bo.getDeptNo(),bo.getEmpNo());
		return count;
	}

	@Override
	public int deleteEmpByNo(int no) {
		int count=0;
		count=jt.update(DELETE,no);
		return count;
	}

	@Override
	public int insertEmployee(EmployeeBO bo) {
		int count=0;
		count=jt.update(INSERT, bo.getEmpNo(),bo.getEname(),bo.getJob(),bo.getSalary(),bo.getDeptNo());
		return count;
	}
}
