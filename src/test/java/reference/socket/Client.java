package reference.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable{
	
	public void run() {
		
		try {
			
			Socket socket = new Socket("192.168.1.100", 8001);
			
			OutputStream out = socket.getOutputStream();
			
			out.write(" hello ".getBytes());
			
			out.flush();
			out.close();
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Client());
		thread.start();
	}
}
