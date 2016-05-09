package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	public void run() {
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(8001);
			
			Socket socket = serverSocket.accept();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		
	}
	
}
