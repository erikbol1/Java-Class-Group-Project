package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Courses implements Comparable <Courses> {

	//instance variables
	private String courseId;
	private Calendar courseStartDate;
	private Calendar courseEndDate;
	private String courseName;
	private String courseSummary;
	private int courseEnrollmentLimit;
	private int currentNumEnrolled;
	
	SimpleDateFormat dateFormatter;

	//Constructor to take inputs
	public Courses (String id, Calendar startDate, Calendar endDate, String name, String summary, int limit, int numEnrolled) {
		courseId = id;
		courseStartDate = startDate;
		courseEndDate = endDate;
		courseName = name;
		courseSummary = summary;
		courseEnrollmentLimit = limit;
		currentNumEnrolled = numEnrolled;
		
		dateFormatter = new SimpleDateFormat();
		dateFormatter.applyPattern("yyyy-MM-dd");
	}
	//get course id
	public String getCourseId() {
		return courseId;
	}

	//get course start date
	public String getCourseStartDate() {
		return dateFormatter.format(courseStartDate.getTime());
	}

	//get course end date
	public String getCourseEndDate() {
		return dateFormatter.format(courseEndDate.getTime());
	}

	//get course name
	public String getCourseName() {
		return courseName;
	}

	//get course summary
	public String getCourseSummary() {
		return courseSummary;
	}

	//get enrollment limit
	public int getCourseEnrollmentLimit() {
		return courseEnrollmentLimit;
	}

	//get number of students enrolled
	public int getCurrentNumEnrolled() {
		return currentNumEnrolled;
	}

	//print string with course information
	public String toString() {
		return "[courseId: " + courseId + ", courseStartDate:" + getCourseStartDate() + ", courseEndDate:" + getCourseEndDate() + ", courseName: " + courseName + ", courseSummary: " + courseSummary + ", courseEnrollmentLimit: " + courseEnrollmentLimit + ", currentNumEnrolled: " + currentNumEnrolled + "]";
	}

	//create course comparison method to compare course name to sort alphabetically
	public int compareTo(Courses course){
		return courseName.compareTo(course.getCourseName());
	}

}
