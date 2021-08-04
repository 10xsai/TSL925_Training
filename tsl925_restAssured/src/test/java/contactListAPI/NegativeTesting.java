package contactListAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class NegativeTesting {
	@Test(enabled=false, description="Getting Record Which does Not Exists")
	public void gettingSpecificContact() {
		given()
		.when()
			.get("http://3.13.86.142:3000/contacts")
		.then()
			.log()
			.body()
			.statusCode(404);
	}
	
	@Test(enabled=true, description = "Adding new Contact with missing field")
	public void addingContact() {
		JSONObject param = new JSONObject();
		JSONObject loc = new JSONObject();
		JSONObject employer = new JSONObject();
		
		loc.put("city", "Mumbai");
		loc.put("country", "India");
		
		employer.put("jobTitle", "GET");
		employer.put("company", "LTI");
		
		param.put("firstName", "Sio");
		param.put("lastName", "Krishna");
		param.put("email", "gdsvsk@gmail.com");
		param.put("location", loc);
		param.put("employer", employer);		
		
		String id = given()
				.header("Content-Type", "application/json")
				.body(param.toJSONString())
				.when()
					.post("http://3.13.86.142:3000/contacts")
				.then()
					.log()
					.body()
					.statusCode(200)
					.extract()
					.path("_id");
		System.out.println("ID is " + id);
	}
	
	@Test(enabled=true, description = "Adding new Contact with missing field")
	public void addingContactWithTooManyCharacters() {
		JSONObject param = new JSONObject();
		JSONObject loc = new JSONObject();
		JSONObject employer = new JSONObject();
		
		loc.put("city", "Mumbaivdsrgspdfvjpsjvvdanvdabgvdgdgdasgdgd");
		loc.put("country", "India");
		
		employer.put("jobTitle", "GET");
		employer.put("company", "LTI");
		
		param.put("firstName", "Sio");
		param.put("lastName", "Krishna");
		param.put("email", "gdsvsk@gmail.com");
		param.put("location", loc);
		param.put("employer", employer);		
		
		String err = given()
				.header("Content-Type", "application/json")
				.body(param.toJSONString())
				.when()
					.post("http://3.13.86.142:3000/contacts")
				.then()
					.log()
					.body()
					.statusCode(400)
					.extract()
					.path("err");
		Assert.assertTrue(err.contains("is longer than the maximum allowed length (30)"));
	}
	
	@Test(enabled=true, description = "Adding new Contact with missing field")
	public void invalidCharacters() {
		JSONObject param = new JSONObject();
		JSONObject loc = new JSONObject();
		JSONObject employer = new JSONObject();
		
		loc.put("city", "Mumbai");
		loc.put("country", "India");
		
		employer.put("jobTitle", "GET");
		employer.put("company", "LTI");
		
		param.put("firstName", "S45");
		param.put("lastName", "454Krishna");
		param.put("email", "gdsvsk@gmail.com");
		param.put("location", loc);
		param.put("employer", employer);		
		
		String err = given()
				.header("Content-Type", "application/json")
				.body(param.toJSONString())
				.when()
					.post("http://3.13.86.142:3000/contacts")
				.then()
					.log()
					.body()
					.statusCode(400)
					.extract()
					.path("err");
		Assert.assertTrue(
				err.contains("Validator failed for path `firstName` with value")
				|| err.contains("Validator failed for path `lastName` with value"));
	}
	
	@Test(enabled=true, description = "Adding new Contact with missing field")
	public void invalidFormat() {
		JSONObject param = new JSONObject();
		JSONObject loc = new JSONObject();
		JSONObject employer = new JSONObject();
		
		loc.put("city", "Mumbai");
		loc.put("country", "India");
		
		employer.put("jobTitle", "GET");
		employer.put("company", "LTI");
		
		param.put("firstName", "S45");
		param.put("lastName", "454Krishna");
		param.put("email", "gdsvsk@gmail.com");
		param.put("location", loc);
		param.put("employer", employer);		
		
		String err = given()
				.header("Content-Type", "application/json")
				.body(param.toJSONString())
				.when()
					.post("http://3.13.86.142:3000/contacts")
				.then()
					.log()
					.body()
					.statusCode(400)
					.extract()
					.path("err");
		Assert.assertTrue(err.contains("Contacts validation failed:"));
	}
}
