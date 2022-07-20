package AbstractClass.MidTerm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageEmployee {
	private List<Employee> listofEmployees;

	public List<Employee> getListofEmployees() {
		return listofEmployees;
	}

	public void setListofEmployees(List<Employee> listofEmployees) {
		this.listofEmployees = listofEmployees;
	}


	public ManageEmployee() {
		this.listofEmployees = new ArrayList();
	}

	public ManageEmployee(List<Employee> listofEmployees) {
		this.listofEmployees = listofEmployees;
	}


	void input() throws Exception {
		Employee employee = null;
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("1: Experience | 2: Fresher | 3: Intern | 0: Exit ");
			System.out.println("Which type of employee you want to input information? ");
			System.out.println("Please enter number: ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					employee = new Experience();
					break;
			
				case 2:
					employee = new Fresher();
					break;
				
				case 3:
					employee = new Intern();
					break;
				default:
					employee = null;
					choice = 0;
			}
			
			if (employee != null) {
				employee.input();
				this.listofEmployees.add(employee);
			}
		} while (choice != 0);
	}

	void output() {
		for (Employee employees: this.listofEmployees) {
			employees.showInfo();
		}
	}


	public void output(int typeOfEmployee) {
		switch (typeOfEmployee) {
			case Employee.Experience:
				for (Employee employee : this.listofEmployees) {
					if (employee instanceof Experience) {
						employee.showInfo();
					}
				}
				break;
			
			case Employee.Fresher:
				for (Employee employee : this.listofEmployees) {
					if (employee instanceof Fresher) {
						employee.showInfo();
					}
				}
				break;
			
			case Employee.Intern:
				for (Employee employee : this.listofEmployees) {
					if (employee instanceof Intern) {
						employee.showInfo();
					}
				}
				break;
		
			default:
				output();
		}
	}


	public static void main(String[] args) throws Exception {
		Employee employee = new Experience();
		employee.input();
		employee.showInfo();

		employee = new Fresher();
		employee.input();
		employee.showInfo();

		employee = new Intern();
		employee.input();
		employee.showInfo();

		List<Employee> listEmployees = new ArrayList();
		try {
			listEmployees.add(new Experience("Nguyen Van A", "1997/08/20", 
										"0909876500", "nguyenvana@gmail.com", 
										"Experience", 5, "Design Patterns"));
			listEmployees.add(new Experience("Van Hoang B", "1999/02/29", 
											"090983201", "vanhb@gmail.com", 
										"Experience", 10, "Python"));
			listEmployees.add(new Experience("Nguyen Be Bi", "1989/12/24", 
										"0978234403", "bbnguyen@gmail.com", 
										"Experience", 8, "Java"));
		} catch (Exception e) {
			Logger.getLogger(ManageEmployee.class.getName()).log(Level.SEVERE, null, e);
		}


		// OUTPUT INFO
		for (Employee emp : listEmployees) {
			emp.showInfo();
		}

	}
}
