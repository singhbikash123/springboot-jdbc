package com.java.codeganges.jdbc.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.codeganges.jdbc.dao.JDBCDao;
import com.java.codeganges.jdbc.vo.EmployeeVO;

@Service
public class JDBCServiceImpl implements JDBCService {

	@Autowired
	private JDBCDao jdbcDao;

	@Override
	public List<EmployeeVO> getEmployeeList() {
		List<Map<String, Object>> list = jdbcDao.getEmployeeList();
		List<EmployeeVO> employeeList = mapRow(list);
		return employeeList;

	}

	public List<EmployeeVO> mapRow(List<Map<String, Object>> list) {
		List<EmployeeVO> employeeList = new ArrayList<>();
		for (Map<String, Object> map : list) {
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setEmployeeId(((java.math.BigDecimal) map.get("EMPNO")).intValue());
			employeeVO.setName((String) map.get("ENAME"));
			employeeVO.setJob((String) map.get("JOB"));
			if (null != map.get("MGR")) {
				employeeVO.setManagerId(((java.math.BigDecimal) map.get("MGR")).intValue());
			}
			if (null != map.get("SAL")) {
				employeeVO.setSalary(((java.math.BigDecimal) map.get("SAL")).doubleValue());
			}
			if (null != map.get("COMM")) {
				employeeVO.setCommission(((java.math.BigDecimal) map.get("COMM")).doubleValue());
			}
			if (null != map.get("DEPTNO")) {
				employeeVO.setDepartmentNumber(((java.math.BigDecimal) map.get("DEPTNO")).intValue());
			}
			employeeVO.setHireDate(new SimpleDateFormat("MM-dd-yyyy").format(map.get("HIREDATE")));

			employeeList.add(employeeVO);
		}

		return employeeList;
	}

	public EmployeeVO getEmployee(int empID) {
		return jdbcDao.getEmployee(empID);

	}


	@Override
	public int getEmployeeCount() {
		return jdbcDao.getEmployeeCount();
	}

	public Map<String, Object> getEmployeeListForMap() {
		return jdbcDao.getEmployeeListForMap();
	}

	public Stream<EmployeeVO> getAllEmployeeStream(){
		return jdbcDao.getAllEmployeeStream();
	}

	@Override
	public EmployeeVO getEmployeeQueryForObject(int empID) {
		return jdbcDao.getEmployeeQueryForObject(empID);
	}

	@Override
	public List<EmployeeVO> getEmployeeListUsingQuery() {
		return jdbcDao.getEmployeeListUsingQuery();
	}

	@Override
	public int addEmployee(EmployeeVO employee) {
		return jdbcDao.addEmployee(employee);
	}

	@Override
	public int updateEmployeeName(String name, int empID) {
		return jdbcDao.updateEmployeeName(name, empID);
	}

	@Override
	public int deleteEmployee(int empID) {
		return jdbcDao.deleteEmployee(empID);
	}

	@Override
	public int addUpdateEmployee(EmployeeVO employee) {
		return jdbcDao.addUpdateEmployee(employee);
	}
}
