package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class whetherAPI {
	String API_KEY = "913af04c337cef9585a423fed719d52f"; 

	@Test(enabled=false, description="For getting Whether information")
	public void getWhetherInfo() {
		String cityName = "pentapadu";
		RestAssured.when()
					.get("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid="+API_KEY)
					.then()
					.log()
					.body()
					.statusCode(200);
	}
	
	@Test
	public void getWhetherInfo2() {
		String cityName = "pentapadu";
		Response res = RestAssured.when()
							.get("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid="+API_KEY);
		System.out.println(res.prettyPrint());
		System.out.println(res.getTime());
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
	}
	
	@Test
	public void getWhetherInfo3() {
		String cityName = "pentapadu";
		RestAssured.given()
					.queryParam("q", cityName)
					.queryParam("appid", API_KEY)
				.when()
					.get("http://api.openweathermap.org/data/2.5/weather")
				.then()
					.log()
					.body()
					.statusCode(200);
	}
	
	@Test
	public void getWhetherInfo4() {
		String cityName = "pentapadu";
		Map<String, String> param = new HashMap<String, String>();
		param.put("q", cityName);
		param.put("appid", API_KEY);
		RestAssured.given()
					.queryParams(param)
					.when()
						.get("http://api.openweathermap.org/data/2.5/weather")
					.then()
						.log()
						.body()
						.statusCode(200);
	}
}
