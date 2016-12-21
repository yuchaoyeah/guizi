package guizi.user.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;

import commons.entity.BaseEntity;

@Entity(noClassnameStored=true)
public class User extends BaseEntity{
	@Indexed
	private String name;
	private int age;
	private boolean gender;
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return "id:"+getId()+",name:"+name+",age:"+age+",gender:"+gender;
	}
}
