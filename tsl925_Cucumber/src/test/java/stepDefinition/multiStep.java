package stepDefinition;


import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class multiStep {
	int a, b, c, d, mul;
	int x, y, z, sum;
	@Given("I have two variable {string} & {string}")
	public void i_have_two_variables(String num1, String num2) {
		a = Integer.parseInt(num1);
		b = Integer.parseInt(num2);
	}
	
	@When("I do multiplication")
	public void i_do_multiplication() {
		mul = a*b;
	}
	
	@Then("result should display in console")
	public void result_should_display_in_console() {
		System.out.println("Multiplication is " + mul);
	}
	
	@Given("I have two variables as below list")
	public void i_have_two_variables_as_below_list(List<String> num) {
		a = Integer.parseInt(num.get(0));
		b = Integer.parseInt(num.get(1));
	}
	
	@Given("I have three variables {string} & {string} & {string}")
	public void i_have_three_variables(String num1, String num2, String num3) {
		x = Integer.parseInt(num1);
		y = Integer.parseInt(num2);
		z = Integer.parseInt(num3);
	}
	
	@When("I do sum")
	public void i_do_sum() {
		sum = x + y + z;
	}
	
	@Then("print sum of three variables")
	public void print_sum_of_three_variables() {
		System.out.println("Sum of adding three variables is " + sum);
	}
	
	@Given("I have Four variables as below Map")
	public void i_have_four_variables_as_below_map(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		
		a = Integer.parseInt(data.get("num1"));
		b = Integer.parseInt(data.get("num2"));
		c = Integer.parseInt(data.get("num3"));
		d = Integer.parseInt(data.get("num4"));
	}
	
	@When("I do multiplication with multiple variable")
	public void i_do_multiplication_with_multiple_variable() {
		mul = a*b*c*d;
	}
	
	@Then("Then result should display in console")
	public void then_result_should_display_in_console() {
		System.out.println("Result of Multiplication of four numbers is " + mul);
	}
}
