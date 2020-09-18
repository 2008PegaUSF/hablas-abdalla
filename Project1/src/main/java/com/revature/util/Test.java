/**
 * 
 */
package com.revature.util;

import java.sql.SQLException;

import com.revature.beans.Request;
import com.revature.daoimpl.ReimbursementDaoImpl;

/**
 * @author Abdalla Hablas
 * @date Sep 13, 2020
 */
public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		ReimbursementDaoImpl r = new ReimbursementDaoImpl();
		Request e = new Request();
		e.setAmount(100.00);
		e.setemployeeid(3);
		e.setrequestid(1059);
		e.setStatus("approved");
		
		System.out.println(r.updateRequestStatus(e));

	}

}
