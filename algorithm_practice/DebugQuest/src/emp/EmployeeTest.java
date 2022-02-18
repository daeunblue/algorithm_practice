package emp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/*
0. EmployeeTest 클래스는 수정하지 않습니다. 
   - 만약 EmployeeTest에 오류가 있더라도 다른 클래스에서 오류의 원인을 찾고 수정하세요.

1. Employee 클래스의 컴파일 오류를 처리하시오.
   - Employee들은 age 순으로 오름차순 한다.
2. PersonManager 클래스의 컴파일 오류를 처리하시오.  
3. EmployeeTest 클래스의 컴파일 오류를 처리하시오. 

4. 기본 동작을 확인하세요. (5. 항목까지 출력되고 ClassCaseException이 발생한다.)
*/
public class EmployeeTest {
	private PersonManager pm = PersonManager.getManager();

	public static void main(String[] args) {
		EmployeeTest pt = new EmployeeTest();
		pt.run();
	}

	public void run() {
		// 6. pm을 출력해서 현재 몇 명의 사용자가 있는지, 파일은 어디에 저장되는지 알아보자.
		// 출력 예시: 버전: 1.0, 파일 저장 위치: ./person.dat
		System.out.printf("%d: %s%n", 6, pm.toString());

		// 7. 현재 직원들의 나이의 평균을 살펴보자. 
		// 출력 예시: 아직 등록된 직원이 없습니다.
		try {
			System.out.printf("%d: %s%n", 7, pm.getAgeAvg());
		} catch (RuntimeException e) {
			System.out.printf("%d: %s%n", 7, e.getMessage());
		} 

		// 8. 4명의 사용자를 저장한다. 단 전화번호가 같으면 같은 사람으로 간주해서 기존 자료를 새로운 자료로 대체한다. 처리 후 관리되고 있는 인원을 출력한다.
		// 출력 예시: 8
		// 출력 예시: 8: [Employee [name=홍길동, phone=010-1234-5678, age=34], Employee [name=장길산, phone=010-5678-1234, age=50000], Employee [name=임꺽정, phone=010-0000-0000, age=40]]
		pm.add(new Employee("홍길순", "010-1234-5678", 25));
		pm.add(new Employee("홍길동", "010-1234-5678", 34));
		pm.add(new Employee("장길산", "010-5678-1234", 50000));
		pm.add(new Manager("임꺽정", "010-0000-0000", 40, "개발1팀"));
		System.out.printf("%d: %s%n", 8, pm.getSize());
		System.out.printf("%d: %s%n", 8, pm.getEmps());

		// 9. 현재 직원들의 평균 나이를 출력해보자.
		// 출력 예시: 16691.333333333332
		System.out.printf("%d: %s%n", 9, pm.getAgeAvg());

		// 10. 이제까지 살아온 나이를 초로 출력해보자.
		// 출력 예시: 2880666368
		System.out.printf("%d: %s%n", 10, pm.getLiveSecSum());

		// 11. 직원 중 메니저의 정보를 가져와서 부서의 이름을 출력해보자.
		// 출력 예시: 개발1팀
		String teamName = pm.getManagerTeamName();
		System.out.printf("%d: %s%n", 11, teamName);
		
		// 12. 모든 직원의 정보를 이름 순으로 정렬해서 출력해보자. 내용이 잘 보이는가?
		// 출력 예시: [Employee [name=임꺽정, phone=010-0000-0000, age=40], Employee [name=장길산, phone=010-5678-1234, age=50000], Employee [name=홍길동, phone=010-1234-5678, age=34]]
		List<Employee> emps = pm.getEmpsSortByName();
		System.out.printf("%d: %s%n", 12, emps);



		// 13. 현재까지의 정보를 파일에 저장해보자.
		// 출력 예시: 파일에 저장 되었습니다.
		save();
		System.out.printf("%d: %s%n", 13, "파일에 저장 되었습니다.");

		// 14. 이름중 '길'이 들어있는 Employee 를 삭제하고 결과를 출력하시오.
		// 출력 예시: [Employee [name=임꺽정, phone=010-0000-0000, age=40]]
		pm.removeByName("길");
		System.out.printf("%d: %s%n", 14, pm.getEmps());

		// 15. PersonManager의 레벨을 2.0으로 업데이트 해보자.
		pm.upgrade("2.0");
		System.out.printf("%d: %s%n", 15, pm.toString());
	}

	private void save() {
		try {
			pm.save();
			System.out.println("파일에 저장 되었습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
}
