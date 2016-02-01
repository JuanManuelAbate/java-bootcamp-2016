package entities;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class EnrolledCourse {

	private String courseName;
	private int finalNote;

	public EnrolledCourse(String courseName, int finalNote) {
		this.courseName = courseName;
		this.finalNote = finalNote;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getFinalNote() {
		return finalNote;
	}

	public void setFinalNote(int finalNote) {
		this.finalNote = finalNote;
	}

}
