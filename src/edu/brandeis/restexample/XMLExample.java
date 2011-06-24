package edu.brandeis.restexample;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class XMLExample {
	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse("data/items.xml");

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("count(//item)");

		Double result = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
		System.out.println(result.toString());
	}
}
