package company;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Company {
	private List<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public int countSoftwareEngineers() {
		AtomicInteger count = new AtomicInteger(0);
		employees.forEach(i -> {
			if(i.isSoftwareEngineer()) {
				count.set(count.get() + 1);
			}
		});
		
		return count.get();
	}
	
	public int count(Predicate<Employee> p) {
		AtomicInteger count = new AtomicInteger(0);
		employees.forEach( e -> {
			if(p.test(e)) {
				count.set(count.get() + 1);
			}
		});
		
		return count.get();
	}

	public boolean any(Predicate<Employee> p) {
		AtomicInteger count = new AtomicInteger(0);
		employees.forEach( e -> {
			if(p.test(e)) {
				count.set(count.get() + 1);
			}
		});
		if(count.get() > 0)
			return true;
		return false;
	}

	public boolean all(Predicate<Employee> p) {
		AtomicInteger count = new AtomicInteger(0);
		employees.forEach( e -> {
			if(p.test(e)) {
				count.set(count.get() + 1);
			}
		});
		if(count.get() < employees.size())
			return false;
		return true;
	}
	
}
