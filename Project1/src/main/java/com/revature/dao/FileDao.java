/**
 * 
 */
package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.File;

/**
 * @author Abdalla Hablas
 * @date Sep 14, 2020
 */
public interface FileDao {

	

	/**
	 * @param file
	 * @throws SQLException
	 */
	void uploadFile(File file) throws SQLException;
}
