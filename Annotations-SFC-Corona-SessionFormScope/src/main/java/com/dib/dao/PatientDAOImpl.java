package com.dib.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dib.bo.PatientBO;

@Repository
public class PatientDAOImpl implements PatientDAO {

	private static final String QUERY="INSERT INTO CORONA VALUEs (?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int insert(PatientBO bo) {
		int count=0;
		count=jt.update(QUERY, bo.getPatName(), bo.getAge(), bo.getLocation(), bo.getHospital());
		return count;
	}

}
