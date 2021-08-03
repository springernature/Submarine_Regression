package com.sn.sanity;

import org.testng.annotations.Test;

import com.sn.config.BaseConfig;
import com.sn.pageobjects.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test01 extends BaseConfig {
	private static final Logger LOGGER =  LogManager.getLogger(
			Test01.class);
// Logger test = LogManager.getLogger(Test01.class);
private LoginPage loginobj;
	
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  loginobj = new LoginPage(this);
		
		loginobj.login(getConfig().getProperty("user_pro"), getConfig().getProperty("pass_pro"));
		        LOGGER.info("Landed on Dashboard page");
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
