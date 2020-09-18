/**
 * 
 */
package com.revature.beans;

import java.sql.Date;


/**
 * @author Abdalla Hablas
 * @date Sep 11, 2020
 */
public class Request {

	private int requestid;
	private int employeeid;
	private String requesttype;
	private Date requestdate;
	private Date coursedate;
	private Double amount;
	private String status;
	private String coursename;
	private String coursedescription;
	private String lastname;
	private String firstname;
	private Double balance;
	
	
	/**
	 * 
	 */
	public Request() {
		super();

	}

	/**
	 * @param requestid
	 * @param employeeid
	 * @param requesttype
	 * @param requestdate
	 * @param coursedate
	 * @param amount
	 * @param status
	 */
	public Request(int requestid, int employeeid, String requesttype, Date requestdate, Date coursedate,
			Double amount, String status,String coursename,String coursedescription) {
		super();
		this.requestid = requestid;
		this.employeeid = employeeid;
		this.requesttype = requesttype;
		this.requestdate = requestdate;
		this.coursedate = coursedate;
		this.amount = amount;
		this.status = status;
		this.coursename = coursename;
		this.coursedescription = coursedescription;
	}

	/**
	 * 
	 * @param requestid
	 * @param employeeid
	 * @param requesttype
	 * @param requestdate
	 * @param coursedate
	 * @param amount
	 * @param status
	 * @param lastname
	 * @param firstname
	 * @param balance
	 */
	public Request(int requestid, int employeeid, String requesttype, Date requestdate, Date coursedate,
			Double amount, String status,String coursename,String coursedescription, String lastname, String firstname, Double balance) {
		this(requestid, employeeid, requesttype, requestdate, coursedate, amount, status, coursename,coursedescription);
		this.lastname = lastname;
		this.firstname = firstname;
		this.balance = balance;
	}

	/**
	 * @return the requestid
	 */
	public int getrequestid() {
		return requestid;
	}

	/**
	 * @param requestid the requestid to set
	 */
	public void setrequestid(int requestid) {
		this.requestid = requestid;
	}

	/**
	 * @return the employeeid
	 */
	public int getemployeeid() {
		return employeeid;
	}

	/**
	 * @param employeeid the employeeid to set
	 */
	public void setemployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	/**
	 * @return the requesttype
	 */
	public String getrequesttype() {
		return requesttype;
	}

	/**
	 * @param requesttype the requesttype to set
	 */
	public void setrequesttype(String requesttype) {
		this.requesttype = requesttype;
	}

	/**
	 * @return the requestdate
	 */
	public Date getrequestdate() {
		return requestdate;
	}

	/**
	 * @param requestdate the requestdate to set
	 */
	public void setrequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	/**
	 * @return the coursedate
	 */
	public Date getcoursedate() {
		return coursedate;
	}

	/**
	 * @param coursedate the coursedate to set
	 */
	public void setcoursedate(Date coursedate) {
		this.coursedate = coursedate;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amoount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * @return the coursename
	 */
	public String getCoursename() {
		return coursename;
	}

	/**
	 * @param coursename the coursename to set
	 */
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	/**
	 * @return the coursedescription
	 */
	public String getCoursedescription() {
		return coursedescription;
	}

	/**
	 * @param coursedescription the coursedescription to set
	 */
	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}

	@Override
	public String toString() {
		return "Request [requestid=" + requestid + ", employeeid=" + employeeid + ", requesttype=" + requesttype
				+ ", requestdate=" + requestdate + ", coursedate=" + coursedate + ", amount=" + amount + ", status="
				+ status + ", coursename=" + coursename + ", coursedescription=" + coursedescription + ", lastname="
				+ lastname + ", firstname=" + firstname + ", balance=" + balance + "]";
	}
}
