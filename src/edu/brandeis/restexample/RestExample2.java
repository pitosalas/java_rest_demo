package edu.brandeis.restexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RestExample2 {

	public static void main(String[] args) throws IOException {
		Socket socket = null;
		//set hostname
		String addr = "vogueable.heroku.com";

		//set use port
		int port = 80;

		//set service path
		String path = "/users/1.xml";
		//set parameter
		String query = "";

		//open socket
		socket = new Socket(addr, port);

		//send query
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream pw = new PrintStream(socket.getOutputStream());
		pw.print("GET " + path + " HTTP/1.0\n");
		pw.print("User-Agent: java/socket\n");
		pw.print("Content-Length:" + query.length() + "\n\n");
		pw.print(query);

		//get result
		String l = null;
		while ((l=br.readLine())!=null) {
			System.out.println(l);
		}
		pw.close();
		br.close();
	}
}
