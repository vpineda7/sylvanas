package reference.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connection implements Runnable {
	
	private String urls;
	
	public Connection(){
		
	}

	public Connection(String urls){
		
		this.urls = urls;
	}
	
	public void setUrls(String urls){
		
		this.urls = urls;
	}
	
	public void run() {
		
		try {
			
			System.out.printf("start connection with url [%s] \n",urls);
			
			URL url = new URL(urls);
			
			URLConnection conn = url.openConnection();
			
			InputStream input = conn.getInputStream();
			
			int data = input.read();
			
			while(data != -1){
				
				data = input.read();
			}
			
			input.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Connection("https://www.baidu.com"));
		
		Thread t2 = new Thread(new Connection("http://cn.bing.com"));
		
		Thread t3 = new Thread(new Connection("https://www.zhihu.com"));
		
		t1.start();
		t2.start();
		t3.start();
	}
}
