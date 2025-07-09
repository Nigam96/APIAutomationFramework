package com.api.tests;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import com.api.util.*;
public class BaseTest {

	protected Properties config;

    @BeforeClass
    public void setUpConfig() {
        // Load config once before all tests in the class
        config = new Properties();
        config.put("userName", ConfigLoaderUtility.get("userName"));
        config.put("email", ConfigLoaderUtility.get("email"));
        config.put("firstName", ConfigLoaderUtility.get("firstName"));
        config.put("password", ConfigLoaderUtility.get("password"));
        config.put("lastName", ConfigLoaderUtility.get("lastName"));
        config.put("mobileNumber", ConfigLoaderUtility.get("mobileNumber"));
        config.put("updatedMobileNumber", ConfigLoaderUtility.get("updatedMobileNumber"));
    }
}
