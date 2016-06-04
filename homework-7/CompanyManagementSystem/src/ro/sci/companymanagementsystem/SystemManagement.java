package ro.sci.companymanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The SystemManagement Class is where we have our methods that we use in the
 * application.
 * 
 * @author Bobo
 *
 */
public class SystemManagement {

	private List<Employee> employeeList = new ArrayList<Employee>();
	private List<Employee> managerList = new ArrayList<Employee>();
	private List<Employee> juniorList = new ArrayList<Employee>();
	private List<Employee> employeeListWithNoParking = new ArrayList<Employee>();
	private List<Employee> employeeListWithParking = new ArrayList<Employee>();

	/**
	 * The add method adds the employee in a list that represents it. In our
	 * application we have five lists:
	 * 
	 * employeeList : list with all the employee's managerList : list with the
	 * managers only juniorList : list with the juniors
	 * employeeListWithNoParking : employee's with no parking list
	 * employeeListWithParking : employess's with parking list
	 * 
	 * 
	 * @param employe
	 * @throws WrongRoleException
	 * @throws WrongYearsOfWorkException
	 */

	public void add(Employee employe) throws WrongRoleException, WrongYearsOfWorkException {
		if (employe.getRole() != "manager" && employe.getRole() != "junior") {
			throw new WrongRoleException("\n\nRole is not good for " + employe.getName() + "\n");
		}
		if (employe.getYearsInCompany() <= 0) {
			throw new WrongYearsOfWorkException("\n\nYou have to work more, " + employe.getName() + "\n");
		}
		else
			employeeList.add(employe);

		if (employe.getRole() == "manager")
			managerList.add(employe);

		else if (employe.getRole() == "junior")
			juniorList.add(employe);

		if (employe.hasParking() == false)
			employeeListWithNoParking.add(employe);

		else if (employe.hasParking() == true)
			employeeListWithParking.add(employe);

	}

	/**
	 * We have print methods for all of our lists that we created for our
	 * employee's.
	 */
	public void printAllEmployees() {
		System.out.print("All employee's list: \t");
		for (Employee employee : employeeList)
			System.out.print(employee.getName() + ", ");
	}

	public void printManagers() {
		System.out.print("\n\nManagers list: \t");
		for (Employee employee : managerList)
			System.out.print(employee.getName() + ", ");
	}

	public void printJuniors() {
		System.out.print("\n\nJuniors list: \t");
		for (Employee employee : juniorList)
			System.out.print(employee.getName() + ", ");
	}

	public void printEmployeesWithNoParking() {
		System.out.println("\n\nEmployee's with no parking list: \t");
		Collections.sort(employeeListWithNoParking, Employee.Seniority);
		for (Employee employee : employeeListWithNoParking)
			System.out.println(employee.getName() + ", years in company: " + employee.getYearsInCompany());
	}

	public void printEmployeesWithParking() {
		System.out.print("\n\nEmployee's with parking list: \t");
		for (Employee employee : employeeListWithParking)
			System.out.print(employee.getName() + ", ");

	}

}
