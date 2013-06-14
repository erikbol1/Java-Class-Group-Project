package tests.unit;

import static org.junit.Assert.*;

import model.ContactInfo;
import model.Name;
import model.Student;

import org.junit.Before;
import org.junit.Test;

import persistance.AbstractStudentRepository;
import persistance.StaticStudentPersistance;

/**
 * These tests are brittle as we are testing against the internal hard coded data
 * @author Erik B
 */
public class TestAbstractStudentRepository {
	
	private AbstractStudentRepository sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new AbstractStudentRepository(new StaticStudentPersistance());
	}

	//***************************************************************
	// Tests for AbstractStudentRepository.getStudent(String courseId)
	//***************************************************************
	@Test
	public void testGetNullStudent() {
		assertNull(sut.getStudent(null));
	}
	@Test
	public void testGetValidStudent(){
		assertNotNull(sut.getStudent("janewu"));
	}
	@Test
	public void testGetInvalidStudent(){
		assertNull(sut.getStudent("slkdfsldj"));
	}
	//***************************************************************
	// Tests for AbstractStudentRepository.saveStudent(Student student)
	//***************************************************************
	@Test
	public void testSaveNullStudent() {
		assertFalse(sut.saveStudent(null));
	}
	@Test
	public void testSaveValidStudent(){
		Student temp = new Student(1, new Name("Bob", "Smith"), "bob", new ContactInfo("a@abc.com", 23L));
		assertTrue(sut.saveStudent(temp));
		assertEquals(temp, sut.getStudent(temp.getUsername()));
	}
	@Test
	public void testSaveExistingStudent(){
		assertTrue(sut.saveStudent(sut.getStudent("janewu")));
	}	

}
