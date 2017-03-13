package now;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VectorTest {

	double testX, testY;
	Vector testVector;

	@Before public void setUp() {
		testX = 333.0;
		testY = 666.0;
		testVector = new Vector(testX, testY);
	}
	
	@Test
	public void testVector() {
		assertTrue(testVector != null);
	}

	@Test
	public void testGetX() {
		assertEquals(testX, testVector.getX(), 0.0001);
	}

	@Test
	public void testGetY() {
		assertEquals(testY, testVector.getY(), 0.0001);
	}

	@Test
	public void testSetX() {
		int setX = -333;
		testVector.setX(setX);
		assertEquals(setX, testVector.getX(), 0.0001);
	}

	@Test
	public void testSetY() {
		int setY = -333;
		testVector.setY(setY);
		assertEquals(setY, testVector.getY(), 0.0001);
	}

	@Test
	public void testToString() {
		assertEquals("X = " + testX + ", Y = " + testY, testVector.toString());
	}

}
