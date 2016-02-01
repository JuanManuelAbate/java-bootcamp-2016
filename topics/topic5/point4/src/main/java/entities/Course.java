package entities;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Course {

	@Id
	@Property("id")
	private ObjectId id;

	private String name;
	private String asignedTeacher;

	@Embedded
	private ArrayList<Schedule> scheduler;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAsignedTeacher() {
		return asignedTeacher;
	}

	public void setAsignedTeacher(String asignedTeacher) {
		this.asignedTeacher = asignedTeacher;
	}

	public ArrayList<Schedule> getScheduler() {
		return scheduler;
	}

	public void setScheduler(ArrayList<Schedule> scheduler) {
		this.scheduler = scheduler;
	}

}
