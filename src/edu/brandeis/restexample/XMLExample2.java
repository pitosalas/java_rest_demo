package edu.brandeis.restexample;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File fXmlFile = new File("data/items.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					printTag("Title", "title", eElement);
					printTag("Asin", "asin", eElement);
					printTag("Image", "image_url", eElement);
					printTag("Brand", "brand", eElement);
					printTag("Fabric", "fabric_type", eElement);
					
					System.out.println("***************************");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printTag(String prompt, String tag, Element e) {
		try {
			String val = getTagValue(tag, e);
			if (val != null) {
				System.out.println(prompt + ": " + val);
			}
		} catch (Exception ee) {
		}
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}

}
