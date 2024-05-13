package com.java.codeganges.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.codeganges.jdbc.vo.EmployeeVO;

public class EmployeeRowMapper implements org.springframework.jdbc.core.RowMapper<EmployeeVO> {

	@Override
	public EmployeeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmployeeId(rs.getInt("EMPNO"));
		employeeVO.setName(rs.getString("ENAME"));
		employeeVO.setJob(rs.getString("JOB"));
		employeeVO.setManagerId(rs.getInt("MGR"));
		employeeVO.setHireDate(rs.getString("HIREDATE"));
		employeeVO.setSalary(rs.getDouble("SAL"));
		employeeVO.setCommission(rs.getDouble("COMM"));
		employeeVO.setDepartmentNumber(rs.getInt("DEPTNO"));
		return employeeVO;
	}

}
