package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Courses implements Comparable <Courses> {

	//instance variables
	private String courseId;
	private Calendar startDate;
	private Calendar endDate;
	private String name;
	private String description;
	private int enrollmentLimit;
	private int currentNumEnrolled;
	
	SimpleDateFormat dateFormatter;

	//Constructor to take inputs
	public Courses (String id, Calendar startDate, Calendar endDate, String name, String summary, int limit, int numEnrolled) {
		this.courseId = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.description = summary;
		this.enrollmentLimit = limit;
		this.currentNumEnrolled = numEnrolled;
		
		dateFormatter = new SimpleDateFormat();
		dateFormatter.applyPattern("yyyy-MM-dd");
	}
	//get course id
	public String getCourseId() {
		return courseId;
	}

	//get course start date
	public String getStartDate() {
		return dateFormatter.format(startDate.getTime());
	}

	//get course end date
	public String getEndDate() {
		return dateFormatter.format(endDate.getTime());
	}

	//get course name
	public String getName() {
		return name;
	}

	//get course summary
	public String getSummary() {
		return description;
	}

	//get enrollment limit
	public int getEnrollmentLimit() {
		return enrollmentLimit;
	}

	//get number of students enrolled
	public int getCurrentNumEnrolled() {
		return currentNumEnrolled;
	}

	//print string with course information
	@Override
	public String toString() {
		return "[courseId: " + courseId + ", courseStartDate:" + getStartDate() + ", courseEndDate:" + getEndDate() + ", courseName: " + name + ", courseSummary: " + description + ", courseEnrollmentLimit: " + enrollmentLimit + ", currentNumEnrolled: " + currentNumEnrolled + "]";
	}

	//create course comparison method to compare course name to sort alphabetically
	public int compareTo(Courses course){
		return name.compareToIgnoreCase(course.name);
	}

}
