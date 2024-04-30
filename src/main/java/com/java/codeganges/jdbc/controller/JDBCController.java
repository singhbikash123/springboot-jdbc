package com.java.codeganges.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.codeganges.jdbc.service.JDBCService;
import com.java.codeganges.jdbc.vo.EmployeeVO;

@RestController
public class JDBCController {
	
	@Autowired
	private JDBCService jdbcService;
	
	@GetMapping("/all")
	public List<EmployeeVO> getAllEmployeeList() {
		return this.jdbcService.getEmployeeList();
	}

}
