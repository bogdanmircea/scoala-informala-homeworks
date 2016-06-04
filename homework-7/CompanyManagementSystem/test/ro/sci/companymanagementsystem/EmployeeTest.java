package ro.sci.companymanagementsystem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

	@Test
	public void employeeTest() {

		Employee employee = new Employee("Mirel", 4, "junior", true);

		if (employee instanceof Employee) {

			assertEquals("Mirel", employee.getName());
			assertEquals(4, employee.getYearsInCompany());
			assertEquals("junior", employee.getRole());
			assertEquals(true, employee.hasParking());
		}
	}
}
