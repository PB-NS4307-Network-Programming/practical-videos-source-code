package video04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream fromClient = null;
		DataOutputStream toClient = null;
		try {
			serverSocket = new ServerSocket(9101);
			System.out.println("Server has started.");
			socket = serverSocket.accept();
			System.out.println("Client has connected.");
			
			fromClient = new DataInputStream(socket.getInputStream());
			toClient = new DataOutputStream(socket.getOutputStream());
			
			while(true) {				
				// Receive length
				double length = fromClient.readDouble();
				// Receive breadth
				double breadth = fromClient.readDouble();
				System.out.println("Received length: " + length);
				System.out.println("Received breadth:" + breadth);
				
				// Calculate Area
				double area = length * breadth;
				
				// Send Area
				toClient.writeDouble(area);
				
				boolean wantContinue = fromClient.readBoolean();
				if(!wantContinue) {
					break;
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}
				if(socket != null) {
					socket.close();
				}
				if(fromClient != null) {
					fromClient.close();
				}
				if(toClient != null) {
					toClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
