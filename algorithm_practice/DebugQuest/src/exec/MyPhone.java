package exec;

import java.io.Serializable;

 public class MyPhone implements Serializable{

	private static final long serialVersionUID = 3711778243568150650L;
	String color;

    public MyPhone(String color) {
    	this.color = color;
    }
   
    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
    public String toString() {
        return "MyPhone [color=" + color + "]";
    }
}
