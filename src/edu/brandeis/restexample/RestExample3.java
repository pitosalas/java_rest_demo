package edu.brandeis.restexample;

import java.io.IOException;

import org.w3c.dom.NodeList;

import us.monoid.web.Resty;
import us.monoid.web.XMLResource;

public class RestExample3 {
	public static void main(String[] args) throws IOException, Exception {
		Resty r = new Resty();
		String user1 = r.xml("http://vogueable.heroku.com/users/1.xml").toString();
		System.out.println(user1);
		
		XMLResource usr1 = r.xml("http://vogueable.heroku.com/users/1.xml");
		NodeList usr1s = usr1.get("/user/gender");
		System.out.println(usr1s.item(0).getNodeValue());
		
	}

}
