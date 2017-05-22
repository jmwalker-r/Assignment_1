package project1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class XMLtoSQL {

	// JDBC driver name and database URL
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost/";
	 static final String DISABLE_SSL = "?useSSL=false";
	 // Database credentials
	 static final String USER = "root";
	 static final String PASS = "root"; // insert the password to SQL server

	 public static void main(String[] args) {

	 Connection conn = null;
	 Statement stmt = null;
	 try{
		// Register JDBC driver
	 Class.forName(JDBC_DRIVER);
	 // Open a connection
	 System.out.println("Connecting to SQL server...");
	 conn = DriverManager.getConnection(DB_URL+DISABLE_SSL, USER, PASS);
	 System.out.println("Connected database successfully...");
	 
	// execute a query to create database
	 System.out.println("Creating database...");
	 stmt = conn.createStatement();
	 String sql = "CREATE DATABASE IF NOT EXISTS PowerSystem"; //
	 stmt.executeUpdate(sql);
	 System.out.println("Database created successfully...");

	 // Connect to the created database powersystem and create table breaker
	 conn = DriverManager.getConnection(DB_URL + "PowerSystem"+DISABLE_SSL, USER, PASS);
	 sql = "USE PowerSystem";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS BaseVoltage";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS Substation";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS VoltageLevel";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS GeneratingUnit";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS SynchronousMachine";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS RegulatingControl";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS PowerTransformer";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS EnergyConsumer";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS Breakers";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS PowerTransformerEnd";
	 stmt.executeUpdate(sql);
	 sql = "DROP TABLE IF EXISTS RatioTapChanger";
	 stmt.executeUpdate(sql);
	 
	 
//
	 
//	 ReadXML3.extractNode041(node);

 
	 
	 sql = "CREATE TABLE IF NOT EXISTS BaseVoltage( NorminalValue VARCHAR(255), RDF_ID VARCHAR(255) ,  PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS Substation( Name VARCHAR(255), RDF_ID VARCHAR(255) , Region_rdfID VARCHAR(255), PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS VoltageLevel( Name VARCHAR(255), RDF_ID VARCHAR(255) , Substation_rdfID VARCHAR(255), BaseVoltage_rdfID VARCHAR(255) , PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS GeneratingUnit (Name VARCHAR(255), RDF_ID VARCHAR(255) , MaxP VARCHAR(255), MinP VARCHAR(255), EquipmentContainer_rdfID VARCHAR(255),PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS SynchronousMachine( Name VARCHAR(255), RDF_ID VARCHAR(255) , RatedS VARCHAR(255), P VARCHAR(255) , Q VARCHAR(255) , GenUnit_rdfID VARCHAR(255), RegControl_rdfID VARCHAR(255) ,EquipmentContainer_rdfID VARCHAR(255), PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS RegulatingControl( Name VARCHAR(255), RDF_ID VARCHAR(255) , TargetValue VARCHAR(255),  PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS PowerTransformer( Name VARCHAR(255), RDF_ID VARCHAR(255) , EquipmentContainer_RDF VARCHAR(255), PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS EnergyConsumer( Name VARCHAR(255), RDF_ID VARCHAR(255) , P VARCHAR(255) , Q VARCHAR(255) , EquipmentContainer_RDF VARCHAR(255), PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS PowerTransformerEnd( Name VARCHAR(255), RDF_ID VARCHAR(255) ,Transformer_r VARCHAR(255) ,Transformer_x VARCHAR(255), Transformer_rdfID VARCHAR(255),BaseVoltage_rdfID VARCHAR(255) ,PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS Breakers( Name VARCHAR(255), RDF_ID VARCHAR(255) ,EquipmentContainer_rdfID VARCHAR(255) ,State VARCHAR(255) , PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 sql = "CREATE TABLE IF NOT EXISTS RatioTapChanger( Name VARCHAR(255), RDF_ID VARCHAR(255) , Step VARCHAR(255), PRIMARY KEY(RDF_ID))"; // create table Breaker with corresponding attributes
	 stmt.executeUpdate(sql) ;
	 
	 
//	 stmt.executeUpdate(sql) ; // execute query

	 System.out.println("Created table in given database successfully...");
	 
	 // insert values into the table 
	 
	 
	   	
	 
	 
/*	 
//	 sql = "INSERT INTO Breakers " + "VALUES (100, \'A\', 15, \'Open\')";
	 sql = "INSERT INTO Breakers " + "VALUES (100, \'A\', 15, \'Open\')";
//	 sql = "INSERT INTO Breakers " + "VALUES (extractNode041.breakerrdfID,\'A\', 15, \'Open\')";
	 stmt.executeUpdate(sql); // repeat the procedure for all rows of the table
	 sql = "INSERT INTO Breakers " + "VALUES (101, \'B\', 10, \'Close\')";
	 stmt.executeUpdate(sql);
	 sql = "INSERT INTO Breakers " + "VALUES (102, \'A\', 20, \'Close\')";
	 stmt.executeUpdate(sql);
	 sql = "INSERT INTO Breakers " + "VALUES (103, \'A\', 15, \'Open\')";
	 stmt.executeUpdate(sql);*/

//	 System.out.println("Inserted records into the table...");

/*	 // create the java mysql update preparedstatement
	 String query = "update Breakers SET status=? WHERE ID=?"; // update status of Breaker, id=103
	 PreparedStatement preparedStmt = conn.prepareStatement(query);
	 preparedStmt.setString(1, "Close");
	 preparedStmt.setInt(2, 103);
	 // execute PreparedStatement
	 preparedStmt.executeUpdate();
	 // insert a new values to the table with preparedstatement
	 query = "insert into Breakers values(?, ?, ?, ?)";
	 preparedStmt = conn.prepareStatement(query);
	 preparedStmt.setInt(1, 104);
	 preparedStmt.setString(2, "A");
	 preparedStmt.setInt(3, 30);
	 preparedStmt.setString(4, "Open");
	 preparedStmt.executeUpdate();
	 // finish the statement
*/
//	 System.out.println("The table is updated...");
//	 conn.close();

	 
	 
			
//			File XmlFile1 = new File("MicroGridTestConfiguration_T1_BE_EQ_V2.xml");
//			File XmlFile2 = new File("MicroGridTestConfiguration_T1_BE_SSH_V2.xml");
	 
  	    File XmlFile1 = new File("Assignment_EQ_reduced.xml");
		File XmlFile2 = new File("Assignment_SSH_reduced.xml");
	 
	 
	 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(XmlFile1);
			Document doc2 = dBuilder.parse(XmlFile2);
			
			
					 
			// normalize XML file
			doc1.getDocumentElement().normalize();
			doc2.getDocumentElement().normalize();
			
			NodeList subList = doc1.getElementsByTagName("cim:Substation");
			NodeList voltList = doc1.getElementsByTagName("cim:VoltageLevel");
			
			NodeList genList = doc1.getElementsByTagName("cim:SynchronousMachine");
			NodeList genListSSH = doc2.getElementsByTagName("cim:SynchronousMachine");
			
			NodeList breakerList = doc1.getElementsByTagName("cim:Breaker");
			NodeList breakerListSSH = doc2.getElementsByTagName("cim:Breaker");
			
			NodeList generatingUnit = doc1.getElementsByTagName("cim:GeneratingUnit");
			
			NodeList regulatingcontrol = doc1.getElementsByTagName("cim:RegulatingControl");
			NodeList regulatingcontrolSSH = doc2.getElementsByTagName("cim:RegulatingControl");
			
			NodeList basevolList =doc1.getElementsByTagName("cim:BaseVoltage");
			
			NodeList powertranList = doc1.getElementsByTagName("cim:PowerTransformer");//power transformer
			
			NodeList energyList = doc1.getElementsByTagName("cim:EnergyConsumer");
			NodeList energyListSSH = doc2.getElementsByTagName("cim:EnergyConsumer");//energy consumer
			
			NodeList transendList = doc1.getElementsByTagName("cim:PowerTransformerEnd");//power transformer end
			NodeList tapchangerList = doc1.getElementsByTagName("cim:RatioTapChanger");
			NodeList tapchangerListSSH = doc2.getElementsByTagName("cim:RatioTapChanger");//ratio tap changer
			
			NodeList terminalList=doc1.getElementsByTagName("cim:Terminal");// Terminal
			NodeList ConnectivitynodeList=doc1.getElementsByTagName("cim:ConnectivityNode");
			NodeList AClineList = doc1.getElementsByTagName("cim:ACLineSegment");
			
			NodeList BusbarList = doc1.getElementsByTagName("cim:BusbarSection");
			
			
//			String[] Substations = new String[ subList.getLength()];
			
			
			
			
			for (int i = 0; i < subList.getLength(); i++) {
				Element element = (Element) subList.item(i);

				// substation info
				String subrdfID = element.getAttribute("rdf:ID");
				String subname = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
				String region_rdfID = ((Element) element.getElementsByTagName("cim:Substation.Region").item(0)).getAttribute("rdf:resource");
			
				 String query = "insert into Substation values(?, ?, ?)";
				 PreparedStatement preparedStmt = conn.prepareStatement(query);
				 
				 preparedStmt = conn.prepareStatement(query);
				 preparedStmt.setString(1, subname);
				 preparedStmt.setString(2, subrdfID);
				 preparedStmt.setString(3, region_rdfID);
				 preparedStmt.executeUpdate();
				 System.out.println("substation info:" + "\n");
				 System.out.println("rdfID: " + subrdfID +"\n" + "SubstationName: " + subname +"\n" +"region_rdfID: " + region_rdfID +"\n"  );
				
//				 Substations[i]= subname;
				 
				
			}
			

			
			
			for (int i = 0; i < voltList.getLength(); i++) {
				Element element = (Element) voltList.item(i);
				System.out.println("votagelvel info:" + "\n");
				
				String volrdfID = element.getAttribute("rdf:ID");
				String volname = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
				String subregion_rdfID =  ((Element) element.getElementsByTagName("cim:VoltageLevel.Substation").item(0)).getAttribute("rdf:resource");
				String baseVoltage_rdfID = ((Element) element.getElementsByTagName("cim:VoltageLevel.BaseVoltage").item(0)).getAttribute("rdf:resource");
				
				String query = "insert into VoltageLevel values(?, ?, ?, ?)";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				 
				 preparedStmt = conn.prepareStatement(query);
				 preparedStmt.setString(1, volname);
				 preparedStmt.setString(2, volrdfID);
				 preparedStmt.setString(3, subregion_rdfID);
				 preparedStmt.setString(4, baseVoltage_rdfID);
				 
				 preparedStmt.executeUpdate();
				
				
				
				 
				 
				System.out.println("rdfID: " + volrdfID +"\n" + "VoltageLevel: " + volname +"\n" +"subregion_rdfID: " + subregion_rdfID +"\n" + "Basevoltage_rdfID: " + baseVoltage_rdfID +"\n");
				
				
			    
			}

			for (int i = 0; i < genList.getLength(); i++) {
			
					Element element = (Element) genList.item(i);
					
					System.out.println("synchronousmachine info:" + "\n");
					// synchronousmachine info
					String synchronousmachinerdfID = element.getAttribute("rdf:ID");
					String synchronousmachinename = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
					String ratedS=((Element) element.getElementsByTagName("cim:RotatingMachine.ratedS").item(0)).getTextContent();
					String genUnit_rdfID=((Element) element.getElementsByTagName("cim:RotatingMachine.GeneratingUnit").item(0)).getAttribute("rdf:resource");
					String regControl_rdfID=((Element) element.getElementsByTagName("cim:RegulatingCondEq.RegulatingControl").item(0)).getAttribute("rdf:resource");
					String EquipmentContainer_rdfID=((Element) element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");

					
					//String syncbasevoltage_rdfID= ((Element) element.getElementsByTagName("cim:VoltageLevel.BaseVoltage").item(0)).getAttribute("rdf:resource");
					
					Element element2 = (Element) genListSSH.item(i);
					String P=((Element) element2.getElementsByTagName("cim:RotatingMachine.p").item(0)).getTextContent();
					String Q=((Element) element2.getElementsByTagName("cim:RotatingMachine.q").item(0)).getTextContent();
					
					System.out.println("P: " + P +"\n" + "Q: " + Q +"\n" );
					System.out.println("rdfID: " + synchronousmachinerdfID +"\n" + "objectName: " + synchronousmachinename +"\n" + "EquipmentContainer_rdfID: " + EquipmentContainer_rdfID +"\n" + "regControl_rdfID: " + regControl_rdfID +"\n" + "genUnit_rdfID: " + genUnit_rdfID +"\n"+ "ratedS: " + ratedS);
					//System.out.println("syncBasevoltage_rdfID: " +syncbasevoltage_rdfID );
					

					String query = "insert into SynchronousMachine values(?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					 
					 preparedStmt = conn.prepareStatement(query);
					 preparedStmt.setString(1, synchronousmachinename);
					 preparedStmt.setString(2, synchronousmachinerdfID);
					 preparedStmt.setString(3, ratedS);
					 preparedStmt.setString(4, P);
					 preparedStmt.setString(5, Q);
					 preparedStmt.setString(6, genUnit_rdfID);
					 preparedStmt.setString(7, regControl_rdfID);
					 preparedStmt.setString(8, EquipmentContainer_rdfID);
					 
					 
					 preparedStmt.executeUpdate();
					
				}

	
		  
			for (int i = 0; i < breakerList.getLength(); i++) {
			    Element element = (Element) breakerList.item(i);
				
				// breaker info
				String breakerrdfID = element.getAttribute("rdf:ID");
				String breakername = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
			    String breakercontainer =((Element)element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");
				System.out.println("breaker info:" + "\n");
				System.out.println("breakerrdfID: " + breakerrdfID +"\n" + "breakerobjectName: " + breakername +  "Equipmentcontainer: " + breakercontainer + "\n" );
			   
			    
			    Element element2 = (Element) breakerListSSH.item(i);
			
				String breakerstate =((Element)element2.getElementsByTagName("cim:Switch.open").item(0)).getTextContent();
				System.out.println("breakerState: " + breakerstate +"\n" );
				
		
				String query = "insert into Breakers values(?, ?, ?, ?)";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				 
				 preparedStmt = conn.prepareStatement(query);
				 preparedStmt.setString(1, breakername);
				 preparedStmt.setString(2, breakerrdfID);
				 preparedStmt.setString(3, breakercontainer);
				 preparedStmt.setString(4, breakerstate);
				 preparedStmt.executeUpdate();
	    
		       }
			
 
		
		   for (int i = 0; i < generatingUnit.getLength(); i++) {
		            Element element = (Element) generatingUnit.item(i);
		        	
		        	System.out.println("Generatingunit info:" + "\n");
		        	
		        	String GenUnitrdfID = element.getAttribute("rdf:ID");
		        	String GenUnitname = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
		        	String maxP = ((Element) element.getElementsByTagName("cim:GeneratingUnit.maxOperatingP").item(0)).getTextContent();
		        	String minP = ((Element) element.getElementsByTagName("cim:GeneratingUnit.minOperatingP").item(0)).getTextContent();
		        	String EquipmentContainer_rdfID = ((Element) element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");
		        	
		        	System.out.println("rdfID: " + GenUnitrdfID +"\n" + "objectName: " + GenUnitname +"\n" +"MaxP: " + maxP +"\n" + "MinP: "  + minP + "\n" +"EquipmentContainer_rdfID: " + EquipmentContainer_rdfID);

		        	
		        	
		        	String query = "insert into GeneratingUnit values(?, ?, ?, ?,?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					 
					 preparedStmt = conn.prepareStatement(query);
					 preparedStmt.setString(1, GenUnitname);
					 preparedStmt.setString(2, GenUnitrdfID);
					 preparedStmt.setString(3, maxP);
					 preparedStmt.setString(4, minP);
					 preparedStmt.setString(5, EquipmentContainer_rdfID);
					 
					 preparedStmt.executeUpdate();
		        	
	          }
		

		for (int i = 0; i < regulatingcontrol.getLength(); i++) {
	
	            	Element element = (Element) regulatingcontrol.item(i);
	            	System.out.println("regulatingcontrol info:" + "\n");
	            	// regulatingcontrol info
	            	String regulatingcontrolrdfID = element.getAttribute("rdf:ID");
	            	String regulatingcontrolname = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	            	

	            	
	            	System.out.println("regulatingcontrolrdfID: " + regulatingcontrolrdfID +"\n" + "regulatingcontrolobjectName: " + regulatingcontrolname);
	               
	            
	           
	            	Element element2 = (Element) regulatingcontrolSSH.item(i);
	            	String targetValue = ((Element) element2.getElementsByTagName("cim:RegulatingControl.targetValue").item(0)).getTextContent();
	            	System.out.println("targetValue : " + targetValue  +"\n" );
	            	
	
	        	 
	        	 
	        	 String query = "insert into RegulatingControl values(?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					 
					 preparedStmt = conn.prepareStatement(query);
					 preparedStmt.setString(1, regulatingcontrolname);
					 preparedStmt.setString(2, regulatingcontrolrdfID);
					 preparedStmt.setString(3, targetValue);
		
					 preparedStmt.executeUpdate();	
	            	
	            }

		String[] Basevoltagerdf = new String[ basevolList.getLength()];
		double[] Basevoltage= new double[basevolList.getLength()] ;
		
		for (int i = 0; i < basevolList.getLength(); i++) {
		  	    
		  	  Element element = (Element) basevolList.item(i);
		  	
		   	  System.out.println("Basevoltage info:" + "\n");
		  	// basevolatge info
		  	  String basevolatgerdfID = element.getAttribute("rdf:ID");
		  	  String norminalvalue = element.getElementsByTagName("cim:BaseVoltage.nominalVoltage").item(0).getTextContent();
		   	  System.out.println("rdfID: " + basevolatgerdfID +"\n" + "norminalvalue: " + norminalvalue +"\n" );
		   	  
		   	 String query = "insert into BaseVoltage values(?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 
			 preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setString(1, norminalvalue);
			 preparedStmt.setString(2, basevolatgerdfID);
	
			 preparedStmt.executeUpdate();	
			 
			 
	            Basevoltagerdf[i]= basevolatgerdfID;
	            double basevoltage= Double.parseDouble(norminalvalue);
	            Basevoltage[i]=basevoltage;

		}
		
		


		for (int i = 0; i < powertranList.getLength(); i++) {
	  	        Element element = (Element) powertranList.item(i);
	  	       // powertransformer info

	  	    	System.out.println("Powertransformer info:" + "\n");
	  	    	String PowertransformerrdfID = element.getAttribute("rdf:ID");
	  	    	String Powertransformername = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	  	    	String EquipmentContainer_rdfID = ((Element) element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");
	  	    	
	  	    	System.out.println("Powertransformer_rdfID: " + PowertransformerrdfID +"\n" + "PowertransformerName: " + Powertransformername +"\n" + "EquipmentContainer_rdfID: " +EquipmentContainer_rdfID+"\n");
	  	    	
	  	    	String query = "insert into PowerTransformer values(?, ?, ?)";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
					 
			    preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, Powertransformername);
				preparedStmt.setString(2, PowertransformerrdfID);
				preparedStmt.setString(3, EquipmentContainer_rdfID);
		
				preparedStmt.executeUpdate();	
	          
	    }
		
		
		
		Double[] Consumer = new Double[ energyList.getLength()];
		
		
		for (int i = 0; i < energyList.getLength(); i++) {

		            Element element = (Element) energyList.item(i);
		            
		           // EnergyConsumer info

		        	System.out.println("EnergyConsumer info:" + "\n");
		        	String EnergyConsumerrdfID = element.getAttribute("rdf:ID");
		        	String EnergyConsumername = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
		        	String EquipmentContainer_rdfID = ((Element) element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");
		        	
		        	System.out.println("EnergyConsumerrdfID: " + EnergyConsumerrdfID +"\n" + "EnergyConsumername: " + EnergyConsumername +"\n" + "EquipmentContainer_rdfID: " +EquipmentContainer_rdfID);
		        	

		            Element element2 = (Element) energyListSSH.item(i);
		            
		            String loadp=((Element) element2.getElementsByTagName("cim:EnergyConsumer.p").item(0)).getTextContent();
		        	String loadq=((Element) element2.getElementsByTagName("cim:EnergyConsumer.q").item(0)).getTextContent();
		        	
		        	System.out.println("LoadP: " + loadp +"\n" + "LoadQ: " + loadq +"\n" );
		            
		  	    	String query = "insert into EnergyConsumer values(?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
						 
				    preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString(1, EnergyConsumername);
					preparedStmt.setString(2, EnergyConsumerrdfID);
					preparedStmt.setString(3, loadp);
					preparedStmt.setString(4, loadq);
					preparedStmt.setString(5, EquipmentContainer_rdfID);
			
					preparedStmt.executeUpdate();	
		        	
					
					double LoadP = Double.parseDouble(loadp);
		            Consumer[i]=LoadP ;
	    }
		
		String[] Transendname = new String[ transendList.getLength()];
		String[] Transbaserdf = new String[ transendList.getLength()];
		double[] Transbase = new double[ transendList.getLength()];
		String[] Transformerr = new String[ transendList.getLength()];
//		double[] Transbasecal = new double[powertranList.getLength()];
		for (int i = 0; i < transendList.getLength(); i++) {
			
	                Element element = (Element) transendList.item(i);
	                
	            	System.out.println("transformerEnd info:" + "\n");
	            	
	            	String rdfID = element.getAttribute("rdf:ID");
	            	String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	            	String transformerr =((Element)element.getElementsByTagName("cim:PowerTransformerEnd.r").item(0)).getTextContent();
	            	String transformerx =((Element)element.getElementsByTagName("cim:PowerTransformerEnd.x").item(0)).getTextContent();
	            	String transformerrdf =((Element)element.getElementsByTagName("cim:PowerTransformerEnd.PowerTransformer").item(0)).getAttribute("rdf:resource");
	            	String transbasevol =((Element)element.getElementsByTagName("cim:TransformerEnd.BaseVoltage").item(0)).getAttribute("rdf:resource");
	            	String ratedS=((Element)element.getElementsByTagName("cim:PowerTransformerEnd.ratedS").item(0)).getTextContent();
	            	
	            	
	            	System.out.println("transformerEnd_rdfID: " +  rdfID + "\n"+ "transformerEndname: " + name);
	            	System.out.println("transformer r: "+transformerr + "\n"+"transformer x: "+ transformerx +"\n"+ "transformer_rdf: " +transformerrdf +"\n"+ "baseVoltage: "+ transbasevol+"\n" + "RatedS: "+ ratedS + "\n");

	            	String query = "insert into PowerTransformerEnd values(?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
						 
				    preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString(1, name);
					preparedStmt.setString(2, rdfID);
					preparedStmt.setString(3, transformerr);
					preparedStmt.setString(4, transformerx);
					preparedStmt.setString(5, transformerrdf);
					preparedStmt.setString(6, transbasevol);
			
					preparedStmt.executeUpdate();	
	            	
					Transformerr[i] = transformerr ;
					Transbaserdf[i] = transbasevol ;
					Transendname[i] =	name;			
					
					
					
	                }
		

 

		for (int i = 0; i < tapchangerList.getLength(); i++) {

		            Element element = (Element) tapchangerList.item(i);
		            
		        	System.out.println("Tapchanger info:" + "\n");
		        	
		        	String rdfID = element.getAttribute("rdf:ID");
		        	String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();

		        	System.out.println("Tapchanger_rdfID: " +  rdfID + "\n"+ "Tapchangername: " + name);
	
		            Element element2 = (Element) tapchangerListSSH.item(i);
		            String step=  element2.getElementsByTagName("cim:TapChanger.step").item(0).getTextContent();
		            System.out.println("Step: " +  step +"\n");
		            
		            
	            	String query = "insert into RatioTapChanger values(?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
						 
				    preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString(1, name);
					preparedStmt.setString(2, rdfID);
					preparedStmt.setString(3, step);
				
					preparedStmt.executeUpdate();	
					
		      }	
		
		for (int i = 0; i < terminalList.getLength(); i++) {

			            Element element = (Element) terminalList.item(i);	
			            
			            String rdfID =element.getAttribute("rdf:ID");
			            String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
			            String Connectivitynode_rdfID =((Element) element.getElementsByTagName ("cim:Terminal.ConnectivityNode").item(0)).getAttribute("rdf:resource");
			            
			            
			            System.out.println("Terminal_rdfID: " +  rdfID + "\n"+ "Connectivitynode_rdfID: " + Connectivitynode_rdfID + "\n"+ "Terminalnodename: " + name + "\n" );
					
		}
		
		for (int i = 0; i < ConnectivitynodeList.getLength(); i++) {

            Element element = (Element) ConnectivitynodeList.item(i);	
            
            String rdfID =element.getAttribute("rdf:ID");
            String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
         
            
            System.out.println("Connectivitynode_rdfID: " +  rdfID + "\n" + "Connectivitynodename: " + name + "\n");
		
       }
		
		
	
		for (int i = 0; i < AClineList.getLength(); i++) {

            Element element = (Element) AClineList.item(i);	
		    
            String rdfID =element.getAttribute("rdf:ID");
            String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
            
            System.out.println("ACline_rdfID: " +  rdfID +  "\n"+ "AClinename: " + name + "\n" );
    		
		}
		
		for (int i = 0; i < BusbarList.getLength(); i++) {

            Element element = (Element) BusbarList.item(i);	
		    
            String rdfID =element.getAttribute("rdf:ID");
            String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
            
            System.out.println("Busbar_rdfID: " +  rdfID +  "\n"+ "Busbarname: " + name + "\n" );
    		
		}
		
/*		String[] Basevoltage = new String[ basevolList.getLength()];
		
		for (int i = 0; i < basevolList.getLength(); i++) {
		  	    
		  	  Element element = (Element) basevolList.item(i);
		  	
		   	  System.out.println("Basevoltage info:" + "\n");
		  	// basevolatge info
		  	  String basevolatgerdfID = element.getAttribute("rdf:ID");
		  	  String norminalvalue = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
		   	  System.out.println("rdfID: " + basevolatgerdfID +"\n" + "norminalvalue: " + norminalvalue +"\n" );
		   	  
		   	 String query = "insert into BaseVoltage values(?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 
			 preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setString(1, norminalvalue);
			 preparedStmt.setString(2, basevolatgerdfID);
	
			 preparedStmt.executeUpdate();	
			 
			 
	            Basevoltage[i]= basevolatgerdfID;
		   	  
		}*/
		
		
		
		
		for (int i = 0; i < transendList.getLength(); i++) {

		    for (int j = 0;  j< basevolList.getLength(); j++){
             String transrdf= new String(Transbaserdf[i]);
             String baserdf= new String("#"+Basevoltagerdf[j]);
             
	         if (transrdf.equals(baserdf)){
				Transbase[i]= Basevoltage[j];
			 }
		}
		    
		
		
		
		
		 
		System.out.println(Transendname[i]+"\t"+Transbaserdf[i]+"\t"+Transbase[i]);
	
		}



		
		
	 System.out.println("The table is updated...");
	 conn.close();
	 
	 }catch(SQLException se){
		 //Handle errors for JDBC
		 se.printStackTrace();
		 }catch(Exception e){
		 //Handle errors for Class.forName
		 e.printStackTrace();}
		 System.out.println("Goodbye!");
			 
	 }
	 }
	 