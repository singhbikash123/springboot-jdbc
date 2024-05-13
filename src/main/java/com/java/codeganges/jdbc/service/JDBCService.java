package com.java.codeganges.jdbc.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.java.codeganges.jdbc.vo.EmployeeVO;

public interface JDBCService {
	
	public List<EmployeeVO> getEmployeeList();
	
	public EmployeeVO getEmployee(int empID);
	
	public int getEmployeeCount();
	
	public Map<String,Object> getEmployeeListForMap();
	
	public Stream<EmployeeVO> getAllEmployeeStream();
	
	public EmployeeVO getEmployeeQueryForObject(int empID);
	
	public List<EmployeeVO> getEmployeeListUsingQuery();
	
	public int addEmployee(EmployeeVO employee);
	
	public int updateEmployeeName(String name, int empID);
	
	public int deleteEmployee(int empID);
	
	public int addUpdateEmployee(EmployeeVO employee);
}
