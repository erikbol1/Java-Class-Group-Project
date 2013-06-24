package tests.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.AvailableCoursesMenu;
import view.MainMenu;
import view.Menu;

public class TestMainMenu {
	
	Menu sut;

	@Before
	public void setUp() throws Exception {
		sut = MainMenu.getInstance();
	}

	//********************************************************************
	// Tests for MainMenu.parseInput(String input)
	//********************************************************************
	@Test
	public void testNullInput() {
		sut.parseInput(null);
		assertTrue(sut.moreInputNeeded());
	}
	@Test
	public void testInvalidInput(){
		sut.parseInput("|");
		assertTrue(sut.moreInputNeeded());
	}
	@Test
	public void testValidInputV(){
		sut.parseInput("v");
		assertSame(AvailableCoursesMenu.getInstance(null), sut.getNextMenu());
	}

}
