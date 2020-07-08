package utilities;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class Specs2 {
	
protected static RequestSpecification req_spec;
protected static ResponseSpecification res_spec;

public RequestSpecification request_specification() throws FileNotFoundException {
PrintStream ps=new PrintStream(new FileOutputStream("log.txt"));
req_spec=new RequestSpecBuilder().setBaseUri("http://216.10.245.166").setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(ps))
.addFilter(ResponseLoggingFilter.logResponseTo(ps)).build();
return req_spec;
}
public ResponseSpecification response_specification() throws FileNotFoundException {
res_spec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
return res_spec;
}
}
