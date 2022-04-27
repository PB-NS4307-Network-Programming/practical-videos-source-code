package video03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) {
		Socket socket = null;
		DataOutputStream toServer = null;
		DataInputStream fromServer = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 9101);
			
			toServer = new DataOutputStream(socket.getOutputStream());
			fromServer = new DataInputStream(socket.getInputStream());
			
			System.out.println("Input Rectangle Length:");
			double length = Double.parseDouble(scanner.nextLine());
			
			System.out.println("Input Rectangle Breadth:");
			double breadth = Double.parseDouble(scanner.nextLine());
			
			// Send length
			toServer.writeDouble(length);
			// Send breadth
			toServer.writeDouble(breadth);

			// Receive Area
			double area = fromServer.readDouble();
			System.out.println("Area: " + area);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
				if(toServer != null) {
					toServer.close();
				}
				if(fromServer != null) {
					fromServer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scanner.close();
	}
	
}
