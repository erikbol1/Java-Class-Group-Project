package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Course implements Comparable <Course> {

	//instance variables
	private final String courseId;
	private final Calendar startDate;
	private final Calendar endDate;
	private final String name;
	private final String description;
	private int enrollmentLimit;
	private int currentEnrollment;
	
	SimpleDateFormat dateFormatter;

	//Constructor to take inputs
	public Course (String id, Calendar startDate, Calendar endDate, String name, String summary, int limit, int numEnrolled) {
		//Protect against enrollment errors
		if (numEnrolled > limit)
			throw new IllegalArgumentException("Number of enrolled students can not exceed enrollment limit.");
		if (numEnrolled < 0)
			throw new IllegalArgumentException("Number of enrolled students can not be negative.");
		if (limit < 1)
			throw new IllegalArgumentException("Class size must be greater than zero.");
		
		this.courseId = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.description = summary;
		
		this.enrollmentLimit = limit;
		this.currentEnrollment = numEnrolled;
		
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

	/**
	 * @return number of students currently enrolled in the course
	 */
	public int getCurrentEnrollment() {
		return currentEnrollment;
	}
	/**
	 * Increases the number of enrolled students by 1.
	 */
	public boolean incrementEnrollment(){
		//Ensure we don't exceed enrollment limit
		if (currentEnrollment == enrollmentLimit)
			return false;
		
		currentEnrollment++;
		return true;
	}
	/**
	 * Decreases the number of enrolled students by 1.
	 */
	public boolean decrementEnrollment(){
		//Ensure we don't drop below zero students
		if (currentEnrollment == 0)
			return false;
		
		currentEnrollment--;
		return true;
	}
	@Override
	public String toString() {
		return courseId + ", " + getStartDate() + ", " + getEndDate() + ", " + name + ", " + description + ", " + enrollmentLimit + ", " + currentEnrollment;
	}
	/**
	 * Comparison based on course Id as course Id is typically arranged by category.
	 */
	@Override
	public int compareTo(Course course){
		return courseId.compareToIgnoreCase(course.courseId);
	}

}
