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
		assertSame(sut, sut.parseInput(null));
	}
	@Test
	public void testInvalidInput(){
		assertSame(sut, sut.parseInput("|"));
	}
	@Test
	public void testValidInputV(){
		assertSame(AvailableCoursesMenu.getInstance(null), sut.parseInput("v"));
	}

}
