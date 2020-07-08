package API_Test;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utilities.Specs2;
import utilities.get_Excel_Data;
public class LibrayAPI extends Specs2{

//providing Json body as payload via dataprovider after reading data from excel and returning it as 
//an array of hash-maps(indicating key-value pairs for the json body)
@Test(dataProvider="get_excel_Data",dataProviderClass=get_Excel_Data.class)	
public void add_book(HashMap<String,Object> m) throws FileNotFoundException {
Response rs=given().spec(request_specification()).body(m).when().post("/Library/Addbook.php").then()
.spec(response_specification()).extract().response();
}

}
