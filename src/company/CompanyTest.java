package company;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import company.Employee.LOCATION;
import company.Employee.OCCUPATION;


public class CompanyTest {
	private static Company company;
	
	@BeforeClass
	public static void setup() {
		company = new Company();
		company.addEmployee(new Employee("James", 16, OCCUPATION.SOFTWARE_ENGINEER, LOCATION.SAN_DIEGO));
		company.addEmployee(new Employee("Severa", 16, OCCUPATION.SOFTWARE_ENGINEER, LOCATION.SAN_DIEGO));
		company.addEmployee(new Employee("Logan", 16, OCCUPATION.SOFTWARE_ENGINEER, LOCATION.SAN_DIEGO));
		company.addEmployee(new Employee("Mark", 30, OCCUPATION.HR_EMPLOYEE, LOCATION.CHICAGO));
		company.addEmployee(new Employee("James", 40, OCCUPATION.HR_EMPLOYEE, LOCATION.LA));
	}
	
	@Test
	public void testCountSoftwareEngineers() {
		assertEquals(3, company.countSoftwareEngineers());
	}
	
	@Test
	public void testCount() {
		assertEquals(3, company.count(e -> e.isSoftwareEngineer()));
		assertEquals(2, company.count(e -> e.getAge() > 18));
	}
	
	@Test
	public void testAny() {
		assertTrue(company.any(e -> e.isSoftwareEngineer()));
		assertFalse(company.any(e -> e.getOccupation() == OCCUPATION.SALES_EMPLOYEE));
	}
	
	@Test
	public void testAll() {
		assertFalse(company.all(e -> e.isSoftwareEngineer()));
		assertTrue(company.all(e -> e.getAge() > 12));
	}
	
	

}
