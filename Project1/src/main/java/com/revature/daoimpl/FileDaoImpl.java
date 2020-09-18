/**
 * 
 */
package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.File;
import com.revature.dao.FileDao;
import com.revature.util.ConnFactory;

/**
 * @author Abdalla Hablas
 * @date Sep 14, 2020
 */
public class FileDaoImpl implements FileDao {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void uploadFile(File file) throws SQLException {

		Connection con = cf.getConnection();
		String sql = "insert into \"file\" values (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		if (file != null) {
		
			ps.setBytes(1, file.getFile());
		}
		ps.executeUpdate();
	}

	
}
