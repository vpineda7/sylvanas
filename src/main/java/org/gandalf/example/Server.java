package org.gandalf.example;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(8999);
		
		Socket socket = server.accept();
		
		InputStream is = socket.getInputStream();
		
		ObjectInputStream ois = new ObjectInputStream(is);
		
		SimpleEnumeration color = (SimpleEnumeration)ois.readObject();
		
		// 用值比较方式来对比枚举对象
        if (color == SimpleEnumeration.RED) { 
            System.out.println("client Friday enum value is same as server's"); 
        } else if (color.equals(SimpleEnumeration.RED)) { 
            System.out.println("client Friday enum value is equal to server's"); 
        } else { 
            System.out.println("client Friday enum value is not same as server's"); 
        } 
        
        switch (color) { 
            case RED: 
                System.out.println("Do RED"); 
                break; 
            case ORANGE: 
                System.out.println("Do ORANGE"); 
                break; 
            default: 
                System.out.println("I don't know which is day"); 
                break; 
        } 
        
        ois.close(); 
        is.close(); 
        socket.close(); 
	}
}
