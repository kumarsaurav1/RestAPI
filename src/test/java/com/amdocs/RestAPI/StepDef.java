package com.amdocs.RestAPI;

import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = RestApiApplication.class)
public class StepDef {
	
	String url;
	Double result;
	
	@Given("rest api {string}")
	public void rest_api(String serviceUrl) {
		url = serviceUrl ;
	}
	
	@When("i invoke the given rest api")
	public void i_invoke_the_given_rest_api() {
	    RestTemplate restTemplate = new RestTemplate();
	    result = restTemplate.getForObject(url, Double.class);
	}

	@Then("expected sum is {int}")
	public void expected_sum_is(Integer expected) {
	    assertEquals(expected, result,0.01);
	}
}