package DataDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTByJSONFile {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("./src/test/resources/JSONdata.json");
		Object javaObj = parser.parse(file);
		
		JSONObject obj = (JSONObject) javaObj;
		String name = obj.get("name").toString();
		String id = obj.get("id").toString();
		String branch = obj.get("Branch").toString();
		String age = obj.get("Age").toString();
		String isStudent = obj.get("isStudent").toString();
		Object backlogs = obj.get("backlogs");
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(branch);
		System.out.println(age);
		System.out.println(isStudent);
		System.out.println(backlogs);
		
	}

}
