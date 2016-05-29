package ro.sci.companymanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws WrongYearsOfWorkException, WrongRoleException {

		List<Employee> employeeList = new ArrayList<Employee>();
		List<Employee> managerList = new ArrayList<Employee>();
		List<Employee> juniorList = new ArrayList<Employee>();
		List<Employee> employeesWithParkings = new ArrayList<Employee>();
		List<Employee> employeesWithNoParkings = new ArrayList<Employee>();

		employeeList.add(new Employee("Marcel", 4, "manager", true));
		employeeList.add(new Employee("Cornel", 3, "junior", false));
		employeeList.add(new Employee("Andreea", 5, "junior", true));
		employeeList.add(new Employee("Sefa'", 9, "manager", false));
		employeeList.add(new Employee("Traian", 2, "junior", true));
		employeeList.add(new Employee("Mishu", 1, "junior", true));
		employeeList.add(new Employee("Valer", 7, "manager", false));
		employeeList.add(new Employee("Mihai", 3, "manager", true));
		employeeList.add(new Employee("Sebi", 7, "junior", false));
		employeeList.add(new Employee("Tarzan", 4, "junior", true));
		employeeList.add(new Employee("Sefu'", 3, "manager", false));
		employeeList.add(new Employee("Busu", 4, "junior", true));
		employeeList.add(new Employee("Bruce Lee", 2, "junior", true));
		employeeList.add(new Employee("Batman", 7, "manager", false));

		Collections.sort(employeeList);

		System.out.print("Company Employee's(sorted by the name): ");

		for (Employee employee : employeeList) {

			if (employee.getRole() == "manager")
				managerList.add(employee);
			else if (employee.getRole() == "junior")
				juniorList.add(employee);
			System.out.print(employee.getName() + ", ");
		}

		System.out.println();

		System.out.print("\nManagers: ");
		for (Employee manager : managerList)
			System.out.print(manager.getName() + ", ");

		System.out.println();

		System.out.print("\nJuniors: ");
		for (Employee junior : juniorList)
			System.out.print(junior.getName() + ", ");

		System.out.println();
		System.out.println();

		for (Employee employee : employeeList) {
			if (employee.hasParking() == false)
				employeesWithNoParkings.add(employee);
			else
				employeesWithParkings.add(employee);
		}

		Collections.sort(employeesWithNoParkings, Employee.Seniority);
		System.out.println("Employee's with no parking, orderd by years in the company: ");
		for (Employee s : employeesWithNoParkings)
			System.out.println("\tName: " + s.getName() + ", years in the company: " + s.getYearsInCompany());

		System.out.println();

		Collections.sort(employeesWithParkings, Employee.Seniority);
		System.out.println("Employee's with parking, orderd by years in the company: ");
		for (Employee s : employeesWithParkings)
			System.out.println("\tName: " + s.getName() + ", years in the company: " + s.getYearsInCompany());

	}
}
