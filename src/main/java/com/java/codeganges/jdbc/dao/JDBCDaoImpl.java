package com.java.codeganges.jdbc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.codeganges.jdbc.rowmapper.EmployeeRowMapper;
import com.java.codeganges.jdbc.vo.EmployeeVO;

@Repository
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getEmployeeList() {
		List<Map<String, Object>> list = jdbcTemplate
				.queryForList("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP");
		return list;

	}

	public EmployeeVO getEmployee(int empID) {
		EmployeeVO employee = this.jdbcTemplate.queryForObject(
				"SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP WHERE EMP.EMPNO= ?",
				new EmployeeRowMapper(), empID);
		return employee;
	}

	public int getEmployeeCount() {
		int employeeCount = this.jdbcTemplate.queryForObject("SELECT COUNT(EMPNO) FROM EMP", Integer.class);
		return employeeCount;
	}
	
	public List<EmployeeVO> getEmployeeQueryForList() {
		List<EmployeeVO> list = jdbcTemplate
				.queryForList("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP",EmployeeVO.class);
		return list;

	}
	
	public Map<String,Object> getEmployeeListForMap(){
		return jdbcTemplate.queryForMap("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP WHERE EMPNO=7876");
	}

	@Override
	public Stream<EmployeeVO> getAllEmployeeStream() {
		return jdbcTemplate.queryForStream("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP", new EmployeeRowMapper());
	}
	
	public EmployeeVO getEmployeeQueryForObject(int empID) {
		return jdbcTemplate.queryForObject("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP WHERE EMP.EMPNO= ?", new EmployeeRowMapper(), empID);
		
	}
	
	public List<EmployeeVO> getEmployeeListUsingQuery(){
		 return jdbcTemplate.query("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP", new EmployeeRowMapper());
		
	}

	@Override
	public int addEmployee(EmployeeVO employee) {
		return jdbcTemplate.update("INSERT INTO EMP VALUES (?, ?, ?, ?, ?, ?, ?, ?)", employee.getEmployeeId(),employee.getName(),employee.getJob(),employee.getManagerId(),getDate(employee.getHireDate()),employee.getSalary(),employee.getCommission(),employee.getDepartmentNumber());
	}

	public Date getDate(String inputDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date date =null;
		try {
			date = formatter.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public int updateEmployeeName(String name, int empID) {
		int updateCount = 0;
		int employeeCount = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMP WHERE EMPNO =?", Integer.class, empID);
		if(employeeCount>0) {
			updateCount = jdbcTemplate.update("UPDATE EMP SET ENAME =? WHERE EMPNO= ?",name,empID);
		}
		else {
			System.out.println("Employee id not found");
		}
		return updateCount;
	}
	
	
	
	public int deleteEmployee(int empID) {
		int deleteCount = 0;
		int employeeCount = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMP WHERE EMPNO =?", Integer.class, empID);
		if(employeeCount>0) {
			deleteCount = jdbcTemplate.update("DELETE FROM EMP WHERE EMP.EMPNO = ?",empID);
		}
		else {
			System.out.println("Employee id not found");
		}
		return deleteCount;
	}

	@Override
	public int addUpdateEmployee(EmployeeVO employee) {
		int updateCount = 0;
		int employeeCount = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMP WHERE EMPNO =?", Integer.class, employee.getEmployeeId());
		if(employeeCount>0) {
			updateCount = jdbcTemplate.update("UPDATE EMP SET ENAME =?,JOB =?,MGR =?,HIREDATE =?, SAL =?, COMM=?, DEPTNO=? WHERE EMPNO=?",employee.getName(),employee.getJob(),employee.getManagerId(),getDate(employee.getHireDate()),employee.getSalary(),employee.getCommission(),employee.getDepartmentNumber(),employee.getEmployeeId());
		}
		else {
			updateCount =jdbcTemplate.update("INSERT INTO EMP VALUES (?, ?, ?, ?, ?, ?, ?, ?)", employee.getEmployeeId(),employee.getName(),employee.getJob(),employee.getManagerId(),getDate(employee.getHireDate()),employee.getSalary(),employee.getCommission(),employee.getDepartmentNumber());
		}
		return updateCount;
	}
	
}
