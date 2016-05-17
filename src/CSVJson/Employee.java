package CSVJson;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import au.com.bytecode.opencsv.CSVReader;

public class Employee {

	public static void main(String[] args) {

		String csvLocation = "https://docs.google.com/a/bsb.in/spreadsheets/d/1tpTMIAwI65IsRygUVm2VJMb2az32KvUi4CofJlCWWDQ/export?format=csv&id=1tpTMIAwI65IsRygUVm2VJMb2az32KvUi4CofJlCWWDQ&gid=0";
		String csvContent = getContent(csvLocation);
		InputStream is = new ByteArrayInputStream(csvContent.getBytes());
		try {
			String[] listData;
			CSVReader csvReader = new CSVReader(new InputStreamReader(is));
			csvReader.readNext();
			while ((listData = csvReader.readNext()) != null) {
				String listId = "EMPLOYEE_" + listData[0];
				EmployeeListMetaData listMetaData = populateMetaDataFromListData(listData);
				System.out.println(listId);
				System.out.println("Content " + listMetaData.getLanguage());
			}
			csvReader.close();
		} catch (Exception e) {
			System.err.println("Unable to parse CSV" + e.getMessage());
		}

	}

	private static EmployeeListMetaData populateMetaDataFromListData(String[] listData) {

		EmployeeListMetaData employeeData = new EmployeeListMetaData();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		employeeData.setId(listData[0]);
		employeeData.setName(listData[1]);
		employeeData.setDesignation(listData[2]);
		employeeData.setDob(parseDob(listData[3], sdf).getTime());
		employeeData.setAge(listData[4]);
		employeeData.setSalary(Long.parseLong(listData[5]));
		employeeData.setLanguage(listData[6]);

		return employeeData;
	}

	public static Date parseDob(String dateStr, SimpleDateFormat sdf) {
		if (dateStr != null) {

			try {
				Date date = sdf.parse(dateStr);
				return date;
			} catch (ParseException e) {
				System.err.println("Error while parsing date " + e.getMessage());
			}

		}
		return null;
	}

	private static String getContent(String filepath) {
		String content = "";
		String line = null;
		HttpGet get = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(filepath);
			HttpResponse response = client.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				InputStream inputStream = response.getEntity().getContent();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				while ((line = bufferedReader.readLine()) != null) {
					content += line;
					content += '\n';
				}
				return content;
			}
		}

		catch (FileNotFoundException e) {
			System.err.println("exception in finding list " + e.getMessage());
		} catch (IOException e) {
			System.err.println("exception in finding list " + e.getMessage());
		} finally {
			if (get != null) {
				get.releaseConnection();
			}
		}
		return null;
	}

}
