package tests.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.AuthenticatedMainMenu;
import view.LoginMenu;
import view.Menu;

public class TestLoginMenu {
	Menu sut;

	@Before
	public void setUp() throws Exception {
		sut = LoginMenu.getInstance();
	}

	//********************************************************************
	// Tests for LoginMenu.parseInput(String input)
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
	public void testValidInput(){//Test relies on StudentRepository containing this username
		sut.parseInput("janewu");
		assertSame(AuthenticatedMainMenu.getInstance("janewu"), sut.getNextMenu());
	}

}
