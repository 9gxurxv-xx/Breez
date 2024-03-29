package com.Breez.Read;


import java.io.File;
import java.io.IOException;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 
public class ReadXML {
	
	
    public static void main (String argv []){
    	
    	try {
	 DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
     DocumentBuilder docBuilder;
	
		docBuilder = docBuilderFactory.newDocumentBuilder();
	
     Document doc = docBuilder.parse (new File("book.xml"));

     // normalize text representation
     doc.getDocumentElement ().normalize ();
     System.out.println ("Root element of the doc is " + 
          doc.getDocumentElement().getNodeName());


     NodeList listOfPersons = doc.getElementsByTagName("person");
     int totalPersons = listOfPersons.getLength();
     System.out.println("Total no of people : " + totalPersons);

     for(int s=0; s<listOfPersons.getLength() ; s++){


         Node firstPersonNode = listOfPersons.item(s);
         if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){


             Element firstPersonElement = (Element)firstPersonNode;

             //-------
             NodeList firstNameList = firstPersonElement.getElementsByTagName("first");
             Element firstNameElement = (Element)firstNameList.item(0);

             NodeList textFNList = firstNameElement.getChildNodes();
             System.out.println("First Name : " + 
                    ((Node)textFNList.item(0)).getNodeValue().trim());

             //-------
             NodeList lastNameList = firstPersonElement.getElementsByTagName("last");
             Element lastNameElement = (Element)lastNameList.item(0);

             NodeList textLNList = lastNameElement.getChildNodes();
             System.out.println("Last Name : " + 
                    ((Node)textLNList.item(0)).getNodeValue().trim());

             //----
             NodeList ageList = firstPersonElement.getElementsByTagName("age");
             Element ageElement = (Element)ageList.item(0);

             NodeList textAgeList = ageElement.getChildNodes();
             System.out.println("Age : " + 
                    ((Node)textAgeList.item(0)).getNodeValue().trim());

             //------


         }//end of if clause
         
     }//for end
    	} catch (ParserConfigurationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
     }
}
