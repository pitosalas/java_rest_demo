package edu.brandeis.restexample;

//http://www.ibm.com/developerworks/xml/tutorials/x-xpath/section7.html
//http://www.ibm.com/developerworks/library/x-javaxpathapi/index.html


import us.monoid.web.Resty;
import us.monoid.web.XMLResource;

public class RestExample3 {
	public static void main(String[] args) throws Exception {
		Resty r = new Resty();
		String user1 = r.xml("http://vogueable.heroku.com/users/1.xml").toString();
		System.out.println(user1);

		XMLResource usr1 = r.xml("http://vogueable.heroku.com/users/1.xml");
		String id = usr1.get("/user/id/text()", String.class);
		System.out.println(id);
		
		String user2 = r.xml("http://vogueable.heroku.com/users.xml").toString();
		System.out.println(user2);
		
		XMLResource usr2 = r.xml("http://vogueable.heroku.com/users.xml");
		String id2 = usr2.get("count(//user)", String.class);
		System.out.println(id2);
	}

}
