package video01;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerApp {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9101);
			System.out.println("Server has started.");
			serverSocket.accept();
			System.out.println("Client has connected.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
