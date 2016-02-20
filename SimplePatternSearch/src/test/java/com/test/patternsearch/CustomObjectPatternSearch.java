package com.test.patternsearch;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public class CustomObjectPatternSearch {

	private static SearchUtil<Student> searchUtil = null;
	private static Student[] mainPattern = null;

	@BeforeClass
	public static void setupTest() {
		searchUtil = new SearchUtil<Student>();
		mainPattern = new Student[10];
		
		mainPattern[0] = new Student("Student 1", 12);
		mainPattern[1] = new Student("Student 2", 12);
		mainPattern[2] = new Student("Student 3", 15);
		mainPattern[3] = new Student("Student 4", 17);
		mainPattern[4] = new Student("Student 5", 10);
		mainPattern[5] = new Student("Student 6", 18);
		mainPattern[6] = new Student("Student 7", 10);
		mainPattern[7] = new Student("Student 8", 11);
		mainPattern[8] = new Student("Student 9", 19);
		mainPattern[9] = new Student("Student 10", 16);
	}

	@DataProvider(name = "intSearchDataProvider")
	public static Object[][] getIntSearchData() {

		Boolean EXP_TRUE = new Boolean(Boolean.TRUE);
		Boolean EXP_FALSE = new Boolean(Boolean.FALSE);

		return new Object[][] {
				{ new Student[] {new Student("Student 1", 12), new Student("Student 2", 34), new Student("Student 4", 56)}, EXP_TRUE },
				{ new Student[] {new Student("Student 3", 12), new Student("Student 5", 34), new Student("Student 6", 56)}, EXP_TRUE },
				{ new Student[] {new Student("Student 1", 12), new Student("Student 6", 34), new Student("Student 4", 56)}, EXP_FALSE }
		};
	}

	@Test(dataProvider = "intSearchDataProvider")
	public void testIntPattern(Student[] searchPattern, boolean expected) {

		Assert.assertEquals(searchUtil.search(mainPattern, searchPattern),
				expected, "Pattern Did Not Match");
	}
}
