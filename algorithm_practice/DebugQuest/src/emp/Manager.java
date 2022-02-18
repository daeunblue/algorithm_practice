package emp;

public class Manager extends Employee{

    private String team;

    public Manager(String name, String phone, int age, String team) {
    	super(name, phone, age);
    	this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString()+this.team;
    }
}
