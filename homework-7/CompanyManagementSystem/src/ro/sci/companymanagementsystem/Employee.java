package ro.sci.companymanagementsystem;

import java.util.Comparator;

class Employee implements Comparable<Employee> {

	public static Comparator<Employee> Seniority = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o2.yearsInCompany - o1.yearsInCompany;
		}
	};
	private String name;
	private int yearsInCompany;
	private String role;
	private boolean parking;

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

	public int getYearsInCompany() throws WrongYearsOfWorkException {
		if (yearsInCompany <= 0) {
			throw new WrongYearsOfWorkException("\n\nYou have to work more, " + getName() + "\n");
		}
		else
			return yearsInCompany;
	}

	public String getRole() throws WrongRoleException {
		if (role != "manager" && role != "junior") {
			throw new WrongRoleException("\n\nRole is not good for " + getName() + "\n");
		}
		else
			return role;
	}

	public boolean hasParking() {
		return parking;
	}

	@Override
	public int compareTo(Employee o) {
		return (this.name).compareTo(o.name);
	}

}
