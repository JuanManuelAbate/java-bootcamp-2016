package entities;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Schedule {

	private String begin;
	private String end;
	private String day;

	public Schedule(String begin, String end, String day) {
		this.begin = begin;
		this.end = end;
		this.day = day;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
