/**
 * 
 */
package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Request;
import com.revature.dao.ReimbursementDao;
import com.revature.util.ConnFactory;

/**
 * @author Abdalla Hablas
 * @date Sep 11, 2020
 */
public class ReimbursementDaoImpl implements ReimbursementDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	private ArrayList<Request> req = new ArrayList<Request>();

	// get list of requests from DB by employeeID
	// -------------------------------------------------------------------------------------------------
	@Override
	public ArrayList<Request> getAllRequestByEmployeeId(int id) throws SQLException {

		Connection con = cf.getConnection();
		String sql = "select * from \"request\" where \"employeeid\"=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Request r = null;
		while (rs.next()) {
			r = new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
					rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9));
			req.add(r);
		}
		return req;
	}

	// get list of requests from DB by admin title
	// -------------------------------------------------------------------------------------------------
	@Override
	public ArrayList<Request> getAllRequestByAdmin(int title) throws SQLException {

		Connection con = cf.getConnection();
		String sql = "select requestid, request.employeeid, requesttype, requestdate, coursedate, amount, status, coursename, coursedescription, lastname, firstname, balance from request inner join employee on employee.employeeid = request.employeeid where reportsto=? order by employee.employeeid";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, title);
		ResultSet rs = ps.executeQuery();
		Request r = null;
		while (rs.next()) {
			r = new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
					rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
					rs.getString(11), rs.getDouble(12));
			req.add(r);
		}
		return req;
	}

	// get list of requests from DB by Benefits Coordinator
	// -------------------------------------------------------------------------------------------------
	@Override
	public ArrayList<Request> getAllRequestBybenfitCord(String status) throws SQLException {

		Connection con = cf.getConnection();
		String sql = "select requestid, request.employeeid, requesttype, requestdate, coursedate, amount, status, coursename, coursedescription, lastname, firstname, balance from request inner join employee on employee.employeeid = request.employeeid  where request.status=? order by employee.employeeid";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, status);
		ResultSet rs = ps.executeQuery();
		Request r = null;
		while (rs.next()) {
			r = new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
					rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
					rs.getString(11), rs.getDouble(12));
			req.add(r);
		}
		
		String sql2 = "select requestid, request.employeeid, requesttype, requestdate, coursedate, amount, status, coursename, coursedescription, lastname, firstname, balance from request inner join employee on employee.employeeid = request.employeeid  where request.status=? order by employee.employeeid;";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setString(1, "approved");
		ResultSet rs2 = ps.executeQuery();
		Request r2 = null;
		while (rs2.next()) {
			r2 = new Request(rs2.getInt(1), rs2.getInt(2), rs2.getString(3), rs2.getDate(4), rs2.getDate(5),
					rs2.getDouble(6), rs2.getString(7), rs2.getString(8), rs2.getString(9), rs2.getString(10),
					rs2.getString(11), rs2.getDouble(12));
			req.add(r2);
		}
		
		return req;
	}

	// save new request to DB
	// -------------------------------------------------------------------------------------------------
	@Override
	public boolean addRequest(Request req) throws SQLException {

		Connection conn = cf.getConnection(); // connecting to database
		String sql = "insert into \"request\" values (nextval('requestseq'),?,?,?,?,?,?,?,?)"; // query
		// send the query to the database
		PreparedStatement ps = conn.prepareStatement(sql);
		// ps.setInt(1, req.getrequestid()); // request id is auto populated in DB
		ps.setInt(1, req.getemployeeid());
		ps.setString(2, req.getrequesttype());
		ps.setDate(3, req.getrequestdate());
		ps.setDate(4, req.getcoursedate());
		ps.setDouble(5, req.getAmount());
		ps.setString(6, req.getStatus());
		ps.setString(7, req.getCoursename());
		ps.setString(8, req.getCoursedescription());
		ps.executeUpdate(); // execute query
		return true;
	}

	// Update request status and balance if approved
	// -------------------------------------------------------------------------------------------------
	@Override
	public boolean updateRequestStatus(Request req) throws SQLException {

		Connection conn = cf.getConnection(); // connecting to database
		String sql = "update \"request\" set \"status\"=? where \"requestid\"=?"; // query
		// send the query to the database
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(2, req.getrequestid()); // request id is auto populated in DB
		ps.setString(1, req.getStatus());
		ps.executeUpdate(); // execute query
		
		// update balance if status is approved
		if(req.getStatus().equals("approved")) {
			String sql3 = "update \"employee\" set \"balance\"=? where \"employeeid\"=?"; // query to update balance
			String sql2 = "select balance from employee where employeeid=?"; // query to get balance
			// get balance first
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, req.getemployeeid());
			ResultSet rs = ps2.executeQuery();
			double balance;
			rs.next();
			balance = rs.getDouble(1);
			balance = balance- req.getAmount();
			// update balance
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setDouble(1, balance);
			ps3.setInt(2, req.getemployeeid());
			ps3.executeUpdate(); // execute query
		}
		return true;
	}

}
