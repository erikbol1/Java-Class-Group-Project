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
		assertSame(sut, sut.parseInput(null));
	}
	@Test
	public void testInvalidInput(){
		assertSame(sut, sut.parseInput("|"));
	}
	@Test
	public void testValidInput(){//Test relies on StaticStudentRepository
		assertSame(AuthenticatedMainMenu.getInstance("janewu"), sut.parseInput("janewu"));
	}

}
