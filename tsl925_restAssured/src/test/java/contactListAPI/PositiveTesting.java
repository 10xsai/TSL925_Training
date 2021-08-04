package contactListAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PositiveTesting {
	String id;
	
	@Test(description="Getting all Contacts information")
	public void getAllContacts() {
		given()
			.when()
				.get("http://3.13.86.142:3000/contacts")
			.then()
				.log()
				.body()
				.statusCode(200);
	}
	
	@Test(enabled=true, description="Adding new Contact")
	public void addContact() {
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
		
		id = given()
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
	
	@Test(enabled=true, dependsOnMethods="addContact", description="Update Contact")
	public void updateContact() {
		JSONObject param = new JSONObject();
		JSONObject loc = new JSONObject();
		JSONObject employer = new JSONObject();
		
		loc.put("city", "Mumbai");
		loc.put("country", "India");
		
		employer.put("jobTitle", "GET");
		employer.put("company", "LTI");
		
		param.put("firstName", "Sai");
		param.put("lastName", "Krishna");
		param.put("email", "gdsvsk@gmail.com");
		param.put("location", loc);
		param.put("employer", employer);		
		
		given()
			.header("Content-Type", "application/json")
			.body(param.toJSONString())
			.when()
				.put("http://3.13.86.142:3000/contacts/"+id)
			.then()
				.log()
				.body()
				.statusCode(204)
				.extract()
					.path("_id");
		System.out.println("ID is " + id);
	}
	
	@Test(enabled=true, dependsOnMethods="updateContact", description="Updating Contact")
	public void gettingSpecificContact() {
		given()
		.when()
			.get("http://3.13.86.142:3000/contacts/" + id)
		.then()
			.log()
			.body()
			.statusCode(200);
	}
	
	@Test(enabled=true, dependsOnMethods="gettingSpecificContact", description="deleting Contact")
	public void deleteSpecificContact() {
		given()
		.when()
			.get("http://3.13.86.142:3000/contacts/" + id)
		.then()
			.log()
			.body()
			.statusCode(204);
	}
}
