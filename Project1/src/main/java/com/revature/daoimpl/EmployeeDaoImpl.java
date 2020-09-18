/**
 * 
 */
package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

/**
 * @author Abdalla Hablas
 * @date Sep 10, 2020
 */
public class EmployeeDaoImpl implements EmployeeDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	private ArrayList<Employee> empList = new ArrayList<>();

	// get employee by ID number
	// -------------------------------------------------------------------------------------------------
	@Override
	public Employee getEmployeeByID(int id) throws SQLException {

		Connection con = cf.getConnection();
		String sql = "select * from \"employee\" where \"employeeiid\"=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Employee employ = null;
		while (rs.next()) {
			employ = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11),
					rs.getInt(12), rs.getString(13));
		}
		return employ;
	}

	// get employee by Username
	// -------------------------------------------------------------------------------------------------
	@Override
	public Employee getEmployeeByUsername(String username) throws SQLException {

		Connection con = cf.getConnection();
		String sql = "select * from \"employee\" where \"username\"=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Employee employ = null;
		while (rs.next()) {
			employ = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11),
					rs.getInt(12), rs.getString(13));
		}
		return employ;
	}

	// get a list of All employee
	// -------------------------------------------------------------------------------------------------
	@Override
	public ArrayList<Employee> getAllEmployees() throws SQLException {

		Connection con = cf.getConnection();
		String sql = "select * from \"employee\"";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Employee employ = null;
		while (rs.next()) {
			employ = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11),
					rs.getInt(12), rs.getString(13));
			empList.add(employ);
		}
		return empList;
	}
}
