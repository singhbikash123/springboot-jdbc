package com.java.codeganges.jdbc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.codeganges.jdbc.service.JDBCService;
import com.java.codeganges.jdbc.vo.EmployeeVO;

import jakarta.websocket.server.PathParam;

@RestController
public class JDBCController {
	
	@Autowired
	private JDBCService jdbcService;
	
	@GetMapping("employee/all")
	public List<EmployeeVO> getAllEmployeeList() {
		return this.jdbcService.getEmployeeList();
	}
	
	
	@GetMapping("/employee/{empID}")
	public EmployeeVO getEmployee(@PathVariable int empID) {
		return this.jdbcService.getEmployee(empID);
	}

	
	@GetMapping("/employee/count")
	public int getEmployeeCount() {
		return this.jdbcService.getEmployeeCount();
	}
	

	@GetMapping("/employee/map")
	public  Map<String,Object> getEmployeeListForMap() {
		return this.jdbcService.getEmployeeListForMap();
	}
	
	@GetMapping(value = "employee/stream")
	public Stream<EmployeeVO> getAllEmployeeStream() {
		return this.jdbcService.getAllEmployeeStream();
	}
	
	@GetMapping(value = "employee/object/{empID}")
	public EmployeeVO getEmployeeQueryForObject(@PathVariable int empID) {
		return this.jdbcService.getEmployeeQueryForObject(empID);
	}
	
	@GetMapping(value = "employee/listq")
	public List<EmployeeVO> getEmployeeListUsingQuery(){
		return jdbcService.getEmployeeListUsingQuery();
	}
	
	@PostMapping(value = "employee/add")
	public int addEmployee(@RequestBody EmployeeVO employee) {
		return jdbcService.addEmployee(employee);
	}
	
	@PutMapping(value = "employee/update/{empID}")
	public int updateEmployeeName(@PathParam(value = "name") String name,@PathVariable(value = "empID") int empID) {
		return jdbcService.updateEmployeeName(name,empID);
	}
	
	@DeleteMapping(value = "employee/delete/{empID}")
	public int deleteEmployee(@PathVariable(value = "empID") int empID) {
		return jdbcService.deleteEmployee(empID);
	}
	
	
	@PutMapping(value = "employee/put")
	public int addUpdateEmployee(@RequestBody EmployeeVO employee) {
		return jdbcService.addUpdateEmployee(employee);
	}
	
	
	
}
