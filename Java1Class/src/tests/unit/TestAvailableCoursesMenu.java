package tests.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.AvailableCoursesMenu;
import view.Menu;

public class TestAvailableCoursesMenu {
	Menu sut;

	@Before
	public void setUp() throws Exception {
		sut = AvailableCoursesMenu.getInstance(null);
	}

	//********************************************************************
	// Tests for MainMenu.parseInput(String input)
	//********************************************************************
	@Test
	public void testParseNullInput() {
		assertSame(sut, sut.parseInput(null));
	}
	@Test
	public void testInvalidInput(){
		assertSame(sut, sut.parseInput("|"));
	}
	@Test
	public void testValidInputM(){
		assertNotSame(sut, sut.parseInput("m"));
	}

}
