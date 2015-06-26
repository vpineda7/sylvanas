package demo.socket;

import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import demo.SimpleEnumeration;

public class Client {
	
	public static void main(String[] args) throws Exception{
		
		Socket socket = new Socket();
		
		socket.connect(new InetSocketAddress("127.0.0.1", 8999));
		
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		
		oos.writeObject(SimpleEnumeration.RED);
		
		oos.close();
		
		socket.close();
	}
}
