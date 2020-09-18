/**
 * 
 */
package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Request;

/**
 * @author Abdalla Hablas
 * @date Sep 11, 2020
 */
public interface ReimbursementDao {

	public ArrayList<Request> getAllRequestByEmployeeId(int id) throws SQLException;

	public ArrayList<Request> getAllRequestByAdmin(int title) throws SQLException;

	public ArrayList<Request> getAllRequestBybenfitCord(String status) throws SQLException;

	public boolean addRequest(Request req) throws SQLException;

	boolean updateRequestStatus(Request req) throws SQLException;

}
