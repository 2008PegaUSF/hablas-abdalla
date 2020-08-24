/**
 * 
 */
package myPackage;

/**
 * @author Abdalla Hablas
 * @date Aug 20, 2020
 */
public class Employee  {
	
	private String name;
	private String department;
	private int age;
	
	// constructor 
	public Employee (String name, String department, int age) {
		this.age = age;
		this.name = name;
		this.department = department;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
}
