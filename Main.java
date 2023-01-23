package com.danyal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Main {

	FirstOne firstOne;
	 Name name;
	Currencies currencies;
	Idd idd;
	Languages languages;
	TransaltionSubType transaltionSubType;
	Translations translations;
	Demonyms demonyms;
	Maps maps;
	Car car;
	CoatOfArms coatOfArms;
	CapitalInfo capitalInfo;
	Eng eng;
	Xcd xcd;
	SubCurrencies subCurrencies;
	

	public static void mainMenue() {

		System.out.println("***********************************************************");
		System.out.println(" 1- connect To( Json Data )Data Base ");
		System.out.println(" 2- print json Api ");
		System.out.println(" 3- create Big Data Table ");
		System.out.println(" 4- insert Into Table Json Data");
		System.out.println(" 0- Exit ");
		System.out.println("***********************************************************");

	}

	public static void jsonApi() throws Throwable, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();

		System.out.println(" printing (API) information  ");

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://restcountries.com/v3.1/all")).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.printf(response.body());

	}

	public static void connectToDataBase() throws Throwable, IllegalAccessException, ClassNotFoundException {

		Connection connection;

		try {

			// Create a connection to the database

			String serverName = "localhost";

			String url = "jdbc:sqlserver://localhost:1433;databaseName=BigData;encrypt=true;trustServerCertificate=true";
			String user = "sa";
			String pass = "root";
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			connection = DriverManager.getConnection(url, user, pass);

			System.out.println("Successfully Connected to the database!" + " BigData ");

		} catch (SQLException e) {

			System.out.println("Could not connect to the database " + e.getMessage());
		}

	}

	public static void createJsonDataTable() throws Throwable, IllegalAccessException, ClassNotFoundException {
		Connection conn;
		String url = "jdbc:sqlserver://localhost:1433;databaseName=BigData;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		try (Connection conn1 = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn1.createStatement();) {
			String sql = "CREATE TABLE JsonDataTest25 "
				    + "( Id int PRIMARY KEY IDENTITY(1,1)," 
					+ " common VARCHAR(1000),"
					+ " tld VARCHAR(1000)," 
					+ " cca2 VARCHAR(1000) ," 
					+ " ccn3 VARCHAR(1000) ," 
					+ " cca3 VARCHAR(1000),"
					+ " cioc VARCHAR(1000)," 
					+ " independent bit ," 
					+ " status VARCHAR(1000)," 
					+ " unMember bit ,"
//					+ " altSpellings VARCHAR(1000),)";
                    + " landlocked bit,"
					+ " region VARCHAR(1000) ,"
			        + " area float ," 
			        + " flag VARCHAR(1000) ,"
			        + " population Bigint ,"
					+ " fifa VARCHAR(500) ," 
			        + " timezones VARCHAR(1000) ,"
                    + " continents VARCHAR(1000),"
					+ " startOfWeek VARCHAR(1000) ,"
			        + " common1 VARCHAR(1000) ," 
			        + " official VARCHAR(1000) ,"
//					+ " symbol VARCHAR(1000) ," 
			        + " root VARCHAR(1000) ," 
                    + " suffixes VARCHAR(1000),"
					+ " eng VARCHAR(1000) ," 
//			        + " f VARCHAR(1000) ," 
					+ "Currencies VARCHAR(1000),"
//                  + " m VARCHAR(1000),)";
					+ " googleMaps VARCHAR(1000) ," 
			        + " openStreetMaps VARCHAR(1000) ,"
			        + " signs VARCHAR(1000),"
					+ " side VARCHAR(1000) ,"
			        + " png VARCHAR(1000) ," 
			        + " svg VARCHAR(1000),)"; 
//			        + " latlng float ,)";
//			        + "capital VARCHAR(1000)," 			  
			
			
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertIntoTableJsonData()throws Throwable, InterruptedException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=BigData;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);

		HttpRequest request2 = HttpRequest.newBuilder()

				.uri(URI.create("https://restcountries.com/v3.1/all")).build();

		HttpResponse<String> response2;

		HttpClient client = HttpClient.newHttpClient();

//		
//
		HttpResponse<String> response = client.send(request2, HttpResponse.BodyHandlers.ofString());
		
		
		
		Gson gson1 = new Gson();
		FirstOne[] firstOne = new Gson().fromJson(response.body(), FirstOne[].class);
		System.out.println(firstOne);
		
		for (FirstOne firstOne1 : firstOne) {
			
			String sql = "Insert into JsonDataTest25 values( '"
			        + firstOne1.getName().getCommon()+ "','" 
					+ firstOne1.getTld()[0]+ "' ,'" 
			        + firstOne1.getCca2() + "','" 
					+ firstOne1.getCcn3() + "','" 
			        + firstOne1.getCca3()+"','"
					+ firstOne1.getCioc() + "','" 
			        + firstOne1.isIndependent() + "','"
					+ firstOne1.getStatus() + "','" 
			        + firstOne1.isUnMember() + "','"
//					+ firstOne1.getAltSpellings()[0] +"','" 
					+ firstOne1.isLandlocked() + "','"
					+ firstOne1.getRegion() + "',"
                    + firstOne1.getArea()   + ",'"
					+ firstOne1.getFlag()   + "',"
					+ firstOne1.getPopulation() + ",'" 
					+ firstOne1.getFifa() + "','" 
					+ firstOne1.getTimezones()[0]+"','"
			        + firstOne1.getContinents()[0] + "','"
                    + firstOne1.getStartOfWeek() + "','"
                    + firstOne1.getName().getCommon1() +"','"
					+ firstOne1.getName().getOfficial() + "','"
//                  + firstOne1.getXcd().getSymbol()+ "','"
//[Lcom.danyal.FirstOne;@2e377400
//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.danyal.SubCurrencies.getSymbol()" because the return value of "com.danyal.FirstOne.getSubcurrencies()" is null
					+ firstOne1.getIdd().getRoot() +"','" 
                    + firstOne1.getIdd().getSuffixes()[0] + "','"
                    + firstOne1.getLanguages().getEng()+"','"
                    +firstOne1.getCurrencies()+"','"
//			        + firstOne1.getM() + "')";
                    + firstOne1.getMaps().getGoogleMaps() + "','"
					+ firstOne1.getMaps().getOpenStreetMaps() + "','"
			        + firstOne1.getCar().getSigns()[0] + "','"
					+ firstOne1.getCar().getSide() + "','"
			        + firstOne1.getCoatOfArms().getPng() +"','"
			        + firstOne1.getCoatOfArms().getSvg() +"')";
//                  + firstOne1.getCapitalInfo().getLatlng()[0] + ")";

			

//		'"+ firstOne[0].getXcd().getSymbol()+ "',
//		'" + firstOne[0].getEng().getF()+ "',
//		'" + firstOne[0].getEng().getM() + "',
//			'" + firstOne1.getCapital()[0]+"',
			System.out.println(sql);

			Connection con;

			try {

				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);

				// Reference to connection interface
				con = DriverManager.getConnection(url, user, pass);

				// Creating a statement
				Statement st = con.createStatement();

				// Executing query
				int m = st.executeUpdate(sql);
				if (m >= 1)
					System.out.println("inserted successfully : " + sql);
				else
					System.out.println("insertion failed");

				// Closing the connections
				con.close();
			}

//		 Catch block to handle exceptions
			catch (Exception ex) {
				// Display message when exceptions occurs
				System.err.println(ex);
			}
		}
	}

	public static void toExit() {

		System.out.println("***********");
		System.out.println("Good Bay");
		System.out.println("***********");

	}

	public static void byDefault() {

		System.out.println("plase Enter correct choise");

	}

	public static void main(String[] args) throws InterruptedException, Throwable {

		Scanner sc = new Scanner(System.in);

		boolean exit = true;

		do {

			mainMenue();
			int option = sc.nextInt();

			switch (option) {

			case 1:
				connectToDataBase();
				break;

			case 2:
				jsonApi();
				break;

			case 3:
				createJsonDataTable();

				break;

			case 4:
				insertIntoTableJsonData();

				break;

			case 0:
				toExit();
				exit = false;

				break;

			default:

				byDefault();
			}

		} while (exit);
	}

}
