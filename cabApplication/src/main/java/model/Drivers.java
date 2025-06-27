package model;

public class Drivers {
	   private int id;
	   private String name;
	   private String password;
	   private int age;
	   private int Cabcount;
	   private boolean isPre;
	public int getCabcount() {
		return Cabcount;
	}
	public void setCabcount(int cabcount) {
		Cabcount = cabcount;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isPre() {
		return isPre;
	}
	public void setPre(boolean isPre) {
		this.isPre = isPre;
	}
}
