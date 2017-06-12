/**
 * 
 */
package b;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ²ÜºÆ
 *
 */
public class TriangleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link b.Triangle#WhatTriangle()}.
	 */
	@Test
	public void testWhatTriangle() {
		assertEquals(1,Triangle.WhatTriangle(1,1,1));
		assertEquals(2,Triangle.WhatTriangle(2,2,3));
		assertEquals(3,Triangle.WhatTriangle(3,4,5));
		assertEquals(4,Triangle.WhatTriangle(2,3,4));
		assertEquals(5,Triangle.WhatTriangle(1,2,3));
	}

}
