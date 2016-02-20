package com.test.patternsearch;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public class TestRunner {

	public static void main(String[] args) {

		TestNG testNG = new TestNG();

		XmlSuite suite = new XmlSuite();
		XmlTest test = new XmlTest(suite);
		test.setName("IntPattern Test");
		List<XmlClass> testClasses = new ArrayList<XmlClass>();
		testClasses.add(new XmlClass(
				com.test.patternsearch.IntegerPatternSearchTest.class));
		test.setXmlClasses(testClasses);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);

		testNG.setXmlSuites(suites);
		
		@SuppressWarnings("rawtypes")
		List<Class> classes = new ArrayList<Class>();
		classes.add(org.uncommons.reportng.HTMLReporter.class);
		classes.add(org.uncommons.reportng.JUnitXMLReporter.class);
		testNG.setListenerClasses(classes);
		
		testNG.run();

	}
}
