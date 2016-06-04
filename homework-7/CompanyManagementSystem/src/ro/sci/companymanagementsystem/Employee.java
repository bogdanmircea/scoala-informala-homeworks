package ro.sci.companymanagementsystem;

import java.util.Comparator;

/**
 * The employee class is where we have our Employee created.
 * 
 * 
 * @author Bobo
 *
 */

class Employee implements Comparable<Employee> {

	private String name;
	private int yearsInCompany;
	private String role;
	private boolean parking;

	/**
	 * The employee constructor has the next parameters:
	 * 
	 * @param name
	 *            is a String which is the name of the employee.
	 * @param yearsInCompany
	 *            is a Integer. We use an Integer to simplify the complexity of
	 *            our problem. It represents the years of the employee in the
	 *            company
	 * @param role
	 *            is a String which represents the role of our employee. For
	 *            this application we can have only "manager" or "junior"
	 * @param parking
	 *            is a boolean that tells us if the employee has or has not a
	 *            parking.
	 */
	public Employee(String name, int yearsInCompany, String role, boolean parking) {
		this.name = name;
		this.yearsInCompany = yearsInCompany;
		this.role = role;
		this.parking = parking;

	}

	public Employee() {
	}

	public String getName() {

		return name;
	}

	public int getYearsInCompany() {

		return yearsInCompany;
	}

	public String getRole() {

		return role;
	}

	public boolean hasParking() {

		return parking;
	}

	/**
	 * The Seniority Comparator helps us to sort the employee's after how many
	 * years they have worked in the company.
	 */
	public static Comparator<Employee> Seniority = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o2.yearsInCompany - o1.yearsInCompany;
		}
	};

	@Override
	public int compareTo(Employee o) {
		return (this.name).compareTo(o.name);
	}
}
