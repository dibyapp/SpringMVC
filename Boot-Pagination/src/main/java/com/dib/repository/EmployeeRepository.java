package com.dib.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dib.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

}
