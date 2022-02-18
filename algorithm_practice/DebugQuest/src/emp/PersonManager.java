package emp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonManager implements Comparable<Employee>{
    private final String file = "./person.dat";
    private String version = "1.0";

    private List<Employee> employees = new ArrayList<>();

    private static PersonManager manager = new PersonManager();

    private PersonManager() {
    }

    public static PersonManager getManager() {
        return manager;
    }

    public List<Employee> getEmps() {
        return employees;
    }

    public List<Employee> getEmpsSortByName() {

        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName())); // e1, e2 순서 변환
        
        return employees;
    }
    
    @Override
	public int compareTo(Employee o) {
		
		return 0;
	}

    public long getLiveSecSum() {
    	long sum = 0;
        for (Employee p : employees) {
            sum += p.getLiveSec();
        }
        return sum;
    }

    public double getAgeAvg() throws RuntimeException {
        double sum = 0.0;
        
        if(employees.isEmpty()) {
        	throw new RuntimeException("아직 등록된 직원이 없습니다.");
        }
        for (Employee e : employees) {
            sum += e.getAge();
        }
        return sum / employees.size();
    }

    public void add(Employee p) {

    	for(Employee e : employees) {
    		if(e.getPhone() == p.getPhone()){
//    			System.out.println("핸드폰 번호 중복");
    			e.setAge(p.getAge());
    			e.setName(p.getName());
    			return;
    		}
    	}
    	 employees.add(p);
       
    }

    public int getSize() {
        return employees.size();
    }

    public String getManagerTeamName() {
        for (Employee e : employees) {
        	if(e instanceof Manager) {	// instance of로 체크하기
        		  Manager m = (Manager) e;
                  return m.getTeam();
        	}
        }
        return null;
    }

    public void save() throws FileNotFoundException, IOException {	// 순서대로 catch해줘야함
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File(file)))) {
            output.writeObject(employees);
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void removeByName(String name) {
    	for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().contains(name)) {
                employees.remove(i);
                i--;	// 삭제되면 index가 1 줄어야함 -> 다시 for문 현재 위치부터 돌게해야한다! 
            }
        }
        
    }
    
    public void upgrade(String version) {
        this.version = version;
    }

    public String toString() {
        return String.format("버전: %s, 파일 저장 위치: %s", version, file);
    }

	
}
