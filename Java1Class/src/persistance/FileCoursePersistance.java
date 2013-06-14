package persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import model.Course;

public class FileCoursePersistance implements CoursePersistance{

	private String fileName;
	private List<Course> courses;

	public FileCoursePersistance(String fileName){
		this.fileName = fileName;
	}
	@Override
	public boolean updateCourse(Course updatedCourse) {
		//Protect against nulls
		if (updatedCourse == null)
			return false;

		for (Course oldCourse: courses)
			//Find course in our course list
			if (oldCourse.getCourseId().equalsIgnoreCase(updatedCourse.getCourseId())){
				//Loop until course in our course list has same enrollment
				while (oldCourse.getCurrentEnrollment() != updatedCourse.getCurrentEnrollment()){
					if (oldCourse.getCurrentEnrollment() < updatedCourse.getCurrentEnrollment())
						oldCourse.incrementEnrollment();
					else
						oldCourse.decrementEnrollment();
				}
				//Update successful
				return persistInFile(courses, fileName);
			}

		//Course not present so return false	
		return false;
	}

	@Override
	public List<Course> getCourses() {
		if (courses != null)//Return cache if possible
			return courses;
		
		return pullFromFile(fileName);
	}

	@Override
	public boolean persistNewCourse(Course course) {
		if (course == null)
			return false;

		if (!courses.contains(course))//Add the course and return true
			return (courses.add(course)) ? persistInFile(courses, fileName): false;

		return false;
	}

	private List<Course> pullFromFile(String file){
		List<Course> output = new ArrayList<Course>();
		File input = new File(file);
		Scanner scanner;

		try {
			scanner = new Scanner(input);
			while (scanner.hasNext()){
				//Read a line and break it into parts
				String[] courseParts = scanner.nextLine().split(", ");

				//Assign the attributes
				String courseId = courseParts[0];
				Calendar startDate = parseDate(courseParts[1]);
				Calendar endDate = parseDate(courseParts[2]);
				String name = courseParts[3];

				String description;//Handled differently in case description has commas
				if (courseParts.length == 7)
					description = courseParts[4];//No commas in description
				else {
					StringBuilder sb = new StringBuilder();
					int limit = courseParts.length - 2;
					for(int index = 4; index < limit; index++){
						if (index > 4)//Put the comma back
							sb.append(", ");

						sb.append(courseParts[index]);
					}

					description = sb.toString();
				}


				int enrollmentLimit = Integer.parseInt(courseParts[courseParts.length - 2]);
				int currentEnrollment = Integer.parseInt(courseParts[courseParts.length - 1]);

				//Add the course to the output
				output.add(new Course(courseId,startDate, endDate, name, description, enrollmentLimit, currentEnrollment));
			}
			//Close the file
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Collections.sort(output);

		return output;
	}

	private boolean persistInFile(List<Course> courseList, String file){
		File output = new File(file);
		PrintWriter printer;
		try {
			printer = new PrintWriter(output);
			for (Course c: courses){
				//Write to file
				printer.println(c.toString());
			}
			//Close file
			printer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return true;
	}

	private Calendar parseDate(String date){

		String[] dateParts = date.split("-");

		int year = Integer.parseInt(dateParts[0]);
		int month = Integer.parseInt(dateParts[1]) - 1;
		int day = Integer.parseInt(dateParts[2]);

		return new GregorianCalendar(year, month, day);
	}

}
