package ro.sci.companymanagementsystem;

/**
 * This is the main class of System management Project.
 * 
 * @author Bobo
 *
 */
public class Main {

	public static void main(String[] args) throws WrongYearsOfWorkException, WrongRoleException {

		SystemManagement employeeList = new SystemManagement();

		employeeList.add(new Employee("Marcel", 8, "manager", true));
		employeeList.add(new Employee("Cornel", 3, "junior", false));
		employeeList.add(new Employee("Andreea", 5, "junior", true));
		employeeList.add(new Employee("Sefa'", 9, "manager", false));
		employeeList.add(new Employee("Traian", 2, "junior", true));
		employeeList.add(new Employee("Mishu", 4, "junior", true));
		employeeList.add(new Employee("Valer", 7, "manager", false));
		employeeList.add(new Employee("Mihai", 3, "manager", true));
		employeeList.add(new Employee("Sebi", 9, "junior", false));
		employeeList.add(new Employee("Tarzan", 4, "junior", true));
		employeeList.add(new Employee("Sefu'", 3, "manager", false));
		employeeList.add(new Employee("Busu", 1, "junior", true));
		employeeList.add(new Employee("Bruce Lee", 2, "junior", true));
		employeeList.add(new Employee("Batman", 2, "manager", false));

		employeeList.printAllEmployees();
		employeeList.printJuniors();
		employeeList.printManagers();
		employeeList.printEmployeesWithParking();
		employeeList.printEmployeesWithNoParking();
	}
}