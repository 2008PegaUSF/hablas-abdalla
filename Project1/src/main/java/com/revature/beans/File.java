/**
 * 
 */
package com.revature.beans;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Abdalla Hablas
 * @date Sep 13, 2020
 */
public class File implements Serializable{
	
	
	private static final long serialVersionUID = -7529997408539331207L;

	private byte[] file;
	private int fileid;
	private int requestid;
	private String filename;
	/**
	 * 
	 */
	public File() {
		super();
		
	}
	/**
	 * @param file
	 * @param fileid
	 * @param requestid
	 * @param filename
	 */
	public File(byte [] file, int fileid, int requestid, String filename) {
		super();
		this.file = file;
		this.fileid = fileid;
		this.requestid = requestid;
		this.filename = filename;
	}
	/**
	 * @return the file
	 */
	public byte [] getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(byte [] file) {
		this.file = file;
	}
	/**
	 * @return the fileid
	 */
	public int getFileid() {
		return fileid;
	}
	/**
	 * @param fileid the fileid to set
	 */
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	/**
	 * @return the requestid
	 */
	public int getRequestid() {
		return requestid;
	}
	/**
	 * @param requestid the requestid to set
	 */
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "File [file=" + Arrays.toString(file) + ", fileid=" + fileid + ", requestid=" + requestid + ", filename="
				+ filename + "]";
	}
}
