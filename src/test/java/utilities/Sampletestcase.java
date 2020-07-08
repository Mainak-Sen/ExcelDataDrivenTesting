package utilities;
import java.io.IOException;
import java.util.ArrayList;

public class Sampletestcase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatadrivenTesting dt=new DatadrivenTesting();
		ArrayList<String> l=dt.getdata("Login");
		System.out.println(l);
		
	}

}
