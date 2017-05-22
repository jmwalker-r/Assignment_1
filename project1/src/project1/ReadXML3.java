

package project1;


import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadXML3 {
	public static void main(String[] args) {
	   
		try {
	
	File XmlFile1 = new File("MicroGridTestConfiguration_T1_BE_EQ_V2.xml");
	File XmlFile2 = new File("MicroGridTestConfiguration_T1_BE_SSH_V2.xml");
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

	
	for (int i = 0; i < subList.getLength(); i++) {
		extractNode01 (subList.item(i));
	}
		
	

	//Voltage Level
	for (int i = 0; i < voltList.getLength(); i++) {
		extractNode02 (voltList.item(i)); 
		
		}
	
	for (int i = 0; i < genList.getLength(); i++) {
			extractNode031 (genList.item(i));
			extractNode032 (genListSSH.item(i));
			
		}
	
	for (int i = 0; i < breakerList.getLength(); i++) {
		    extractNode041 (breakerList.item(i));
		    extractNode042 (breakerListSSH.item(i));
	}
	
	for (int i = 0; i < generatingUnit.getLength(); i++) {
	        extractNode05 (generatingUnit.item(i));
	       
    }
	

	for (int i = 0; i < regulatingcontrol.getLength(); i++) {
            extractNode061 (regulatingcontrol.item(i));
            extractNode062 (regulatingcontrolSSH.item(i));
          
    }
	
	for (int i = 0; i < basevolList.getLength(); i++) {
	  	    extractNode07 (basevolList.item(i));
	}

	for (int i = 0; i < powertranList.getLength(); i++) {
  	        extractNode08 (powertranList.item(i));
    }
	
	for (int i = 0; i < energyList.getLength(); i++) {
	        extractNode091 (energyList.item(i));
	        extractNode092 (energyListSSH.item(i));
    }
	
	for (int i = 0; i < transendList.getLength(); i++) {
            extractNode10 (transendList.item(i));
    }
	
	
	for (int i = 0; i < tapchangerList.getLength(); i++) {
	        extractNode111 (tapchangerList.item(i));
	        extractNode112 (tapchangerListSSH.item(i));
    }
	
}
		catch(Exception e){
			e.printStackTrace();
	}
		
}


 
	

		
		// Collect info about cim Class
public static void extractNode01 (Node node){
	Element element = (Element) node;
	
	System.out.println("substation info:" + "\n");
	// substation info
	String subrdfID = element.getAttribute("rdf:ID");
	String subname = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	String region_rdfID = ((Element) element.getElementsByTagName("cim:Substation.Region").item(0)).getAttribute("rdf:resource");

	
	
	System.out.println("rdfID: " + subrdfID +"\n" + "SubstationName: " + subname +"\n" +"region_rdfID: " + region_rdfID +"\n"  );
   
}

public static void extractNode02 (Node node){
	Element element = (Element) node;
	System.out.println("votagelvel info:" + "\n");
	
	String volrdfID = element.getAttribute("rdf:ID");
	String volname = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	String subregion_rdfID =  ((Element) element.getElementsByTagName("cim:VoltageLevel.Substation").item(0)).getAttribute("rdf:resource");
	
	
	System.out.println("rdfID: " + volrdfID +"\n" + "VoltageLevel: " + volname +"\n" +"subregion_rdfID: " + subregion_rdfID +"\n" );

}


public static void extractNode031 (Node node){
	Element element = (Element) node;
	
	System.out.println("synchronousmachine info:" + "\n");
	// synchronousmachine info
	String synchronousmachinerdfID = element.getAttribute("rdf:ID");
	String synchronousmachinename = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	String ratedS=((Element) element.getElementsByTagName("cim:RotatingMachine.ratedS").item(0)).getTextContent();
	String genUnit_rdfID=((Element) element.getElementsByTagName("cim:RotatingMachine.GeneratingUnit").item(0)).getAttribute("rdf:resource");
	String regControl_rdfID=((Element) element.getElementsByTagName("cim:RegulatingCondEq.RegulatingControl").item(0)).getAttribute("rdf:resource");
	String EquipmentContainer_rdfID=((Element) element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");

	
	//String syncbasevoltage_rdfID= ((Element) element.getElementsByTagName("cim:VoltageLevel.BaseVoltage").item(0)).getAttribute("rdf:resource");
	
	
	
	System.out.println("rdfID: " + synchronousmachinerdfID +"\n" + "objectName: " + synchronousmachinename +"\n" + "EquipmentContainer_rdfID: " + EquipmentContainer_rdfID +"\n" + "regControl_rdfID: " + regControl_rdfID +"\n" + "genUnit_rdfID: " + genUnit_rdfID +"\n"+ "ratedS: " + ratedS);
	//System.out.println("syncBasevoltage_rdfID: " +syncbasevoltage_rdfID );
	
}

public static void extractNode032 (Node node){
	Element element = (Element) node;
	String P=((Element) element.getElementsByTagName("cim:RotatingMachine.p").item(0)).getTextContent();
	String Q=((Element) element.getElementsByTagName("cim:RotatingMachine.q").item(0)).getTextContent();
	
	System.out.println("P: " + P +"\n" + "Q: " + Q +"\n" );
	
}

public static void extractNode041 (Node node){
	Element element = (Element) node;
	
	// breaker info
	String breakerrdfID = element.getAttribute("rdf:ID");
	String breakername = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
    String breakercontainer =((Element)element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");
	System.out.println("breaker info:" + "\n");
	System.out.println("breakerrdfID: " + breakerrdfID +"\n" + "breakerobjectName: " + breakername +  "Equipmentcontainer: " + breakercontainer + "\n" );
   
	

	
}

public static void extractNode042 (Node node){
	Element element = (Element) node;
	String breakerstate =((Element)element.getElementsByTagName("cim:Switch.open").item(0)).getTextContent();
	
	System.out.println("breakerState: " + breakerstate +"\n" );
	
}

	
public static void extractNode05 (Node node){
	Element element = (Element) node;
	
	System.out.println("Generatingunit info:" + "\n");
	
	String GenUnitrdfID = element.getAttribute("rdf:ID");
	String GenUnitname = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	String maxP = ((Element) element.getElementsByTagName("cim:GeneratingUnit.maxOperatingP").item(0)).getTextContent();
	String minP = ((Element) element.getElementsByTagName("cim:GeneratingUnit.minOperatingP").item(0)).getTextContent();
	String EquipmentContainer_rdfID = ((Element) element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");
	
	
	
	System.out.println("rdfID: " + GenUnitrdfID +"\n" + "objectName: " + GenUnitname +"\n" +"MaxP: " + maxP +"\n" + "MinP: "  + minP + "\n" +"EquipmentContainer_rdfID: " + EquipmentContainer_rdfID);

	
}




public static void extractNode061 (Node node){
	Element element = (Element) node;
	System.out.println("regulatingcontrol info:" + "\n");
	// regulatingcontrol info
	String regulatingcontrolrdfID = element.getAttribute("rdf:ID");
	String regulatingcontrolname = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	

	
	System.out.println("regulatingcontrolrdfID: " + regulatingcontrolrdfID +"\n" + "regulatingcontrolobjectName: " + regulatingcontrolname);
   
}
public static void extractNode062 (Node node){
	Element element = (Element) node;
	String targetValue = ((Element) element.getElementsByTagName("cim:RegulatingControl.targetValue").item(0)).getTextContent();
	System.out.println("targetValue : " + targetValue  +"\n" );
}


public static void extractNode07 (Node node){
	Element element = (Element) node;
	
	System.out.println("Basevoltage info:" + "\n");
	// basevolatge info
	String basevolatgerdfID = element.getAttribute("rdf:ID");
	String norminalvalue = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	System.out.println("rdfID: " + basevolatgerdfID +"\n" + "norminalvalue: " + norminalvalue +"\n" );
   
}

public static void extractNode08 (Node node){
    Element element = (Element) node;
   // powertransformer info

	System.out.println("Powertransformer info:" + "\n");
	String PowertransformerrdfID = element.getAttribute("rdf:ID");
	String Powertransformername = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	String EquipmentContainer_rdfID = ((Element) element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");
	
	System.out.println("Powertransformer_rdfID: " + PowertransformerrdfID +"\n" + "PowertransformerName: " + Powertransformername +"\n" + "EquipmentContainer_rdfID: " +EquipmentContainer_rdfID+"\n");
	
}

public static void extractNode091 (Node node){
    Element element = (Element) node;
   // EnergyConsumer info

	System.out.println("EnergyConsumer info:" + "\n");
	String EnergyConsumerrdfID = element.getAttribute("rdf:ID");
	String EnergyConsumername = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	String EquipmentContainer_rdfID = ((Element) element.getElementsByTagName("cim:Equipment.EquipmentContainer").item(0)).getAttribute("rdf:resource");
	
	System.out.println("EnergyConsumerrdfID: " + EnergyConsumerrdfID +"\n" + "EnergyConsumername: " + EnergyConsumername +"\n" + "EquipmentContainer_rdfID: " +EquipmentContainer_rdfID);
	
	

}

public static void extractNode092 (Node node){
    Element element = (Element) node;
    
    String loadp=((Element) element.getElementsByTagName("cim:EnergyConsumer.p").item(0)).getTextContent();
	String loadq=((Element) element.getElementsByTagName("cim:EnergyConsumer.q").item(0)).getTextContent();
	
	System.out.println("LoadP: " + loadp +"\n" + "LoadQ: " + loadq +"\n" );
    
}   

public static void extractNode10 (Node node){
    Element element = (Element) node;
    
	System.out.println("transformerEnd info:" + "\n");
	
	String rdfID = element.getAttribute("rdf:ID");
	String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
	String transformerr =((Element)element.getElementsByTagName("cim:PowerTransformerEnd.r").item(0)).getTextContent();
	String transformerx =((Element)element.getElementsByTagName("cim:PowerTransformerEnd.x").item(0)).getTextContent();
	String transformerrdf =((Element)element.getElementsByTagName("cim:PowerTransformerEnd.PowerTransformer").item(0)).getAttribute("rdf:resource");
	String transbasevol =((Element)element.getElementsByTagName("cim:TransformerEnd.BaseVoltage").item(0)).getAttribute("rdf:resource");
	
	System.out.println("transformerEnd_rdfID: " +  rdfID + "\n"+ "transformerEndname: " + name);
	System.out.println("transformer r: "+transformerr + "\n"+"transformer x: "+ transformerx +"\n"+ "transformer_rdf: " +transformerrdf +"\n"+ "baseVoltage: "+ transbasevol+"\n");

	
}

public static void extractNode111 (Node node){
    Element element = (Element) node;
    
	System.out.println("Tapchanger info:" + "\n");
	
	String rdfID = element.getAttribute("rdf:ID");
	String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();

	System.out.println("Tapchanger_rdfID: " +  rdfID + "\n"+ "Tapchangername: " + name);
	
}

public static void extractNode112 (Node node){
    Element element = (Element) node;
    String step=  element.getElementsByTagName("cim:TapChanger.step").item(0).getTextContent();
    System.out.println("Step: " +  step +"\n");
}

}

		

		
	