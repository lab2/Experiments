package ch.codespin.java.switch;

import java.io.*;
import java.net.*;

public class SwitchDomain {
	String whois = "whois.nic.ch", info = "";
	int port = 43;
	Socket mysock = null;
	DataOutputStream out = null;
	DataInputStream in = null;

	public String getInfoDomain(String domain) {
		try {
			InetAddress addr = InetAddress.getByName(whois);
			mysock = new Socket(addr, port);
			out = new DataOutputStream(mysock.getOutputStream());
			in = new DataInputStream(mysock.getInputStream());
			out.writeBytes(domain + "\n\r");

			while (in.readLine() != null) {
				if (in.readLine() != null)
					info += in.readLine() + "\n";
			}
			out.close();
			in.close();
			mysock.close();

		} catch (Exception e) {
			info = e.toString();
		}
		return info;
	}

	public static void main(String args[]) {
		SwitchDomain test = new SwitchDomain();
		System.out.println(test.getInfoDomain("admin.ch"));
	}
}
