package emp;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable{

	private static final long serialVersionUID = 4240158060824407807L;
	private String name;
    private String phone;
    private int age;
    
    public Employee() {}

    public Employee(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * �씠�젣源뚯� �궡�븘�삩 珥덈�� 諛섑솚�븳�떎. �떒 1�뀈�� 365�씪怨� 媛��젙�븳�떎.
     * 
     * @return
     */
    public long getLiveSec() {
        return age * 365 * 24 * 60 * 60;
    }

    // comparator 가 갖고있는거임 ! 헷갈리지 말자
	public int compare(Employee o) {	
		return Integer.compare(this.age, o.age);
	}
    
    public String toString() {
        return "Employee [name=" + name + ", phone=" + phone + ", age=" + age + "]";
    }

	@Override
	public int compareTo(Employee o) {
		
		return Integer.compare(age, o.age);
	}



}
