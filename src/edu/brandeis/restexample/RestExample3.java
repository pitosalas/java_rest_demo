package edu.brandeis.restexample;

import java.io.IOException;
import us.monoid.web.Resty;

public class RestExample3 {
	public static void main(String[] args) throws IOException, Exception {
		Resty r = new Resty();
		String user1 = r.xml("http://vogueable.heroku.com/users/1.xml").toString();
		System.out.println(user1);
	}

}
