package git;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class GitExample {
	@Test(enabled=true, description="Getting all repositories")
	public void getAllRepositories() {
		given()
			.auth()
			.oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.log()
			.body()
			.statusCode(200);
	}
	
	@Test(enabled=true, description="Create new repository")
	public void createRepository() {
		JSONObject param = new JSONObject();
		param.put("name", "RestAssuredCreatedMe2");
		param.put("description", "Created using github API");
		param.put("homepage", "https://github.com/krishnagottipalli");
		
		given()
			.auth()
			.oauth2("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")
			.header("Content-Type", "application/json")
			.body(param.toJSONString())
		.when()
			.post("https://api.github.com/user/repos")
		.then()
			.log()
			.body()
			.statusCode(201);
	}
	
	@Test(enabled=true, description="Deleting repository")
	public void deleteRepository() {
		given()
			.auth()
			.oauth2("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")
		.when()
			.delete("https://api.github.com/repos/RestAssuredCreatedMe2")
		.then()
			.log()
			.body()
			.statusCode(200);
	}
}
