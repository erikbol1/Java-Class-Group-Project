package model;

public class Courses implements Comparable <Courses> {

	//instance variables
	private String courseId;
	private String courseStartDate;
	private String courseEndDate;
	private String courseName;
	private String courseSummary;
	private int courseEnrollmentLimit;
	private int currentNumEnrolled;

	//Constructor to take inputs
	public Courses (String id, String startDate, String endDate, String name, String summary, int limit, int numEnrolled) {
		courseId = id;
		courseStartDate = startDate;
		courseEndDate = endDate;
		courseName = name;
		courseSummary = summary;
		courseEnrollmentLimit = limit;
		currentNumEnrolled = numEnrolled;
	}

	//Default constructor if no inputs
	public Courses () {
		System.out.println ("Missing course information.");
	}

	//Methods (getters & setters) to View Available Courses

	//get course id
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String id) {
		courseId = id;
	}

	//get course start date
	public String getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(String startDate) {
		courseStartDate = startDate;
	}

	//get course end date
	public String getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(String endDate) {
		courseEndDate = endDate;
	}

	//get course name
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String name) {
		courseName = name;
	}

	//get course summary
	public String getCourseSummary() {
		return courseSummary;
	}

	public void setCourseSummary(String summary) {
		courseSummary = summary;
	}

	//get enrollment limit
	public int getCourseEnrollmentLimit() {
		return courseEnrollmentLimit;
	}

	public void setCourseEnrollmentLimit(int limit) {
		courseEnrollmentLimit = limit;
	}

	//get number of students enrolled
	public int getCurrentNumEnrolled() {
		return currentNumEnrolled;
	}

	public void setCurrentNumEnrolled(int numEnrolled) {
		currentNumEnrolled = numEnrolled;
	}

	//print string with course information
	public String toString() {
		return "[courseId: " + courseId + ", courseStartDate:" + courseStartDate + ", courseEndDate:" + courseEndDate + ", courseName: " + courseName + ", courseSummary: " + courseSummary + ", courseEnrollmentLimit: " + courseEnrollmentLimit + ", currentNumEnrolled: " + currentNumEnrolled + "]";
	}

	//create course comparison method to compare course name to sort alphabetically
	public int compareTo(Courses course){
		return courseName.compareTo(course.getCourseName());
	}

}
