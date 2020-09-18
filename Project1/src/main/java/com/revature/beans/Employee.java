package com.revature.beans;

import java.io.Serializable;

public class Employee implements Serializable{


	private static final long serialVersionUID = -9034860264018131186L;
	
	private int employeeid;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private int title;
	private int reportsto;
	private String balance;
	
	public Employee() {
		super();
		
	}

	/**
	 * @param employeeid
	 * @param username
	 * @param password
	 * @param email
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param title
	 * @param reportsto
	 * @param balance
	 */
	public Employee(int employeeid, String username, String password, String email, String firstname, String lastname,
			String address, String city, String state, String zipcode, int title, int reportsto, String balance) {
		super();
		this.employeeid = employeeid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.title = title;
		this.reportsto = reportsto;
		this.balance = balance;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeid;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeid = employeeId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstname
	 */
	public String getfirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getlastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipcode
	 */
	public String getzipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setzipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the title
	 */
	public int getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(int title) {
		this.title = title;
	}

	/**
	 * @return the reportsto
	 */
	public int getreportsto() {
		return reportsto;
	}

	/**
	 * @param reportsto the reportsto to set
	 */
	public void setreportsto(int reportsto) {
		this.reportsto = reportsto;
	}

	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeid + ", username=" + username + ", password=" + password + ", email="
				+ email + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + ", title=" + title + ", reportsto=" + reportsto
				+ ", balance=" + balance + "]";
	}

}
