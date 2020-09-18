package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.beans.Employee;

public interface EmployeeDao {

	public Employee getEmployeeByID(int id) throws SQLException;

	public List<Employee> getAllEmployees() throws SQLException;

	public Employee getEmployeeByUsername(String username) throws SQLException;
}
