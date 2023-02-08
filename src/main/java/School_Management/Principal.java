package School_Management;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Principal {
	@Id
	private int id;
	private String name;
	private int age;
	private long MoNumber;
	private String email;
	private String pass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMoNumber() {
		return MoNumber;
	}
	public void setMoNumber(long moNumber) {
		MoNumber = moNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
