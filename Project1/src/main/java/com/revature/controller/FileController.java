/**
 * 
 */
package com.revature.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.revature.beans.File;
import com.revature.daoimpl.FileDaoImpl;

/**
 * @author Abdalla Hablas
 * @date Sep 14, 2020
 */
public class FileController {
	
	public static void uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		FileDaoImpl rdi = new FileDaoImpl();
		Part filePart = request.getPart("file");
		InputStream ip = filePart.getInputStream();
		File f = new File();
		f.setFilename(filePart.getName());
		System.out.println(filePart.getName());
		System.out.println(filePart.getSize());
		System.out.println(filePart.getContentType());
		byte[] bytes = IOUtils.toByteArray(ip);
		f.setFile(bytes);
		try {
			rdi.uploadFile(f);
			System.out.println("Request uploads to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
