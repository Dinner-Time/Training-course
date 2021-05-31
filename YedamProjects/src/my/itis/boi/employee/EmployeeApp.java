package my.itis.boi.employee;

import java.util.Scanner;

public class EmployeeApp {
	int empNum = 0;
	Scanner scanner = new Scanner(System.in);
	Employee[] employees;

	void init() {
		System.out.print("전체 사원수: ");
		employees = new Employee[scanner.nextInt()];
	}

	void input() {
		System.out.print("사번> ");
		int empID = scanner.nextInt();
		System.out.print("이름> ");
		String name = scanner.next();
		System.out.print("부서번호> ");
		int depID = scanner.nextInt();
		System.out.print("급여(만원)> ");
		int salary = scanner.nextInt();
		System.out.print("메일> ");
		String mail = scanner.next();
		employees[empNum] = new Employee(empID, name, salary, mail, depID);
		empNum++;
	}

	String search(int a) {
		String result = "";
		for (int i = 0; i < empNum; i++) {
			if (employees[i].employeeId == a) {
				result = employees[i].name;
			} 
		}
		return result;
	}

	void print() {
		for (int i = 0; i < empNum; i++) {
			System.out.println("사번:" + employees[i].employeeId + " 이름:" + employees[i].name + " 부서명:"
					+ employees[i].departmentName + " 급여(만원):" + employees[i].salary + " 메일:" + employees[i].email);
		}
	}

	int sum() {
		int total = 0;
		for (int i = 0; i < empNum; i++) {
			total += employees[i].salary;
		}
		return total;
	}
}
