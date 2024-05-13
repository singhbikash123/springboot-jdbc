package com.java.codeganges.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.RequestBody;

import com.java.codeganges.jdbc.vo.EmployeeVO;

public interface JDBCDao {
	
	public List<Map<String, Object>> getEmployeeList();
	
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
