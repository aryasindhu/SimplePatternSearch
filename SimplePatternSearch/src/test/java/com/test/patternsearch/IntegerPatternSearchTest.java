package com.test.patternsearch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public class IntegerPatternSearchTest {

	private static SearchUtil<Integer> searchUtil = null;
	private static Integer[] mainPattern = null;

	@BeforeClass
	public static void setupTest() {
		searchUtil = new SearchUtil<Integer>();
		mainPattern = new Integer[45000];
		StringBuilder testDataBuilder = new StringBuilder();
		InputStream is = null;
		try {
			is = IntegerPatternSearchTest.class.getClassLoader()
					.getResourceAsStream("testIntData.csv");
			byte[] bytes = new byte[1];
			while (is.read(bytes) != -1) {
				testDataBuilder.append(new String(bytes));
			}
			int counter = 0;
			for (String eachIntVal : testDataBuilder.toString().split(", ")) {
				mainPattern[counter++] = Integer.parseInt(eachIntVal);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@DataProvider(name = "intSearchDataProvider")
	public static Object[][] getIntSearchData() {

		Boolean EXP_TRUE = new Boolean(Boolean.TRUE);
		Boolean EXP_FALSE = new Boolean(Boolean.FALSE);

		return new Object[][] {
				{ new Integer[] { 1, 3, 4, 5, 9 }, EXP_TRUE },
				{ new Integer[] { 1, 6, 14 }, EXP_TRUE },
				{ new Integer[] { 1 }, EXP_TRUE },
				{ new Integer[] {}, EXP_TRUE },
				{ new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }, EXP_TRUE },
				{ new Integer[] { 13, 14 }, EXP_TRUE },
				{ new Integer[] { 14 }, EXP_TRUE },
				{ new Integer[] { 15 }, EXP_TRUE },
				{ new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, EXP_TRUE },
				{ new Integer[] { 15, 19, 47, 6004, 9003, 12345, 23456, 34567, 44555, 44999 }, EXP_TRUE },
				{ new Integer[] { 1, 2, 15, 19, 47, 6004, 9003, 12345, 23456, 34567, 44555, 44999, 45000 }, EXP_FALSE } 
		};
	}

	@Test(dataProvider = "intSearchDataProvider")
	public void testIntPattern(Integer[] searchPattern, boolean expected) {

		Assert.assertEquals(searchUtil.search(mainPattern, searchPattern),
				expected, "Pattern Did Not Match");
	}

}
