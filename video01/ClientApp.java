package video01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 9101);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
