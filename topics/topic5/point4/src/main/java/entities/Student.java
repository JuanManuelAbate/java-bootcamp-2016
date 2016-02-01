package entities;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Student {

	@Id
	@Property("id")
	private ObjectId id;

	private String firstName;
	private String lastName;
	private String birthDate;

	@Embedded
	private ArrayList<EnrolledCourse> courses;

	public ArrayList<EnrolledCourse> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<EnrolledCourse> courses) {
		this.courses = courses;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public String getBirth_date() {
		return birthDate;
	}

	public void setBirth_date(String birth_date) {
		this.birthDate = birth_date;
	}
}
