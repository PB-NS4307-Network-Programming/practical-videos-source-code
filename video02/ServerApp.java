package video02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream fromClient = null;
		try {
			serverSocket = new ServerSocket(9101);
			System.out.println("Server has started.");
			socket = serverSocket.accept();
			System.out.println("Client has connected.");
			
			fromClient = new DataInputStream(socket.getInputStream());
			
			String msg = fromClient.readUTF();
			System.out.println(msg);
			
			
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
