package tests.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.AuthenticatedMainMenu;
import view.AvailableCoursesMenu;
import view.MainMenu;
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
		sut.parseInput(null);
		assertTrue(sut.moreInputNeeded());
	}
	@Test
	public void testInvalidInput(){
		sut.parseInput("|");
		assertTrue(sut.moreInputNeeded());
	}
	@Test
	public void testValidInputNotAuthenticated(){
		sut.parseInput("m");
		assertEquals(MainMenu.getInstance(), sut.getNextMenu());
	}
	@Test
	public void testValidInputAuthenticated(){
		sut = AvailableCoursesMenu.getInstance("janewu");
		sut.parseInput("m");
		assertEquals(AuthenticatedMainMenu.getInstance("janewu"), sut.getNextMenu());
	}

}
