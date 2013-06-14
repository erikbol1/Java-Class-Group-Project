package tests.unit;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Course;

import org.junit.Before;
import org.junit.Test;

import persistence.AbstractCourseRepository;
import persistence.CourseRepository;
import persistence.StaticCoursePersistence;

/**
 * Tests are brittle because we are testing against the internal hard coded data
 * @author Erik B
 *
 */
public class TestAbstractCourseRepository {

	private CourseRepository sut;
	private Calendar calendar;
	
	@Before
	public void setUp() throws Exception {
		sut = new AbstractCourseRepository(new StaticCoursePersistence());
		calendar = new GregorianCalendar();
	}

	//********************************************************************
	// Tests for StaticCourseRepository.getAvailableCourses()
	//********************************************************************
	@Test
	public void testGetAvailableCourses() {
		assertEquals(8, sut.getAvailableCourses().size());
	}

	//********************************************************************
	// Tests for StaticCourseRepository.getCourse(String courseId)
	//********************************************************************
	@Test
	public void testGetNullCourse() {
		assertNull(sut.getCourse(null));
	}
	@Test
	public void testGetValidCourse(){
		assertNotNull(sut.getCourse("CS460"));
	}
	@Test
	public void testGetInvalidCourse(){
		assertNull(sut.getCourse("slkdjfslaj"));
	}
	//********************************************************************
	// Tests for StaticCourseRepository.saveNewCourse(Course course)
	//********************************************************************
	@Test
	public void testSaveNullCourse() {
		assertFalse(sut.saveNewCourse(null));
	}
	@Test
	public void testSaveNewCourse(){
		assertTrue(sut.saveNewCourse(new Course("ID", calendar, calendar, "Name", "Description", 10, 1)));
	}
	@Test
	public void testSaveExistingCourse(){
		assertFalse(sut.saveNewCourse(sut.getCourse("CS460")));
	}
	//********************************************************************
	// Tests for StaticCourseRepository.updateCourse(Course updatedCourse)
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
		Course updatedCourse = sut.getCourse("CS460");
		updatedCourse.decrementEnrollment();
		assertTrue(sut.updateCourse(updatedCourse));
	}

}
