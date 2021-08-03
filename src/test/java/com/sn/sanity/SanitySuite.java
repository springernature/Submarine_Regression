package com.sn.sanity;

import org.testng.annotations.Test;

import com.sn.config.BaseConfig;

public class SanitySuite extends BaseConfig{
	
	
	@Test(alwaysRun = true)
	public void test() {
		
		System.out.println("Test");
	}
	
	
 
}
