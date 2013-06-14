package tests.unit;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Course;

import org.junit.Before;
import org.junit.Test;

import persistance.CoursePersistance;
import persistance.StaticCoursePersistance;

public class TestStaticCoursePersistance {

	CoursePersistance sut;
	private Calendar calendar;

	@Before
	public void setUp() throws Exception {
		sut = new StaticCoursePersistance();
		calendar = new GregorianCalendar();
	}


	//********************************************************************
	// Tests for StaticCoursePersistance.getCourses()
	//********************************************************************
	@Test
	public void testGetCourses() {
		assertNotNull(sut.getCourses());
		assertEquals(10, sut.getCourses().size());
	}
	//********************************************************************
	// Tests for StaticCoursePersistance.persistNewCourse(Course course)
	//********************************************************************
	@Test
	public void testSaveNullCourse() {
		assertFalse(sut.persistNewCourse(null));
	}
	@Test
	public void testSaveNewCourse(){
		assertTrue(sut.persistNewCourse(new Course("ID", calendar, calendar, "Name", "Description", 10, 1)));
	}
	@Test
	public void testSaveExistingCourse(){
		assertFalse(sut.persistNewCourse(sut.getCourses().get(0)));
	}
	//********************************************************************
	// Tests for StaticCoursePersistance.updateCourse(Course updatedCourse)
	//********************************************************************
	@Test
	public void testUpdateNullCourse() {
		assertFalse(sut.updateCourse(null));
	}
	@Test
	public void testUpdateNewCourse() {
		assertFalse(sut.updateCourse(new Course("ID1", calendar, calendar, "Name", "Description", 10, 1)));
	}
	@Test
	public void testUpdateExistingCourse(){
		Course updatedCourse = sut.getCourses().get(0);
		updatedCourse.decrementEnrollment();
		assertTrue(sut.updateCourse(updatedCourse));
	}

}
