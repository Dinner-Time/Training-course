package co.yedam.emp;

/*
 * 사원정보 저장
 */
public class Employee {
	int employeeId, salary, departmentId; // 10:인사 20:개발 30:영업(기본값)

	String name, email, departmentName;

	Employee() {
		this(0, "", 0, "", 0);
	}

	public Employee(int employeeId, String name, int salary, String email, int departmentId) {
		super();
		// 사번
		this.employeeId = employeeId;
		// 급여 (기본:2400)
		if (salary == 0) {
			this.salary = 2400;
		} else {
			this.salary = salary;
		}
//		 부서번호 (기본:30)
		if (departmentId != 10 && departmentId != 20) {
			this.departmentId = 30;
		} else {
			this.departmentId = departmentId;
		}
		// 부서명 (기본:영업)
		if (this.departmentId == 10) {
			this.departmentName = "인사"; // 부서번호10: 인사
		} else if (this.departmentId == 20) {
			this.departmentName = "개발"; // 부서번호20: 개발
		} else {
			this.departmentName = "영업"; // 부서번호30: 영업
		}
		// 이름
		this.name = name;
		// 메일
		this.email = email;
	}

	Employee(int employeeId, String name) {
		this(employeeId, name, 0, "", 0);
	}

	Employee(int employeeId, String name, String email) {
		this(employeeId, name, 0, email, 0);
	}

	Employee(int employeeId, String name, int salary) {
		this(employeeId, name, 2500, "", 0);
	}

	@Override
	public String toString() {
		return "[employeeId=" + employeeId + ", salary=" + salary + ", departmentId=" + departmentId + ", name=" + name
				+ ", email=" + email + ", departmentName=" + departmentName + "]";
	}

}
