package com.sn.smoke;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class SmokeSuite {

	public static void main(String[] args) {

		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		System.out.println(System.getProperty("user.dir"));
		suites.add(System.getProperty("user.dir")+"/TestNG.xml");
		testng.setTestSuites(suites);
		testng.run();

	}

}
