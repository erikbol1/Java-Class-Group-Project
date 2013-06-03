package tests;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import model.Courses;

/**
 * Creates course objects, adds courses to an arraylist and sorts courses in alphabetical order.
 */
public class CourseListing {

	public static void main (String[] args) throws ParseException {

		//Create an ArrayList of type Courses to store list of courses
		List<Courses> courseList = new ArrayList<Courses>();
		
		Calendar juneFirst2013 = new GregorianCalendar(2013, Calendar.JUNE, 01);
		Calendar juneFifteenth2013 = new GregorianCalendar(2013, Calendar.JUNE, 15);
		Calendar augustThirtyFirst2013 = new GregorianCalendar(2013, Calendar.AUGUST, 31);
		Calendar septemberFifteenth2013 = new GregorianCalendar(2013, Calendar.SEPTEMBER, 15);

		//create 10 course Objects to store in an arraylist

		Courses course1 = new Courses("CS460", juneFirst2013, augustThirtyFirst2013,"Java Programming I", 
				"Java is an excellent choice for those new to programming wishing to enhance their current skillset or change their career. " +
				"The aim of this course is to provide students with the knowledge and competencies to be able to write and design sophisticated " +
				"professional programs using Java through exercises.",10,1);
		System.out.println("Course 1: " + course1.toString());
		System.out.println();

		Courses course2 = new Courses("CS461", juneFirst2013, augustThirtyFirst2013,"Java Programming II", 
				"Expand your knowledge of Java and learn about several of the advanced features available in the Java programming environment. " +
				"This course focuses on the development of advanced graphical user interfaces (GUIs) using Swing, multithreading and concurrency.",10,2);
		System.out.println("Course 2: " + course2.toString());
		System.out.println();

		Courses course3 = new Courses("MGMT497", juneFirst2013, augustThirtyFirst2013,"Concise Writing", 
				"Strong writing skills are necessary for effective communication in today's complex business world, " +
				"especially with the advent of new technologies. This class will take an audience centered approach for " +
				"preparing and writing messages considering the objective of the message and the organizational context for maximum impact.",5,3);
		System.out.println("Course 3: " + course3.toString());
		System.out.println();

		Courses course4 = new Courses("CSCI425", juneFirst2013, augustThirtyFirst2013,"Data Modeling", 
				"In this course you will learn how to develop data models which are used to publish the information " +
				"that organizations rely on for their day-to-day decision making processes. Basic data modeling techniques " +
				"will be explored including capturing data requirements, analyzing data elements, identifying entities and " +
				"attributes, and determining relationships between entities.",10,4);
		System.out.println("Course 4: " + course4.toString());
		System.out.println();

		Courses course5 = new Courses("MGMT481", juneFirst2013, augustThirtyFirst2013,"Fundamentals of " +
				"Business Analysis", "Whether you are new to the field of business analysis, or a supervisor of business " +
						"analysts, this core class provides a basic understanding of the functions and business impact of " +
						"the business analyst role. This course focuses on business analysis functions as they relate to " +
						"the development of enterprise-wide solutions and the business analysis project life cycle.",7,7);
		System.out.println("Course 5: " + course5.toString());
		System.out.println();

		Courses course6 = new Courses("MGMT481", juneFifteenth2013, septemberFifteenth2013,"Medical Product Manufacturing", 
				"Learn about the essential manufacturing principles for medical device and pharmaceutical products, and the " +
				"regulations governing the medical product manufacturing process. Gain valuable knowledge in understanding the " +
				"key principles, challenges and issues involved in good manufacturing practices (GMPs) of medical products.",5,3);
		System.out.println("Course 6: " + course6.toString());
		System.out.println();

		Courses course7 = new Courses("EECS44", juneFifteenth2013, septemberFifteenth2013,"System Validation and Verification", 
				"Expand your knowledge of test and evaluation, analysis, demonstration, and examination as methods of inspection for " +
				"proving design capabilities compliance with requirements. A focus is placed on tools and techniques utilized to manage " +
				"the complete verification process.",8,8);
		System.out.println("Course 7: " + course7.toString());
		System.out.println();

		Courses course8 = new Courses("MGMT410", juneFifteenth2013, septemberFifteenth2013, "Introduction to Business Process " +
				"Optimization", "This course will provide participants with an understanding of the components of the Business Process " +
						"Optimization framework and an awareness of the methodologies, tools and models that serve as its core elements.",9,0);
		System.out.println("Course 8: " + course8.toString());
		System.out.println();

		Courses course9 = new Courses("EECS495", juneFifteenth2013, septemberFifteenth2013, "C Programming for DSP", 
				"C programming is a preferred high-level programming language for digital signal processing (DSP) applications. " +
				"Increase your knowledge on efficient DSP programming techniques and how to write DSP code in C.",4,2);
		System.out.println("Course 9: " + course9.toString());
		System.out.println();

		Courses course10 = new Courses("CS460", juneFifteenth2013, septemberFifteenth2013, "Human Resources and the Law", 
				"This course covers the primary basic federal and state laws which come to bear on the practice of human resources management, " +
				"and which govern employer-employee relations.",6,5);
		System.out.println("Course 10: " + course10.toString());
		System.out.println();

		//Add each of the 10 course objects to the arraylist.
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		courseList.add(course4);
		courseList.add(course5);
		courseList.add(course6);
		courseList.add(course7);
		courseList.add(course8);
		courseList.add(course9);
		courseList.add(course10);

		//sort courses alphabetically, but limit print out only courses that have seats available.
		//Would it be better to just remove these from the arraylist and not even show them???
		Collections.sort(courseList);

		//initialize course counter
		int i = 0;

		System.out.println("Alphabetical course listing");
		for (Courses course: courseList){
			if (course.getCurrentNumEnrolled() < course.getCourseEnrollmentLimit()){
				System.out.println("Course " + i + ": "+ course.toString());
				System.out.println();
				i = i + 1;
			};

		}

		//print out number of available courses
		System.out.println("Total number of courses: " + courseList.size());
		System.out.println("Total number of available courses:" + i);
		System.out.println("Total unavailable courses:" + (courseList.size() - i));
		System.out.println();


	}
}
