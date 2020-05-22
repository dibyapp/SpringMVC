package com.dib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dib.dto.EmployeeDTO;
import com.dib.entity.Employee;
import com.dib.repository.EmployeeRepository;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public int getPagesCount(int size) {
		int pagesCount=0;
		int recordsCount=0;

		recordsCount=(int) repository.count();
		pagesCount=(recordsCount/size);

		if(recordsCount%pagesCount==0)
			return pagesCount;
		else
			return pagesCount++;
	}

	@Override
	public List<EmployeeDTO> getPageData(int pageNo, int pageSize) {
		Pageable pagable=null;
		Page<Employee> page=null;
		List<Employee> listEntities=null;
		List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();
		pagable=PageRequest.of(pageNo, pageSize,Sort.by("ename").ascending());

		page=repository.findAll(pagable);

		listEntities=page.getContent();
		listEntities=page.get().collect(Collectors.toList()); //Java 8 Stream API

		listEntities.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
