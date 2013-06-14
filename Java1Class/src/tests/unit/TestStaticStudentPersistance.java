package tests.unit;

import static org.junit.Assert.*;

import model.ContactInfo;
import model.Name;
import model.Student;

import org.junit.Before;
import org.junit.Test;

import persistance.StaticStudentPersistance;
import persistance.StudentPersistance;

public class TestStaticStudentPersistance {
	
	private StudentPersistance sut;

	@Before
	public void setUp() throws Exception {
		sut = new StaticStudentPersistance();
	}

	//***************************************************************
	// Tests for StaticStudentPersistance.getStudents()
	//***************************************************************
	
	@Test
	public void testGetStudents(){
		assertNotNull(sut.getStudents());
		assertEquals(1, sut.getStudents().size());
	}
	//***************************************************************
	// Tests for StaticStudentPersistance.persistStudent(Student student)
	//***************************************************************
	@Test
	public void testSaveNullStudent() {
		assertFalse(sut.persistStudent(null));
	}
	@Test
	public void testSaveNewStudent(){
		Student temp = new Student(1, new Name("Bob", "Smith"), "bob", new ContactInfo("a@abc.com", 23L));
		assertTrue(sut.persistStudent(temp));
		assertTrue(sut.getStudents().contains(temp));
	}
	@Test
	public void testSaveExistingStudent(){
		Student temp = sut.getStudents().get(0);
		assertTrue(sut.persistStudent(temp));
		assertTrue(sut.getStudents().contains(temp));
	}
	
}
