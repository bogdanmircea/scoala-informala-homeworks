package ro.sci.companymanagementsystem;

import org.junit.Test;

public class CompanyManagementTest {

	@Test
	public void systemManagementTest() throws WrongYearsOfWorkException, WrongYearsOfWorkException {
		SystemManagement employeeList = new SystemManagement();
		try {
			employeeList.add(new Employee("Marcel", 4, "manager", true));
			employeeList.add(new Employee("Busu", 1, "junior", true));
			employeeList.add(new Employee("Bruce Lee", 7, "junior", true));
			employeeList.add(new Employee("Batman", 7, "manager", false));
		}
		catch (WrongRoleException e) {
			e.printStackTrace();
		}
		catch (WrongYearsOfWorkException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Managers expected: Marcel & Batman. ");
			employeeList.printManagers();
			System.out.println("\n\n");
			System.out.println("Juniors expected: Busu & Bruce Lee");
			employeeList.printJuniors();
			System.out.println("\n\n");
			System.out.println("Employee's with parking: Marcel & Bruce Lee & Busu. ");
			employeeList.printEmployeesWithParking();
			System.out.println("\n\n");
			System.out.println("Employee's withe no parking: Batman");
			employeeList.printEmployeesWithNoParking();

		}
	}

}
